import java.util.ArrayList;

public class SplitBill {

    private String billId;
    private User payer;
    private ArrayList<User> members;
    private double totalBill;

    public SplitBill(String billId,
                     User payer,
                     double totalBill) {

        this.billId = billId;
        this.payer = payer;
        this.totalBill = totalBill;

        members = new ArrayList<>();
    }

    public void addMember(User user) {
        members.add(user);
    }

    public void showMembers() {

        System.out.println("\n===== MEMBER SPLIT BILL =====");

        for(User u : members){
            System.out.println("- " + u.getName());
        }
    }

    public void processSplitBill() {

        if(members.isEmpty()){

            System.out.println(
                    "Belum ada anggota.");

            return;
        }

        double share =
                totalBill / members.size();

        System.out.println(
                "\n===== SPLIT BILL =====");

        System.out.println(
                "ID Bill : " + billId);

        System.out.println(
                "Total Tagihan : Rp" +
                totalBill);

        System.out.println(
                "Jumlah Member : " +
                members.size());

        System.out.println(
                "Tagihan per Orang : Rp" +
                share);

        for(User u : members){

            if(u.getBalance() >= share){

                u.deductBalance(share);

                payer.addBalance(share);

                u.addTransaction(
                        new Transaction(
                                "Split Bill",
                                share,
                                "SUCCESS"
                        )
                );

                System.out.println(
                        u.getName() +
                        " berhasil membayar.");
            }

            else{

                System.out.println(
                        u.getName() +
                        " saldo tidak cukup.");
            }
        }
    }
}