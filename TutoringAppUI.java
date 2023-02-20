package TutoringApp;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;

public class TutoringAppUI implements ActionListener {
    String currentScreen = "Starting Screen";
    String role;
    String name;
    String password;
    String canMath;
    String canReading;
    String canMusic;
    String canOther;
    String currentQuestion;

    JFrame frame = new JFrame();
    JLabel welcomeText = new JLabel();
    JButton signUp = new JButton("Sign Up");
    JButton logIn = new JButton("Log in");
    JLabel alreadyAccount = new JLabel("Already have an account?");
    BufferedImage logo = ImageIO.read(new File("C:\\Users\\shakt\\Downloads\\th (1).png"));
    JLabel logo1 = new JLabel(new ImageIcon(logo));
    JTextField createUsername = new JTextField();
    JTextField createPassword = new JTextField();
    JLabel enterUsername = new JLabel("Enter Username");
    JLabel enterPassword = new JLabel("Enter Password");
    JLabel areStudentOrTutor = new JLabel("Are you a student or tutor?");
    JRadioButton selectStudent = new JRadioButton("Student");
    JRadioButton selectTutor = new JRadioButton("Tutor");
    ButtonGroup b1 = new ButtonGroup();
    JButton nextScreen = new JButton("Next");
    JLabel createUser = new JLabel("Create Username:");
    JLabel createPass = new JLabel("Create Password:");
    JLabel whatSubjects = new JLabel("What subjects can you teach?");
    JCheckBox math = new JCheckBox("Mathematics");
    JCheckBox reading = new JCheckBox("Reading/ELA");
    JCheckBox music = new JCheckBox("Music");
    JCheckBox other = new JCheckBox("Other");
    JButton finish = new JButton("Finish");
    JTextField enterUser = new JTextField();
    JTextField enterPass = new JTextField();
    JButton logInButton = new JButton("Sign in");

    JButton askQuestion = new JButton("Ask");
    JPanel askPanel = new JPanel();
    JPanel tutorsPanel = new JPanel();
    JTextPane tp = new JTextPane();
    JPanel questionPanel = new JPanel();
    JPanel answerPanel = new JPanel();
    JTextArea questiontf = new JTextArea();
    JTextArea answertf = new JTextArea();
    JButton answerQuestion = new JButton("Answer");
    JButton refresh = new JButton("Refresh");


    TutoringAppUI() throws IOException {
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.WHITE);

        logo1.setBounds(-100,-100,300,300);



        signUp.setBounds(670,460,150,60);
        signUp.setBackground(Color.green);
        signUp.setFont(new Font("Courier", Font.PLAIN ,30));
        signUp.setForeground(Color.WHITE);
        signUp.addActionListener(this);

        logIn.addActionListener(this);

        finish.addActionListener(this);

        logInButton.addActionListener(this);

        logIn.setBounds(670,600,150,60);
        logIn.setBackground(Color.BLUE);
        logIn.setFont(new Font("Courier", Font.PLAIN ,30));
        logIn.setForeground(Color.WHITE);

        alreadyAccount.setFont(new Font("Courier", Font.PLAIN, 20));
        alreadyAccount.setBounds(630,540,300,30);

        welcomeText.setText("Welcome to MyTutoring");
        welcomeText.setBounds(300,100,1000,400);
        welcomeText.setFont(new Font("Courier",Font.BOLD,80));

        b1.add(selectStudent);
        b1.add(selectTutor);

        frame.add(areStudentOrTutor);
        frame.add(logo1);
        frame.add(welcomeText);
        frame.add(signUp);
        frame.add(alreadyAccount);
        frame.add(logIn);
        frame.add(selectStudent);
        frame.add(selectTutor);
        frame.add(nextScreen);
        frame.add(createUser);
        frame.add(createPass);
        frame.add(createUsername);
        frame.add(createPassword);
        frame.add(whatSubjects);
        frame.add(math);
        frame.add(reading);
        frame.add(music);
        frame.add(other);
        frame.add(enterUsername);
        frame.add(enterPassword);
        frame.add(finish);
        frame.add(enterUser);
        frame.add(enterPass);
        frame.add(logInButton);
        frame.add(askQuestion);
        frame.add(askPanel);
        frame.add(tutorsPanel);
        frame.add(tp);
        frame.add(answerQuestion);
        frame.add(answerPanel);
        frame.add(questionPanel);
        frame.add(refresh);
        frame.add(questiontf);
        frame.add(answertf);


