package Models;

import java.sql.*;
import java.util.ArrayList;

public class QuestionDataBase
{
    public final String url = "jdbc:derby:DerbyDatabase;create=true";
    public final String username = "pdc";
    public final String password = "pdc";
    public final String tableName = "pdc_Quiz_DataBase";
    public Connection connection;
    public Statement statement;
    
    private ArrayList<Attributes> Quiz_Questions = new ArrayList<>();
  
    
    public void autoConnectDB() {
        try {
            
            connection = DriverManager.getConnection(url, username, password);
            System.out.println(url + "     Connected.....");
            
        } catch (Throwable ex) {
            System.err.println("SQL Exception: " + ex.getMessage());
        }
    }
    
    public void createTable() {
        try {
            statement = connection.createStatement();
            this.checkTableExisting(tableName);
            statement.executeUpdate("CREATE TABLE " + tableName+" ( Difficulty int,"
                    +  "Question varchar(255), Answer varchar(255), Incorrect1 varchar(255), Incorrect2 varchar(255)," +
                    "Incorrect3 varchar(255))");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(1, 'Who is the major actor in Transformers?', 'Shia Le Bouef', 'Harrison Ford', 'Aaron Eckhart', 'Tom Cruise')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(3, 'What is the common name for Melaleuca tree?', 'Tea Tree', 'Pohutakawha', 'Apple', 'Kowhai')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(2, 'Which country is the largest exporter of rice?', 'India', 'China', 'Thailand', 'Pakistan')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(1, 'Which disease devastated livestock across the UK during 2001?', 'Foot-and-mouth', 'Hand-and-foot', 'Hand-to-mouth', 'Foot-in-mouth')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(1, 'What country won 2015 Rugby World Cup? ', 'New Zealand', 'Australia', 'England', 'Argentina')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(3, 'Who did artist Grant Wood use as the model for the farmer in his classic painting \"American Gothic\"?', 'His dentist', 'Traveling salesman', 'Local sheriff', 'His butcher')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(3, 'In addition to his career as an astrologer and \"prophet\", Nostradamus published a 1555 treatise that included a section on what?', 'Making jam and jellies', 'Training parrots to talk', 'Cheating at card games', 'Digging graves')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(1, 'Sri Lanka is surrounded by which ocean', 'Indian Ocean', 'Pacific Ocean', 'Atlantic Ocean', 'Red Sea')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(2, 'Which Patriot leader organized the Boston Tea Party in 1773?', 'Samuel Adams', 'George Washington', 'Richard Nixon', 'John Adams')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(1, 'What is the world''s longest river?', 'The Amazon', 'The Waikato', 'The Nile', 'The Congo River')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(1, 'What is the deepest part of the Ocean?', 'Mariana Trench', 'South Sandwich Trench', 'Java Trench', 'Eurasian Basin')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(2, 'Where would you find the Sea of Tranquility?', 'The Moon', 'Tonga', 'Fiji', 'Mediterranean')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(1, 'Name the seventh planet from the sun', 'Uranus', 'Saturan', 'Juiptier', 'Neptune')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(1, 'How many rings on the Olympic flag', 'Five', 'Six', 'Seven', 'Four')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(1, 'Who was the first man in space?', 'Yuri Gagarin', 'Neil Armstrong', 'Laika', 'Dmitry Klokov')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(2, 'If you had pogonophobia, what would you be afraid of?', 'Beards', 'Pogo sticks', 'Pornography', 'Chimpanzees')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(1, 'Which company does Bill Gates own?', 'Microsoft', 'Apple', 'VMWare', 'Samsung')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(1, 'What is a baby Goat called?', 'A kid', 'A cub', 'A kitten', 'A calf')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(1, 'Which car company makes the Celica', 'Toyota', 'Nissian', 'Mazda', 'Volkswagen')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(1, 'What is the largest state in the USA?', 'Alaska', 'Texas', 'New York', 'California')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(1, 'What was the world''s first high level programming language?', 'IBM Fortran', 'Microsoft C', 'Oracle Java', 'Python')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(2, 'In Japan what is Seppuku', 'Suicide', 'Traditional Festival', 'A rank of Samurai ', 'A form of painting')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(2, 'The title of whose book translates as my struggle', 'Adolf Hitler', 'Leo Tolstoy', 'Haruki Murakami', 'Vladimir Nabokov')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(2, 'Who shot John Fitzgerald Kennedy', 'Lee Harvey Oswald', 'Dwight Eisenhower', 'General Lee', 'Lyndon B. Johnson')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(1, 'What date was Treaty of Waitangi signed?', '6 February 1840', '25 December 1776', '26 January 1980', '15 September 1801')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(1, 'What date was the end of the Great War (World War One) ?', '11 November 1918', '7 May 1945', '12 December 1917', '2 February 1901')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(1, 'Who was the author of Lord of the Rings series?', 'J. R. R. Tokien', 'J. K. Rowling', 'C. K. Stead', 'Maurice Gee')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(3, 'What family name was the original family of Venice?', 'Medici''s', 'Monguzzi''s', 'Marco Polo''s', 'Da Vinci''s')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(1, 'What language is the most widely used in Brazil?', 'Portuguese', 'Spanish', 'German', 'English')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(1, 'In the children''s book series, where is Paddington Bear originally from?', 'Peru', 'Iceland', 'Canada', 'England')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(1, 'In French, what does R.S.V.P stand for?', 'Respondez Sil-vous-Plait', 'Recruitez Sans voulezvous pardon ', 'Recordez shivile ville parlez', 'Other')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(2, 'Who was the director of the Star Wars trilogy?', 'George Lucas', 'Stephen Spielberg', 'James Cameron', 'Quentin Tarantino')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(3, 'What is Bombus Terrertris?', 'Buff-tailed Bumblebee', 'Land bomb ', 'Large-eyed sloth', 'Ring tailed lemur')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(2, 'What country has the single colour flag of Green?', 'Libya', 'Angola', 'Australia', 'Guam')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(2, 'How many colours in the rainbow?', '7', '6', '5', '8')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(3, 'What country has the largest population of people?', 'China', 'India', 'Indonesia', 'Russia')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(3, 'Who was the first European to discover New Zealand', 'Abel Janzoon Tasman', 'Captain James Cook', 'Samuel Marsden', 'Thomas Busby')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(3, 'What was the movie that won the 89th Academy Award in 2017?', 'Moonlight', 'La La Land', 'Lion', 'Hacksaw Ridge')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(3, 'What date were the Royal Romanov family of Russia executed? ', 'July 17 1918', 'February 23 1901', 'December 25 1913', 'May 29 1914')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(1, 'What do Germans typically have every Sunday?', 'Kaffee und Kuchcen', 'Fruhstck', 'Abendbrot', 'Mittagessen')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(2, 'Which House name did Queen Victoria belong to before she was married?', 'House of Hanover', 'House of Gothe-Saxe Coburg', 'House of Habsburg', 'House of Windsor')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(1, 'On a pirate ship, who is in charge of distributing the treasure?', 'Quarter master', 'Captain ', 'First Mate', 'Lieutenant')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(2, 'Name the Scottish invention?', 'Rubber tires', 'Haggis', 'Kilts', 'Television')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(3, 'What was the top export for Uganda in 2014?', 'Coffee', 'Raw Tobacco', 'Tea', 'Fish Fillets')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(1, 'What is the biggest?', 'The Moon', 'An Elephant', 'A Kettle', 'A Peanut')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(2, 'What statue was the present from the French Government to the United States of America?', 'Statue of Liberty', 'Liberty Bell', 'Joan of Arc', 'Statue of David')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(1, 'The gold medallists from the 1936 Olympic Games were given what in addition to their medal?', 'An oak tree', 'A signed autograph from the leader of the Nazi Party', 'A teddy bear', 'A pair of lederhosen')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(3, 'What new water sport has been added to Olympic games for 2020 in Tokyo?', 'Surfing', 'Kite surfing', 'Sailing', 'Free diving')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(2, 'What is the longest Squid?', 'Giant Squid', 'Colossal Squid', 'Jumbo Squid', 'Dana octopus Squid')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(1, 'What is the main element in water?', 'Hydrogen', 'Oxygen', 'Argon', 'Plutonium')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(1, 'Which of these is not known as a green house gas?', 'Hydrogen', 'Methane', 'Nitrous Oxide', 'Carbon dioxide')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(2, 'Who is the father of Geometry?', 'Euclid', 'Aristotle', 'Pythagoras', 'Kepler')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(2, 'What colour is Spock''s blood?', 'Green', 'Blue', 'Red', 'Black')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(2, 'Who betrayed Jesus to the Romans?', 'Judas', 'John', 'Simon', 'Matthias')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(3, 'Which of these isn''t a wireless protocol?', '802.11h', '802.11n', '802.11g', '802.11a')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(3, 'Of these philosophers, who is NOT associated with Existentialism?', 'David Hume', 'Gabriel Marcel', 'Søren Kierkegaard', 'Jean-Paul Sartre')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(3, 'Which 3rd century mystic and follower of Platonism is regarded as the last great Ancient Greek philosopher?', 'Plotinus', 'Aristotle', 'Sophocles', 'Heraclitus')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(3, 'Apple spent $15 million on what single item in 1986', 'A supercomputer', 'An office', 'A robot', 'A SERVER')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(3, 'Apple sold it''s first computer kit at what price?', '$666', '$777', '$888', '$999')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(3, 'Who was the Titan of Justice in Greek mythology?', 'Themis', 'Urania', 'Athena', 'Hera')");
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES(3, 'What is the name of Queen Elizabeth''s husband?', 'Prince Philip', 'Prince Charles', 'Prince Henry', 'Prince William')");
            
            statement.close();

            System.out.println("Table Created ");

        } catch (SQLException e) {
            System.err.println("SQL Exception: " + e.getMessage());
        }
    }
   public void queryDataBase() {
        try
        {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * " + "FROM " + tableName);
            while (rs.next()) {
                Attributes attribute = new Attributes();
                attribute.setDifficulty(rs.getString("Difficulty"));
                attribute.setQuestion(rs.getString("QUESTION"));
                attribute.setAnswer(rs.getString("ANSWER"));
                attribute.setIncorrect1(rs.getString("INCORRECT1"));
                attribute.setIncorrect2(rs.getString("INCORRECT2"));
                attribute.setIncorrect3(rs.getString("INCORRECT3"));

                Quiz_Questions.add(attribute);

            }
            statement.close();
        }

        catch(SQLException e){
            System.err.println("SQL Exception: " + e.getMessage());
        }
    }
    
   private void checkTableExisting(String newTableName) {
        try {
            System.out.println("check existing tables.... ");
            String[] types = {"TABLE"};
            DatabaseMetaData dbmd = connection.getMetaData();
            ResultSet rsDBMeta = dbmd.getTables(null, null, null, null);//types);
            Statement dropStatement = null;

            while (rsDBMeta.next()) {
                String tableName = rsDBMeta.getString("TABLE_NAME");
                System.out.println("found: " + tableName);
                if (tableName.compareToIgnoreCase(newTableName) == 0) {
                    System.out.println(tableName + "  needs to be deleted");
                    String sqlDropTable = "DROP TABLE " + newTableName;
                    dropStatement = connection.createStatement();
                    dropStatement.executeUpdate(sqlDropTable);
                }
            }
            if (rsDBMeta != null) {
                rsDBMeta.close();
            }
            if (dropStatement != null) {
                dropStatement.close();
            }

        } catch (SQLException ex) {
            System.err.println("SQL Exception: " + ex.getMessage());
        }
   }
   
    public ArrayList<Attributes> getQuiz_Questions(){
        
        return this.Quiz_Questions;
    }
    
}
