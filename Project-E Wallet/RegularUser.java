public class RegularUser extends User {

    public RegularUser(String userId,
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
        return 2000000;
    }

    @Override
    public double getCashbackRate() {
        return 0.01;
    }

    @Override
    public String getAccountType() {
        return "Regular User";
    }
}