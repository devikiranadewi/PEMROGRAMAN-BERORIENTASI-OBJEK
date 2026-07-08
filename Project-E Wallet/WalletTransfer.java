public class WalletTransfer extends Payment {

    public WalletTransfer(String paymentId,
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
        return 0;
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
                >= amount;
    }

    @Override
    public String getPaymentMethod() {
        return "Wallet Transfer";
    }
}