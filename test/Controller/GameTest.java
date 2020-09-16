
package Controller;

import Models.LifeLines;
import Models.Prize;
import Models.QuestionNumber;
import Models.Username;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Iris-
 */
public class GameTest {
    
    public GameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

   
     @Test
    public void testQuestionNumber(){
        QuestionNumber qNumber = new QuestionNumber();
        qNumber.setCurrentNumber(10);
        int output = qNumber.getQuestionNumber();

        assertEquals(10, output);
    }

    
    @Test
    public void testLifeLines(){
        LifeLines lifeLines = new LifeLines();
        lifeLines.setLifeLines();
        boolean output = lifeLines.getLifeLines(1);

        assertEquals(false, output);
    }
    
    @Test
    public void testUserInput(){
        Username username = new Username();
        username.setUsername(false);
        boolean output = username.getUsername();

        assertEquals(false, output);
    }
    
    @Test
    public void testPrizeMoney(){
        Prize prizeMoney = new Prize();
        int output = prizeMoney.getPrize(14);

        assertEquals(1000000, output);

    }
    
}
