public abstract class Promo {

    protected String promoName;

    public Promo(String promoName) {
        this.promoName = promoName;
    }

    public String getPromoName() {
        return promoName;
    }

    // Menghitung nilai promo
    public abstract double calculatePromo(double amount);

    // Menampilkan jenis promo
    public abstract String getPromoType();
}