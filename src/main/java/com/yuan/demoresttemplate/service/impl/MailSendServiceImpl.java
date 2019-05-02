package com.yuan.demoresttemplate.service.impl;

import com.yuan.demoresttemplate.domain.dto.Mail;
import com.yuan.demoresttemplate.service.MailSendService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.IOException;
import java.util.Map;

/**
 * @author David Hong
 * @version 1.0
 * @description
 */
@Slf4j
@Service
public class MailSendServiceImpl implements MailSendService {

    /**
     * spring提供的Java邮件发送类
     */
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @Override
    public boolean sendWithHTMLTemplate(Mail mail) {
        try {
            //发件人昵称
            String nick = MimeUtility.encodeText("David");
            //发件人网络地址
            InternetAddress from = new InternetAddress(nick + "<1751632917@qq.com>");
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setTo(mail.getReceiverEmail());
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setSubject(mail.getSubject());
            // 使用模板生成html邮件内容
            String result = getMailTextByTemplateName(mail.getTemplateName(), mail.getParams());
            mimeMessageHelper.setText(result, true);
            javaMailSender.send(mimeMessage);
            return true;
        } catch (Exception e) {
            log.error("TAG=sendEmailFailed, msg={}", e.getMessage());
            return false;
        }
    }

    @Override
    public String getMailTextByTemplateName(String templateName, Map<String, Object> params) throws IOException, TemplateException {
        String mailText = "";
        // 通过指定模板名获取FreeMarker模板实例
        Template template = freeMarkerConfigurer.getConfiguration().getTemplate(templateName);
        // FreeMarker通过Map传递动态数据
        // 注意动态数据的key和模板标签中指定的属性相匹配
        // 解析模板并替换动态数据，最终code将替换模板文件中的${code}标签。
        mailText = FreeMarkerTemplateUtils.processTemplateIntoString(template, params);
        return mailText;
    }

}
