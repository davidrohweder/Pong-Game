import java.awt.Graphics;
import java.util.Random;

/**
 * Ball
 * @author David Rohweder
 * This class will control the ball component 
 * Our instance variables are: coordX, coordY, velX, velY, layout, BALL_WIDTH, BALL_HEIGHT
 * Our constructor is Ball(Board layout)
 * Our instance methods are drawBall, move, paddleCollision, returnCoordX, returnCoordY
 */
public class Ball
{

    // instance variables 
    
    private double coordX; // coord on the x axi  s for the ball used in drawBall method
    private double coordY; // coord on the y axis for the ball used in the drawBall method
    private double velX; // the velocity on the x axis for the ball
    private double velY; // the velocity on the y axis for the ball
    private Board layout; // layout object used for calculating board positions
    private final int BALL_WIDTH = 20; // const width of ball
    private final int BALL_HEIGHT = 20; // const height of ball

    /** 
        constructor
        @param Board
        @return none
    */
    public Ball(Board layout)
    {
        this.layout = layout;
        this.coordX = this.layout.returnWidth() / 2;
        this.coordY = this.layout.returnHeight() / 2;
        Random r = new Random(); // used to find random velocitys for x and y coordinates
        this.velX = r.nextInt(2) + 1;
        this.velY = r.nextInt(2) + 1;        
    }

    /** 
        Draws the ball to the current coordinates of x and y
        @param Graphics
        @return none
    */
    public void drawBall(Graphics g)
    {
        g.setColor(layout.returnTheme().returnBallColor());
        g.fillOval((int)coordX - (BALL_WIDTH / 2), (int)coordY - (BALL_HEIGHT / 2), BALL_WIDTH, BALL_HEIGHT);
    }

    /** 
        Move the ball to the rate of the velocity checks for top and bottom collision 
        @param none
        @return none
    */
    public void move()
    {
        this.coordX += velX;
        this.coordY += velY;

        if (this.coordY < 10)
        {
            this.velY = -(this.velY);
        }
        if (this.coordY > this.layout.returnHeight() - BALL_HEIGHT)
        {
            this.velY = -(this.velY);
        }
    }

    /** 
        Checks to see if the y coordinate of the ball falls into the range of either paddles top and bottom y position
        @param HumanPaddle, ComputerPaddle
        @return none
    */
    public void paddleCollision(HumanPaddle player, ComputerPaddle computer)
    {
        int hitWidth = (int)(player.returnCoordX() + player.returnPaddleWidth() + (BALL_WIDTH / 2)); // used to simplify code holds value that would qualify as a hit zone

        if (this.coordX <= hitWidth)
        {
            if (coordY >= player.returnCoordY() && coordY <= (player.returnCoordY() + player.returnPaddleHeight()))
            {
                this.velX = -(this.velX);
            }
        }
        else if (this.coordX >= (layout.returnWidth() - hitWidth)) 
        {
            if (coordY >= computer.returnCoordY() && coordY <= (computer.returnCoordY() + computer.returnPaddleHeight()))
            {
                this.velX = -(this.velX);
            }
        }
    }

    // accessors

    /** 
        Returns the x coordinate of the ball
        @param none
        @return coordX
    */
    public int returnCoordX()
    {
        return (int)this.coordX;
    }

    /** 
        Returns the y coordinate of the ball
        @param none
        @return coordY
    */
    public int returnCoordY()
    {
        return (int)this.coordY;
    }

    /** 
        Return the width of the ball 
        @param none
        @return BALL_WIDTH
    */
    public int returnBallWidth()
    {
        return this.BALL_WIDTH;
    }

} // End of Ball Class