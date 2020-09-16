package Controller;

import Models.*;
import View.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;


public class MillionaireQuiz extends JFrame implements ActionListener {


    private Card card = new Card();

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String source = ((Component) actionEvent.getSource()).getName();

        if (source.equals("newGameButton")) {
            Game game = new Game(card);

        } else if (source.equalsIgnoreCase("menuButton")) {
            card.showCard("Menu");
        } else if (source.equalsIgnoreCase("rulesButton")) {
            QuizRulesView quizRulesView = new QuizRulesView(this);
            card.addCardToStack(quizRulesView, "Rules");
        } else if (source.equalsIgnoreCase("returnButton")) {
            card.showCard("Menu");
        } else if (source.equals("exitButton")) {
            System.exit(0);
        }
    }

    public MillionaireQuiz() {
        super(" Who wants to be a millionaire ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel menuView = new QuizMenuView(this);

        card.addCardToStack(menuView, "Menu");
        add(card);
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenDimension = tk.getScreenSize();
        setSize(760, 430);
        setLocation((screenDimension.width-getSize().width)/2,
         (screenDimension.height-getSize().height)/2);
        
        setResizable(false);
        setVisible(true);

    }

    public static void main(String[] args) throws IOException, InterruptedException, SQLException {

        QuestionDataBase NewQuiz = new QuestionDataBase();
        SetFinalGameQuestions set = new SetFinalGameQuestions();
        NewQuiz.autoConnectDB();
        NewQuiz.createTable();
        NewQuiz.queryDataBase();
        
        
        set.setFinalQuestions(NewQuiz.getQuiz_Questions());
        
        MillionaireQuiz quiz = new MillionaireQuiz();
    }

}
