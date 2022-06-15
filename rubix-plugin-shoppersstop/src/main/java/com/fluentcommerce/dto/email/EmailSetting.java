package com.fluentcommerce.dto.email;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * This class represents Email Configuration Setting JSON saved under Settings
 * e.g.
 * {@code
 *  EMAIL.PROVIDER.CONFIG = {
 *      "shipped_email": {
 *              "fromEmail": "cs@example.com",
 *              "subject": "Order shipped",
 *              "mandrillTemplate": "shipped_template"},
 *      "rejected_email": {
 *              "fromEmail": "cs@example.com",
 *              "subject": "Order rejected",
 *              "mandrillTemplate": "rejected_template"},
 *  }
 * }
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailSetting {
    //These should match with email setting key names in RetailerSettings
    public enum Names {
        fromEmail,
        fromName,
        toEmail,
        toName,
        ccEmail,
        ccName,
        bccEmail,
        bccName,
        replyTo,
        subject,
        mandrillTemplate
    }

    public String getFromEmail() {
        return getSettingMap().get(Names.fromEmail.name());
    }

    public String getFromName() {
        return getSettingMap().get(Names.fromName.name());
    }

    public String getToEmail() {
        return getSettingMap().get(Names.toEmail.name());
    }

    public String getToName() {
        return getSettingMap().get(Names.toName.name());
    }

    public String getCcEmail() {
        return getSettingMap().get(Names.ccEmail.name());
    }

    public String getCcName() {
        return getSettingMap().get(Names.ccName.name());
    }

    public String getBccEmail() {
        return getSettingMap().get(Names.bccEmail.name());
    }

    public String getBccName() {
        return getSettingMap().get(Names.bccName.name());
    }

    public String getReplyTo() {
        return getSettingMap().get(Names.replyTo.name());
    }

    public String getSubject() {
        return getSettingMap().get(Names.subject.name());
    }

    public String getMandrillTemplate() {
        return getSettingMap().get(Names.mandrillTemplate.name());
    }

    private Map<String, String> settingMap;
}