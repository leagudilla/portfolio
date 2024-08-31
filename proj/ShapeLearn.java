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
public class ShapeLearn extends JFrame{
    public ShapeLearn() {
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

        JButton circlebtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("circle1.png")));
        circlebtn.setBounds(150,64,120,120);
        circlebtn.setOpaque(false);
        circlebtn.setBorder(null);
        circlebtn.setContentAreaFilled(false);
        circlebtn.setFocusPainted(false);
        ImageIcon circlePressed = new ImageIcon("circle_pressed.png");
        circlebtn.setPressedIcon(circlePressed);

        circlebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound("Circle.wav");
            }
        });

        JButton trianglebtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("triangle1.png")));
        trianglebtn.setBounds(330,70,120,120);
        trianglebtn.setOpaque(false);
        trianglebtn.setBorder(null);
        trianglebtn.setContentAreaFilled(false);
        trianglebtn.setFocusPainted(false);
        ImageIcon trianglePressed = new ImageIcon("triangle_pressed.png");
        trianglebtn.setPressedIcon(trianglePressed);

        trianglebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound("Triangle.wav");
            }
        });

        JButton squarebtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("square1.png")));
        squarebtn.setBounds(520,70,120,120);
        squarebtn.setOpaque(false);
        squarebtn.setBorder(null);
        squarebtn.setContentAreaFilled(false);
        squarebtn.setFocusPainted(false);
        ImageIcon squarePressed = new ImageIcon("square_pressed.png");
        squarebtn.setPressedIcon(squarePressed);

        squarebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound("Square.wav");
            }
        });

        JButton rectanglebtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("rectangle1.png")));
        rectanglebtn.setBounds(720,70,120,120);
        rectanglebtn.setOpaque(false);
        rectanglebtn.setBorder(null);
        rectanglebtn.setContentAreaFilled(false);
        rectanglebtn.setFocusPainted(false);
        ImageIcon rectanglePressed = new ImageIcon("rectangle_pressed.png");
        rectanglebtn.setPressedIcon(rectanglePressed);

        rectanglebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound("Rectangle.wav");
            }
        });

        JButton pentagonbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("pentagon1.png")));
        pentagonbtn.setBounds(150,200,120,120);
        pentagonbtn.setOpaque(false);
        pentagonbtn.setBorder(null);
        pentagonbtn.setContentAreaFilled(false);
        pentagonbtn.setFocusPainted(false);
        ImageIcon pentagonPressed = new ImageIcon("pentagon_pressed.png");
        pentagonbtn.setPressedIcon(pentagonPressed);

        pentagonbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound("Pentagon.wav");
            }
        });

        JButton hexagonbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("hexagon1.png")));
        hexagonbtn.setBounds(330,200,120,120);
        hexagonbtn.setOpaque(false);
        hexagonbtn.setBorder(null);
        hexagonbtn.setContentAreaFilled(false);
        hexagonbtn.setFocusPainted(false);
        ImageIcon hexagonPressed = new ImageIcon("hexagon_pressed.png");
        hexagonbtn.setPressedIcon(hexagonPressed);

        hexagonbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound("Hexagon.wav");
            }
        });

        JButton trapezoidbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("trapezoid1.png")));
        trapezoidbtn.setBounds(480,200,200,120);
        trapezoidbtn.setOpaque(false);
        trapezoidbtn.setBorder(null);
        trapezoidbtn.setContentAreaFilled(false);
        trapezoidbtn.setFocusPainted(false);
        ImageIcon trapezoidPressed = new ImageIcon("trapezoid_pressed.png");
        trapezoidbtn.setPressedIcon(trapezoidPressed);

        trapezoidbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound("Trapezoid.wav");
            }
        });

        JButton diamondbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("diamond1.png")));
        diamondbtn.setBounds(720,200,120,120);
        diamondbtn.setOpaque(false);
        diamondbtn.setBorder(null);
        diamondbtn.setContentAreaFilled(false);
        diamondbtn.setFocusPainted(false);
        ImageIcon diamondPressed = new ImageIcon("diamond_pressed.png");
        diamondbtn.setPressedIcon(diamondPressed);

        diamondbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound("Diamond.wav");
            }
        });

        JButton starbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("star1.png")));
        starbtn.setBounds(150,335,120,120);
        starbtn.setOpaque(false);
        starbtn.setBorder(null);
        starbtn.setContentAreaFilled(false);
        starbtn.setFocusPainted(false);
        ImageIcon starPressed = new ImageIcon("star_pressed.png");
        starbtn.setPressedIcon(starPressed);

        starbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound("Star.wav");
            }
        });

        JButton heartbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("heart1.png")));
        heartbtn.setBounds(330,335,120,120);
        heartbtn.setOpaque(false);
        heartbtn.setBorder(null);
        heartbtn.setContentAreaFilled(false);
        heartbtn.setFocusPainted(false);
        ImageIcon heartPressed = new ImageIcon("heart_pressed.png");
        heartbtn.setPressedIcon(heartPressed);

        heartbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound("Heart.wav");
            }
        });

        JButton ovalbtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("oval1.png")));
        ovalbtn.setBounds(495,335,170,120);
        ovalbtn.setOpaque(false);
        ovalbtn.setBorder(null);
        ovalbtn.setContentAreaFilled(false);
        ovalbtn.setFocusPainted(false);
        ImageIcon ovalPressed = new ImageIcon("oval_pressed.png");
        ovalbtn.setPressedIcon(ovalPressed);

        ovalbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound("Oval.wav");
            }
        });

        JButton cubebtn = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("cube1.png")));
        cubebtn.setBounds(720,335,120,130);
        cubebtn.setOpaque(false);
        cubebtn.setBorder(null);
        cubebtn.setContentAreaFilled(false);
        cubebtn.setFocusPainted(false);
        ImageIcon cubePressed = new ImageIcon("cube_pressed.png");
        cubebtn.setPressedIcon(cubePressed);

        cubebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playSound("Cube.wav");
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
                new Shapes();
            }
        });


        background.setLayout(null);
        background.add(backButton);
        background.add(circlebtn);
        background.add(trianglebtn);
        background.add(squarebtn);
        background.add(rectanglebtn);
        background.add(pentagonbtn);
        background.add(hexagonbtn);
        background.add(trapezoidbtn);
        background.add(diamondbtn);
        background.add(starbtn);
        background.add(heartbtn);
        background.add(ovalbtn);
        background.add(cubebtn);



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

