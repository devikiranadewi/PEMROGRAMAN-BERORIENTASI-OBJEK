public class BankTransfer extends Payment {

    private static final double ADMIN_FEE = 2500;

    public BankTransfer(String paymentId,
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
        return ADMIN_FEE;
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
        return "Bank Transfer";
    }
}