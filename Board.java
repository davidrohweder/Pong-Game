/**
 * Board
 * @author David Rohweder
 * This class will represnet all information about the layout of our game
 * Our instance variables are width, height, theme
 * Our constructor is Board(int width, int height, Theme theme)
 * Our instance methods are returnWidth, returnHeight, returnTheme
 */
public class Board
{

    // instance variables

    private int width; // width of the board
    private int height; // height of the board
    private Theme theme; // theme object of the board for coloring graphics components

    /** 
        constructor
        @param width, height, Theme
        @return none
    */
    public Board(int width, int height, Theme theme)
    {
        this.width = width;
        this.height = height;
        this.theme = theme;
    }

    // Accessors

    /** 
        Returns the width variable for calculating x positions
        @param none
        @return width
    */
    public int returnWidth()
    {
        return this.width;
    }

    /** 
        Returns the height variable for calculating y positions
        @param none
        @return height
    */
    public int returnHeight()
    {
        return this.height;
    }

    /** 
        Returns the theme variable for coloring the graphics components
        @param none
        @return theme
    */
    public Theme returnTheme()
    {
        return this.theme;
    }

} // End of Board class