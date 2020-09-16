package Models;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author fwd0849
 */

public class PhoneAFriend
{
   private SetFinalGameQuestions QuizQuestions = new SetFinalGameQuestions();
   private ShuffleAnswers answers = new ShuffleAnswers();
   private ArrayList<String> friendNames = new ArrayList<String>();


    public int friendIsCorrect() {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;
        return randomNumber;
    }

    public int randomNumber() {
        Random random = new Random();
        int number = random.nextInt(4) + 1;
        return number;
    }

    public String getPhoneResponse(String name, int round) {
        
        int friendIsIncorrect = 40;
        int i = round;
        String username = name;
        String friendAnswer = "";
        if (friendIsCorrect() > friendIsIncorrect) {
            for (int y = 0; y < answers.getShuffledAnswers().size(); y++) {
                if (QuizQuestions.getQuestion(i).getAnswer().equalsIgnoreCase(answers.getShuffledAnswers().get(y))) {
                    friendAnswer = friendAnswer.concat("Hi, " + username + friendNames.get(getFriendName()) + " here, i looked at the question" + "\n");
                    friendAnswer = friendAnswer.concat("and i believe that | " + answers.getShuffledAnswers().get(y) + " | is the correct one. ");
                    friendAnswer = friendAnswer.concat("GoodLuck!!!");

                    return friendAnswer;
                }
            }
        } else {
            friendAnswer = friendAnswer.concat("Sup man " + username + " its your friend " + friendNames.get(getFriendName()) + " here, i looked at the question" + "\n");
            friendAnswer = friendAnswer.concat("your stuck on, and i think the answer is | " + answers.getShuffledAnswers().get(randomNumber()) + " | hope that helps! later man!");

            return friendAnswer;

        }

        return friendAnswer;
    }

    public Integer getFriendName() {

        friendNames.add("Sean");
        friendNames.add("Oscar");
        friendNames.add("Max");
        friendNames.add("Charlie");
        
        friendNames.trimToSize();
        
        Random random = new Random();
        int number = random.nextInt(4);

        return number;
    }

}
