package proj;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class Numbers extends JFrame {

    public Numbers() {
        setTitle("KiddieLearn");
        setSize(1000, 550);
        setLocationRelativeTo(null);
        setResizable(false);

        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("KIDDIELEARN.jpg"));
        setIconImage(icon.getImage());
        
        JPanel background = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon bg = new ImageIcon(getClass().getClassLoader().getResource("numbg.png"));
                Image image = bg.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };

        JButton numbersLearn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("learnnumbers.png")));
        numbersLearn.setBounds(120, 50, 400, 300);
        numbersLearn.setOpaque(false);
        numbersLearn.setBorder(null);
        numbersLearn.setContentAreaFilled(false);
        numbersLearn.setFocusPainted(false);

        numbersLearn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                playMusic("tapnumbers.wav"); 
                dispose();
                new LearnNumbers();
            }
        });

        JButton numberIdentify = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("numbersIdentify.png")));
        numberIdentify.setBounds(440, 50, 400, 300);
        numberIdentify.setOpaque(false);
        numberIdentify.setBorder(null);
        numberIdentify.setContentAreaFilled(false);
        numberIdentify.setFocusPainted(false);

        numberIdentify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                playMusic("identifynumber.wav");
                dispose();
                new NumberQuiz();
            }
        });

        JButton backButton = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("back.png")));
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
        background.add(numbersLearn);
        background.add(numberIdentify);
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