        nextScreen.setVisible(false);
        areStudentOrTutor.setVisible(false);
        selectStudent.setVisible(false);
        selectTutor.setVisible(false);
        createUser.setVisible(false);
        createPassword.setVisible(false);
        createPass.setVisible(false);
        createUsername.setVisible(false);


        frame.setSize(1536, 864);
        frame.setVisible(true);
    }



    public void changeScreen() throws SQLException, InterruptedException {

        if (currentScreen.equals("New Account1")) {
            areStudentOrTutor.setBounds(350, 100, 1000, 400);
            areStudentOrTutor.setFont(new Font("Courier",Font.BOLD,60));
            areStudentOrTutor.setVisible(true);

            selectTutor.setBounds(720,400,100,30);
            selectTutor.setVisible(true);
            selectTutor.setBackground(Color.WHITE);

            selectStudent.setVisible(true);
            selectStudent.setBounds(600,400,100,30);
            selectStudent.setBackground(Color.WHITE);

            nextScreen.setVisible(true);
            nextScreen.setBounds(900,500,100,50);
            nextScreen.addActionListener(this);

            logIn.setVisible(false);
            alreadyAccount.setVisible(false);
            signUp.setVisible(false);
            welcomeText.setVisible(false);
        }

        if (currentScreen.equals("New Account2t")) {
            areStudentOrTutor.setVisible(false);
            selectTutor.setVisible(false);
            selectStudent.setVisible(false);

            whatSubjects.setVisible(true);
            whatSubjects.setBounds(350, 100, 1000, 400);
            whatSubjects.setFont(new Font("Courier", Font.PLAIN, 60));

            math.setVisible(true);
            math.setBounds(600,375,100,20);
            math.setBackground(Color.WHITE);

            reading.setVisible(true);
            reading.setBounds(600,430,100,20);
            reading.setBackground(Color.WHITE);

            music.setVisible(true);
            music.setBounds(750,375,100,20);
            music.setBackground(Color.WHITE);

            other.setVisible(true);
            other.setBounds(750,430,100,20);
            other.setBackground(Color.WHITE);
        }

        if (currentScreen.equals("New Account2")) {
            areStudentOrTutor.setVisible(false);
            selectTutor.setVisible(false);
            selectStudent.setVisible(false);
            math.setVisible(false);
            reading.setVisible(false);
            other.setVisible(false);
            music.setVisible(false);
            whatSubjects.setVisible(false);
            nextScreen.setVisible(false);

            createUser.setVisible(true);
            createUser.setBounds(600,310,200,30);

            createUsername.setVisible(true);
            createUsername.setBounds(600,350,100,20);

            createPass.setVisible(true);
            createPass.setBounds(750,310,200,30);


            createPassword.setVisible(true);
            createPassword.setBounds(750,350,100,20);

            finish.setVisible(true);
            finish.setBounds(900,500,100,50);
        }
        if (currentScreen.equals("Starting Screen")) {
            signUp.setVisible(true);
            logIn.setVisible(true);
            welcomeText.setVisible(true);
            alreadyAccount.setVisible(true);

            createPassword.setVisible(false);
            createUsername.setVisible(false);
            createPass.setVisible(false);
            createUser.setVisible(false);
            finish.setVisible(false);
        }

        if (currentScreen.equals("Login Screen")) {
            welcomeText.setVisible(false);
            signUp.setVisible(false);
            logIn.setVisible(false);
            alreadyAccount.setVisible(false);

            enterUsername.setVisible(true);
            enterUsername.setBounds(600,310,200,30);

            enterUser.setVisible(true);
            enterUser.setBounds(600,350,100,20);

            enterPassword.setVisible(true);
            enterPassword.setBounds(750,310,200,30);


            enterPass.setVisible(true);
            enterPass.setBounds(750,350,100,20);
            logInButton.setBounds(900,500,100,50);
        }
        if (currentScreen.equals("Main Window")) {
            logInButton.setVisible(false);
            enterPass.setVisible(false);
            enterPassword.setVisible(false);
            enterUser.setVisible(false);
            enterUsername.setVisible(false);
            logo1.setVisible(false);

            tp.setBounds(400,564,1136,300);
            tp.setBorder(new LineBorder(Color.LIGHT_GRAY));
            tutorsPanel.setBounds(0,0,400,864);
            tutorsPanel.setBackground(Color.LIGHT_GRAY);

            refresh.setBounds(0,0,80,30);
            refresh.addActionListener(this);

            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "orcl");
            PreparedStatement stmt = c.prepareStatement("select * from UsersTutoringApp where username = ? AND password1 = ?");
            stmt.setString(1,enterUser.getText());
            stmt.setString(2, enterPass.getText());

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                role = rs.getString(3);
            }


            if (role.equals("Student")) {
                askQuestion.addActionListener(this);
                askQuestion.setBounds(400,514,100,50);
                askQuestion.setBackground(Color.GREEN);
                displayQuestionStudent();
                updateFrameStudent();
            }
            if (role.equals("Tutor")) {
                answerQuestion.addActionListener(this);
                answerQuestion.setBounds(400,514,100,50);
                answerQuestion.setBackground(Color.GREEN);
                getQuestion();

            }
        }

    }

    public void displayQuestionStudent() throws SQLException {
//        questionPanel.setBounds(450,60,300,200);
//        questionPanel.setBackground(Color.GREEN);
//        questionPanel.setVisible(true);
        //27 char long
        questiontf.setBounds(450,60,500,200);
        questiontf.setEditable(false);
        questiontf.setFont(new Font("Courier",Font.PLAIN, 20));
        questiontf.setBackground(Color.GREEN);
        String questionText = "";

        Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "orcl");
        PreparedStatement pstmt = c.prepareStatement("select * from Messages where changeQuestion = ?");
        System.out.println(enterUser.getText());
        pstmt.setString(1,enterUser.getText());
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            questionText = rs.getString(1);
        }

        questiontf.setText(questionText);
    }
    public void displayAnswerStudent() throws SQLException {

        answertf.setBounds(1000,300,500,200);
        answertf.setEditable(false);
        answertf.setFont(new Font("Courier",Font.PLAIN, 20));
        answertf.setBackground(Color.CYAN);
        String answerText = "";

        Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "orcl");
        PreparedStatement pstmt = c.prepareStatement("select * from Messages where changeQuestion = ?");
        pstmt.setString(1,enterUser.getText());
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            answerText = rs.getString(2);
        }

        answertf.setText(answerText);
    }

    public void getQuestion() {
        try {
            questiontf.setBounds(450,60,500,200);
            questiontf.setEditable(true);
            questiontf.setFont(new Font("Courier",Font.PLAIN, 20));
            questiontf.setBackground(Color.GREEN);
            answertf.setBounds(1000,300,500,200);
            answertf.setEditable(false);
            answertf.setFont(new Font("Courier",Font.PLAIN, 20));
            answertf.setBackground(Color.CYAN);

            Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "orcl");
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Messages where response = 'None' ");

            while (rs.next()) {
                currentQuestion = rs.getString(1);
            }

            questiontf.setText(currentQuestion);

        } catch(Exception e) {
            System.out.println(e);
        }

    }

    private void updateFrameStudent() throws SQLException {
        displayQuestionStudent();
        displayAnswerStudent();
    }
    private void updateFrameTutor() {
        getQuestion();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

        TutoringAppUI obj = new TutoringAppUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signUp) {
            name = null;
            role = null;
            password = null;
            canMath = null;
            canReading = null;
            canMusic = null;
            canOther = null;
            currentScreen = "New Account1";
            try {
                changeScreen();
            } catch (SQLException | InterruptedException throwables) {
                throwables.printStackTrace();
            }
        }
        if (e.getSource() == nextScreen) {
            if (currentScreen.equals("New Account2t")) {
                if (math.isSelected()) {
                    canMath = "True";
                }
                if (reading.isSelected()) {
                    canReading = "True";
                }
                if (music.isSelected()) {
                    canMusic = "True";
                }
                if (other.isSelected()) {
                    canOther = "True";
                }
                currentScreen = "New Account2";
                try {
                    changeScreen();
                } catch (SQLException | InterruptedException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (currentScreen.equals("New Account1")) {
                if (selectStudent.isSelected()==true) {
                    role = "Student";
                    currentScreen = "New Account2";
                    try {
                        changeScreen();
                    } catch (SQLException | InterruptedException throwables) {
                        throwables.printStackTrace();
                    }
                }
                if (selectTutor.isSelected()==true) {
                    role = "Tutor";
                    currentScreen = "New Account2t";
                    try {
                        changeScreen();
                    } catch (SQLException | InterruptedException throwables) {
                        throwables.printStackTrace();
                    }
                }

            }

        }
        if (e.getSource() == finish) {

            name = createUsername.getText();
            password = createPassword.getText();

            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "orcl");

                PreparedStatement stmt = c.prepareStatement("insert into UsersTutoringApp values (?,?,?,?,?,?,?,?)");
                stmt.setString(1,name);
                stmt.setString(2,password);
                stmt.setString(3,role);
                stmt.setString(4,"false");
                stmt.setString(5,canMath);
                stmt.setString(6,canReading);
                stmt.setString(7,canMusic);
                stmt.setString(8,canOther);

                stmt.execute();

                c.close();
            } catch(Exception f) {
                System.out.println(f);
            }

            currentScreen = "Starting Screen";
            try {
                changeScreen();
            } catch (SQLException | InterruptedException throwables) {
                throwables.printStackTrace();
            }
        }
        if (e.getSource()== logIn) {
            currentScreen = "Login Screen";
            try {
                changeScreen();
            } catch (SQLException | InterruptedException throwables) {
                throwables.printStackTrace();
            }

        }
        if (e.getSource()==logInButton) {
            try {
                String user = enterUser.getText();
                String pass = enterPass.getText();
//                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "orcl");
                Connection c1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "orcl");
                Statement stmt = c.createStatement();
                PreparedStatement pstmt = c1.prepareStatement("update UsersTutoringApp set Online1 = ? where Username = ? AND Password1 = ?");
                ResultSet rs = stmt.executeQuery("select * from UsersTutoringApp");
                boolean found = false;
                while(rs.next()) {
                    if (user.equals(rs.getString("username"))) {
                        if (pass.equals(rs.getString("password1"))) {
                            found = true;

                            break;
                        }
                    }
                }

                if (found) {

                    pstmt.setString(1,"True");
                    pstmt.setString(2,user);
                    pstmt.setString(3,pass);
                    pstmt.executeUpdate();

                    c.close();
                    c1.close();

                    currentScreen = "Main Window";
                    changeScreen();

                }
            } catch(Exception g) {
                System.out.println(g);
            }
        }
        if (e.getSource() == askQuestion) {
            try {
                String question = tp.getText();

                Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "orcl");

                Statement stmt = c.createStatement();
                PreparedStatement pstmt = c.prepareStatement("insert into Messages values (?,?,?)");

                pstmt.setString(1,question);
                pstmt.setString(2,"None");
                pstmt.setString(3,enterUser.getText());
                pstmt.executeUpdate();

//                PreparedStatement stmt = c.prepareStatement("update Messages set question = ? where response = ?");

                c.close();

            } catch(Exception f) {
                System.out.println(f);
            }

        }
        if (e.getSource() == answerQuestion) {
            try {
                String answer = tp.getText();

                Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "orcl");


                PreparedStatement pstmt = c.prepareStatement("update Messages set response = ? where question = ?");

                pstmt.setString(1,answer);
                pstmt.setString(2,currentQuestion);
                pstmt.executeUpdate();

                answertf.setText(answer);

                c.close();
            }catch(Exception g) {
                System.out.println(g);
            }

        }
        if (e.getSource() == refresh) {
            try {
                if (role == "Student") {
                    updateFrameStudent();
                } else {
                    updateFrameTutor();
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }


}
