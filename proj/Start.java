package proj;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;

class Start extends JFrame {
    JButton backButton, alphabetButton, shapesButton, numbersButton, colorsButton, videosButton;
    private Clip backgroundClip;

    public Start() {
        setTitle("KiddieLearn");
        setSize(1000, 550);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("KIDDIELEARN.jpg"));
        setIconImage(icon.getImage());

        JPanel background = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon bg = new ImageIcon(getClass().getClassLoader().getResource("startbg.png"));
                Image image = bg.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };

        background.setLayout(null);


        ImageIcon backIcon = new ImageIcon(getClass().getClassLoader().getResource("back.png"));
        backButton = new JButton(backIcon);
        backButton.setBounds(8, 15, 100, 60);
        backButton.setOpaque(false);
        backButton.setBorder(null);
        backButton.setContentAreaFilled(false);
        backButton.setFocusPainted(false);

        ImageIcon alphaIcon = new ImageIcon(getClass().getClassLoader().getResource("alpha.png"));
        alphabetButton = new JButton(alphaIcon);
        alphabetButton.setBounds(70, 100, alphaIcon.getIconWidth(), alphaIcon.getIconHeight());
        alphabetButton.setOpaque(false);
        alphabetButton.setBorder(null);
        alphabetButton.setContentAreaFilled(false);
        alphabetButton.setFocusPainted(false);
        ImageIcon pressedIcon = new ImageIcon("pressed_alphabet.png");
        alphabetButton.setPressedIcon(pressedIcon);

        ImageIcon shapesIcon = new ImageIcon(getClass().getClassLoader().getResource("shapes.png"));
        shapesButton = new JButton(shapesIcon);
        shapesButton.setBounds(240, 100, alphaIcon.getIconWidth(), alphaIcon.getIconHeight());
        shapesButton.setOpaque(false);
        shapesButton.setBorder(null);
        shapesButton.setContentAreaFilled(false);
        shapesButton.setFocusPainted(false);
        ImageIcon pressedShapes = new ImageIcon("pressed_shapes.png");
        shapesButton.setPressedIcon(pressedShapes);

        ImageIcon numbersIcon = new ImageIcon(getClass().getClassLoader().getResource("numbers.png"));
        numbersButton = new JButton(numbersIcon);
        numbersButton.setBounds(415, 100, alphaIcon.getIconWidth(), alphaIcon.getIconHeight());
        numbersButton.setOpaque(false);
        numbersButton.setBorder(null);
        numbersButton.setContentAreaFilled(false);
        numbersButton.setFocusPainted(false);
        ImageIcon pressedNumbers = new ImageIcon("pressed_colors.png");
        numbersButton.setPressedIcon(pressedNumbers);

        ImageIcon colorsIcon = new ImageIcon(getClass().getClassLoader().getResource("colors.png"));
        colorsButton = new JButton(colorsIcon);
        colorsButton.setBounds(590, 100, alphaIcon.getIconWidth(), alphaIcon.getIconHeight());
        colorsButton.setOpaque(false);
        colorsButton.setBorder(null);
        colorsButton.setContentAreaFilled(false);
        colorsButton.setFocusPainted(false);
        ImageIcon pressedColors = new ImageIcon("pressed_colors.png");
        colorsButton.setPressedIcon(pressedColors);

        ImageIcon videosIcon = new ImageIcon(getClass().getClassLoader().getResource("videos.png"));
        videosButton = new JButton(videosIcon);
        videosButton.setBounds(770, 100, alphaIcon.getIconWidth(), alphaIcon.getIconHeight());
        videosButton.setOpaque(false);
        videosButton.setBorder(null);
        videosButton.setContentAreaFilled(false);
        videosButton.setFocusPainted(false);
        ImageIcon pressedVideos = new ImageIcon("pressed_videos.png");
        videosButton.setPressedIcon(pressedVideos);

        background.setLayout(null);
        background.add(alphabetButton);
        background.add(shapesButton);
        background.add(numbersButton);
        background.add(colorsButton);
        background.add(videosButton);
        background.add(backButton);

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                stopMusic();
                dispose();
                new HomePage();
            }
        });

        alphabetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                stopMusic();
                playMusic("alphabet.wav");
                dispose();
                new Alphabet();
            }
        });

        shapesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                stopMusic();
                playMusic("shapes.wav");
                dispose();
                new Shapes();
            }
        });

        numbersButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                stopMusic();
                playMusic("numbers.wav");
                dispose();
                new Numbers();
            }
        });

        colorsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                stopMusic();
                playMusic("colors.wav");
                dispose();
                new Colors();
            }
        });

        videosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stopMusic();
                playMusic("videos.wav");
                dispose();
                new Videos();
            }
        });

        setLayout(new BorderLayout());
        add(background, BorderLayout.CENTER);

        setVisible(true);
        playBackgroundMusic("music.wav");
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

    private void playBackgroundMusic(String filePath) {
        try {
            URL url = getClass().getClassLoader().getResource(filePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(url);
            backgroundClip = AudioSystem.getClip();
            backgroundClip.open(audioInputStream);
            backgroundClip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            System.out.println("Error playing background music: " + e.getMessage());
        }
    }

    private void stopMusic() {
        if (backgroundClip != null && backgroundClip.isRunning()) {
            backgroundClip.stop();
            backgroundClip.close();
        }
    }
}