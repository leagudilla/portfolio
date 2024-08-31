package proj;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;

class ShapesQuiz extends JFrame {

    private JLabel questionLabel;
    private JButton[] optionButtons;
    private int currentQuestionIndex = 0;
    private int score = 0;
    private Clip correctSoundClip;
    private Clip wrongSoundClip;

    private String[] questions = {
            "Touch Circle", "Touch Triangle", "Touch Square", "Touch Rectangle", "Touch Pentagon", "Touch Hexagon",
            "Touch Trapezoid", "Touch Diamond", "Touch Star", "Touch Heart", "Touch Oval", "Touch Cube"
    };

    private ImageIcon[][] options = {
            {new ImageIcon(getClass().getClassLoader().getResource("circle.png")), new ImageIcon(getClass().getClassLoader().getResource("triangle.png")), new ImageIcon(getClass().getClassLoader().getResource("square.png"))},
            {new ImageIcon(getClass().getClassLoader().getResource("circle.png")), new ImageIcon(getClass().getClassLoader().getResource("triangle.png")), new ImageIcon(getClass().getClassLoader().getResource("rectangle.png"))},
            {new ImageIcon(getClass().getClassLoader().getResource("star.png")), new ImageIcon(getClass().getClassLoader().getResource("oval.png")), new ImageIcon(getClass().getClassLoader().getResource("square.png"))},
            {new ImageIcon(getClass().getClassLoader().getResource("rectangle.png")), new ImageIcon(getClass().getClassLoader().getResource("pentagon.png")), new ImageIcon(getClass().getClassLoader().getResource("hexagon.png"))},
            {new ImageIcon(getClass().getClassLoader().getResource("pentagon.png")), new ImageIcon(getClass().getClassLoader().getResource("hexagon.png")), new ImageIcon(getClass().getClassLoader().getResource("heart.png"))},
            {new ImageIcon(getClass().getClassLoader().getResource("star.png")), new ImageIcon(getClass().getClassLoader().getResource("hexagon.png")), new ImageIcon(getClass().getClassLoader().getResource("oval.png"))},
            {new ImageIcon(getClass().getClassLoader().getResource("cube.png")), new ImageIcon(getClass().getClassLoader().getResource("triangle.png")), new ImageIcon(getClass().getClassLoader().getResource("trapezoid.png"))},
            {new ImageIcon(getClass().getClassLoader().getResource("trapezoid.png")), new ImageIcon(getClass().getClassLoader().getResource("star.png")), new ImageIcon(getClass().getClassLoader().getResource("diamond.png"))},
            {new ImageIcon(getClass().getClassLoader().getResource("heart.png")), new ImageIcon(getClass().getClassLoader().getResource("star.png")), new ImageIcon(getClass().getClassLoader().getResource("square.png"))},
            {new ImageIcon(getClass().getClassLoader().getResource("oval.png")), new ImageIcon(getClass().getClassLoader().getResource("heart.png")), new ImageIcon(getClass().getClassLoader().getResource("circle.png"))},
            {new ImageIcon(getClass().getClassLoader().getResource("diamond.png")), new ImageIcon(getClass().getClassLoader().getResource("oval.png")), new ImageIcon(getClass().getClassLoader().getResource("rectangle.png"))},
            {new ImageIcon(getClass().getClassLoader().getResource("cube.png")), new ImageIcon(getClass().getClassLoader().getResource("heart.png")), new ImageIcon(getClass().getClassLoader().getResource("circle.png"))},
    };
    private int[] correctAnswers = {0, 1, 2, 0, 0, 1, 2, 2, 1, 1, 1, 0};

