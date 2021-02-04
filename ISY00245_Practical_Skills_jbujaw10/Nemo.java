import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Nemo - Player of the game.
 * 
 * Functions of class Nemo:
 * - Set player controls using keys
 * - Configure nemo eating planktons
 * - Add sharks to intensify game
 * - Check if game is won
 * 
 * References:
 * - Static variables allows variable to be accessed from different classes -
 *  - by typing fromWorld.variableName and will only contain one value throughout classes 
 * - Reference for calling and using static variables - https://www.greenfoot.org/topics/4327
 * - Reference for changing worlds - https://www.youtube.com/watch?v=dyJfY3oai-c    
 * 
 * Please see README.TXT file in this same directory for enhancements and more details.
 * 
 * @author Jaydel Bujawe 
 * @version 1.0
 */
public class Nemo extends Actor
{
    // declare planktonsEaten eaten variable and initialise value of 0
    public static int planktonsEaten = 0;    

    // create instance of Shark
    private Shark sharkMate;

    /**
     * Act - do whatever the Nemo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // method call to setting keys control       
        setKeysControl(); 

        // method call to nemo eating planktons procedure         
        eatPlankton();

        // method call to check if game is won by Nemo eating all Planktons
        gameWon(); 
    }

    public void setKeysControl() 
    {     
        // check to see if keys A or left are pressed
        if (Greenfoot.isKeyDown("A") || Greenfoot.isKeyDown("left")) 
        {    
            // move by manipulating x and y coordinates
            setLocation(getX()-5, getY());

            // set image appropriate to movement
            setImage("nemoReverse.png");
        }        

        // check to see if keys D or right are pressed
        if (Greenfoot.isKeyDown("D") || Greenfoot.isKeyDown("right"))
        {         
            setLocation(getX()+5, getY());
            setImage("nemo.png");
        }    

        // check to see if up key is pressed
        if (Greenfoot.isKeyDown("up")) 
        {  
            setLocation(getX(), getY()-3);
            setImage("nemoUp.png");
        }    

        // check to see if down key is pressed
        if (Greenfoot.isKeyDown("down")) 
        {
            setLocation(getX(), getY()+3); 
            setImage("nemoDown.png");
        }
    }      

    public void eatPlankton() 
    {
        if (isTouching(Plankton.class)) 
        {          
            // remove the instance of plankton that nemo is touching
            removeTouching(Plankton.class); 

            // play sound effect 
            Greenfoot.playSound("swallow.mp3");

            // increment planktonsEaten eaten by 1 
            planktonsEaten ++;  

            // method call to check adding of shark
            checkAddShark();           
        }    
    }

    public void checkAddShark()
    {
        // add sharks to make game more interactive and challenging
        if (planktonsEaten == 3 || planktonsEaten == 6 || planktonsEaten == 9)
        {
            addShark();           
        }        

        // turn towards Nemo when planktonsEaten is equal to 9 as the final challenge of game
        if (planktonsEaten == 9)        
        {
            sharkMate.turnTowards(getX(), getY());             
        }
    }

    public void addShark()
    {
        // create new object (sharkMate) of Shark class        
        sharkMate = new Shark(); 

        // set location of object in world
        getWorld().addObject(sharkMate, 0, Greenfoot.getRandomNumber(370)+10);

        // reset location if first random coordinates is already touching Nemo
        if (isTouching(Nemo.class))
        {
            sharkMate.setLocation(0, getY()+Greenfoot.getRandomNumber(30));
        }
    } 

    public void gameWon()
    {
        if (planktonsEaten == 10)
        {
            // store value of current gameTimer in finalTime for time score
            SeaWorld.finalTime = SeaWorld.gameTimer;

            // set world to Win to display winning screen        
            Greenfoot.setWorld(new Win(SeaWorld.finalTime, planktonsEaten));      
        }
    }   
}
