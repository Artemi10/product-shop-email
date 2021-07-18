package devanmejia.productshopemail.controller;

import devanmejia.productshopemail.exception.DecodeException;
import devanmejia.productshopemail.model.params.OrderParams;
import devanmejia.productshopemail.service.email.EmailMessageSender;
import devanmejia.productshopemail.model.params.CodeParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
@RequestMapping("/email")
public class EmailController {
    @Autowired
    @Qualifier("verifyEmailMessageSender")
    private EmailMessageSender<CodeParams> verifyMessageSender;
    @Autowired
    @Qualifier("resetEmailMessageSender")
    private EmailMessageSender<CodeParams> resetMessageSender;
    @Autowired
    @Qualifier("orderMessageSender")
    private EmailMessageSender<OrderParams> orderMessageSender;

    @PostMapping("/verify")
    public void sendVerifyCode(@RequestBody CodeParams codeParams) throws MessagingException, DecodeException {
        verifyMessageSender.sendMessage(codeParams);
    }

    @PostMapping("/reset")
    public void sendResetCode(@RequestBody CodeParams codeParams) throws MessagingException, DecodeException {
        resetMessageSender.sendMessage(codeParams);
    }

    @PostMapping("/order")
    public void sendResetCode(@RequestBody OrderParams orderParams) throws MessagingException, DecodeException {
        orderMessageSender.sendMessage(orderParams);
    }
}
