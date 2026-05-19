import java.util.Scanner;

class BangunDatar {

    double luas(double panjang, double lebar) {
        return panjang * lebar;
    }

    double luasSegitiga(double alas, double tinggi) {
        return 0.5 * alas * tinggi;
    }
}

class Lingkaran extends BangunDatar {

    double luasLingkaran(double r) {
        return 3.14 * r * r;
    }
}

public class App {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        BangunDatar bd = new BangunDatar();

        System.out.print("Masukkan Panjang: ");
        double panjang = input.nextDouble();

        System.out.print("Masukkan Lebar: ");
        double lebar = input.nextDouble();

        double luasPP = bd.luas(panjang, lebar);

        System.out.println("Luas Persegi Panjang adalah " + luasPP);

        System.out.print("Masukkan Alas: ");
        double alas = input.nextDouble();

        System.out.print("Masukkan Tinggi: ");
        double tinggi = input.nextDouble();

        double luasSegitiga = bd.luasSegitiga(alas, tinggi);

        System.out.println("Luas Segitiga siku-siku adalah " + luasSegitiga);

        Lingkaran l = new Lingkaran();

        System.out.print("Masukkan Jari-jari Lingkaran: ");
        double r = input.nextDouble();

        double luasLingkaran = l.luasLingkaran(r);

        System.out.println("Luas Lingkaran adalah " + luasLingkaran);

        input.close();
    }
}