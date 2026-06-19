public class Mhs {

    private String nim;
    private String nama;

    private double nilaiUTS;
    private double nilaiUAS;
    private double nilaiTugas;

    public Mhs(
            String nim,
            String nama,
            double nilaiUTS,
            double nilaiUAS,
            double nilaiTugas) {

        this.nim = nim;
        this.nama = nama;
        this.nilaiUTS = nilaiUTS;
        this.nilaiUAS = nilaiUAS;
        this.nilaiTugas = nilaiTugas;
    }

    public double uts() {
        return nilaiUTS * 0.30;
    }

    public double uas() {
        return nilaiUAS * 0.40;
    }

    public double tugas() {
        return nilaiTugas * 0.30;
    }

    public double nilaiAkhir() {
        return uts() + uas() + tugas();
    }

    public String getNilHuruf(double nilai) {

        if (nilai >= 85)
            return "A";
        else if (nilai >= 70)
            return "B";
        else if (nilai >= 60)
            return "C";
        else if (nilai >= 50)
            return "D";
        else
            return "E";
    }

    public String getPredikat(String huruf) {

        switch (huruf) {

            case "A":
                return "Sangat Baik";

            case "B":
                return "Baik";

            case "C":
                return "Cukup";

            case "D":
                return "Kurang";

            default:
                return "Gagal";
        }
    }
}