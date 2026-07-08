public abstract class Payment {

    protected String paymentId;
    protected double amount;
    protected User sender;
    protected User receiver;

    public Payment(String paymentId,
                   double amount,
                   User sender,
                   User receiver) {

        this.paymentId = paymentId;
        this.amount = amount;
        this.sender = sender;
        this.receiver = receiver;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }

    // Abstract Method
    public abstract double calculateFee();

    public abstract boolean validate();

    public abstract String getPaymentMethod();
}