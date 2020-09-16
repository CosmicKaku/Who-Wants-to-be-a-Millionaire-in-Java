package Models;


public class QuestionNumber {

    private static int currentNumber;

    //getter and setter
    public void setCurrentNumber(int currentNumber)
    {
        this.currentNumber = currentNumber;
    }

    public int getQuestionNumber()
    {
        return currentNumber;
    }

}
