package devanmejia.productshopemail.service.email;

import devanmejia.productshopemail.model.MessageType;
import devanmejia.productshopemail.model.params.OrderParams;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;

@Service("orderMessageSender")
public class OrderMessageSender extends EmailMessageSender<OrderParams> {
    @Override
    public void sendMessage(OrderParams params) throws MessagingException {
        Message message = createMessage(params);
        Transport.send(message);
    }

    private Message createMessage(OrderParams params) throws MessagingException {
        Message message = createBasicMessage(params.getEmail());
        message.setSubject("Order №" + params.getId());
        if (params.getOrderStatus().equals("ORDERED")){
            message.setText(MessageType.MAKE_ORDER_MESSAGE.toString());
        }
        if (params.getOrderStatus().equals("READY")){
            message.setText(MessageType.READY_ORDER_MESSAGE.toString());
        }
        return message;
    }
}
