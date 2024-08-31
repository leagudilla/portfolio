package proj;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URI;

class Videos extends JFrame {
    public Videos() {
        setTitle("KiddiLearn");
        setSize(1000, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("KIDDIELEARN.jpg"));
        setIconImage(icon.getImage());

        JPanel background = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon bg = new ImageIcon(getClass().getClassLoader().getResource("vid.png"));
                Image image = bg.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };

        background.setLayout(null);

        JButton videos1 = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("alphabetsong.png")));
        videos1.setBounds(250, 80, 200, 200);
        videos1.setOpaque(false);
        videos1.setBorder(null);
        videos1.setFocusPainted(false);
        videos1.setContentAreaFilled(false);
        ImageIcon videos1Pressed = new ImageIcon("videos1_pressed.png");
        videos1.setPressedIcon(videos1Pressed);

        videos1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();

                openURL("https://youtu.be/x7q5JVdPTng?si=zQFLKoHLN7rygpEG");
            }
        });

        JButton videos2 = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("countingsong.png")));
        videos2.setBounds(550, 80, 200, 200);
        videos2.setOpaque(false);
        videos2.setBorder(null);
        videos2.setFocusPainted(false);
        videos2.setContentAreaFilled(false);
        ImageIcon videos2Pressed = new ImageIcon("videos2_pressed.png");
        videos2.setPressedIcon(videos2Pressed);

        videos2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openURL("https://youtu.be/HRwUMD8UQK4?si=YrOqxqekPF_HeFMA");
            }
        });

        JButton videos3 = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("shapesong.png")));
        videos3.setBounds(250, 290, 200, 200);
        videos3.setOpaque(false);
        videos3.setBorder(null);
        videos3.setFocusPainted(false);
        videos3.setContentAreaFilled(false);
        ImageIcon videos3Pressed = new ImageIcon("videos3_pressed.png");
        videos3.setPressedIcon(videos3Pressed);

        videos3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                openURL("https://youtu.be/VGDiUaku3bQ?si=3VyGOUC2AiB1l1lu");
            }
        });

        JButton videos4 = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("colorsong.png")));
        videos4.setBounds(550, 290, 200, 200);
        videos4.setOpaque(false);
        videos4.setBorder(null);
        videos4.setFocusPainted(false);
        videos4.setContentAreaFilled(false);
        ImageIcon videos4Pressed = new ImageIcon("videos4_pressed.png");
        videos4.setPressedIcon(videos4Pressed);

        videos4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                openURL("https://youtu.be/aMTIm-D1l54?si=oDMca_RAQLS-mLaI");
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
                new Start();
            }
        });

        setLayout(new BorderLayout());
        add(background, BorderLayout.CENTER);
        background.add(videos1);
        background.add(videos2);
        background.add(videos3);
        background.add(videos4);
        background.add(backButton);

        setVisible(true);
    }

    private void openURL(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
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
