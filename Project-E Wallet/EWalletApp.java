import java.util.ArrayList;
import java.util.Scanner;

public class EWalletApp {
    public static void processPayment(
            Payment payment) {

        if (!payment.validate()) {

            System.out.println(
                    "\nTransaksi gagal!");

            return;
        }

        double adminFee =
                payment.calculateFee();

        double total =
                payment.getAmount() + adminFee;

        payment.getSender()
                .deductBalance(total);

        payment.getReceiver()
                .addBalance(payment.getAmount());

        double cashback =
                payment.getAmount()
                * payment.getSender()
                .getCashbackRate();

        payment.getSender()
                .addBalance(cashback);

        payment.getSender()
                .addTransaction(
                        new Transaction(
                                payment.getPaymentMethod(),
                                payment.getAmount(),
                                "SUCCESS"
                        )
                );

        System.out.println(
                "\n===== PEMBAYARAN BERHASIL =====");

        System.out.println(
                "Metode        : "
                        + payment.getPaymentMethod());

        System.out.println(
                "Nominal       : Rp"
                        + payment.getAmount());

        System.out.println(
                "Biaya Admin   : Rp"
                        + adminFee);

        System.out.println(
                "Cashback      : Rp"
                        + cashback);
    }

    public static void main(String[] args) {

        Scanner input =
                new Scanner(System.in);

        User user =
                new PremiumUser(
                        "U001",
                        "Ahmad",
                        "08123456789",
                        "1234",
                        500000
                );

        User merchant =
                new MerchantUser(
                        "M001",
                        "Toko Roti",
                        "08999999999",
                        "0000",
                        0
                );

        System.out.println(
                "===== LOGIN =====");

        System.out.print(
                "Masukkan PIN : ");

        String pin =
                input.nextLine();

       if (!user.checkPin(pin)) {

            System.out.println("PIN salah.");
            input.close();
        return;
}

        Promo cashbackPromo =
                new CashbackPromo(
                        "Cashback Akhir Pekan",
                        0.10,
                        50000);

        Promo discountPromo =
                new DiscountPromo(
                        "Diskon Belanja",
                        0.20,
                        30000);

        ArrayList<User> users =
                new ArrayList<>();

        users.add(user);
        users.add(merchant);

        int pilih;

        do {

            System.out.println(
                    "\n========== MENU ==========");

            System.out.println(
                    "1. Lihat Saldo");

            System.out.println(
                    "2. Top Up");

            System.out.println(
                    "3. Bayar Merchant");

            System.out.println(
                    "4. Riwayat Transaksi");

            System.out.println(
                    "5. Laporan Bulanan");

            System.out.println(
                    "6. Promo Cashback");

            System.out.println(
                    "7. Promo Diskon");

            System.out.println(
                    "8. Split Bill");

            System.out.println(
                    "9. Simpan Data");

            System.out.println(
                    "10. Load Data");

            System.out.println(
                    "11. Keluar");

            System.out.print(
                    "Pilih : ");

            pilih =
                    input.nextInt();

            switch (pilih) {

                case 1:

                    user.showBalance();

                    break;

                case 2:

                    System.out.print(
                            "Nominal Top Up : ");

                    double topup =
                            input.nextDouble();

                    user.topUp(topup);

                    break;

                case 3:

                    System.out.print(
                            "Jumlah Bayar : ");

                    double bayar =
                            input.nextDouble();

                    Payment payment =
                            new QRPayment(
                                    "P001",
                                    bayar,
                                    user,
                                    merchant);

                    processPayment(payment);

                    break;

                case 4:

                    user.showHistory();

                    break;

                case 5:

                    user.showMonthlyReport();

                    break;

                case 6:

                    ((CashbackPromo)
                            cashbackPromo)
                            .showPromo();

                    double cashback =
                            cashbackPromo
                                    .calculatePromo(
                                            200000);

                    System.out.println(
                            "Cashback Rp"
                                    + cashback);

                    break;

                case 7:

                    ((DiscountPromo)
                            discountPromo)
                            .showPromo();

                    double bayarAkhir =
                            ((DiscountPromo)
                                    discountPromo)
                                    .getFinalPayment(
                                            200000);

                    System.out.println(
                            "Total setelah diskon : Rp"
                                    + bayarAkhir);

                    break;

                case 8:

                    SplitBill bill =
                            new SplitBill(
                                    "SB001",
                                    merchant,
                                    300000);

                    bill.addMember(user);

                    bill.showMembers();

                    bill.processSplitBill();

                    break;

                case 9:

                    FileManager.saveUsers(
                            users);

                    FileManager
                            .saveTransactionHistory(
                                    user);

                    break;

                case 10:

                    users =
                            FileManager.loadUsers();

                    System.out.println(
                            "Jumlah user : "
                                    + users.size());

                    break;

                case 11:

                    System.out.println(
                            "Terima kasih.");

                    break;

                default:

                    System.out.println(
                            "Menu tidak tersedia.");

            }

        } while (pilih != 11);

        input.close();
    }
}