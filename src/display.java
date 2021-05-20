import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class display {

    JLabel counterLabel, perSecLabel, judulLabel, cursorLabel, wallpaper;
    JButton tempeBlessing,tempeTemple,tempeGod,clickByTheGod;
    int tempeCounter=0,tempeIncrement=1;
    Font font1, font2, font3;
    Timer timer;
    boolean timerOn = false;
    double perSecond;
    int timerSpeed;
    int tempeBlessingCounter = 1, tempeTempleCounter = 1, tempeGodCounter = 1;
    int clickByTheGodCounter = 1;
    int tempeBlessingPrice = 5, tempeTemplePrice = 10, tempeGodPrice = 20;
    int lvlBlessing =0, lvlTemple = 0, lvlGod = 0, lvlClickByGod = 0;
    int clickByTheGodPrice = 2;

    aksi tempeAksi = new aksi();

    public void createFont(){
        font1 = new Font("Comic Sans MS", Font.PLAIN, 32);
        font2 = new Font("Comic Sans MS", Font.PLAIN, 16);
        font3 = new Font("Comic Sans MS", Font.PLAIN, 8);
    }

    public void createUI(){


        JFrame window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);

        //JPanel wallpaperPanel = new JPanel();
        //wallpaperPanel.setBounds(0,0,800,600);
        //wallpaperPanel.setBackground(new Color(0,0,0,0));
        //window.add(wallpaperPanel);

        JPanel tempePanel = new JPanel();
        tempePanel.setBounds(280, 200, 200, 200);
        tempePanel.setBackground(new Color(0,0,0,0));
        window.add(tempePanel);

        JPanel judulPanel = new JPanel();
        judulPanel.setBounds(280, 20, 215, 100);
        judulPanel.setBackground(new Color(0,0,0,0));
        window.add(judulPanel);

        judulLabel = new JLabel(" Tempe Clicker");
        judulLabel.setForeground(Color.white);
        judulLabel.setFont(font1);
        judulPanel.add(judulLabel);

        //JLabel wallpaper = new JLabel(new ImageIcon (getClass().getClassLoader().getResource("jiso.jpg")));
        //wallpaperPanel.add(wallpaper);

        ImageIcon tempe = new ImageIcon(getClass().getClassLoader().getResource("tempeee png 8 bit.png"));
        JButton tempeButton = new JButton();
        tempeButton.setBackground(Color.black);
        tempeButton.setFocusPainted(false);
        tempeButton.setBorder(null);
        tempeButton.setIcon(tempe);
        tempeButton.addActionListener(tempeAksi);
        tempeButton.setActionCommand("tempeAdd");
        tempePanel.add(tempeButton);

        JPanel counterPanel = new JPanel();
        counterPanel.setBounds(50, 40, 200, 100);
        counterPanel.setBackground(Color.black);
        counterPanel.setLayout(new GridLayout(3,1));
        window.add(counterPanel);

        counterLabel = new JLabel(tempeCounter + " Tempe ");
        counterLabel.setForeground(Color.white);
        counterLabel.setFont(font1);
        counterPanel.add(counterLabel);

        perSecLabel = new JLabel("Tempe/s : 0");
        perSecLabel.setForeground(Color.white);
        perSecLabel.setFont(font2);
        counterPanel.add(perSecLabel);

        cursorLabel = new JLabel("Power : "+clickByTheGodCounter+"/click");
        cursorLabel.setForeground(Color.WHITE);
        cursorLabel.setFont(font2);
        counterPanel.add(cursorLabel);


        JPanel upgrade = new JPanel();
        upgrade.setBounds(550, 120, 200,200);
        upgrade.setBackground(Color.blue);
        upgrade.setLayout(new GridLayout(4,2));
        window.add(upgrade);

        tempeBlessing = new JButton("Tempe Blessing");
        tempeBlessing.setFont(font2);
        tempeBlessing.setFocusPainted(false);
        tempeBlessing.addActionListener(tempeAksi);
        tempeBlessing.setActionCommand("tempeBlessing");
        upgrade.add(tempeBlessing);

        tempeTemple = new JButton("Tempe Temple");
        tempeTemple.setFont(font2);
        tempeTemple.setFocusPainted(false);
        tempeTemple.addActionListener(tempeAksi);
        tempeTemple.setActionCommand("tempeTemple");
        upgrade.add(tempeTemple);
        
        tempeGod = new JButton("Tempe God");
        tempeGod.setFont(font2);
        tempeGod.setFocusPainted(false);
        tempeGod.addActionListener(tempeAksi);
        tempeGod.setActionCommand("tempeGod");
        upgrade.add(tempeGod);

        clickByTheGod = new JButton("God Clicker");
        clickByTheGod.setFont(font2);
        clickByTheGod.setFocusPainted(false);
        clickByTheGod.addActionListener(tempeAksi);
        clickByTheGod.setActionCommand("clickByTheGod");
        upgrade.add(clickByTheGod);


        window.setVisible(true);
    }

    public void setTimer(){
        timer = new Timer(timerSpeed, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                
                tempeCounter++;
                counterLabel.setText(tempeCounter + " Tempe");
            }
        });
    }

    public void timerUpdate() {
        if(timerOn=false){
            timerOn = true;
        }
        else if(timerOn=true){
            timerOn = false;
        }

        double speed = 1/perSecond*1000;
        timerSpeed = (int)Math.round(speed);
        String s = String.format("%.2f", perSecond);
        perSecLabel.setText("Tempe/s : " + s);

        setTimer();
        timer.start();
    }
    public class aksi implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            
            String action = event.getActionCommand();
            
            switch (action) {
                case "tempeAdd":
                    tempeCounter = tempeCounter + tempeIncrement;
                    counterLabel.setText(tempeCounter + " Tempe");
                break;
                case "tempeBlessing":
                    if (tempeCounter >= tempeBlessingPrice) {
                        tempeCounter = tempeCounter-tempeBlessingPrice;
                        tempeBlessingPrice=tempeBlessingPrice+5;
                        tempeBlessingCounter++;
                        lvlBlessing++;
                        tempeBlessing.setText("Tempe Blessing lv "+ lvlBlessing);
                        perSecond = perSecond + 0.1;
                        timerUpdate();
                    }
                    counterLabel.setText(tempeCounter + " Tempe");
                break;
                case "tempeTemple":
                    if (tempeCounter >= tempeTemplePrice) {
                        tempeCounter = tempeCounter-tempeTemplePrice;
                        tempeTemplePrice=tempeTemplePrice+10;
                        tempeTempleCounter++;
                        lvlTemple++;
                        tempeTemple.setText("Tempe Temple lv "+ lvlTemple);
                        perSecond = perSecond + 0.5;
                        timerUpdate();
                    }
                counterLabel.setText(tempeCounter + " Tempe");
                break;
                case "tempeGod":
                    if (tempeCounter >= tempeGodPrice) {
                        tempeCounter = tempeCounter-tempeGodPrice;
                        tempeGodPrice=tempeGodPrice+15;
                        tempeGodCounter++;
                        lvlGod++;
                        tempeGod.setText("Tempe God lv "+ lvlGod);
                        perSecond = perSecond + 1.0;
                        timerUpdate();
                    }
                    counterLabel.setText(tempeCounter + " Tempe");
                break;
                case "clickByTheGod":
                    if (tempeCounter >= clickByTheGodPrice) {
                        tempeCounter = tempeCounter-clickByTheGodPrice;
                        tempeIncrement++;
                        clickByTheGodCounter++;
                        lvlClickByGod++;
                        clickByTheGod.setText("God Clicker lv "+ lvlClickByGod);
                        cursorLabel.setText("Power : "+clickByTheGodCounter+"/click");
                        clickByTheGodPrice = clickByTheGodPrice*clickByTheGodPrice;
                    }
                    counterLabel.setText(tempeCounter + " Tempe");
                    
                    break;
            }
      
        }
    }

}
