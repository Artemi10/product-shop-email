package devanmejia.productshopemail.service.email;

import devanmejia.productshopemail.exception.DecodeException;
import devanmejia.productshopemail.model.MessageType;
import devanmejia.productshopemail.service.crypto.CryptoService;
import devanmejia.productshopemail.model.params.CodeParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;

@Service("verifyEmailMessageSender")
public class VerifyEmailMessageSender extends EmailMessageSender<CodeParams>{
    @Autowired
    private CryptoService cryptoService;

    @Override
    public void sendMessage(CodeParams params) throws MessagingException, DecodeException {
        Message message = createMessage(params);
        Transport.send(message);
    }

    private Message createMessage(CodeParams params) throws MessagingException, DecodeException {
        Message message = createBasicMessage(params.getEmail());
        message.setSubject("Confirm password");
        message.setText(MessageType.VERIFY_MESSAGE + cryptoService.decrypt(params.getCode()));
        return message;
    }
}
