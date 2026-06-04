public class Sepeda extends Kendaraan {
    private boolean isAuto; 

    public Sepeda(boolean isAuto) {
        this.isAuto = isAuto;
    }

    @Override
    public void jenis() { 
        if (this.isAuto) {
            System.out.println("Sepeda otomatis"); 
        } else {
            System.out.println("Sepeda kayuh"); 
        }
    }
}