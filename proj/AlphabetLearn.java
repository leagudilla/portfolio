package proj;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
public class AlphabetLearn extends JFrame{

    JButton Abtn, Bbtn, Cbtn, Dbtn, Ebtn, Fbtn, Gbtn, Hbtn, Ibtn, Jbtn, Kbtn, Lbtn, Mbtn, Nbtn, Obtn, Pbtn, Qbtn, Rbtn, Sbtn, Tbtn;
    JButton Ubtn, Vbtn, Wbtn, Xbtn, Ybtn, Zbtn, backButton;
    public AlphabetLearn() {
        setTitle("KiddieLearn");
        setSize(1000, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("KIDDIELEARN.jpg"));
        setIconImage(icon.getImage());

        JPanel background = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon bg = new ImageIcon(getClass().getClassLoader().getResource("shapeslearn.png"));
                Image image = bg.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };

        Abtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("letterA.png")));
        Abtn.setBounds(120,50,120,120);
        Abtn.setOpaque(false);
        Abtn.setBorder(null);
        Abtn.setContentAreaFilled(false);
        Abtn.setFocusPainted(false);
        ImageIcon APressed = new ImageIcon("A_pressed.png");
        Abtn.setPressedIcon(APressed);

        Abtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	playMusic("A.wav");
            }
        });

        Bbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("letterB.png")));
        Bbtn.setBounds(270,50,120,120);
        Bbtn.setOpaque(false);
        Bbtn.setBorder(null);
        Bbtn.setContentAreaFilled(false);
        Bbtn.setFocusPainted(false);
        ImageIcon BPressed = new ImageIcon("B_pressed.png");
        Bbtn.setPressedIcon(BPressed);

        Bbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	playMusic("B.wav");
            }
        });

        Cbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("letterC.png")));
        Cbtn.setBounds(420,50,120,120);
        Cbtn.setOpaque(false);
        Cbtn.setBorder(null);
        Cbtn.setContentAreaFilled(false);
        Cbtn.setFocusPainted(false);
        ImageIcon CPressed = new ImageIcon("C_pressed.png");
        Cbtn.setPressedIcon(CPressed);

        Cbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	playMusic("C.wav");
            }
        });

        Dbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("letterD.png")));
        Dbtn.setBounds(570,50,120,120);
        Dbtn.setOpaque(false);
        Dbtn.setBorder(null);
        Dbtn.setContentAreaFilled(false);
        Dbtn.setFocusPainted(false);
        ImageIcon DPressed = new ImageIcon("D_pressed.png");
        Dbtn.setPressedIcon(DPressed);

        Dbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	playMusic("D.wav");
            }
        });

        Ebtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("letterE.png")));
        Ebtn.setBounds(720,50,120,120);
        Ebtn.setOpaque(false);
        Ebtn.setBorder(null);
        Ebtn.setContentAreaFilled(false);
        Ebtn.setFocusPainted(false);
        ImageIcon EPressed = new ImageIcon("E_pressed.png");
        Ebtn.setPressedIcon(EPressed);

        Ebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	playMusic("E.wav");
            }
        });

        Fbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("letterF.png")));
        Fbtn.setBounds(120,120,120,120);
        Fbtn.setOpaque(false);
        Fbtn.setBorder(null);
        Fbtn.setContentAreaFilled(false);
        Fbtn.setFocusPainted(false);
        ImageIcon FPressed = new ImageIcon("F_pressed.png");
        Fbtn.setPressedIcon(FPressed);

        Fbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	playMusic("F.wav");
            }
        });

        Gbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("letterG.png")));
        Gbtn.setBounds(270,120,120,120);
        Gbtn.setOpaque(false);
        Gbtn.setBorder(null);
        Gbtn.setContentAreaFilled(false);
        Gbtn.setFocusPainted(false);
        ImageIcon GPressed = new ImageIcon("G_pressed.png");
        Gbtn.setPressedIcon(GPressed);

        Gbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	playMusic("G.wav");
            }
        });

        Hbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("letterH.png")));
        Hbtn.setBounds(420,120,120,120);
        Hbtn.setOpaque(false);
        Hbtn.setBorder(null);
        Hbtn.setContentAreaFilled(false);
        Hbtn.setFocusPainted(false);
        ImageIcon HPressed = new ImageIcon("H_pressed.png");
        Hbtn.setPressedIcon(HPressed);

        Hbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	playMusic("H.wav");
            }
        });

        Ibtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("letterI.png")));
        Ibtn.setBounds(570,120,120,120);
        Ibtn.setOpaque(false);
        Ibtn.setBorder(null);
        Ibtn.setContentAreaFilled(false);
        Ibtn.setFocusPainted(false);
        ImageIcon IPressed = new ImageIcon("I_pressed.png");
        Ibtn.setPressedIcon(IPressed);

        Ibtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	playMusic("I.wav");
            }
        });

        Jbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("letterJ.png")));
        Jbtn.setBounds(720,120,120,120);
        Jbtn.setOpaque(false);
        Jbtn.setBorder(null);
        Jbtn.setContentAreaFilled(false);
        Jbtn.setFocusPainted(false);
        ImageIcon JPressed = new ImageIcon("J_pressed.png");
        Jbtn.setPressedIcon(JPressed);

        Jbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	playMusic("J.wav");
            }
        });

        Kbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("letterK.png")));
        Kbtn.setBounds( 120,190,120,120);
        Kbtn.setOpaque(false);
        Kbtn.setBorder(null);
        Kbtn.setContentAreaFilled(false);
        Kbtn.setFocusPainted(false);
        ImageIcon KPressed = new ImageIcon("K_pressed.png");
        Kbtn.setPressedIcon(KPressed);

        Kbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	playMusic("K.wav");
            }
        });

        Lbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("letterL.png")));
        Lbtn.setBounds(270,190,120,120);
        Lbtn.setOpaque(false);
        Lbtn.setBorder(null);
        Lbtn.setContentAreaFilled(false);
        Lbtn.setFocusPainted(false);
        ImageIcon LPressed = new ImageIcon("L_pressed.png");
        Lbtn.setPressedIcon(LPressed);

        Lbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	playMusic("L.wav");
            }
        });

        Mbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("letterM.png")));
        Mbtn.setBounds(420,190,120,120);
        Mbtn.setOpaque(false);
        Mbtn.setBorder(null);
        Mbtn.setContentAreaFilled(false);
        Mbtn.setFocusPainted(false);
        ImageIcon MPressed = new ImageIcon("M_pressed.png");
        Mbtn.setPressedIcon(MPressed);

        Mbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	playMusic("M.wav");
            }
        });

        Nbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("letterN.png")));
        Nbtn.setBounds(570,190,120,120);
        Nbtn.setOpaque(false);
        Nbtn.setBorder(null);
        Nbtn.setContentAreaFilled(false);
        Nbtn.setFocusPainted(false);
        ImageIcon NPressed = new ImageIcon("N_pressed.png");
        Nbtn.setPressedIcon(NPressed);

        Nbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	playMusic("N.wav");
            }
        });

        Obtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("letterO.png")));
        Obtn.setBounds(720,190,120,120);
        Obtn.setOpaque(false);
        Obtn.setBorder(null);
        Obtn.setContentAreaFilled(false);
        Obtn.setFocusPainted(false);
        ImageIcon OPressed = new ImageIcon("O_pressed.png");
        Obtn.setPressedIcon(OPressed);

        Obtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	playMusic("O.wav");
            }
        });

        Pbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("letterP.png")));
        Pbtn.setBounds(120,260,120,120);
        Pbtn.setOpaque(false);
        Pbtn.setBorder(null);
        Pbtn.setContentAreaFilled(false);
        Pbtn.setFocusPainted(false);
        ImageIcon PPressed = new ImageIcon("P_pressed.png");
        Pbtn.setPressedIcon(PPressed);

        Pbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	playMusic("P.wav");
            }
        });

        Qbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("letterQ.png")));
        Qbtn.setBounds(270,260,120,120);
        Qbtn.setOpaque(false);
        Qbtn.setBorder(null);
        Qbtn.setContentAreaFilled(false);
        Qbtn.setFocusPainted(false);
        ImageIcon QPressed = new ImageIcon("Q_pressed.png");
        Qbtn.setPressedIcon(QPressed);

        Qbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	playMusic("Q.wav");
            }
        });

        Rbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("letterR.png")));
        Rbtn.setBounds(420,260,120,120);
        Rbtn.setOpaque(false);
        Rbtn.setBorder(null);
        Rbtn.setContentAreaFilled(false);
        Rbtn.setFocusPainted(false);
        ImageIcon RPressed = new ImageIcon("R_pressed.png");
        Rbtn.setPressedIcon(RPressed);

        Rbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	playMusic("R.wav");
            }
        });

        Sbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("letterS.png")));
        Sbtn.setBounds(570,260,120,120);
        Sbtn.setOpaque(false);
        Sbtn.setBorder(null);
        Sbtn.setContentAreaFilled(false);
        Sbtn.setFocusPainted(false);
        ImageIcon SPressed = new ImageIcon("S_pressed.png");
        Sbtn.setPressedIcon(SPressed);

        Sbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	playMusic("S.wav");
            }
        });

        Tbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("letterT.png")));
        Tbtn.setBounds(720,260,120,120);
        Tbtn.setOpaque(false);
        Tbtn.setBorder(null);
        Tbtn.setContentAreaFilled(false);
        Tbtn.setFocusPainted(false);
        ImageIcon TPressed = new ImageIcon("T_pressed.png");
        Tbtn.setPressedIcon(TPressed);

        Tbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playMusic("T.wav");
            }
        });

        Ubtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("letterU.png")));
        Ubtn.setBounds(120,320,120,120);
        Ubtn.setOpaque(false);
        Ubtn.setBorder(null);
        Ubtn.setContentAreaFilled(false);
        Ubtn.setFocusPainted(false);
        ImageIcon UPressed = new ImageIcon("U_pressed.png");
        Ubtn.setPressedIcon(UPressed);

        Ubtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	playMusic("U.wav");
            }
        });

        Vbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("letterV.png")));
        Vbtn.setBounds(270,320,120,120);
        Vbtn.setOpaque(false);
        Vbtn.setBorder(null);
        Vbtn.setContentAreaFilled(false);
        Vbtn.setFocusPainted(false);
        ImageIcon VPressed = new ImageIcon("V_pressed.png");
        Vbtn.setPressedIcon(VPressed);

        Vbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	playMusic("V.wav");
            }
        });

        Wbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("letterW.png")));
        Wbtn.setBounds(420,320,120,120);
        Wbtn.setOpaque(false);
        Wbtn.setBorder(null);
        Wbtn.setContentAreaFilled(false);
        Wbtn.setFocusPainted(false);
        ImageIcon WPressed = new ImageIcon("W_pressed.png");
        Wbtn.setPressedIcon(WPressed);

        Wbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	playMusic("W.wav");
            }
        });

        Xbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("letterX.png")));
        Xbtn.setBounds(570,320,120,120);
        Xbtn.setOpaque(false);
        Xbtn.setBorder(null);
        Xbtn.setContentAreaFilled(false);
        Xbtn.setFocusPainted(false);
        ImageIcon XPressed = new ImageIcon("X_pressed.png");
        Xbtn.setPressedIcon(XPressed);

        Xbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	playMusic("X.wav");
            }
        });

        Ybtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("letterY.png")));
        Ybtn.setBounds(720,320,120,120);
        Ybtn.setOpaque(false);
        Ybtn.setBorder(null);
        Ybtn.setContentAreaFilled(false);
        Ybtn.setFocusPainted(false);
        ImageIcon YPressed = new ImageIcon("Y_pressed.png");
        Ybtn.setPressedIcon(YPressed);

        Ybtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	playMusic("Y.wav");
            }
        });

        Zbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("letterZ.png")));
        Zbtn.setBounds(420,380,120,120);
        Zbtn.setOpaque(false);
        Zbtn.setBorder(null);
        Zbtn.setContentAreaFilled(false);
        Zbtn.setFocusPainted(false);
        ImageIcon ZPressed = new ImageIcon("Z_pressed.png");
        Zbtn.setPressedIcon(ZPressed);

        Zbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	playMusic("Z.wav");
            }
        });




        backButton = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("back.png")));
        backButton.setBounds(8, 23, 100, 60);
        backButton.setOpaque(false);
        backButton.setBorder(null);
        backButton.setContentAreaFilled(false);
        backButton.setFocusPainted(false);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	buttonSound();
                dispose();
                new Alphabet();
            }
        });


        background.setLayout(null);
        background.add(backButton);
        background.add(Abtn);
        background.add(Bbtn);
        background.add(Cbtn);
        background.add(Dbtn);
        background.add(Ebtn);
        background.add(Fbtn);
        background.add(Gbtn);
        background.add(Hbtn);
        background.add(Ibtn);
        background.add(Jbtn);
        background.add(Kbtn);
        background.add(Lbtn);
        background.add(Mbtn);
        background.add(Nbtn);
        background.add(Obtn);
        background.add(Pbtn);
        background.add(Qbtn);
        background.add(Rbtn);
        background.add(Sbtn);
        background.add(Tbtn);
        background.add(Ubtn);
        background.add(Vbtn);
        background.add(Wbtn);
        background.add(Xbtn);
        background.add(Ybtn);
        background.add(Zbtn);


        add(background, BorderLayout.CENTER);
        setVisible(true);

    }
    private void buttonSound() {
        playMusic("select1.wav");
    }

    private void playMusic(String filePath) {
        try {
            URL url = getClass().getClassLoader().getResource(filePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            System.out.println("Error playing music: " + e.getMessage());
        }
    }
   
    
}

