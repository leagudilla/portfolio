package proj;

import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.InputStream;

public class HomePage extends JFrame {
    JButton startButton, instructionButton, creditsButton, exitButton;

    public HomePage() {
        setTitle("KiddieLearn");
        setSize(1000, 550);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("KIDDIELEARN.jpg"));
        setIconImage(icon.getImage());

        JPanel background = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon bg = new ImageIcon(getClass().getClassLoader().getResource("home.gif"));
                Image image = bg.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };

        background.setLayout(null);

        startButton = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("strt.png")));
        instructionButton = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("inst.png")));
        creditsButton = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("credit.png")));
        exitButton = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("ext.png")));

        startButton.setBounds(600, 220, 300, 70);
        startButton.setOpaque(false);
        startButton.setBorder(null);
        startButton.setContentAreaFilled(false);
        startButton.setFocusPainted(false);
        ImageIcon sbPressed = new ImageIcon("str_pressed.png");
        startButton.setPressedIcon(sbPressed);

        instructionButton.setBounds(600, 290, 300, 70);
        instructionButton.setOpaque(false);
        instructionButton.setBorder(null);
        instructionButton.setContentAreaFilled(false);
        instructionButton.setFocusPainted(false);
        ImageIcon ibPressed = new ImageIcon("inst_pressed.png");
        instructionButton.setPressedIcon(ibPressed);

        creditsButton.setBounds(604, 360, 300, 70);
        creditsButton.setOpaque(false);
        creditsButton.setBorder(null);
        creditsButton.setContentAreaFilled(false);
        creditsButton.setFocusPainted(false);
        ImageIcon cbPressed = new ImageIcon("credit_pressed.png");
        creditsButton.setPressedIcon(cbPressed);

        exitButton.setBounds(605, 425, 300, 120);
        exitButton.setOpaque(false);
        exitButton.setBorder(null);
        exitButton.setContentAreaFilled(false);
        exitButton.setFocusPainted(false);
        ImageIcon ebPressed = new ImageIcon("ext_pressed.png");
        exitButton.setPressedIcon(ebPressed);

        background.add(startButton);
        background.add(instructionButton);
        background.add(creditsButton);
        background.add(exitButton);

        setLayout(new BorderLayout());
        add(background, BorderLayout.CENTER);

        setVisible(true);

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                new Start();
                dispose();
            }
        });

        instructionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                new Instruction();
                dispose();
            }
        });

        creditsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                new Credits();
                dispose();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit Confirmation",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        playWelcomeSound();
    }

    private void buttonSound() {
        playMusic("select1.wav");
    }

    private void playWelcomeSound() {
        playMusic("welcome.wav");
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

    public static void main(String[] args) {
        new HomePage();
    }
}