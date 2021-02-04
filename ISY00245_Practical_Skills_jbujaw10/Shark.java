import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Shark - Predators of Nemo.
 * 
 * Functions of class Shark:
 * - Configure sharks movement
 * - Speeding up shark movement according to planktonsEaten
 * - Set game over if shark eats Nemo
 * 
 * References:
 * - Reference for calling and using static variables - https://www.greenfoot.org/topics/4327
 * - Reference for changing worlds - https://www.youtube.com/watch?v=dyJfY3oai-c   
 * 
 * Please see README.TXT file in this same directory for enhancements and more details.
 * 
 * @author Jaydel Bujawe 
 * @version 1.0
 */
public class Shark extends Actor
{   
    // create variable of type string to track shark direction of movement
    private String sharkDirection = "right";

    // create GreenfootImage variable type to store images for Shark
    private GreenfootImage shark;
    private GreenfootImage sharkReverse; 

    /**
     * Constructor for objects of class Shark.
     */
    public Shark()
    {
        // set value of images for appropriate shark movement
        shark = new GreenfootImage("shark.png");
        sharkReverse = new GreenfootImage("sharkReverse.png");                
    }

    /**
     * Act - do whatever the Shark wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // method call for basic shark movement        
        sharkMove();   
        
        // method call to speed up shark movement (passing planktonsEaten (int) argument)  
        fastSharkMove(Nemo.planktonsEaten);

        // method call to check if game is over when Shark eats Nemo
        gameOver();
    }

    public void sharkMove() 
    {
        // configure direction of shark movement when at edge of world
        if (isAtEdge())
        {
            // set shark direction to create a guide
            if(sharkDirection == "right")
            {
                sharkDirection = "left";                
            }
            else
            {
                sharkDirection = "right";
            }
        }

        // according to guide - move shark appropriately
        if(sharkDirection == "left")
        {
            move(-2);    
            setImage(shark);
        }
        else
        {
            move(2);
            setImage(sharkReverse);
        } 
    }  

    // accepts parameter of type integer and has been passed argument of Nemo.planktonsEaten
    public void fastSharkMove(int planktonsEaten)    
    {
        if (planktonsEaten == 8 || planktonsEaten == 9)
        {   
            if(sharkDirection == "left")
            {
                move(-3);  
            }
            else
            {
                move(3);               
            }  
        }          
    } 

    public void gameOver() 
    {
        // check if Shark is touching Nemo
        if (isTouching(Nemo.class)) 
        { 
            // store value of current gameTimer in finalTime for time score
            SeaWorld.finalTime = SeaWorld.gameTimer;  
            
            // set world to Lose to display game over screen           
            Greenfoot.setWorld(new Lose(SeaWorld.finalTime, Nemo.planktonsEaten));
        }    
    }  
}
