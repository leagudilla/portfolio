package proj;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.List;
import java.net.URL;

public class AlphabetTracing extends JFrame {

    private CardLayout cardLayout;
    private JPanel cardPanel;
    private int startX, startY;
    private Clip backgroundClip;


    public AlphabetTracing() {
        setTitle("KiddieLearn");
        setSize(1000, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("KIDDIELEARN.jpg"));
        setIconImage(icon.getImage());

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        JPanel panel1 = createPanel1();
        JPanel panel2 = createPanel2();
        JPanel panel3 = createPanel3();
        JPanel panel4 = createPanel4();
        JPanel panel5 = createPanel5();
        JPanel panel6 = createPanel6();
        JPanel panel7 = createPanel7();
        JPanel panel8 = createPanel8();
        JPanel panel9 = createPanel9();
        JPanel panel10 = createPanel10();
        JPanel panel11 = createPanel11();
        JPanel panel12 = createPanel12();
        JPanel panel13 = createPanel13();


        cardPanel.add(panel1, "Panel1");
        cardPanel.add(panel2, "Panel2");
        cardPanel.add(panel3, "Panel3");
        cardPanel.add(panel4, "Panel4");
        cardPanel.add(panel5, "Panel5");
        cardPanel.add(panel6, "Panel6");
        cardPanel.add(panel7, "Panel7");
        cardPanel.add(panel8, "Panel8");
        cardPanel.add(panel9, "Panel9");
        cardPanel.add(panel10, "Panel10");
        cardPanel.add(panel11, "Panel11");
        cardPanel.add(panel12, "Panel12");
        cardPanel.add(panel13, "Panel13");


        add(cardPanel);
        setVisible(true);
        
        playBackgroundMusic("bgmusic.wav");
        showInstructionsDialog();
        
    }

    private void showInstructionsDialog() {
        String message = "Welcome to KiddieLearn!\n\n"
                + "Instructions:\n"
                + "1. Click on a letter button to begin tracing.\n"
                + "2. Use the mouse to trace the letter displayed.\n"
                + "3. Click the eraser to erase any mistakes.\n"
                + "4. Use the arrow buttons to navigate between letters.\n"
                + "5. Click the back button to return to the menu.";

        JOptionPane.showMessageDialog(this, message, "Instructions", JOptionPane.INFORMATION_MESSAGE);
    }


