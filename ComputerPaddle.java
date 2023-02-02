/**
 * ComputerPaddle 
 * @author David Rohweder
 * This class will be for the computer controlled paddle 
 * Our instance variables are ball and coordX
 * Our constructor is ComputerPaddle(Board layout, Ball ball)
 * Our instance method is an overrided move
 */
public class ComputerPaddle extends Paddle
{

    // instance variables 

    private Ball ball; // ball object used to know the y coordinate of the ball for tracking
    private double coordX = 30; // width away from the board to begin drawing paddle

    /** 
        constructor
        @param Board, Ball 
        @return none
    */
    public ComputerPaddle(Board layout, Ball ball)
    {
        this.ball = ball;
        this.coordX = layout.returnWidth() - this.coordX - (double)returnPaddleWidth();
        setLayout(layout);
        setCoordX(this.coordX);
        setCoordY(layout.returnHeight() / 2);
    }

    /** 
        Override superclass move method : moves the paddle so that the middle is equal to the y coordinate of the ball
        @param none
        @return none
    */
    public void move()
    {
        setCoordY(this.ball.returnCoordY() - (returnPaddleHeight() / 2));
        boardCollision();
    }
    
} // End of ComputerPaddle class