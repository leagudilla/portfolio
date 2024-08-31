package proj;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Colors extends JFrame {

    JButton colorLearn, colorQuiz, backButton;
    public Colors() {
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
                ImageIcon bg = new ImageIcon(getClass().getClassLoader().getResource("colorsbg.png"));
                Image image = bg.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        background.setLayout(null);

        colorLearn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("colorlearn.png")));
        colorLearn.setBounds(120, 70, 400, 350);
        colorLearn.setOpaque(false);
        colorLearn.setBorder(null);
        colorLearn.setContentAreaFilled(false);
        colorLearn.setFocusPainted(false);

        colorLearn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                playMusic("tapcolor.wav"); 
                dispose();
                new LearnColor();
            }
        });

        colorQuiz = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("colorquiz.png")));
        colorQuiz.setBounds(430, 70, 400, 350);
        colorQuiz.setOpaque(false);
        colorQuiz.setBorder(null);
        colorQuiz.setContentAreaFilled(false);
        colorQuiz.setFocusPainted(false);

        colorQuiz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                playMusic("identifycolor.wav"); 
                dispose();
                new ColorQuiz();
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

        background.add(colorLearn);
        background.add(colorQuiz);
        background.add(backButton);

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

