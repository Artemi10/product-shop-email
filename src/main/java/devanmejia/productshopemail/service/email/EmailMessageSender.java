package devanmejia.productshopemail.service.email;

import devanmejia.productshopemail.exception.DecodeException;
import devanmejia.productshopemail.model.params.AbstractParams;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Service
public abstract class EmailMessageSender<T extends AbstractParams> {

    private static Properties emailPropertiesConfig;
    private static Properties emailProperties;

    public EmailMessageSender() {
        try {
            emailPropertiesConfig = loadProperties("email-properties/emailConfiguration.properties");
            emailProperties = loadProperties("email-properties/email.properties");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Async
    public abstract void sendMessage(T params) throws MessagingException, DecodeException;

    protected Message createBasicMessage(String addresseeEmail) throws MessagingException {
        Message message = new MimeMessage(createSession());
        message.setFrom(new InternetAddress(emailProperties.getProperty("emailAddress")));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(addresseeEmail));
        return message;
    }

    private Session createSession() {
        return Session.getDefaultInstance(emailPropertiesConfig, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailProperties.getProperty("emailAddress"), emailProperties.getProperty("emailPassword"));
            }
        });
    }

    private Properties loadProperties(String propertiesPath) throws IOException {
        Properties properties = new Properties();
        InputStream inStreamEmailPropertiesConfig = new ClassPathResource(propertiesPath).getInputStream();
        properties.load(inStreamEmailPropertiesConfig);
        return properties;
    }
}
