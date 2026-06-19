import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FormNilaiMhs extends javax.swing.JFrame {

    DefaultTableModel tabelModel;

    DBConnection db = new DBConnection();
    Connection con = db.getConnection();

    public FormNilaiMhs() {

        initComponents();

        tabelModel = new DefaultTableModel();

        tabel.setModel(tabelModel);

        tabelModel.addColumn("No");
        tabelModel.addColumn("NIM");
        tabelModel.addColumn("Nama");
        tabelModel.addColumn("Nilai UTS");
        tabelModel.addColumn("Nilai UAS");
        tabelModel.addColumn("Nilai Tugas");
        tabelModel.addColumn("Nilai Akhir");
        tabelModel.addColumn("Nilai Huruf");
        tabelModel.addColumn("Predikat");

        setLocationRelativeTo(null);
        setResizable(false);

        try {
            tampilkanDiTabel();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        nUTS1.setEditable(false);
        nUAS1.setEditable(false);
        nTugas1.setEditable(false);

        nUTS2.setEditable(false);
        nUAS2.setEditable(false);
        nTugas2.setEditable(false);

        simpan.setEnabled(false);
        update.setEnabled(false);
        hapus.setEnabled(false);
        proses1.setEnabled(false);
    }

    private void kosongkanTextField() {

        JTextField[] fields = {
            nim, nama, nUTS, nUAS, nTugas,
            nUTS1, nUAS1, nTugas1,
            nUTS2, nUAS2, nTugas2
        };

        for (JTextField field : fields) {
            field.setText("");
        }
    }

    private void prosesHitungNilai() {

        try {

            String ni = nim.getText();
            String na = nama.getText();

            double uts = Double.parseDouble(nUTS.getText());
            double uas = Double.parseDouble(nUAS.getText());
            double tugas = Double.parseDouble(nTugas.getText());

            Mhs m = new Mhs(
                    ni,
                    na,
                    uts,
                    uas,
                    tugas
            );

            nUTS1.setText(String.valueOf(m.uts()));
            nUAS1.setText(String.valueOf(m.uas()));
            nTugas1.setText(String.valueOf(m.tugas()));

            nUTS2.setText(String.valueOf(m.nilaiAkhir()));

            nUAS2.setText(
                    m.getNilHuruf(
                            m.nilaiAkhir()
                    )
            );

            nTugas2.setText(
                    m.getPredikat(
                            m.getNilHuruf(
                                    m.nilaiAkhir()
                            )
                    )
            );

            simpan.setEnabled(true);

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Input tidak valid",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }

    public ArrayList<ArrayList<Object>> getMhsList()
            throws SQLException {

        ArrayList<ArrayList<Object>> data =
                new ArrayList<>();

        Statement st = con.createStatement();

        ResultSet rs =
                st.executeQuery(
                        "SELECT * FROM mhs"
                );

        while (rs.next()) {

            ArrayList<Object> row =
                    new ArrayList<>();

            row.add(rs.getString("nim"));
            row.add(rs.getString("nama"));
            row.add(rs.getDouble("nilai_uts"));
            row.add(rs.getDouble("nilai_uas"));
            row.add(rs.getDouble("nilai_tugas"));
            row.add(rs.getDouble("nilai_akhir"));
            row.add(rs.getString("nilai_huruf"));
            row.add(rs.getString("predikat"));

            data.add(row);
        }

        return data;
    }

    private void tampilkanDiTabel()
            throws SQLException {

        tabelModel.setRowCount(0);

        ArrayList<ArrayList<Object>> data =
                getMhsList();

        for (int i = 0; i < data.size(); i++) {

            tabelModel.addRow(new Object[]{
                i + 1,
                data.get(i).get(0),
                data.get(i).get(1),
                data.get(i).get(2),
                data.get(i).get(3),
                data.get(i).get(4),
                data.get(i).get(5),
                data.get(i).get(6),
                data.get(i).get(7)
            });
        }
    }

    private void kosongkanTabel() {

        DefaultTableModel model =
                (DefaultTableModel) tabel.getModel();

        model.setRowCount(0);
    }

    private void refreshData() {

        try {

            kosongkanTextField();
            kosongkanTabel();
            tampilkanDiTabel();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void terpilih(int index)
            throws SQLException {

        ArrayList<ArrayList<Object>> list =
                getMhsList();

        nim.setText(
                list.get(index).get(0).toString());

        nama.setText(
                list.get(index).get(1).toString());

        nUTS.setText(
                list.get(index).get(2).toString());

        nUAS.setText(
                list.get(index).get(3).toString());

        nTugas.setText(
                list.get(index).get(4).toString());
    }

    private void prosesActionPerformed(
            java.awt.event.ActionEvent evt) {

        prosesHitungNilai();
    }

    private void simpanActionPerformed(
            java.awt.event.ActionEvent evt) {

        String sql =
                "INSERT INTO mhs VALUES(?,?,?,?,?,?,?,?)";

        try (PreparedStatement ps =
                     con.prepareStatement(sql)) {

            ps.setString(1, nim.getText());
            ps.setString(2, nama.getText());
            ps.setString(3, nUTS.getText());
            ps.setString(4, nUAS.getText());
            ps.setString(5, nTugas.getText());
            ps.setString(6, nUTS2.getText());
            ps.setString(7, nUAS2.getText());
            ps.setString(8, nTugas2.getText());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(
                    null,
                    "Data berhasil disimpan");

            refreshData();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Data gagal disimpan");
        }
    }

    private void tambahLainActionPerformed(
            java.awt.event.ActionEvent evt) {

        kosongkanTextField();
        simpan.setEnabled(false);
    }

    private void updateActionPerformed(
            java.awt.event.ActionEvent evt) {

        String sql =
                "UPDATE mhs SET "
                + "nama=?,"
                + "nilai_uts=?,"
                + "nilai_uas=?,"
                + "nilai_tugas=?,"
                + "nilai_akhir=?,"
                + "nilai_huruf=?,"
                + "predikat=? "
                + "WHERE nim=?";

        try (PreparedStatement ps =
                     con.prepareStatement(sql)) {

            ps.setString(1, nama.getText());
            ps.setString(2, nUTS.getText());
            ps.setString(3, nUAS.getText());
            ps.setString(4, nTugas.getText());
            ps.setString(5, nUTS2.getText());
            ps.setString(6, nUAS2.getText());
            ps.setString(7, nTugas2.getText());
            ps.setString(8, nim.getText());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(
                    null,
                    "Data berhasil diupdate");

            refreshData();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Data gagal diupdate");
        }
    }

    private void hapusActionPerformed(
            java.awt.event.ActionEvent evt) {

        try (PreparedStatement ps =
                     con.prepareStatement(
                             "DELETE FROM mhs WHERE nim=?")) {

            ps.setString(
                    1,
                    nim.getText());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(
                    null,
                    "Data berhasil dihapus");

            refreshData();

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Data gagal dihapus");
        }
    }

    private void tabelMouseClicked(
            java.awt.event.MouseEvent evt) {

        int index =
                tabel.getSelectedRow();

        try {

            terpilih(index);

        } catch (SQLException ex) {

            ex.printStackTrace();
        }

        proses1.setEnabled(true);
        hapus.setEnabled(true);
    }

    private void proses1ActionPerformed(
            java.awt.event.ActionEvent evt) {

        prosesHitungNilai();

        update.setEnabled(true);
    }
}