public class PremiumUser extends User {

    public PremiumUser(String userId,
                       String name,
                       String phone,
                       String pin,
                       double balance) {

        super(
                userId,
                name,
                phone,
                pin,
                balance
        );
    }

    @Override
    public double getTransactionLimit() {
        return 10000000;
    }

    @Override
    public double getCashbackRate() {
        return 0.05;
    }

    @Override
    public String getAccountType() {
        return "Premium User";
    }
}