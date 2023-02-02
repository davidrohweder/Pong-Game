import javax.swing.JFrame;
import java.awt.Color;
import java.util.Scanner;
import java.io.File;        
import java.io.IOException; 
import java.util.ArrayList; 

/**
 * Main
 * @author David Rohweder
 * @version BETA
 * @since   2020-11-20
 *
 * 1. GAME Mechanics 
 * https://www.youtube.com/watch?v=xIqeK2hzx1I
 * 2. Swing Timer and AWT components 
 * https://github.com/awaismirza/Java-Game-Brick-Breaker/blob/master/src/Gameplay.java
 *
 * This class will create our board then add our game to our frame
 * Our instance variable is boardInputs
 * Our instance methods are display and readFile
 */
public class Main 
{

    // instance variables

    private static ArrayList<Integer> boardInputs; // for getting custom values in board_inputs.txt

    public static void main(String[] args) throws Exception 
    {
        readFile();
        display();
    }

    /** 
      Displays the game and inits the boad and game
      @param none
      @return none
    */
    public static void display()
    {
		JFrame obj = new JFrame(); // New frame of game
        Board layout = new Board(boardInputs.get(0), boardInputs.get(1), new Theme(Color.BLUE, Color.WHITE, Color.GREEN)); // all board information
		Pong gamePlay = new Pong(layout); // inits game of pong 
		
		obj.setBounds(10, 10, layout.returnWidth(), layout.returnHeight());
		obj.setTitle("Pong, but worse. By David Rohweder");		
		obj.setResizable(false);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.add(gamePlay);
        obj.setVisible(true);
	}

    /** 
        Reads the inputs from the board_inputs.txt file to get priming information
        @param none
        @return none
    */
    public static void readFile()
    {
        boardInputs = new ArrayList<Integer>();

        // read numeric data from external input file
        try
        {
            Scanner scanner = new Scanner(new File("files/board_inputs.txt")); // reads input from text file
      
            while (scanner.hasNext())
            {
            boardInputs.add(scanner.nextInt());
            }
        }
        catch (IOException ioe) 
        {
          System.err.println(ioe);
        }
    }

} // End of Main class