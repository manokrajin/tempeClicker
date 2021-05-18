import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class display {

    JLabel counterLabel, perSecLabel;
    int tempeCounter=0;
    Font font1, font2;

    aksi tempeAksi = new aksi();

    public void createFont(){
        font1 = new Font("Comic Sans MS", Font.PLAIN, 32);
        font2 = new Font("Comic Sans MS", Font.PLAIN, 18);
    }

    public void createUI(){

        JFrame window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);

        JPanel tempePanel = new JPanel();
        tempePanel.setBounds(100, 200, 200, 200);
        tempePanel.setBackground(Color.black);
        window.add(tempePanel);

        ImageIcon tempe = new ImageIcon(getClass().getClassLoader().getResource("tempeUtama.png"));
        JButton tempeButton = new JButton();
        tempeButton.setBackground(Color.black);
        tempeButton.setFocusPainted(false);
        tempeButton.setBorder(null);
        tempeButton.setIcon(tempe);
        tempeButton.addActionListener(tempeAksi);
        tempePanel.add(tempeButton);

        JPanel counterPanel = new JPanel();
        counterPanel.setBounds(100, 100, 200, 100);
        counterPanel.setBackground(Color.black);
        counterPanel.setLayout(new GridLayout(2,1));
        window.add(counterPanel);

        counterLabel = new JLabel(tempeCounter + " Tempe ");
        counterLabel.setForeground(Color.white);
        counterLabel.setFont(font1);
        counterPanel.add(counterLabel);

        perSecLabel = new JLabel();
        perSecLabel.setForeground(Color.white);
        perSecLabel.setFont(font2);
        counterPanel.add(perSecLabel);

        window.setVisible(true);
    }
    public class aksi implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            tempeCounter++;
            counterLabel.setText(tempeCounter + " Tempe");
        }
    }

}
