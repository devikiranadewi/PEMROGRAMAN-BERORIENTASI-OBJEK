public class MainBangunDatar {
    public static void main(String[] args) {
        Kotak kotakKu = new Kotak(5.0, 4.0);
        Segitiga segitigaKu = new Segitiga(6.0, 4.0);

        System.out.println("Luas Kotak: " + kotakKu.getLuas());
        System.out.println("Keliling Kotak: " + kotakKu.getKeliling());
        System.out.println("Luas Segitiga: " + segitigaKu.getLuas());
        System.out.println("Keliling Segitiga: " + segitigaKu.getKeliling());
    }
}