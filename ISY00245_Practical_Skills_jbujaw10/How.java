import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Display instructions how to play the game.
 * 
 * Trigger: 
 * Cover class | Method: loadInstructions();
 * 
 * Functions of class Lose:
 * - Remove instance after creation by checking if mouse has clicked the object
 * - Set world to SeaWorld to play the game
 * - Stops introduction background music
 * 
 * References: 
 * - The "this" parameter checks mouse click of the current/given object  
 * - Reference for Greenfoot.mouseClicked(this) - https://www.greenfoot.org/topics/3136 
 * - Reference for removing objects - https://www.greenfoot.org/topics/4330
 * - Reference for changing worlds - https://www.youtube.com/watch?v=dyJfY3oai-c  
 * - Reference for calling and using static variables - https://www.greenfoot.org/topics/4327
 * 
 * Please see README.TXT file in this same directory for enhancements and more details.
 * 
 * @author Jaydel Bujawe 
 * @version 1.0
 */
public class How extends Actor
{
    /**
     * Act - do whatever the How wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // method call to start game
        startGame();        
    } 

    public void startGame()
    {
        // check if user clicked on object (this)
        if (Greenfoot.mouseClicked(this))       
        {
            // remove instructions (how object) 
            getWorld().removeObject(this);

            // set world to SeaWorld to start game 
            Greenfoot.setWorld(new SeaWorld());    

            // stop startSound from playing              
            Cover.startSound.stop();            
        }
    } 
}
