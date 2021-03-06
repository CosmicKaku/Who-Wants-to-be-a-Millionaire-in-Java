package Models;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author fwd0849
 */

public class SetFinalGameQuestions
{
    private int number;
    private int difficulty1;
    private int difficulty2;
    private int difficulty3;
    private int randomDiff;
    private int numberOfQuestions;
    private static ArrayList<Attributes> finalGameQuestions = new ArrayList<Attributes>();

    public static int randomDifficulty(){
        Random rand = new Random();
        int randomNumber = rand.nextInt(3) + 1;
        return randomNumber;
    }

    public void setFinalQuestions(ArrayList<Attributes> dbQuestions){
        
        number = 0;
        numberOfQuestions = 0;
        difficulty1 = 0;
        difficulty2 = 0;
        difficulty3 = 0;

       while(number < dbQuestions.size()){
           
           randomDiff = randomDifficulty();

           for (int i = number; i < dbQuestions.size(); i++){ //these nested if statements setup the final game arraylist.
               
                if (randomDiff == Integer.parseInt(dbQuestions.get(i).getDifficulty())){
                       if (dbQuestions.get(i).getDifficulty().equalsIgnoreCase("1")){
                           difficulty1++; //a counter system to make sure that i don't get more than 5 of one difficulty.
                           if (difficulty1 <= 5) {
                               if (numberOfQuestions <= 15) {
                                   finalGameQuestions.add(dbQuestions.get(i));  //adds this difficulty rating attribute to the final game
                                   numberOfQuestions++;
                                   break;
                               }
                           }else
                               break;      
                       }else if (dbQuestions.get(i).getDifficulty().equalsIgnoreCase("2")){
                           difficulty2++;
                           if (difficulty2 <= 5) {
                               if (numberOfQuestions <= 15) {
                                   finalGameQuestions.add(dbQuestions.get(i));
                                   numberOfQuestions++;
                                   break;
                               }
                           } else 
                               break;
                       }else if (dbQuestions.get(i).getDifficulty().equalsIgnoreCase("3")) {
                           difficulty3++;
                           if (difficulty3 <= 5) {
                               if (numberOfQuestions <= 15){
                                   finalGameQuestions.add(dbQuestions.get(i));
                                   numberOfQuestions++;
                                   break;
                               }
                           } else
                               break;
                       } else 
                           break;   
               }else
                   break;
           }

           number++;
       }

    }

    public ArrayList getFinalQuizQuestions()
    {
        return this.finalGameQuestions;
    }

    public Attributes getQuestion(int index) {
        if (index >= 0 && index < this.finalGameQuestions.size()) {
            return this.finalGameQuestions.get(index);
        }
        return null;
    }

    public void clear()
    {
        for(int i = 0; i < finalGameQuestions.size(); i++)
        {
            finalGameQuestions.set(i, null);
        }
        finalGameQuestions.trimToSize();
    }
}
