import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction implements Serializable {

    private String time;
    private String type;
    private double amount;
    private String status;

    public Transaction(String type,
                       double amount,
                       String status) {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern(
                        "dd-MM-yyyy HH:mm:ss");

        this.time =
                LocalDateTime.now().format(formatter);

        this.type = type;
        this.amount = amount;
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public void showTransaction() {

        System.out.println(
                time +
                " | " +
                type +
                " | Rp" +
                amount +
                " | " +
                status
        );
    }

    @Override
    public String toString() {

        return time + ";" +
                type + ";" +
                amount + ";" +
                status;
    }
}