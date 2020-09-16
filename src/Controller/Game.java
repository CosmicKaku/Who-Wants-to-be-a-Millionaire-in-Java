package Controller;

import Models.*;
import View.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;



public class Game implements ActionListener{
    private SetFinalGameQuestions QuizQuestions = new SetFinalGameQuestions();
    private QuestionDataBase NewQuiz = new QuestionDataBase();
    private ShuffleAnswers SortedAnswers = new ShuffleAnswers();
    private QuestionNumber question = new QuestionNumber();
    private LifeLines lifeLines = new LifeLines();
    private AskTheAudience askTheAudience = new AskTheAudience();
    private Username userName = new Username();
    private Prize prizeMoney = new Prize();
    private UsernameView usernameView;
    private String UserName;

    private String source;
    private Card card;
    private int question_Number;


    public ArrayList<String> getRoundAnswers()
    {
        return SortedAnswers.getShuffledAnswers();
    }

    //creates a new game each time the new game button is pressed

    public Game(Card card){
        this.card = card;
        NewQuiz.autoConnectDB();
        NewQuiz.createTable();
        NewQuiz.queryDataBase();
        QuizQuestions.setFinalQuestions(NewQuiz.getQuiz_Questions());
        lifeLines.setLifeLines();
        userName.setUsername(true);
        question_Number = 0;
        question.setCurrentNumber(question_Number);
        usernameView = new UsernameView(this);
        card.addCardToStack(usernameView, "username");

    }


    /*this method listens for actions that are performed by the actionlisteners stored
    * inside the classes that i declare. When i receives the actionlistener it acts upon the */
    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {

            source = ((Component) actionEvent.getSource()).getName();

            if(question.getQuestionNumber() == 14 && source.equalsIgnoreCase(QuizQuestions.getQuestion(question.getQuestionNumber()).getAnswer()))
            {
                ExitButtonView exitButtonView = new ExitButtonView(this, question.getQuestionNumber());
                card.addCardToStack(exitButtonView, "exitButton");
            }
            else if (source.equalsIgnoreCase(QuizQuestions.getQuestion(question.getQuestionNumber()).getAnswer()))
            {
                question_Number++;
                question.setCurrentNumber(question_Number);
                QuizCorrectView correctView = new QuizCorrectView(this);
                card.addCardToStack(correctView, "Correct");

                card.showCard("Correct");

            }
            else if(source.equalsIgnoreCase("submitUsernameButton"))
            {

                UserName = usernameView.getUsername().getText().toString();

                if(UserName.equalsIgnoreCase(""))
                {
                    userName.setUsername(false);
                    usernameView = new UsernameView(this);
                    card.addCardToStack(usernameView, "userNAME");
                }
                else
                {
                    QuizQuestionView FirstQuestionView = new QuizQuestionView(this);
                    card.addCardToStack(FirstQuestionView, QuizQuestions.getQuestion(question.getQuestionNumber()).toString());
                }
            }
            else if (source.equalsIgnoreCase("nextQuestionButton"))
            {
                QuizQuestionView NextQuestionView = new QuizQuestionView(this);
                card.addCardToStack(NextQuestionView, QuizQuestions.getQuestion(question.getQuestionNumber()).getQuestion());
            } else if (source.equalsIgnoreCase("returnToMenuBTN"))
            {
                ExitButtonView exitButtonView = new ExitButtonView(this, question.getQuestionNumber());
                card.addCardToStack(exitButtonView, "ExitMessage");
            } else if (source.equalsIgnoreCase("exitButton"))
            {
                ExitButtonView exitButtonView = new ExitButtonView(this, question.getQuestionNumber());
                card.addCardToStack(exitButtonView, "ExitMessage");
            }
            else if(source.equalsIgnoreCase("fiftyFiftyButton") && lifeLines.getLifeLines(0) == false) {
                lifeLines.usedLifeLine(0);
                FiftyFiftyView FiftyFiftyView = new FiftyFiftyView(this);
                card.addCardToStack(FiftyFiftyView, QuizQuestions.getQuestion(question.getQuestionNumber()).toString());
            }
            else if(source.equalsIgnoreCase("phoneAFriendButton") && lifeLines.getLifeLines(1) == false)
            {
                lifeLines.usedLifeLine(1);
                PhoneAFriendView phoneAFriendView = new PhoneAFriendView(this, UserName);
                card.addCardToStack(phoneAFriendView, QuizQuestions.getQuestion(question.getQuestionNumber()).toString());
            }
            else if(source.equalsIgnoreCase("askTheAudienceButton") && lifeLines.getLifeLines(2) == false)
            {
                lifeLines.usedLifeLine(2);
                askTheAudience.setAskTheAudience(question.getQuestionNumber());
                AskTheAudienceView askTheAudienceView = new AskTheAudienceView(this);
                card.addCardToStack(askTheAudienceView, QuizQuestions.getQuestion(question.getQuestionNumber()).toString());
            }
            else if(source.equalsIgnoreCase("mainMenuButton"))
            {
                card.showCard("Menu");
            }
            else
            {
                QuizIncorrectView incorrectView = new QuizIncorrectView(this);
                card.addCardToStack(incorrectView, "Incorrect");
            }
    }


}








