public class MainOverload {

    public static void main(String[] args) {

        System.out.println("Main utama");

        main(10);
        main("Java");
    }

    public static void main(int x) {
        System.out.println("Main int: " + x);
    }

    public static void main(String s) {
        System.out.println("Main String: " + s);
    }
}