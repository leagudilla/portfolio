package proj;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.io.BufferedInputStream;

public class LearnColor extends JFrame {
    private static final String[] COLORS = {
            "black.png", "blue.png", "brown.png", "green.png", "orange.png",
            "pink.png", "purple.png", "red.png", "white.png", "yellow.png"
    };

    private static final String[] SOUNDS = {
            "black.wav", "blue.wav", "brown.wav", "green.wav", "orange.wav",
            "pink.wav", "purple.wav", "red.wav", "white.wav", "yellow.wav"
    };

    JLabel label;
    JButton nextButton, prevButton, backButton;
    int currentIndex = 0;

    public LearnColor() {
        setTitle("KiddieLearn");
        setSize(1000, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("KIDDIELEARN.jpg"));
        setIconImage(icon.getImage());

        label = new JLabel();
        label.setIcon(new ImageIcon(getClass().getClassLoader().getResource(COLORS[currentIndex])));
        label.setBounds(0, 0, 1000, 550);

        nextButton = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("next.png")));
        nextButton.setOpaque(false);
        nextButton.setBorder(null);
        nextButton.setContentAreaFilled(false);
        nextButton.setFocusPainted(false);
        nextButton.setBounds(800, 250, 50, 50);
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentIndex < COLORS.length - 1) {
                    currentIndex++;
                    buttonSound();
                    nextFrame();
                }
            }
        });

        prevButton = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("prev.png")));
        prevButton.setOpaque(false);
        prevButton.setBorder(null);
        prevButton.setContentAreaFilled(false);
        prevButton.setFocusPainted(false);
        prevButton.setBounds(150, 250, 50, 50);
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentIndex > 0) {
                    currentIndex--;
                    buttonSound();
                    nextFrame();
                }
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
                new Colors();
            }
        });

        add(nextButton);
        add(prevButton);
        add(backButton);
        add(label);
        setVisible(true);
    }

    private void nextFrame() {
        label.setIcon(new ImageIcon(getClass().getClassLoader().getResource(COLORS[currentIndex])));
        playSound(SOUNDS[currentIndex]);
        revalidate();
        repaint();
    }

    private void playSound(String soundFile) {
        try {
            InputStream audioSrc = getClass().getClassLoader().getResourceAsStream(soundFile);
            if (audioSrc == null) {
                throw new RuntimeException("Audio file not found: " + soundFile);
            }

            // Wrap the input stream in a BufferedInputStream to support mark/reset
            BufferedInputStream bufferedStream = new BufferedInputStream(audioSrc);

            try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(bufferedStream)) {
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
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
