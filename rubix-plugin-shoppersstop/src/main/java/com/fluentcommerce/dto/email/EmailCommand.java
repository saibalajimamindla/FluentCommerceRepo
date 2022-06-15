package com.fluentcommerce.dto.email;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;


/**
 * EmailCommand is the Object set in event attributes for SendEmailFromEvent rule. It should contain all the information
 * necessary for sending correct email. SendEmailFromEvent rule should only depend EmailCommand object to send Mandrill email.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmailCommand {

    private String emailConfigSetting;

    private Map<String, String> properties;

    private Map<String, Object> templateVariables;

    public EmailCommand( String emailConfigSetting, Map<String, Object> templateVariables) {
        this.properties = new HashMap<>();
        this.emailConfigSetting = emailConfigSetting;
        this.templateVariables = templateVariables;
    }

    public static class EmailCommandBuilder {

        public Map<String, String> getProperties() {
            if (this.properties == null) {
                this.properties = new HashMap<>();
            }
            return this.properties;
        }

        public EmailCommandBuilder fromEmail(String fromEmail) {
            getProperties().put(EmailSetting.Names.fromEmail.name(), fromEmail);
            return this;
        }

        public EmailCommandBuilder fromName(String fromName) {
            getProperties().put(EmailSetting.Names.fromName.name(), fromName);
            return this;
        }

        public EmailCommandBuilder toEmail(String toEmail) {
            getProperties().put(EmailSetting.Names.toEmail.name(), toEmail);
            return this;
        }

        public EmailCommandBuilder toName(String toName) {
            getProperties().put(EmailSetting.Names.toName.name(), toName);
            return this;
        }

        public EmailCommandBuilder ccEmail(String ccEmail) {
            getProperties().put(EmailSetting.Names.ccEmail.name(), ccEmail);
            return this;
        }

        public EmailCommandBuilder ccName(String ccName) {
            getProperties().put(EmailSetting.Names.ccName.name(), ccName);
            return this;
        }

        public EmailCommandBuilder bccEmail(String bccEmail) {
            getProperties().put(EmailSetting.Names.bccEmail.name(), bccEmail);
            return this;
        }

        public EmailCommandBuilder bccName(String bccName) {
            getProperties().put(EmailSetting.Names.bccName.name(), bccName);
            return this;
        }

        public EmailCommandBuilder replyTo(String replyTo) {
            getProperties().put(EmailSetting.Names.replyTo.name(), replyTo);
            return this;
        }
    }

}
