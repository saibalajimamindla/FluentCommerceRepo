#!groovy
@Library('es-jenkins-lib@2.2.0') _
def STASH_KEYS = [
        PLUGIN: 'PLUGIN'
]
pipeline {
    agent any

    tools {
        maven 'M3'
        nodejs 'lts-dubnium'
    }
    environment {
        PATH = "$PATH:/home/developer/bin::/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin"
    }
    // Initialise environment variables
    stages {
        stage ('Initialisation') {
            steps {
                script{
                    initEnv params
                }
            }
        }
        // Version the artifact being deployed
        stage('Versioning') {
            steps {
                script {
                    setEnvVariables branchName: "${env.branchName}",
                            newVersion: "${env.newVersion}",
                            projectName: "${env.projectName}",
                            source: "${env.source}"
                }
            }
        }
        // Build the project stage
        stage('Build') {
            // Skip this step if the selected source from params is "VERSION"
            when {
                expression { env.source == env.GLOBAL_SOURCE_CODE}
            }
            steps {
                script {
                    buildPlugin newBuildVersion: "${env.NEW_BUILD_VERSION}",
                            mvnSettingsConfigId: "${env.mvnSettingsConfigId}"
                }
                stash includes: "target/${env.ARTIFACT_FILENAME}", name: STASH_KEYS.PLUGIN
            }
            post {
                always {
                    step([$class: 'CoberturaPublisher',
                          autoUpdateHealth: false,
                          autoUpdateStability: false,
                          coberturaReportFile: '**/coverage.xml',
                          failUnhealthy: true,
                          failUnstable: true,
                          maxNumberOfBuilds: 0,
                          onlyStable: false,
                          sourceEncoding: 'ASCII',
                          zoomCoverageChart: false])
                }
            }
        }
        // Publish the artifact to Nexus repo
        stage('Publish') {
            // Skip this step if the selected source from params is "VERSION"
            when {
                expression { env.source == env.GLOBAL_SOURCE_CODE}
            }
            steps {
                unstash name: STASH_KEYS.PLUGIN
                script {
                    publishPlugin stashKey: STASH_KEYS.PLUGIN,
                            newBuildVersion: "${env.NEW_BUILD_VERSION}",
                            artifactFilename: "target/${env.ARTIFACT_FILENAME}",
                            artifactPomFilename: "pom.xml",
                            repoId: "${env.REPO_ID}",
                            repoUrl: "${env.REPO_URL}",
                            mvnSettingsConfigId: "${env.mvnSettingsConfigId}"
                }
            }
        }
        // Download, upload and install the plugin to the selected account
        stage('Install') {
            steps {
                script {
                    installPlugin apiUrl: "${env.apiUrl}",
                            account: "${env.account}",
                            accountUsername: "${env.accountUsername}",
                            accountPassword: "${env.accountPassword}",
                            accountClientSecret: "${env.accountClientSecret}",
                            scope: "${env.scope}",
                            projectName: "${env.projectName}",
                            pluginNamespace: "${env.pluginNamespace}",
                            newBuildVersion: "${env.NEW_BUILD_VERSION}",
                            repoId: "${env.REPO_ID}",
                            repoUrl: "${env.REPO_URL}"
                }
            }
        }
        // Increase the version in the pom file
        stage('Increase Version') {
            // Skip this step if the selected version from params is "LATEST"
            when {
                expression { source == env.GLOBAL_SOURCE_CODE}
            }
            steps {
                script {
                    increaseVersion branchName: "${env.branchName}"
                }
            }
        }
    }
}
