import java.io.Serializable;
import java.util.ArrayList;

public abstract class User
        implements Serializable {

    private String userId;
    private String name;
    private String phone;
    private String pin;
    private double balance;

    private ArrayList<Transaction> history;

    public User(String userId,
                String name,
                String phone,
                String pin,
                double balance) {

        this.userId = userId;
        this.name = name;
        this.phone = phone;
        this.pin = pin;

        if (balance >= 0) {
            this.balance = balance;
        } else {
            this.balance = 0;
        }

        history = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<Transaction> getHistory() {
        return history;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void setBalance(double balance) {

        if (balance >= 0) {
            this.balance = balance;
        }
    }

    public boolean checkPin(String inputPin) {

        return pin.equals(inputPin);
    }

    public void topUp(double amount) {

        if (amount <= 0) {

            System.out.println(
                    "Nominal top up tidak valid.");

            history.add(
                    new Transaction(
                            "TOP UP",
                            amount,
                            "FAILED"
                    )
            );

            return;
        }

        balance += amount;

        history.add(
                new Transaction(
                        "TOP UP",
                        amount,
                        "SUCCESS"
                )
        );

        System.out.println(
                "Top up berhasil Rp" +
                        amount
        );
    }

    public void deductBalance(
            double amount) {

        balance -= amount;
    }

    public void addBalance(
            double amount) {

        balance += amount;
    }

    public void addTransaction(
            Transaction transaction) {

        history.add(transaction);
    }

    public void showHistory() {

        System.out.println(
                "\n===== RIWAYAT TRANSAKSI =====");

        if (history.isEmpty()) {

            System.out.println(
                    "Belum ada transaksi.");

            return;
        }

        for (Transaction t : history) {
            t.showTransaction();
        }
    }

    public double getTotalIncome() {

        double total = 0;

        for (Transaction t : history) {

            if (t.getType().equals("TOP UP")) {

                total += t.getAmount();
            }
        }

        return total;
    }

    public double getTotalExpense() {

        double total = 0;

        for (Transaction t : history) {

            if (!t.getType().equals("TOP UP")) {

                total += t.getAmount();
            }
        }

        return total;
    }

    public void showMonthlyReport() {

        System.out.println(
                "\n===== LAPORAN KEUANGAN =====");

        System.out.println(
                "Nama              : " +
                        name);

        System.out.println(
                "Jenis Akun        : " +
                        getAccountType());

        System.out.println(
                "Total Pemasukan   : Rp" +
                        getTotalIncome());

        System.out.println(
                "Total Pengeluaran : Rp" +
                        getTotalExpense());

        System.out.println(
                "Saldo Akhir       : Rp" +
                        balance);
    }

    public void showBalance() {

        System.out.println(
                "\n========================");

        System.out.println(
                "Jenis Akun : " +
                        getAccountType());

        System.out.println(
                "ID User    : " +
                        userId);

        System.out.println(
                "Nama       : " +
                        name);

        System.out.println(
                "No HP      : " +
                        phone);

        System.out.println(
                "Saldo      : Rp" +
                        balance);

        System.out.println(
                "Limit      : Rp" +
                        getTransactionLimit());

        System.out.println(
                "Cashback   : " +
                        (getCashbackRate() * 100)
                        + "%");

        System.out.println(
                "========================");
    }

    public abstract double getTransactionLimit();
    public abstract double getCashbackRate();
    public abstract String getAccountType();
}