public abstract class BangunDatar {
    protected int jumlahSisi; 
    protected int x;          
    protected int y;         

    public BangunDatar(int sisi) { 
        this.jumlahSisi = sisi;   
    }

    public void pindahkan(int x, int y) { this.x = x; this.y = y; } 
    public void draw() { System.out.println("Menggambar bangun."); } 
    public void resize() { System.out.println("Mengubah ukuran."); } 
    public int getJumlahSisi() { return this.jumlahSisi; }           

    public abstract double getLuas();     
    public abstract double getKeliling(); 
}