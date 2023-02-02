/**
 * Human Paddle 
 * @author David Rohweder
 * This class will be for the human controlled paddle 
 * Our instance variables are COORD_X
 * Our constructor is HumanPaddle(Board layout)
 * Our instance methods are an overrided move
 */
public class HumanPaddle extends Paddle 
{

    // instance variables

    private final int COORD_X = 30; // const width paddle will be off edge of board

    /** 
        constructor
        @param Board
        @return none
    */
    public HumanPaddle(Board layout)
    {
        setLayout(layout);
        setCoordX(COORD_X);
        setCoordY(layout.returnHeight() / 2);
    }

    /** 
        Override the superclass move function : moves the paddle in either the up or down direction based on if the up or down boolean value was set from the keyPressed function. Velocity is capped at 5 and board collision is called so paddle stays in board
        @param none
        @return none
    */
    public void move()
    {

        if (returnAccUp())
        {
            setVelY(returnVelY() - 2);
        }
        else if (returnAccDown())
        {
            setVelY(returnVelY() + 2);
        }
        else if (!returnAccUp() && !returnAccDown())
        {
            setVelY(returnVelY() * .94);
        }

        if (returnVelY() > 5)
        {
            setVelY(5);
        }
        else if (returnVelY() < -5)
        {
            setVelY(-5);
        }

        setCoordY((int)(returnCoordY() + returnVelY()));
        boardCollision();
    }

} // End of HumanPaddle class