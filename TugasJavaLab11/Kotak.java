public class Kotak extends BangunDatar implements Resizeable {  
    private double panjang;
    private double lebar;

    public Kotak(double panjang, double lebar) {
        super(4);
        this.panjang = panjang;
        this.lebar = lebar;
    }

    @Override
    public double getLuas() { return panjang * lebar; }

    @Override
    public double getKeliling() { return 2 * (panjang + lebar); }

    @Override
    public void resize(double x) {  
        this.panjang = this.panjang * x;
        this.lebar = this.lebar * x;
    }
}