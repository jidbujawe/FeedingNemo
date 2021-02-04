import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Plankton - Food to eat for Nemo.
 * 
 * Functions of class Plankton:
 * - Configure planktons random movement
 * - Configure animation timer to animate plankton
 * 
 * References:
 * - Reference for animation concept - https://www.greenfoot.org/topics/4751
 * 
 * Please see README.TXT file in this same directory for enhancements and more details.
 * 
 * @author Jaydel Bujawe 
 * @version 1.0
 */
public class Plankton extends Actor
{
    // create GreenfootImage variable type to store images for Plankton
    private GreenfootImage planktonImage1; 
    private GreenfootImage planktonImage2; 

    // declare and initialise timer and delays for animation
    private int animateTimer = 0;
    
    // specific values decided after trying random number generation and/or single values
    private int animateDelay = 6; 
    private int animateDelay2 = 9;

    /**
     * Constructor for objects of class Plankton.
     */
    public Plankton()
    {
        // set value of images for plankton animation
        planktonImage1 = new GreenfootImage("plankton.png");
        planktonImage2 = new GreenfootImage("plankton1.png");

        // initialise image for Plankton
        setImage(planktonImage1); 
    }

    /**
     * Act - do whatever the Plankton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */    
    public void act()
    {
        // increment animateTimer each act cycle
        animateTimer++;

        // method call to animate plankton
        animatePlankton();        

        // method call to randomise turn of plankton
        randomTurn();
    }

    public void randomTurn() 
    {
        // condition is true 5% of the time
        if (Greenfoot.getRandomNumber(100) < 5) 
        {
            // turn range from -45 to 45
            turn(Greenfoot.getRandomNumber(90)-45); 
        }    
    }

    public void animatePlankton() 
    {  
        // condition is true 10% of the time
        if (Greenfoot.getRandomNumber(100) < 10)
        {
            // checking if remainder is equal to 0 delays the changing of image since condition is not always true      
            if (animateTimer%animateDelay == 0)  
            {
                setImage(planktonImage2); 
            }             
            // having different value for animateDelay2 further delays switching of image creating a visually smoother animation     
            if (animateTimer%animateDelay2 == 0)
            {
                setImage(planktonImage1); 
            }
        }
    }
}