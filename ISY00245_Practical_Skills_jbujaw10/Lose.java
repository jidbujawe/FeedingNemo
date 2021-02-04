import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Display game over screen.
 * 
 * Trigger: 
 * Shark class | Method: gameOver();
 * 
 * Functions of class Lose:
 * - Display of score and time when game over
 * - Play game over background music
 * - Reset values of planktonsEaten and gameTimer to 0
 * - Set world to Cover to restart game
 * 
 * References:
 * - The "null" parameter checks mouse click of any object without reference or anywhere in the world  
 * - Reference for Greenfoot.mouseClicked(null) - https://www.greenfoot.org/topics/5276/15
 * - Reference for calling and using static variables - https://www.greenfoot.org/topics/4327
 * - Reference for changing worlds - https://www.youtube.com/watch?v=dyJfY3oai-c
 * - Reference for controlling audio options - https://www.greenfoot.org/topics/2808
 * 
 * Please see README.TXT file in this same directory for enhancements and more details.
 * 
 * @author Jaydel Bujawe 
 * @version 1.0
 */
public class Lose extends World
{
    public GreenfootSound loseSound; // create instance of GreenfootSound

    /**
     * Constructor for objects of class Lose.
     * Accepts parameters of score and time integers
     */
    public Lose(int timeScore, int planktonScore)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);

        // method call to play loseSound 
        playLoseSound();

        // display plankton and time (act cycles) scores
        showText("Score: " + planktonScore, 80, 40); 
        showText("Time: " + timeScore, 200, 40);
    }
    
    /**
     * Act - do whatever the Lose wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */    
    public void act()
    {
        // method call to restart game
        loseRestart();      
    }

    public void loseRestart()
    {  
        // check if user clicked on screen (null)
        if (Greenfoot.mouseClicked(null)) 
        {
            // reset values
            Nemo.planktonsEaten = 0; 
            SeaWorld.gameTimer = 0;
            
            // set world to Cover() to restart game
            Greenfoot.setWorld(new Cover());   

            // stop loseSound when changing world 
            loseSound.stop();
        }
    }

    public void playLoseSound()
    {        
        // initialising value of sound variable
        loseSound = new GreenfootSound("fail.mp3");  
        GreenfootSound biteSound = new GreenfootSound("bite.mp3");

        // set volume to 50
        loseSound.setVolume(50); 
        biteSound.setVolume(50);

        // play sounds once
        loseSound.play(); 
        biteSound.play();  

        // stop underwaterSound from playing
        SeaWorld.underwaterSound.stop();
    }
}