    public ShapesQuiz() {
        setTitle("KiddieLearn");
        setSize(1000, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("KIDDIELEARN.jpg"));
        setIconImage(icon.getImage());
        
        ImageIcon backgroundImage = new ImageIcon(getClass().getClassLoader().getResource("startbg.png"));
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 1000, 550);
        add(backgroundLabel);

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
                new Shapes();
            }
        });
        backgroundLabel.add(backButton);

        setLayout(null);

        questionLabel = new JLabel("Question will be here", JLabel.CENTER);
        questionLabel.setFont(new Font("Comic Sans", Font.BOLD, 30));
        questionLabel.setForeground(Color.WHITE);
        questionLabel.setBounds(0, 40, 1000, 50);
        backgroundLabel.add(questionLabel);

        JPanel optionsPanel = new JPanel();
        optionsPanel.setOpaque(false); // Make the options panel transparent
        optionsPanel.setLayout(new GridLayout(1, 3));
        optionButtons = new JButton[3];

        for (int i = 0; i < 3; i++) {
            optionButtons[i] = new JButton();
            optionButtons[i].setOpaque(false);
            optionButtons[i].setBorder(null);
            optionButtons[i].setContentAreaFilled(false);
            optionButtons[i].setFocusPainted(false);

            optionButtons[i].addActionListener(new OptionButtonListener(i));
            optionsPanel.add(optionButtons[i]);
        }

        optionsPanel.setBounds(100, 150, 750, 200);
        backgroundLabel.add(optionsPanel);

        initializeSoundClips();
        loadNextQuestion();

        setVisible(true);
    }

    private void initializeSoundClips() {
        try {
            correctSoundClip = AudioSystem.getClip();
            wrongSoundClip = AudioSystem.getClip();

         
            AudioInputStream correctSoundInputStream = AudioSystem.getAudioInputStream(getClass().getClassLoader().getResource("correct.wav"));
            AudioInputStream wrongSoundInputStream = AudioSystem.getAudioInputStream(getClass().getClassLoader().getResource("incorrect.wav"));

            correctSoundClip.open(correctSoundInputStream);
            wrongSoundClip.open(wrongSoundInputStream);
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }


    private void loadNextQuestion() {
        if (currentQuestionIndex < questions.length) {
            questionLabel.setText(questions[currentQuestionIndex]);
            for (int i = 0; i < 3; i++) {
                optionButtons[i].setIcon(options[currentQuestionIndex][i]);
            }
        } else {
            displayResults();
        }
    }

    private void displayResults() {
        getContentPane().removeAll();
        revalidate();
        repaint();

        ImageIcon backgroundImage = new ImageIcon(getClass().getClassLoader().getResource("result1.png"));
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 980, 530);
        add(backgroundLabel);

        ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("KIDDIELEARN.jpg"));
        setIconImage(icon.getImage());

        JLabel scoreLabel = new JLabel("Your Score: " + score, JLabel.CENTER);
        scoreLabel.setFont(new Font("Comic Sans", Font.BOLD, 30));
        scoreLabel.setForeground(new Color(46, 152, 255, 210));
        scoreLabel.setBounds(90, 205, 800, 100);
        backgroundLabel.add(scoreLabel);

        JButton startAgain = new JButton("Start Again");
        startAgain.setFont(new Font("Comic Sans", Font.BOLD, 30));
        startAgain.setOpaque(false);
        startAgain.setBorder(null);
        startAgain.setContentAreaFilled(false);
        startAgain.setFocusPainted(false);
        startAgain.setBounds(90, 280, 800, 100);
        startAgain.setForeground(new Color(46, 152, 255, 210));
        startAgain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentQuestionIndex = 0;
                score = 0;
                loadNextQuestion();
                buttonSound();
                dispose();
                new ShapesQuiz();
            }
        });
        backgroundLabel.add(startAgain);

        JButton backButton = new JButton("", new ImageIcon(getClass().getClassLoader().getResource("back.png")));
        backButton.setBounds(8, 10, 100, 60);
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
        backgroundLabel.add(backButton);
        setVisible(true);

        playResultSound("result.wav");
    }

    private void playResultSound(String filePath) {
        try {
            Clip resultClip = AudioSystem.getClip();
            URL audioUrl = getClass().getClassLoader().getResource(filePath); // Load audio file from classpath
            if (audioUrl != null) {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioUrl);
                resultClip.open(audioInputStream);
                resultClip.start();
            } else {
                System.out.println("Error: results.wav file not found");
            }
        } catch (Exception e) {
            System.out.println("Error playing result sound: " + e.getMessage());
        }
    }


    private class OptionButtonListener implements ActionListener {
        private int buttonIndex;

        public OptionButtonListener(int index) {
            this.buttonIndex = index;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (buttonIndex == correctAnswers[currentQuestionIndex]) {
                score++;
                playCorrectSound();
            } else {
                playWrongSound();
            }
            currentQuestionIndex++;
            loadNextQuestion();
        }
    }

    private void playCorrectSound() {
        if (correctSoundClip != null) {
            correctSoundClip.stop();
            correctSoundClip.setFramePosition(0);
            correctSoundClip.start();
        }
    }

    private void playWrongSound() {
        if (wrongSoundClip != null) {
            wrongSoundClip.stop();
            wrongSoundClip.setFramePosition(0);
            wrongSoundClip.start();
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