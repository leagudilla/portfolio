package proj;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Alphabet extends JFrame {
    JButton learnButton, tracingButton, backButton;

    public Alphabet() {
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
                ImageIcon bg = new ImageIcon(getClass().getClassLoader().getResource("alphabet.png"));
                Image image = bg.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };

        learnButton = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("alphaLearn.png")));
        learnButton.setBounds(120, 80, 400, 300);
        learnButton.setOpaque(false);
        learnButton.setBorder(null);
        learnButton.setContentAreaFilled(false);
        learnButton.setFocusPainted(false);

        learnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                playMusic("tapletter.wav"); 
                dispose();
                new AlphabetLearn();
            }
        });

        tracingButton = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("alphaTracing.png")));
        tracingButton.setBounds(430, 80, 400, 300); 
        tracingButton.setOpaque(false);
        tracingButton.setBorder(null);
        tracingButton.setContentAreaFilled(false);
        tracingButton.setFocusPainted(false);

        tracingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                playMusic("tracing.wav");
                dispose();
                new AlphabetTracing();
            }
        });

        backButton = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("back.png")));
        backButton.setBounds(8, 15, 100, 60);
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

        background.add(backButton);
        background.add(learnButton);
        background.add(tracingButton);
        background.setLayout(null);
        add(background, BorderLayout.CENTER);

        setVisible(true);
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
