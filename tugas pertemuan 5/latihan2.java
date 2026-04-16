import java.util.Set;
import java.util.TreeSet;

public class latihan2 {
    public static void main(String[] args) {

        Set<String> buku = new TreeSet<>();

        buku.add("Dilan 1990");
        buku.add("Laskar Pelangi");
        buku.add("Mahaguru");
        buku.add("Mengejar Matahari");
        buku.add("Dilan 1991");
        buku.add("Milea");
        buku.add("Perahu Kertas");
        buku.add("Laskar Pelangi");
        buku.add("Perahu Kertas");

        System.out.println("Daftar Buku secara Urut:");
        int no = 1;
        for (String b : buku) {
            System.out.println(no + ". " + b);
            no++;
        }

        if (buku.contains("Mahaguru")) {
            System.out.println("\nBuku Mahaguru ada");

            buku.remove("Mahaguru");
        } else {
            System.out.println("\nBuku Mahaguru tidak ada");
        }

        System.out.println("\nDaftar Buku setelah Mahaguru dipinjam:");

        for (String b : buku) {
            System.out.println(b);
        }
    }
}