package proj;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Shapes extends JFrame {
    public Shapes() {
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
                ImageIcon bg = new ImageIcon(getClass().getClassLoader().getResource("shapesbg.png"));
                Image image = bg.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        background.setLayout(null);

        JButton shapeLearn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("shapeLearn.png")));
        shapeLearn.setBounds(120, 70, 400, 350);
        shapeLearn.setOpaque(false);
        shapeLearn.setBorder(null);
        shapeLearn.setContentAreaFilled(false);
        shapeLearn.setFocusPainted(false);

        shapeLearn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                playMusic("tapshape.wav"); 
                dispose();
                new ShapeLearn();
            }
        });

        JButton shapeIdentify = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("shapeIdentify.png")));
        shapeIdentify.setBounds(430, 70, 400, 350);
        shapeIdentify.setOpaque(false);
        shapeIdentify.setBorder(null);
        shapeIdentify.setContentAreaFilled(false);
        shapeIdentify.setFocusPainted(false);

        shapeIdentify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSound();
                playMusic("identifyshape.wav"); 
                dispose();
                new ShapesQuiz();
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

        background.add(shapeLearn);
        background.add(shapeIdentify);
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
