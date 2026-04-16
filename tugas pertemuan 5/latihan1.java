import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;

public class latihan1 {
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

        System.out.println("Daftar Buku:");

        int no = 1;
        Iterator<String> it = buku.iterator();

        while (it.hasNext()) {
            System.out.println(no + ". " + it.next());
            no++;
        }
    }
}