package fr.utc.sr03.chat.snippets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * URL du endpoint : http://localhost:8080/snippets/sendmail
 */
@Controller
public class SendMail {
    @Autowired
    private JavaMailSender javaMailSender;

    @GetMapping("/snippets/sendmail")
    @ResponseBody
    public String test() {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("destinataire@test.fr");
        msg.setSubject("send mail from spring");
        msg.setText("blablabla");
        javaMailSender.send(msg);

        return "ok";
    }
}
