public class MerchantUser extends User {

    public MerchantUser(String userId,
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
        return 50000000;
    }

    @Override
    public double getCashbackRate() {
        return 0.0;
    }

    @Override
    public String getAccountType() {
        return "Merchant User";
    }
}