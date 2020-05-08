import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

public class Create extends JFrame {
    JLabel lTitle, lNegara, lPos, lSembuh, lMati,lTgl,lId;
    JTextField fNegara, fPos, fSembuh, fMati,fTgl,fId;
    JButton bSave, bBack;
    Statement statement;
    String negara,tgl ;
    int pos, mati,sembuh,id;

    public Create(){
        setTitle("INPUT DATA");
        lTitle = new JLabel("Input Data");
        lTitle.setFont(new Font("Regular", Font.BOLD, 22));
        lTitle.setForeground(new Color(247, 252, 255));
        
        lId = new JLabel("ID Negara");
        lId.setFont(new Font("Regular", Font.PLAIN, 18));
        lId.setForeground(new Color(247, 252, 255));
        fId = new JTextField();
        fId.setFont(new Font("Regular", Font.PLAIN, 16));
        fId.setForeground(new Color(0, 0, 0));
        fId.setBackground(new Color(247, 252, 255));
        
        lNegara = new JLabel("Negara ");
        lNegara.setFont(new Font("Regular", Font.PLAIN, 18));
        lNegara.setForeground(new Color(247, 252, 255));
        fNegara = new JTextField();
        fNegara.setFont(new Font("Regular", Font.PLAIN, 16));
        fNegara.setForeground(new Color(0, 0, 0));
        fNegara.setBackground(new Color(247, 252, 255));
        
        lPos = new JLabel("Positif ");
        lPos.setFont(new Font("Regular", Font.PLAIN, 18));
        lPos.setForeground(new Color(247, 252, 255));
        fPos = new JTextField();
        fPos.setFont(new Font("Regular", Font.PLAIN, 16));
        fPos.setForeground(new Color(0, 0, 0));
        fPos.setBackground(new Color(247, 252, 255));
        
        lSembuh = new JLabel("Sembuh ");
        lSembuh.setFont(new Font("Regular", Font.PLAIN, 18));
        lSembuh.setForeground(new Color(247, 252, 255));
        fSembuh = new JTextField();
        fSembuh.setFont(new Font("Regular", Font.PLAIN, 16));
        fSembuh.setForeground(new Color(0, 0, 0));
        fSembuh.setBackground(new Color(247, 252, 255));
        
        lMati = new JLabel("Meninggal ");
        lMati.setFont(new Font("Regular", Font.PLAIN, 18));
        lMati.setForeground(new Color(247, 252, 255));
        fMati = new JTextField();
        fMati.setFont(new Font("Regular", Font.PLAIN, 16));
        fMati.setForeground(new Color(0, 0, 0));
        fMati.setBackground(new Color(247, 252, 255));
        
        lTgl = new JLabel("Tanggal ");
        lTgl.setFont(new Font("Regular", Font.PLAIN, 18));
        lTgl.setForeground(new Color(247, 252, 255));
        fTgl = new JTextField();
        fTgl.setFont(new Font("Regular", Font.PLAIN, 16));
        fTgl.setForeground(new Color(0, 0, 0));
        fTgl.setBackground(new Color(247, 252, 255));

        bSave = new JButton("Input");
        bSave.setFont(new Font("Regular",Font.PLAIN, 14));
        bSave.setBackground(new Color(247, 252, 255));
        bBack = new JButton("Kembali");
        bBack.setFont(new Font("Regular",Font.PLAIN, 14));
        bBack.setBackground(new Color(247, 252, 255));

        getContentPane().setBackground(new Color(0, 0, 0));

        setLayout(null);
        add(lTitle);
        add(lId);
        add(fId);
        add(lNegara);
        add(fNegara);
        add(lPos);
        add(fPos);
        add(lSembuh);
        add(fSembuh);
        add(lMati);
        add(fMati);
        add(lTgl);
        add(fTgl);
        add(bSave);
        add(bBack);

        lTitle.setBounds(30, 20, 250, 30);
        lId.setBounds(30, 70, 120, 30);
        fId.setBounds(130, 73,270,25);
        lNegara.setBounds(30, 110, 120, 30);
        fNegara.setBounds(130, 110, 270, 30);
        lPos.setBounds(30, 150, 120, 30);
        fPos.setBounds(130, 153, 270, 25);
        lSembuh.setBounds(30, 190, 120, 30);
        fSembuh.setBounds(130, 193, 270, 25);
        lMati.setBounds(30, 230, 120, 30);
        fMati.setBounds(130, 233, 270, 25);
        lTgl.setBounds(30, 270, 120, 30);
        fTgl.setBounds(130, 273, 270, 25);
        bSave.setBounds(310, 320, 90, 30);
        bBack.setBounds(30, 370, 90,30);

        setSize(440, 450);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        bSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    id = Integer.parseInt(fId.getText());
                    negara = fNegara.getText();
                    pos = Integer.parseInt(fPos.getText());
                    sembuh = Integer.parseInt(fSembuh.getText());
                    mati = Integer.parseInt(fMati.getText());
                    tgl=fTgl.getText();

                    Data data = new Data(id,negara, pos, sembuh, mati,tgl);

                    Koneksi connec = new Koneksi();
                    try {
                        statement = connec.getConnection().createStatement();
                        statement.executeUpdate("INSERT INTO tabel_covid VALUES('" + data.getId() + "','" + data.getTgl() + "','" + data.getNegara() + "','" + data.getPos() + "','" + data.getSembuh() + "','" + data.getMati() + "')");
                        JOptionPane.showMessageDialog(rootPane, "Data Berhasil Disimpan");
                    } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(Create.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        java.util.logging.Logger.getLogger(Create.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Tipe Data yang Anda Masukkan Salah");
                }catch (Error ext){
                    JOptionPane.showMessageDialog(rootPane, "Error!?!?!?");
                }

                setVisible(false);
            }
        });

        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Main();
            }
        });
    }
}
