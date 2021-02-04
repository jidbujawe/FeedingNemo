import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Display winning screen.
 * 
 * Trigger: 
 * Nemo class | Method: gameWon();
 * 
 * Functions of class Win:
 * - Display of score and time when game is won
 * - Play winner background music
 * - Reset values of planktonsEaten and gameTimer to 0
 * - Set world to Cover to restart game
 * 
 * References:
 * - The "null" parameter checks mouse click of any object without reference or anywhere in the world
 * - Reference for Greenfoot.mouseClicked(null) - https://www.greenfoot.org/topics/5276/15    
 * - Reference for changing worlds - https://www.youtube.com/watch?v=dyJfY3oai-c 
 * - Reference for calling and using static variables - https://www.greenfoot.org/topics/4327
 * - Reference for controlling audio options - https://www.greenfoot.org/topics/2808
 *
 * Please see README.TXT file in this same directory for enhancements and more details.
 * 
 * @author Jaydel Bujawe 
 * @version 1.0
 */
public class Win extends World
{
    public GreenfootSound winSound; // create instance of GreenfootSound

    /**
     * Constructor for objects of class Win.
     * Accepts parameters of score and time integers
     */
    public Win(int timeScore, int planktonScore)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);

        // method call to play winSound         
        playWinSound();

        // display plankton and time (act cycles) scores        
        showText("Score: " + planktonScore, 80, 40);
        showText("Time: " + timeScore, 200, 40);

        // check if user has beaten previous high (time) score
        if (timeScore < SeaWorld.previousHighestTime)
        {
            // store new high score 
            SeaWorld.previousHighestTime = timeScore;

            // display notification of new highscore
            showText("You have a new high score! ", 450, 40);
        }
    }

    /**
     * Act - do whatever the Win wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // method call to restart game
        winRestart();    
    }

    public void winRestart()
    {            
        // check if user clicked on screen (null)
        if (Greenfoot.mouseClicked(null)) 
        {
            // method call to set appropriate values to important variables
            setValues();

            // set world to Cover() to restart game           
            Greenfoot.setWorld(new Cover());

            // stop winSound when changing world            
            winSound.stop();            
        }
    }

    public void setValues()
    {
        // reset values
        Nemo.planktonsEaten = 0;
        SeaWorld.gameTimer = 0;        

        // add first score to high score variable
        if (SeaWorld.previousHighestTime == 0)
        {
            SeaWorld.previousHighestTime = SeaWorld.finalTime;
        }
    }

    public void playWinSound()
    {
        // initialising value of sound variable
        winSound = new GreenfootSound("winner.mp3"); 

        // set volume
        winSound.setVolume(50);

        // play winSound once
        winSound.play();   

        // stop underwaterSound from playing
        SeaWorld.underwaterSound.stop(); 
    }
}
