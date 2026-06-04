public class MainInterface {
    public static void main(String[] args) {
        Kotak kotak = new Kotak(4.0, 5.0);

        System.out.println("--- Ukuran Semula ---");
        System.out.println("Luas: " + kotak.getLuas());
        System.out.println("Keliling: " + kotak.getKeliling());

        kotak.resize(2.0);

        System.out.println("\n--- Setelah Resize 2x ---");
        System.out.println("Luas: " + kotak.getLuas());
        System.out.println("Keliling: " + kotak.getKeliling());
    }
}