import javax.swing.JFrame;

public class HalamanUtama extends JFrame {

    public HalamanUtama() {

        initComponents();

        setTitle("Menu Utama");
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        dataMahasiswa =
                new javax.swing.JButton();

        keluar =
                new javax.swing.JButton();

        setDefaultCloseOperation(
                javax.swing.WindowConstants.EXIT_ON_CLOSE);

        dataMahasiswa.setText(
                "Data Mahasiswa");

        keluar.setText("Keluar");

        dataMahasiswa.addActionListener(evt -> {

            FormNilaiMhs fm =
                    new FormNilaiMhs();

            fm.setVisible(true);

            dispose();
        });

        keluar.addActionListener(evt -> {

            System.exit(0);

        });

        javax.swing.GroupLayout layout =
                new javax.swing.GroupLayout(
                        getContentPane());

        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(
                                javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(
                                dataMahasiswa,
                                200,
                                200,
                                200)
                        .addComponent(
                                keluar,
                                200,
                                200,
                                200));

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGap(40)
                        .addComponent(dataMahasiswa)
                        .addGap(20)
                        .addComponent(keluar)
                        .addGap(40));

        pack();
    }

    private javax.swing.JButton dataMahasiswa;
    private javax.swing.JButton keluar;

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(
                () -> new HalamanUtama()
                        .setVisible(true));
    }
}