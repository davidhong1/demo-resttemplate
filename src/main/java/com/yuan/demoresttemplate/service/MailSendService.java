package com.yuan.demoresttemplate.service;

import com.yuan.demoresttemplate.domain.dto.Mail;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.util.Map;

/**
 * @author David Hong
 * @version 1.0
 * @description
 */
public interface MailSendService {

    /**
     * 发送邮件
     *
     * @author David Hong
     *
     * @param mail
     * @return boolean
     */
    boolean sendWithHTMLTemplate(Mail mail);

    /**
     * 通过模板名生成邮件html
     *
     * @author David Hong
     *
     * @param templateName
     * @param params
     * @return String
     *
     * @throws IOException
     * @throws TemplateException
     */
    String getMailTextByTemplateName(String templateName, Map<String, Object> params) throws IOException, TemplateException;

}
