public class Segitiga extends BangunDatar {
    private double alas;   
    private double tinggi; 

    public Segitiga(double alas, double tinggi) {
        super(3); 
        this.alas = alas;
        this.tinggi = tinggi;
    }

    @Override
    public double getLuas() { return 0.5 * alas * tinggi; }

    @Override
    public double getKeliling() {
        double sisiMiring = Math.sqrt((alas / 2 * alas / 2) + (tinggi * tinggi));
        return alas + (2 * sisiMiring);
    }
}