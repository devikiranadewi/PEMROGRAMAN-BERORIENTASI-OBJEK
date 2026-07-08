public class CashbackPromo extends Promo {

    private double cashbackRate;
    private double maxCashback;

    public CashbackPromo(String promoName,
                         double cashbackRate,
                         double maxCashback) {

        super(promoName);

        this.cashbackRate = cashbackRate;
        this.maxCashback = maxCashback;
    }

    @Override
    public double calculatePromo(double amount) {

        double cashback =
                amount * cashbackRate;

        if (cashback > maxCashback) {
            cashback = maxCashback;
        }

        return cashback;
    }

    @Override
    public String getPromoType() {
        return "Cashback";
    }

    public void showPromo() {

        System.out.println(
                "\n===== PROMO CASHBACK =====");

        System.out.println(
                "Nama Promo : " +
                promoName);

        System.out.println(
                "Cashback : " +
                (cashbackRate * 100) + "%");

        System.out.println(
                "Maksimal Cashback : Rp" +
                maxCashback);
    }
}