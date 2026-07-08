public class DiscountPromo extends Promo {

    private double discountRate;
    private double maxDiscount;

    public DiscountPromo(String promoName,
                         double discountRate,
                         double maxDiscount) {

        super(promoName);

        this.discountRate = discountRate;
        this.maxDiscount = maxDiscount;
    }

    @Override
    public double calculatePromo(double amount) {

        double discount =
                amount * discountRate;

        if (discount > maxDiscount) {
            discount = maxDiscount;
        }

        return discount;
    }

    @Override
    public String getPromoType() {
        return "Discount";
    }

    public double getFinalPayment(double amount) {

        return amount -
                calculatePromo(amount);
    }

    public void showPromo() {

        System.out.println(
                "\n===== PROMO DISKON =====");

        System.out.println(
                "Nama Promo : " +
                promoName);

        System.out.println(
                "Diskon : " +
                (discountRate * 100) + "%");

        System.out.println(
                "Maksimal Diskon : Rp" +
                maxDiscount);
    }
}