import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.Timer;

/**
 * Pong
 * @author David Rohweder
 * This information will control all game logic for drawing components, accepting input, moving components, and checking game rules
 * Our instance variables are timer, computer, player, ball, layout, and inSession
 * Our constructor is Pong(Board layout)
 * Our instance methods are an overrided paintComponent, keyPressed, keyReleased, and actionPerformed
 */
public class Pong extends JPanel implements KeyListener, ActionListener 
{

    // instance variables

    private Timer timer; // timer that plays our game
    private ComputerPaddle computer; // computer object player
    private HumanPaddle player; // human player object
    private Ball ball; // game ball
    private Board layout; // layout of the board for calculations
    private boolean inSession; // sees if user started or not

    /** 
        Draws the paddle using the x,y values and the const paddle height, width
        @param Graphics
        @return none
    */
    public Pong(Board layout)
    {
        this.layout = layout;
        this.player = new HumanPaddle(layout);
        this.ball = new Ball(layout);
        this.computer = new ComputerPaddle(layout, ball);
        addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
        timer = new Timer(5,this);
        timer.start();
    }

    /** 
        Overrided method sets background, checks ball boundaries on x coordinates, draws game comonents, and checks if game started
        @param Graphics
        @return none
    */
    public void paintComponent(Graphics g)
    {
        // background
        g.setColor(this.layout.returnTheme().returnBackground());
		g.fillRect(0, 0, this.layout.returnWidth(), this.layout.returnHeight());

        if (this.ball.returnCoordX() < -this.ball.returnBallWidth())
        {
            g.setColor(Color.RED);
            g.drawString("Game Over Brother", this.layout.returnWidth() / 2, this.layout.returnHeight() /2);
        }
        else
        {
            this.player.drawPaddle(g);
            this.computer.drawPaddle(g);
            this.ball.drawBall(g);
        }

        if (!(this.inSession))
        {
            g.setColor(Color.YELLOW);
            g.drawString("Press Enter to Begin Playa (Left Side)", this.layout.returnWidth() / 2 - 100, this.layout.returnHeight() / 2 - 100);
        }
    }

    /** 
        Checks to see if user wants the paddle to move up or down or if they want to start the game
        @param KeyEvent
        @return none
    */
    public void keyPressed(KeyEvent e) 
	{
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{        
            this.player.setAccUp(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{        
            this.player.setAccDown(true);
        }
    }

    /** 
        Stops the user from moving up or down
        @param KeyEvent
        @return none
    */
    public void keyReleased(KeyEvent e) 
	{
		if (e.getKeyCode() == KeyEvent.VK_UP)
		{        
            this.player.setAccUp(false);
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{        
            this.player.setAccDown(false);
        }
		if (e.getKeyCode() == KeyEvent.VK_ENTER)
		{        
            this.inSession = true;
        }
    }

    // needed to overload -- NOT USED
    public void keyTyped(KeyEvent e){}

    /** 
        Moves the games components and checks for collision from ball to paddle, and overrides the repaint method to redraw the graphics 
        @param ActionEvent
        @return none
    */
    public void actionPerformed(ActionEvent e) 
	{
        if (this.inSession)
        {
            this.player.move();
            this.computer.move();
            this.ball.move();
            this.ball.paddleCollision(this.player, this.computer);
        }		
        repaint();
    }

} // End of Pong class 