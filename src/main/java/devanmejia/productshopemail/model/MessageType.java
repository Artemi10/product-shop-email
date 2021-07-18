package devanmejia.productshopemail.model;

public enum MessageType {
    VERIFY_MESSAGE("Verify code: "),
    RESET_MESSAGE("Reset code: "),
    ERROR_MESSAGE("We can not take yor order because of error"),
    MAKE_ORDER_MESSAGE("We take your order!"),
    READY_ORDER_MESSAGE("You order is collected");

    private final String s;

    MessageType(String s){
        this.s= s;
    }

    @Override
    public String toString() {
        return s;
    }
}