    private JPanel createPanel1() {
        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon bg = new ImageIcon(getClass().getClassLoader().getResource("tracingbg.png"));
                Image image = bg.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setLayout(null);

        JButton Abtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("a1.png")));
        Abtn.setBounds(200, 170, 200, 200);
        Abtn.setOpaque(false);
        Abtn.setBorder(null);
        Abtn.setContentAreaFilled(false);
        Abtn.setFocusPainted(false);

        Abtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                displayImage(List.of("A.png", "B.png", "C.png", "D.png", "E.png", "F.png", "G.png", "H.png", "I.png", "J.png", "K.png", "L.png",
                        "M.png", "N.png", "O.png", "P.png", "Q.png", "R.png", "S.png", "T.png", "U.png", "V.png", "W.png", "X.png", "Y.png", "Z.png"), 0);
            }
        });

        JButton Bbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("b1.png")));
        Bbtn.setBounds(500, 170, 200, 200);
        Bbtn.setOpaque(false);
        Bbtn.setBorder(null);
        Bbtn.setContentAreaFilled(false);
        Bbtn.setFocusPainted(false);

        Bbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                displayImage(List.of("B.png", "C.png", "D.png", "E.png", "F.png", "G.png", "H.png", "I.png", "J.png", "K.png", "L.png",
                        "M.png", "N.png", "O.png", "P.png", "Q.png", "R.png", "S.png", "T.png", "U.png", "V.png", "W.png", "X.png", "Y.png", "Z.png"), 0);
            }
        });

        JButton nextBtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("next.png")));
        nextBtn.setBounds(780, 250, 50, 60);
        nextBtn.setOpaque(false);
        nextBtn.setBorder(null);
        nextBtn.setContentAreaFilled(false);
        nextBtn.setFocusPainted(false);

        nextBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                cardLayout.show(cardPanel, "Panel2");
            }
        });

        JButton backButton = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("back.png")));
        backButton.setBounds(8, 20, 100, 60);
        backButton.setOpaque(false);
        backButton.setBorder(null);
        backButton.setContentAreaFilled(false);
        backButton.setFocusPainted(false);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	stopBackgroundMusic();
                buttonSound();
                dispose();
                new Alphabet();
            }
        });

        panel.add(Abtn);
        panel.add(Bbtn);
        panel.add(nextBtn);
        panel.add(backButton);

        return panel;
    }

    private JPanel createPanel2() {
        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon bg = new ImageIcon(getClass().getClassLoader().getResource("tracingbg.png"));
                Image image = bg.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setLayout(null);

        JButton Cbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("c1.png")));
        Cbtn.setBounds(200, 170, 200, 200);
        Cbtn.setOpaque(false);
        Cbtn.setBorder(null);
        Cbtn.setContentAreaFilled(false);
        Cbtn.setFocusPainted(false);

        Cbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                displayImage(List.of("C.png", "D.png", "E.png", "F.png", "G.png", "H.png", "I.png", "J.png", "K.png", "L.png",
                        "M.png", "N.png", "O.png", "P.png", "Q.png", "R.png", "S.png", "T.png", "U.png", "V.png", "W.png", "X.png", "Y.png", "Z.png"), 0);
            }
        });

        JButton Dbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("d1.png")));
        Dbtn.setBounds(500, 170, 200, 200);
        Dbtn.setOpaque(false);
        Dbtn.setBorder(null);
        Dbtn.setContentAreaFilled(false);
        Dbtn.setFocusPainted(false);

        Dbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                displayImage(List.of("D.png", "E.png", "F.png", "G.png", "H.png", "I.png", "J.png", "K.png", "L.png",
                        "M.png", "N.png", "O.png", "P.png", "Q.png", "R.png", "S.png", "T.png", "U.png", "V.png", "W.png", "X.png", "Y.png", "Z.png"), 0);
            }
        });

        JButton nextBtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("next.png")));
        nextBtn.setBounds(780, 250, 50, 60);
        nextBtn.setOpaque(false);
        nextBtn.setBorder(null);
        nextBtn.setContentAreaFilled(false);
        nextBtn.setFocusPainted(false);

        nextBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                cardLayout.show(cardPanel, "Panel3");
            }
        });

        JButton prevBtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("prev.png")));
        prevBtn.setBounds(80, 250, 50, 60);
        prevBtn.setOpaque(false);
        prevBtn.setBorder(null);
        prevBtn.setContentAreaFilled(false);
        prevBtn.setFocusPainted(false);

        prevBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                cardLayout.show(cardPanel, "Panel1");
            }
        });

        JButton backButton = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("back.png")));
        backButton.setBounds(8, 20, 100, 60);
        backButton.setOpaque(false);
        backButton.setBorder(null);
        backButton.setContentAreaFilled(false);
        backButton.setFocusPainted(false);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                stopBackgroundMusic();
                dispose();
                new Alphabet();
            }
        });

        panel.add(Cbtn);
        panel.add(Dbtn);
        panel.add(nextBtn);
        panel.add(prevBtn);
        panel.add(backButton);

        return panel;
    }

    private JPanel createPanel3() {
        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon bg = new ImageIcon(getClass().getClassLoader().getResource("tracingbg.png"));
                Image image = bg.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setLayout(null);

        JButton Ebtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("e1.png")));
        Ebtn.setBounds(200, 170, 200, 200);
        Ebtn.setOpaque(false);
        Ebtn.setBorder(null);
        Ebtn.setContentAreaFilled(false);
        Ebtn.setFocusPainted(false);

        Ebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                displayImage(List.of("E.png", "F.png", "G.png", "H.png", "I.png", "J.png", "K.png", "L.png",
                        "M.png", "N.png", "O.png", "P.png", "Q.png", "R.png", "S.png", "T.png", "U.png", "V.png", "W.png", "X.png", "Y.png", "Z.png"), 0);
            }
        });

        JButton Fbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("f1.png")));
        Fbtn.setBounds(500, 170, 200, 200);
        Fbtn.setOpaque(false);
        Fbtn.setBorder(null);
        Fbtn.setContentAreaFilled(false);
        Fbtn.setFocusPainted(false);

        Fbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                displayImage(List.of("F.png", "G.png", "H.png", "I.png", "J.png", "K.png", "L.png",
                        "M.png", "N.png", "O.png", "P.png", "Q.png", "R.png", "S.png", "T.png", "U.png", "V.png", "W.png", "X.png", "Y.png", "Z.png"), 0);
            }
        });

        JButton nextBtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("next.png")));
        nextBtn.setBounds(780, 250, 50, 60);
        nextBtn.setOpaque(false);
        nextBtn.setBorder(null);
        nextBtn.setContentAreaFilled(false);
        nextBtn.setFocusPainted(false);

        nextBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                cardLayout.show(cardPanel, "Panel4");
            }
        });

        JButton prevBtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("prev.png")));
        prevBtn.setBounds(80, 250, 50, 60);
        prevBtn.setOpaque(false);
        prevBtn.setBorder(null);
        prevBtn.setContentAreaFilled(false);
        prevBtn.setFocusPainted(false);

        prevBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                cardLayout.show(cardPanel, "Panel2");
            }
        });

        JButton backButton = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("back.png")));
        backButton.setBounds(8, 20, 100, 60);
        backButton.setOpaque(false);
        backButton.setBorder(null);
        backButton.setContentAreaFilled(false);
        backButton.setFocusPainted(false);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                stopBackgroundMusic();
                dispose();
                new Alphabet();
            }
        });

        panel.add(Ebtn);
        panel.add(Fbtn);
        panel.add(nextBtn);
        panel.add(prevBtn);
        panel.add(backButton);

        return panel;
    }

    private JPanel createPanel4() {
        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon bg = new ImageIcon(getClass().getClassLoader().getResource("tracingbg.png"));
                Image image = bg.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setLayout(null);

        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("KIDDIELEARN.jpg"));
        setIconImage(icon.getImage());

        JButton Gbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("g1.png")));
        Gbtn.setBounds(200, 170, 200, 200);
        Gbtn.setOpaque(false);
        Gbtn.setBorder(null);
        Gbtn.setContentAreaFilled(false);
        Gbtn.setFocusPainted(false);

        Gbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                displayImage(List.of("G.png", "H.png", "H.png", "I.png", "J.png", "K.png", "L.png",
                        "M.png", "N.png", "O.png", "P.png", "Q.png", "R.png", "S.png", "T.png", "U.png", "V.png", "W.png", "X.png", "Y.png", "Z.png"), 0);
            }
        });

        JButton Hbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("h1.png")));
        Hbtn.setBounds(500, 170, 200, 200);
        Hbtn.setOpaque(false);
        Hbtn.setBorder(null);
        Hbtn.setContentAreaFilled(false);
        Hbtn.setFocusPainted(false);

        Hbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                displayImage(List.of("H.png", "I.png", "J.png", "K.png", "L.png",
                        "M.png", "N.png", "O.png", "P.png", "Q.png", "R.png", "S.png", "T.png", "U.png", "V.png", "W.png", "X.png", "Y.png", "Z.png"), 0);
            }
        });

        JButton nextBtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("next.png")));
        nextBtn.setBounds(780, 250, 50, 60);
        nextBtn.setOpaque(false);
        nextBtn.setBorder(null);
        nextBtn.setContentAreaFilled(false);
        nextBtn.setFocusPainted(false);

        nextBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                cardLayout.show(cardPanel, "Panel5");
            }
        });

        JButton prevBtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("prev.png")));
        prevBtn.setBounds(80, 250, 50, 60);
        prevBtn.setOpaque(false);
        prevBtn.setBorder(null);
        prevBtn.setContentAreaFilled(false);
        prevBtn.setFocusPainted(false);

        prevBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                cardLayout.show(cardPanel, "Panel3");
            }
        });

        JButton backButton = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("back.png")));
        backButton.setBounds(8, 20, 100, 60);
        backButton.setOpaque(false);
        backButton.setBorder(null);
        backButton.setContentAreaFilled(false);
        backButton.setFocusPainted(false);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                stopBackgroundMusic();
                dispose();
                new Alphabet();
            }
        });

        panel.add(Gbtn);
        panel.add(Hbtn);
        panel.add(nextBtn);
        panel.add(prevBtn);
        panel.add(backButton);

        return panel;
    }

    private JPanel createPanel5() {
        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon bg = new ImageIcon(getClass().getClassLoader().getResource("tracingbg.png"));
                Image image = bg.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setLayout(null);

        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("KIDDIELEARN.jpg"));
        setIconImage(icon.getImage());

        JButton Ibtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("i1.png")));
        Ibtn.setBounds(200, 170, 200, 200);
        Ibtn.setOpaque(false);
        Ibtn.setBorder(null);
        Ibtn.setContentAreaFilled(false);
        Ibtn.setFocusPainted(false);

        Ibtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                displayImage(List.of("I.png", "J.png", "K.png", "L.png",
                        "M.png", "N.png", "O.png", "P.png", "Q.png", "R.png", "S.png", "T.png", "U.png", "V.png", "W.png", "X.png", "Y.png", "Z.png"), 0);
            }
        });

        JButton Jbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("j1.png")));
        Jbtn.setBounds(500, 170, 200, 200);
        Jbtn.setOpaque(false);
        Jbtn.setBorder(null);
        Jbtn.setContentAreaFilled(false);
        Jbtn.setFocusPainted(false);

        Jbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                displayImage(List.of("J.png", "K.png", "K.png", "L.png",
                        "M.png", "N.png", "O.png", "P.png", "Q.png", "R.png", "S.png", "T.png", "U.png", "V.png", "W.png", "X.png", "Y.png", "Z.png"), 0);
            }
        });

        JButton nextBtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("next.png")));
        nextBtn.setBounds(780, 250, 50, 60);
        nextBtn.setOpaque(false);
        nextBtn.setBorder(null);
        nextBtn.setContentAreaFilled(false);
        nextBtn.setFocusPainted(false);

        nextBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Panel6");
            }
        });

        JButton prevBtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("prev.png")));
        prevBtn.setBounds(80, 250, 50, 60);
        prevBtn.setOpaque(false);
        prevBtn.setBorder(null);
        prevBtn.setContentAreaFilled(false);
        prevBtn.setFocusPainted(false);

        prevBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                cardLayout.show(cardPanel, "Panel4");
            }
        });

        JButton backButton = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("back.png")));
        backButton.setBounds(8, 20, 100, 60);
        backButton.setOpaque(false);
        backButton.setBorder(null);
        backButton.setContentAreaFilled(false);
        backButton.setFocusPainted(false);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                stopBackgroundMusic();
                dispose();
                new Alphabet();
            }
        });

        panel.add(Ibtn);
        panel.add(Jbtn);
        panel.add(nextBtn);
        panel.add(prevBtn);
        panel.add(backButton);

        return panel;
    }

    private JPanel createPanel6() {
        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon bg = new ImageIcon(getClass().getClassLoader().getResource("tracingbg.png"));
                Image image = bg.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setLayout(null);

        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("KIDDIELEARN.jpg"));
        setIconImage(icon.getImage());

        JButton kbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("k1.png")));
        kbtn.setBounds(200, 170, 200, 200);
        kbtn.setOpaque(false);
        kbtn.setBorder(null);
        kbtn.setContentAreaFilled(false);
        kbtn.setFocusPainted(false);

        kbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                displayImage(List.of("K.png", "L.png",
                        "M.png", "N.png", "O.png", "P.png", "Q.png", "R.png", "S.png", "T.png", "U.png", "V.png", "W.png", "X.png", "Y.png", "Z.png"), 0);
            }
        });

        JButton Lbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("l1.png")));
        Lbtn.setBounds(500, 170, 200, 200);
        Lbtn.setOpaque(false);
        Lbtn.setBorder(null);
        Lbtn.setContentAreaFilled(false);
        Lbtn.setFocusPainted(false);

        Lbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                displayImage(List.of("L.png", "M.png", "N.png", "O.png", "P.png", "Q.png", "R.png", "S.png", "T.png", "U.png", "V.png", "W.png", "X.png", "Y.png", "Z.png"), 0);
            }
        });

        JButton nextBtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("next.png")));
        nextBtn.setBounds(780, 250, 50, 60);
        nextBtn.setOpaque(false);
        nextBtn.setBorder(null);
        nextBtn.setContentAreaFilled(false);
        nextBtn.setFocusPainted(false);

        nextBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                cardLayout.show(cardPanel, "Panel7");
            }
        });

        JButton prevBtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("prev.png")));
        prevBtn.setBounds(80, 250, 50, 60);
        prevBtn.setOpaque(false);
        prevBtn.setBorder(null);
        prevBtn.setContentAreaFilled(false);
        prevBtn.setFocusPainted(false);

        prevBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                cardLayout.show(cardPanel, "Panel5");
            }
        });

        JButton backButton = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("back.png")));
        backButton.setBounds(8, 20, 100, 60);
        backButton.setOpaque(false);
        backButton.setBorder(null);
        backButton.setContentAreaFilled(false);
        backButton.setFocusPainted(false);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                stopBackgroundMusic();
                dispose();
                new Alphabet();
            }
        });

        panel.add(kbtn);
        panel.add(Lbtn);
        panel.add(nextBtn);
        panel.add(prevBtn);
        panel.add(backButton);

        return panel;
    }

    private JPanel createPanel7() {
        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon bg = new ImageIcon(getClass().getClassLoader().getResource("tracingbg.png"));
                Image image = bg.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setLayout(null);

        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("KIDDIELEARN.jpg"));
        setIconImage(icon.getImage());

        JButton Mbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("m1.png")));
        Mbtn.setBounds(200, 170, 200, 200);
        Mbtn.setOpaque(false);
        Mbtn.setBorder(null);
        Mbtn.setContentAreaFilled(false);
        Mbtn.setFocusPainted(false);

        Mbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                displayImage(List.of("M.png", "N.png", "O.png", "P.png", "Q.png", "R.png", "S.png", "T.png", "U.png", "V.png", "W.png", "X.png", "Y.png", "Z.png"), 0);
            }
        });

        JButton Nbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("n1.png")));
        Nbtn.setBounds(500, 170, 200, 200);
        Nbtn.setOpaque(false);
        Nbtn.setBorder(null);
        Nbtn.setContentAreaFilled(false);
        Nbtn.setFocusPainted(false);

        Nbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                displayImage(List.of("N.png", "O.png", "P.png", "Q.png", "R.png", "S.png", "T.png", "U.png", "V.png", "W.png", "X.png", "Y.png", "Z.png"), 0);
            }
        });

        JButton nextBtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("next.png")));
        nextBtn.setBounds(780, 250, 50, 60);
        nextBtn.setOpaque(false);
        nextBtn.setBorder(null);
        nextBtn.setContentAreaFilled(false);
        nextBtn.setFocusPainted(false);

        nextBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                cardLayout.show(cardPanel, "Panel8");
            }
        });

        JButton prevBtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("prev.png")));
        prevBtn.setBounds(80, 250, 50, 60);
        prevBtn.setOpaque(false);
        prevBtn.setBorder(null);
        prevBtn.setContentAreaFilled(false);
        prevBtn.setFocusPainted(false);

        prevBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                cardLayout.show(cardPanel, "Panel6");
            }
        });

        JButton backButton = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("back.png")));
        backButton.setBounds(8, 20, 100, 60);
        backButton.setOpaque(false);
        backButton.setBorder(null);
        backButton.setContentAreaFilled(false);
        backButton.setFocusPainted(false);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                stopBackgroundMusic();
                dispose();
                new Alphabet();
            }
        });

        panel.add(Mbtn);
        panel.add(Nbtn);
        panel.add(nextBtn);
        panel.add(prevBtn);
        panel.add(backButton);

        return panel;
    }

    private JPanel createPanel8() {
        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon bg = new ImageIcon(getClass().getClassLoader().getResource("tracingbg.png"));
                Image image = bg.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setLayout(null);

        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("KIDDIELEARN.jpg"));
        setIconImage(icon.getImage());

        JButton Obtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("o1.png")));
        Obtn.setBounds(200, 170, 200, 200);
        Obtn.setOpaque(false);
        Obtn.setBorder(null);
        Obtn.setContentAreaFilled(false);
        Obtn.setFocusPainted(false);

        Obtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                displayImage(List.of("O.png", "P.png", "Q.png", "R.png", "S.png", "T.png", "U.png", "V.png", "W.png", "X.png", "Y.png", "Z.png"), 0);
            }
        });

        JButton Pbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("p1.png")));
        Pbtn.setBounds(500, 170, 200, 200);
        Pbtn.setOpaque(false);
        Pbtn.setBorder(null);
        Pbtn.setContentAreaFilled(false);
        Pbtn.setFocusPainted(false);

        Pbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                displayImage(List.of("P.png", "Q.png", "R.png", "S.png", "T.png", "U.png", "V.png", "W.png", "X.png", "Y.png", "Z.png"), 0);
            }
        });

        JButton nextBtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("next.png")));
        nextBtn.setBounds(780, 250, 50, 60);
        nextBtn.setOpaque(false);
        nextBtn.setBorder(null);
        nextBtn.setContentAreaFilled(false);
        nextBtn.setFocusPainted(false);

        nextBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                cardLayout.show(cardPanel, "Panel9");
            }
        });

        JButton prevBtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("prev.png")));
        prevBtn.setBounds(80, 250, 50, 60);
        prevBtn.setOpaque(false);
        prevBtn.setBorder(null);
        prevBtn.setContentAreaFilled(false);
        prevBtn.setFocusPainted(false);

        prevBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                cardLayout.show(cardPanel, "Panel7");
            }
        });

        JButton backButton = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("back.png")));
        backButton.setBounds(8, 20, 100, 60);
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

        panel.add(Obtn);
        panel.add(Pbtn);
        panel.add(nextBtn);
        panel.add(prevBtn);
        panel.add(backButton);

        return panel;
    }

    private JPanel createPanel9() {
        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon bg = new ImageIcon(getClass().getClassLoader().getResource("tracingbg.png"));
                Image image = bg.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setLayout(null);

        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("KIDDIELEARN.jpg"));
        setIconImage(icon.getImage());
        
        JButton Qbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("q1.png")));
        Qbtn.setBounds(200, 170, 200, 200);
        Qbtn.setOpaque(false);
        Qbtn.setBorder(null);
        Qbtn.setContentAreaFilled(false);
        Qbtn.setFocusPainted(false);

        Qbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                displayImage(List.of("Q.png", "R.png", "S.png", "T.png", "U.png", "V.png", "W.png", "X.png", "Y.png", "Z.png"), 0);
            }
        });

        JButton Rbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("r1.png")));
        Rbtn.setBounds(500, 170, 200, 200);
        Rbtn.setOpaque(false);
        Rbtn.setBorder(null);
        Rbtn.setContentAreaFilled(false);
        Rbtn.setFocusPainted(false);

        Rbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                displayImage(List.of("R.png", "S.png", "T.png", "U.png", "V.png", "W.png", "X.png", "Y.png", "Z.png"), 0);
            }
        });

        JButton nextBtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("next.png")));
        nextBtn.setBounds(780, 250, 50, 60);
        nextBtn.setOpaque(false);
        nextBtn.setBorder(null);
        nextBtn.setContentAreaFilled(false);
        nextBtn.setFocusPainted(false);

        nextBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                cardLayout.show(cardPanel, "Panel10");
            }
        });

        JButton prevBtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("prev.png")));
        prevBtn.setBounds(80, 250, 50, 60);
        prevBtn.setOpaque(false);
        prevBtn.setBorder(null);
        prevBtn.setContentAreaFilled(false);
        prevBtn.setFocusPainted(false);

        prevBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                cardLayout.show(cardPanel, "Panel8");
            }
        });

        JButton backButton = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("back.png")));
        backButton.setBounds(8, 20, 100, 60);
        backButton.setOpaque(false);
        backButton.setBorder(null);
        backButton.setContentAreaFilled(false);
        backButton.setFocusPainted(false);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                stopBackgroundMusic();
                dispose();
                new Alphabet();
            }
        });

        panel.add(Qbtn);
        panel.add(Rbtn);
        panel.add(nextBtn);
        panel.add(prevBtn);
        panel.add(backButton);

        return panel;
    }

    private JPanel createPanel10() {
        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon bg = new ImageIcon(getClass().getClassLoader().getResource("tracingbg.png"));
                Image image = bg.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setLayout(null);

        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("KIDDIELEARN.jpg"));
        setIconImage(icon.getImage());

        JButton Sbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("s1.png")));
        Sbtn.setBounds(200, 170, 200, 200);
        Sbtn.setOpaque(false);
        Sbtn.setBorder(null);
        Sbtn.setContentAreaFilled(false);
        Sbtn.setFocusPainted(false);

        Sbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                displayImage(List.of("S.png", "T.png", "U.png", "V.png", "W.png", "X.png", "Y.png", "Z.png"), 0);
            }
        });

        JButton Tbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("t1.png")));
        Tbtn.setBounds(500, 170, 200, 200);
        Tbtn.setOpaque(false);
        Tbtn.setBorder(null);
        Tbtn.setContentAreaFilled(false);
        Tbtn.setFocusPainted(false);

        Tbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                displayImage(List.of("T.png", "U.png", "V.png", "W.png", "X.png", "Y.png", "Z.png"), 0);
            }
        });

        JButton nextBtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("next.png")));
        nextBtn.setBounds(780, 250, 50, 60);
        nextBtn.setOpaque(false);
        nextBtn.setBorder(null);
        nextBtn.setContentAreaFilled(false);
        nextBtn.setFocusPainted(false);

        nextBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                cardLayout.show(cardPanel, "Panel11");
            }
        });

        JButton prevBtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("prev.png")));
        prevBtn.setBounds(80, 250, 50, 60);
        prevBtn.setOpaque(false);
        prevBtn.setBorder(null);
        prevBtn.setContentAreaFilled(false);
        prevBtn.setFocusPainted(false);

        prevBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                cardLayout.show(cardPanel, "Panel9");
            }
        });

        JButton backButton = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("back.png")));
        backButton.setBounds(8, 20, 100, 60);
        backButton.setOpaque(false);
        backButton.setBorder(null);
        backButton.setContentAreaFilled(false);
        backButton.setFocusPainted(false);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                stopBackgroundMusic();
                dispose();
                new Alphabet();
            }
        });

        panel.add(Sbtn);
        panel.add(Tbtn);
        panel.add(nextBtn);
        panel.add(prevBtn);
        panel.add(backButton);

        return panel;
    }

    private JPanel createPanel11() {
        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon bg = new ImageIcon(getClass().getClassLoader().getResource("tracingbg.png"));
                Image image = bg.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setLayout(null);

        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("KIDDIELEARN.jpg"));
        setIconImage(icon.getImage());

        JButton Ubtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("u1.png")));
        Ubtn.setBounds(200, 170, 200, 200);
        Ubtn.setOpaque(false);
        Ubtn.setBorder(null);
        Ubtn.setContentAreaFilled(false);
        Ubtn.setFocusPainted(false);

        Ubtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                displayImage(List.of("U.png", "V.png", "W.png", "X.png", "Y.png", "Z.png"), 0);
            }
        });

        JButton Vbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("v1.png")));
        Vbtn.setBounds(500, 170, 200, 200);
        Vbtn.setOpaque(false);
        Vbtn.setBorder(null);
        Vbtn.setContentAreaFilled(false);
        Vbtn.setFocusPainted(false);

        Vbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                displayImage(List.of("V.png", "W.png", "X.png", "Y.png", "Z.png"), 0);
            }
        });

        JButton nextBtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("next.png")));
        nextBtn.setBounds(780, 250, 50, 60);
        nextBtn.setOpaque(false);
        nextBtn.setBorder(null);
        nextBtn.setContentAreaFilled(false);
        nextBtn.setFocusPainted(false);

        nextBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                cardLayout.show(cardPanel, "Panel12");
            }
        });

        JButton prevBtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("prev.png")));
        prevBtn.setBounds(80, 250, 50, 60);
        prevBtn.setOpaque(false);
        prevBtn.setBorder(null);
        prevBtn.setContentAreaFilled(false);
        prevBtn.setFocusPainted(false);

        prevBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                cardLayout.show(cardPanel, "Panel10");
            }
        });

        JButton backButton = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("back.png")));
        backButton.setBounds(8, 20, 100, 60);
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

        panel.add(Ubtn);
        panel.add(Vbtn);
        panel.add(nextBtn);
        panel.add(prevBtn);
        panel.add(backButton);

        return panel;
    }

    private JPanel createPanel12() {
        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon bg = new ImageIcon(getClass().getClassLoader().getResource("tracingbg.png"));
                Image image = bg.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setLayout(null);

        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("KIDDIELEARN.jpg"));
        setIconImage(icon.getImage());

        JButton Wbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("w1.png")));
        Wbtn.setBounds(200, 170, 200, 200);
        Wbtn.setOpaque(false);
        Wbtn.setBorder(null);
        Wbtn.setContentAreaFilled(false);
        Wbtn.setFocusPainted(false);

        Wbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                displayImage(List.of("W.png", "X.png", "Y.png", "Z.png"), 0);
            }
        });

        JButton Xbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("x1.png")));
        Xbtn.setBounds(500, 170, 200, 200);
        Xbtn.setOpaque(false);
        Xbtn.setBorder(null);
        Xbtn.setContentAreaFilled(false);
        Xbtn.setFocusPainted(false);

        Xbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                displayImage(List.of("X.png", "Y.png", "Z.png"), 0);
            }
        });

        JButton nextBtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("next.png")));
        nextBtn.setBounds(780, 250, 50, 60);
        nextBtn.setOpaque(false);
        nextBtn.setBorder(null);
        nextBtn.setContentAreaFilled(false);
        nextBtn.setFocusPainted(false);

        nextBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                cardLayout.show(cardPanel, "Panel13");
            }
        });

        JButton prevBtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("prev.png")));
        prevBtn.setBounds(80, 250, 50, 60);
        prevBtn.setOpaque(false);
        prevBtn.setBorder(null);
        prevBtn.setContentAreaFilled(false);
        prevBtn.setFocusPainted(false);

        prevBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                cardLayout.show(cardPanel, "Panel11");
            }
        });

        JButton backButton = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("back.png")));
        backButton.setBounds(8, 20, 100, 60);
        backButton.setOpaque(false);
        backButton.setBorder(null);
        backButton.setContentAreaFilled(false);
        backButton.setFocusPainted(false);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                stopBackgroundMusic();
                dispose();
                new Alphabet();
            }
        });

        panel.add(Wbtn);
        panel.add(Xbtn);
        panel.add(nextBtn);
        panel.add(prevBtn);
        panel.add(backButton);

        return panel;
    }

    private JPanel createPanel13() {
        JPanel panel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon bg = new ImageIcon(getClass().getClassLoader().getResource("tracingbg.png"));
                Image image = bg.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setLayout(null);

        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("KIDDIELEARN.jpg"));
        setIconImage(icon.getImage());

        JButton Ybtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("y1.png")));
        Ybtn.setBounds(200, 170, 200, 200);
        Ybtn.setOpaque(false);
        Ybtn.setBorder(null);
        Ybtn.setContentAreaFilled(false);
        Ybtn.setFocusPainted(false);

        Ybtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                displayImage(List.of("Y.png", "Z.png"), 0);
            }
        });

        JButton Zbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("z1.png")));
        Zbtn.setBounds(500, 170, 200, 200);
        Zbtn.setOpaque(false);
        Zbtn.setBorder(null);
        Zbtn.setContentAreaFilled(false);
        Zbtn.setFocusPainted(false);

        Zbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                displayImage(List.of("Z.png"), 0);
            }
        });

        JButton nextBtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("next.png")));
        nextBtn.setBounds(780, 250, 50, 60);
        nextBtn.setOpaque(false);
        nextBtn.setBorder(null);
        nextBtn.setContentAreaFilled(false);
        nextBtn.setFocusPainted(false);

        nextBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                cardLayout.show(cardPanel, "Panel1");
            }
        });

        JButton prevBtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("prev.png")));
        prevBtn.setBounds(80, 250, 50, 60);
        prevBtn.setOpaque(false);
        prevBtn.setBorder(null);
        prevBtn.setContentAreaFilled(false);
        prevBtn.setFocusPainted(false);

        prevBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                cardLayout.show(cardPanel, "Panel12");
            }
        });

        JButton backButton = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("back.png")));
        backButton.setBounds(8, 20, 100, 60);
        backButton.setOpaque(false);
        backButton.setBorder(null);
        backButton.setContentAreaFilled(false);
        backButton.setFocusPainted(false);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                stopBackgroundMusic();
                dispose();
                new Alphabet();
            }
        });

        panel.add(Ybtn);
        panel.add(Zbtn);
        panel.add(nextBtn);
        panel.add(prevBtn);
        panel.add(backButton);

        return panel;
    }

    private void displayImage(List<String> images, int index) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1000, 550);
        frame.setTitle("KiddieLearn");
        frame.setLocationRelativeTo(null);

      
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("KIDDIELEARN.jpg"));
        frame.setIconImage(icon.getImage());

        JLabel label = new JLabel();
        
        ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource(images.get(index)));
        label.setIcon(imageIcon);
        frame.add(label);
        label.setLayout(null);

        JButton backButton = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("back.png")));
        backButton.setBounds(8, 450, 100, 60);
        backButton.setOpaque(false);
        backButton.setBorder(null);
        backButton.setContentAreaFilled(false);
        backButton.setFocusPainted(false);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                frame.dispose();
            }
        });

        label.add(backButton);

        if (index + 1 < images.size()) {
            JButton nextButton = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("next1.png")));
            nextButton.setBounds(880, 4, 100, 100);
            nextButton.setOpaque(false);
            nextButton.setBorder(null);
            nextButton.setContentAreaFilled(false);
            nextButton.setFocusPainted(false);

            nextButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonSound();
                    frame.dispose();
                    displayImage(images, index + 1);
                }
            });

            label.add(nextButton);
        }

        if (index > 0) {
            JButton prevButton = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("prev1.png")));
            prevButton.setBounds(10, 1, 100, 100);
            prevButton.setOpaque(false);
            prevButton.setBorder(null);
            prevButton.setContentAreaFilled(false);
            prevButton.setFocusPainted(false);

            prevButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buttonSound();
                    frame.dispose();
                    displayImage(images, index - 1);
                }
            });

            label.add(prevButton);
        }

        JButton eraseButton = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("eraser.png")));
        eraseButton.setBounds(850, 310, 120, 120);
        eraseButton.setOpaque(false);
        eraseButton.setBorder(null);
        eraseButton.setContentAreaFilled(false);
        eraseButton.setFocusPainted(false);

        eraseButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startX = e.getX();
                startY = e.getY();
            }
        });

        eraseButton.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int offsetX = e.getX() - startX;
                int offsetY = e.getY() - startY;

                int newX = eraseButton.getX() + offsetX;
                int newY = eraseButton.getY() + offsetY;

                eraseButton.setLocation(newX, newY);

                Graphics2D g2d = (Graphics2D) label.getGraphics();
                g2d.setColor(label.getBackground());
                g2d.setStroke(new BasicStroke(15));
                g2d.fillRect(newX, newY, eraseButton.getWidth(), eraseButton.getHeight());
            }
        });

        label.add(eraseButton);

        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startX = e.getX();
                startY = e.getY();
            }
        });

        label.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Graphics2D g2d = (Graphics2D) label.getGraphics();
                g2d.setColor(Color.BLACK);
                g2d.setStroke(new BasicStroke(3));
                g2d.drawLine(startX, startY, e.getX(), e.getY());
                startX = e.getX();
                startY = e.getY();
            }
        });

        frame.setVisible(true);
    }

    private void buttonSound() {

        playMusic("select1.wav");
    }
    public void playMusic(String filePath) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getClassLoader().getResource(filePath));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            System.out.println("Error playing music: " + e.getMessage());
        }
    }
    private void playBackgroundMusic(String filePath) {
        try {
            if (backgroundClip == null) {
                URL url = getClass().getClassLoader().getResource(filePath);
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
                backgroundClip = AudioSystem.getClip();
                backgroundClip.open(audioInputStream);
                backgroundClip.loop(Clip.LOOP_CONTINUOUSLY); 
            }
        } catch (Exception e) {
            System.out.println("Error playing background music: " + e.getMessage());
        }
    }

    private void stopBackgroundMusic() {
        if (backgroundClip != null && backgroundClip.isRunning()) {
            backgroundClip.stop();
        }
    }
}