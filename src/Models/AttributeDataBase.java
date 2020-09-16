package Models;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author fwd0849
 */
public class AttributeDataBase {

    ArrayList<Attributes> attributes = new ArrayList<>();
    ArrayList<Attributes> finalGame = new ArrayList<>();
    private int question;
    private int numberOfQuestions;
    private int difficulty1;
    private int difficulty2;
    private int difficulty3;
    private int randomD;
    private String line;
    private String[] splitLine;

    public AttributeDataBase() {
        this.attributes = new ArrayList<>();
        this.finalGame = new ArrayList<>();
        this.initaliseQuestionDataBase();
    }

    public static int randomDifficulty() {
        Random randomDifficulty = new Random();
        int randomNumber = randomDifficulty.nextInt(4)+1;
        return randomNumber;
    }

    public ArrayList<Attributes> initaliseQuestionDataBase() {
        try {

            Scanner fileScan = new Scanner(new File("Input/questionInformationUpdated"));

            while (fileScan.hasNextLine()) 
            {
                line = fileScan.nextLine();
                splitLine = line.split("%");

                Attributes attribute = new Attributes();

                randomD = randomDifficulty(); 

                attribute.setDifficulty(splitLine[1]);
                attribute.setQuestion(splitLine[2]);  //i did this so that all the attributes are set up as the lines are split
                attribute.setAnswer(splitLine[3]);
                attribute.setIncorrect1(splitLine[4]);
                attribute.setIncorrect2(splitLine[5]);
                attribute.setIncorrect3(splitLine[6]);

                attributes.add(attribute);

                for (int i = 0; i < attributes.size(); i++) //these nested if statements setup the final game arraylist.
                {
                    if (randomD == Integer.parseInt(attribute.getDifficulty())) {
                        if (attribute.getDifficulty().equalsIgnoreCase("1")) {
                            difficulty1++; //a counter system to make sure that i don't get more than 5 of one difficulty.

                            if (difficulty1 <= 5) {
                                if (numberOfQuestions <= 15) {
                                    finalGame.add(attribute);  //adds this difficulty rating attribute to the final game
                                    numberOfQuestions++;
                                    break;
                                }
                            } else {
                                break;
                            }
                        } else if (attribute.getDifficulty().equalsIgnoreCase("2")) {
                            difficulty2++;

                            if (difficulty2 <= 5) {
                                if (numberOfQuestions <= 15) {
                                    finalGame.add(attribute);
                                    numberOfQuestions++;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }

                        if (attribute.getDifficulty().equalsIgnoreCase("3")) {
                            difficulty3++;

                            if (difficulty3 <= 5) {
                                if (numberOfQuestions <= 15) {
                                    finalGame.add(attribute);
                                    numberOfQuestions++;
                                    break;
                                }
                            } else {
                                break;
                            }
                        } else if (numberOfQuestions > 15) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                line = "";

            }

            fileScan.close();
        } catch (IOException e) {
        }

        return finalGame;

    }

    public Attributes getQuestion(int index) {
        if (index >= 0 && index < this.finalGame.size()) {
            return this.finalGame.get(index);
        }
        return null;
    }

    public void remove(int id) {
        question = id;
        finalGame.remove(question);
    }

    public ArrayList<Attributes> getQuestions() {
        return this.finalGame;
    }

    public ArrayList<Attributes> getCompleteQuestionList() {
        return this.attributes;
    }
}
