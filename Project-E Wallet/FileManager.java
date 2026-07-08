import java.io.*;
import java.util.ArrayList;

public class FileManager {
    public static void saveUsers(
            ArrayList<User> users){

        try{

            ObjectOutputStream out =
                    new ObjectOutputStream(
                            new FileOutputStream(
                                    "users.dat"));

            out.writeObject(users);

            out.close();

            System.out.println(
                    "Data user berhasil disimpan.");

        }

        catch(Exception e){

            System.out.println(
                    "Gagal menyimpan user.");

        }

    }

    @SuppressWarnings("unchecked")
    public static ArrayList<User> loadUsers(){

        ArrayList<User> users =
                new ArrayList<>();

        try{

            ObjectInputStream in =
                    new ObjectInputStream(
                            new FileInputStream(
                                    "users.dat"));

            users =
                    (ArrayList<User>)
                            in.readObject();

            in.close();

            System.out.println(
                    "Data user berhasil dimuat.");

        }

        catch(Exception e){

            System.out.println(
                    "Belum ada data user.");

        }

        return users;

    }

    public static void saveTransactionHistory(
            User user){

        try{

            PrintWriter writer =
                    new PrintWriter(
                            new FileWriter(
                                    "transactions.txt",
                                    true));

            for(Transaction t :
                    user.getHistory()){

                writer.println(
                        user.getName() +
                        ";" +
                        t.toString());

            }

            writer.close();

            System.out.println(
                    "Riwayat transaksi disimpan.");

        }

        catch(Exception e){

            System.out.println(
                    "Gagal menyimpan transaksi.");

        }

    }

}