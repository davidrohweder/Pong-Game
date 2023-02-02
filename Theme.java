import java.awt.Color;

/**
 * Theme
 * @author David Rohweder
 * This class will be used to store all types of color for the game
 * Our instance variables are background, paddleColor, and ballColor
 * Our constructor is Theme(Color background, Color, paddleColor, Color ballColor)
 * Our instance methods are returnBackground, returnPaddleColor, returnBallColor
 */
public class Theme
{

    // instance variables
    
    private Color background; // background color of the board
    private Color paddleColor; // color of both paddles
    private Color ballColor;  // color of the ball

    /** 
        constructor
        @param Color background, Color paddleColor, Color ballColor
        @return none   
    */
    public Theme(Color background, Color paddleColor, Color ballColor)
    {
        this.background = background;
        this.paddleColor = paddleColor;
        this.ballColor = ballColor;
    }

    // Accessors 

    /** 
        Returns the color of the background
        @param none
        @return background
    */
    public Color returnBackground()
    {
        return this.background;
    }

    /** 
        Returns the color of the paddle
        @param none
        @return paddleColor
    */
    public Color returnPaddleColor()
    {
        return this.paddleColor;
    }

    /** 
        Returns the color of the ball
        @param none
        @return ballColor
    */
    public Color returnBallColor()
    {
        return this.ballColor;
    }

} // End of Theme class