import java.awt.Graphics;

/**
 * Paddle
 * @author David Rohweder
 * This class will be for all information about any type of paddle 
 * Our instance variables are coordX, coordY, velY, accUp, accDown, PADDLE_WIDTH, PADDLE_HEIGHT, and layout
 * Our instance methods are drawPaddle, move, boardCollision, returnLayout, returnCoordY, returnCoordX, returnVelY, returnAccUp, returnAccDown, returnPaddleWidth, returnPaddleHeight, setLayout, setVelY, setAccUp, setAccDown, setCoordX, setCoordY
 */
public abstract class Paddle
{

    //instance variables

    private double coordX; // x coordinate of the paddle 
    private double coordY; // y coordinate of the paddle
    private double velY = 0; // y coordinate veloctiy of the paddle
    private boolean accUp = false; // paddle moving up
    private boolean accDown = false; // paddle moving down
    private final int PADDLE_WIDTH = 20; // const paddle width
    private final int PADDLE_HEIGHT = 80; // const paddle height
    private Board layout; // Board object to do collision calculations

    /** 
        Draws the paddle using the x,y values and the const paddle height, width
        @param Graphics
        @return none
    */
    public void drawPaddle(Graphics g)
    {
        g.setColor(this.layout.returnTheme().returnPaddleColor());
		g.fillRect((int)this.coordX, (int)this.coordY, PADDLE_WIDTH, PADDLE_HEIGHT);
    }

    /** 
        Overridable method for supclasses
        @param none
        @return none
    */
    public abstract void move();

    /** 
        Checks if the paddles position of y intersects with either the upper or lower y boundary of the board. If it does it makes the y value equal to the max
        @param none
        @return none
    */
    public void boardCollision()
    {
        if(this.coordY < 0)
        {
            this.coordY = 0;
        }
        if (this.coordY > (this.layout.returnHeight() - this.PADDLE_HEIGHT))
        {
            this.coordY = this.layout.returnHeight() - this.PADDLE_HEIGHT; 
        }
    }

    // Accessors

    /** 
        Returns the Board layout object for supclasses
        @param none
        @return layout
    */
    public Board returnLayout()
    {
        return this.layout;
    }

    /** 
        Returns the y coordinate of the paddle
        @param none
        @return coordY
    */
    public double returnCoordY()
    {
        return this.coordY;
    }

    /** 
        Returns the x coordinate of the paddle
        @param none
        @return coordX
    */
    public double returnCoordX()
    {
        return this.coordX;
    }

    /** 
        Returns the velocity of the paddle in the y direction 
        @param none
        @return velY
    */
    public double returnVelY()
    {
        return this.velY;
    }

    /** 
        Returns if the paddle is acclerating upwards
        @param none
        @return accUp
    */
    public boolean returnAccUp()
    {
        return this.accUp;
    }

    /** 
        Returns if the paddle is acceleration downwards
        @param none
        @return accDown
    */
    public boolean returnAccDown()
    {
        return this.accDown;
    }

    /** 
        Returns the const of the paddles width
        @param none
        @return PADDLE_WIDTH
    */
    public double returnPaddleWidth()
    {
        return this.PADDLE_WIDTH;
    }

    /** 
        Returns the const of the paddles height
        @param none
        @return PADDLE_HEIGHT
    */
    public double returnPaddleHeight()
    {
        return this.PADDLE_HEIGHT;
    }

    // Mutators

    /** 
        Sets the Board object to do calculations from sub classes
        @param layout
        @return none
    */
    public void setLayout(Board layout)
    {
        this.layout = layout;
    }

    /** 
        Sets the velocity in y coordinate of paddle
        @param velY
        @return none
    */
    public void setVelY(double velY)
    {
        this.velY = velY;
    }

    /** 
        Sets the acceleration of up of paddle
        @param accUp
        @return none
    */
    public void setAccUp(boolean accUp)
    {
        this.accUp = accUp;
    }

    /** 
        Sets the acceleration of down of paddle
        @param accDown
        @return none
    */
    public void setAccDown(boolean accDown)
    {
        this.accDown = accDown;
    }

    /** 
        Sets the x coordinate of the paddle
        @param coordX
        @return none
    */
    public void setCoordX(double coordX)
    {
        this.coordX = coordX;
    }

    /** 
        Sets coordinate y of the paddle
        @param coordY
        @return none
    */
    public void setCoordY(double coordY)
    {
        this.coordY = coordY;
    }

} // End of Paddle Class