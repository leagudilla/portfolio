package proj;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
public class LearnNumbers extends JFrame{
    public LearnNumbers() {
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

        JButton onebtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("1.png")));
        onebtn.setBounds(150,64,120,120);
        onebtn.setOpaque(false);
        onebtn.setBorder(null);
        onebtn.setContentAreaFilled(false);
        onebtn.setFocusPainted(false);
        ImageIcon onePressed = new ImageIcon("one_pressed.png");
        onebtn.setPressedIcon(onePressed);

        onebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound("one.wav");
            }
        });

        JButton twobtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("2.png")));
        twobtn.setBounds(330,70,120,120);
        twobtn.setOpaque(false);
        twobtn.setBorder(null);
        twobtn.setContentAreaFilled(false);
        twobtn.setFocusPainted(false);
        ImageIcon twoPressed = new ImageIcon("two_pressed.png");
        twobtn.setPressedIcon(twoPressed);

        twobtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound("two.wav");
            }
        });

        JButton threebtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("3.png")));
        threebtn.setBounds(520,70,120,120);
        threebtn.setOpaque(false);
        threebtn.setBorder(null);
        threebtn.setContentAreaFilled(false);
        threebtn.setFocusPainted(false);
        ImageIcon threePressed = new ImageIcon("three_pressed.png");
        threebtn.setPressedIcon(threePressed);

        threebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound("three.wav");
            }
        });

        JButton fourbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("4.png")));
        fourbtn.setBounds(720,70,120,120);
        fourbtn.setOpaque(false);
        fourbtn.setBorder(null);
        fourbtn.setContentAreaFilled(false);
        fourbtn.setFocusPainted(false);
        ImageIcon fourPressed = new ImageIcon("four_pressed.png");
        fourbtn.setPressedIcon(fourPressed);

        fourbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound("four.wav");
            }
        });

        JButton fivebtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("5.png")));
        fivebtn.setBounds(150,200,120,120);
        fivebtn.setOpaque(false);
        fivebtn.setBorder(null);
        fivebtn.setContentAreaFilled(false);
        fivebtn.setFocusPainted(false);
        ImageIcon fivePressed = new ImageIcon("five_pressed.png");
        fivebtn.setPressedIcon(fivePressed);

        fivebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound("five.wav");
            }
        });

        JButton sixbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("6.png")));
        sixbtn.setBounds(330,200,120,120);
        sixbtn.setOpaque(false);
        sixbtn.setBorder(null);
        sixbtn.setContentAreaFilled(false);
        sixbtn.setFocusPainted(false);
        ImageIcon sixPressed = new ImageIcon("six_pressed.png");
        sixbtn.setPressedIcon(sixPressed);

        sixbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound("six.wav");
            }
        });

        JButton sevenbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("7.png")));
        sevenbtn.setBounds(480,200,200,120);
        sevenbtn.setOpaque(false);
        sevenbtn.setBorder(null);
        sevenbtn.setContentAreaFilled(false);
        sevenbtn.setFocusPainted(false);
        ImageIcon sevenPressed = new ImageIcon("seven_pressed.png");
        sevenbtn.setPressedIcon(sevenPressed);

        sevenbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound("seven.wav");
            }
        });

        JButton eightbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("8.png")));
        eightbtn.setBounds(720,200,120,120);
        eightbtn.setOpaque(false);
        eightbtn.setBorder(null);
        eightbtn.setContentAreaFilled(false);
        eightbtn.setFocusPainted(false);
        ImageIcon eightPressed = new ImageIcon("eight_pressed.png");
        eightbtn.setPressedIcon(eightPressed);

        eightbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound("eight.wav");
            }
        });

        JButton ninebtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("9.png")));
        ninebtn.setBounds(340,335,120,120);
        ninebtn.setOpaque(false);
        ninebtn.setBorder(null);
        ninebtn.setContentAreaFilled(false);
        ninebtn.setFocusPainted(false);
        ImageIcon ninePressed = new ImageIcon("nine_pressed.png");
        ninebtn.setPressedIcon(ninePressed);

        ninebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound("nine.wav");
            }
        });

        JButton tenbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("10.png")));
        tenbtn.setBounds(520,335,120,120);
        tenbtn.setOpaque(false);
        tenbtn.setBorder(null);
        tenbtn.setContentAreaFilled(false);
        tenbtn.setFocusPainted(false);
        ImageIcon tenPressed = new ImageIcon("ten_pressed.png");
        tenbtn.setPressedIcon(tenPressed);

        tenbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound("ten.wav");
            }
        });


        JButton backButton = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("back.png")));
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
                new Numbers();
            }
        });


        background.setLayout(null);
        background.add(backButton);
        background.add(onebtn);
        background.add(twobtn);
        background.add(threebtn);
        background.add(fourbtn);
        background.add(fivebtn);
        background.add(sixbtn);
        background.add(sevenbtn);
        background.add(eightbtn);
        background.add(ninebtn);
        background.add(tenbtn);

        add(background, BorderLayout.CENTER);
        setVisible(true);

    }

    private void playSound(String filename) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getClassLoader().getResource(filename));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
}

