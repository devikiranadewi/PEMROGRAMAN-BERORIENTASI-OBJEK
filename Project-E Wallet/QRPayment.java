public class QRPayment extends Payment {

    public QRPayment(String paymentId,
                     double amount,
                     User sender,
                     User receiver) {

        super(paymentId,
              amount,
              sender,
              receiver);
    }

    @Override
    public double calculateFee() {

        if (amount < 100000) {
            return 0;
        }

        return amount * 0.007;
    }

    @Override
    public boolean validate() {

        if (amount <= 0) {
            return false;
        }

        if (amount > sender.getTransactionLimit()) {
            return false;
        }

        return sender.getBalance()
                >= amount + calculateFee();
    }

    @Override
    public String getPaymentMethod() {
        return "QR Payment";
    }
}