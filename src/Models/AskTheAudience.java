package Models;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class involves the code for AskTheAudience function
 * 
 *
 * @author fwd0849
 */

public class AskTheAudience
{
    private ShuffleAnswers answers = new ShuffleAnswers();
    private SetFinalGameQuestions QuizQuestions = new SetFinalGameQuestions();
    private static final ArrayList<Integer> chances = new ArrayList<Integer>();

    public ArrayList<Integer> getChances(int chance, int incorrect, int position)
    {
        Random random = new Random();
        int incorrectChances = incorrect;
        int ichance = incorrectChances / 2;
        int number1;
        int number2;

        number1 = random.nextInt((ichance - 10) + 1) + 10;
        incorrectChances = incorrectChances - number1;

        number2 = random.nextInt((ichance - 10) + 1) + 10;
        incorrectChances = incorrectChances - number2;

        switch (position) {
            case 0:
                chances.add(0, chance);
                chances.add(1, number1);
                chances.add(2, number2);
                chances.add(3, incorrectChances);
                break;
            case 1:
                chances.add(0, number1);
                chances.add(position, chance);
                chances.add(2, number2);
                chances.add(3, incorrectChances);
                break;
            case 2:
                chances.add(0, number1);
                chances.add(1, number2);
                chances.add(position, chance);
                chances.add(3, incorrectChances);
                break;
            case 3:
                chances.add(0, number1);
                chances.add(1, number2);
                chances.add(2, incorrectChances);
                chances.add(position, chance);
                break;
            default:
                break;
        }

        chances.trimToSize();
        return chances;
    }

    public void setAskTheAudience(int round) {
        int i = round;

        for (int w = 0; w < answers.getShuffledAnswers().size(); w++) {
            if (QuizQuestions.getQuestion(i).getAnswer().equalsIgnoreCase(answers.getShuffledAnswers().get(w))) {
                if (QuizQuestions.getQuestion(i).getDifficulty().equalsIgnoreCase("1")) {
                    int chance = 45;
                    int incorrect = 55;
                    int position = w;
                    getChances(chance, incorrect, position);
                    break;

                } else if (QuizQuestions.getQuestion(i).getDifficulty().equalsIgnoreCase("2")) {
                    int chance = 55;
                    int incorrect = 45;
                    int position = w;
                    getChances(chance, incorrect, position);
                    break;
                } else if (QuizQuestions.getQuestion(i).getDifficulty().equalsIgnoreCase("3")) {
                    int chance = 65;
                    int incorrect = 35;
                    int position = w;
                    getChances(chance, incorrect, position);
                    break;
                }

            }
        }
    }

    public Integer getChancePercentage(int index)
    {
        return this.chances.get(index);
    }

}
