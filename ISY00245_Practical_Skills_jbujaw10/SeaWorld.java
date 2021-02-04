import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Main world of the game.
 * 
 * Trigger: 
 * How class | Method: startGame();
 * 
 * Functions of class SeaWorld:
 * - Prepare actors in world
 * - Configure game timer and displaying of score during play
 * - Play background music during play
 * 
 * References:
 * - Static variables allows variable to be accessed from different classes -
 *  - by typing fromWorld.variableName and will only contain one value throughout classes 
 * - Reference for calling and using static variables - https://www.greenfoot.org/topics/4327
 * - Reference for controlling audio options - https://www.greenfoot.org/topics/2808
 * 
 * Please see README.TXT file in this same directory for enhancements and more details.
 *
 * @author Jaydel Bujawe 
 * @version 1.0
 */
public class SeaWorld extends World
{
    // create instance of GreenfootSound
    public static GreenfootSound underwaterSound; 

    // create variable to store game timer
    public static int gameTimer; 

    // create variable to store final time as score
    public static int finalTime;

    // create variable to store previous time to compare final score and determine highest score
    public static int previousHighestTime;

    /**
     * Constructor for objects of class SeaWorld.
     */
    public SeaWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);

        // saving world
        prepare();

        // method call to play underwaterSound        
        playUnderwaterSound();
    }  

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {        
        // Create new objects (instances) of Nemo, Shark, Plankton (classes)        
        Nemo nemo = new Nemo();
        addObject(nemo,117,317);        
        Shark shark = new Shark();
        addObject(shark,556,104);  
        Plankton plankton = new Plankton();
        addObject(plankton,248,217);
        Plankton plankton2 = new Plankton();
        addObject(plankton2,357,258);
        Plankton plankton3 = new Plankton();
        addObject(plankton3,393,114);
        Plankton plankton4 = new Plankton();
        addObject(plankton4,510,136);
        Plankton plankton5 = new Plankton();
        addObject(plankton5,229,310);
        Plankton plankton6 = new Plankton();
        addObject(plankton6,418,351);
        Plankton plankton7 = new Plankton();
        addObject(plankton7,111,181);
        Plankton plankton8 = new Plankton();
        addObject(plankton8,227,74);
        Plankton plankton9 = new Plankton();
        addObject(plankton9,288,393);
        Plankton plankton10 = new Plankton();
        addObject(plankton10,508,52); 

        // Reset location of actors to save in world (randomised) 
        nemo.setLocation(Greenfoot.getRandomNumber(300)+200, Greenfoot.getRandomNumber(200)+100);
        shark.setLocation(0, Greenfoot.getRandomNumber(370)+10);
        plankton.setLocation(Greenfoot.getRandomNumber(600)+1, Greenfoot.getRandomNumber(400)+1);
        plankton2.setLocation(Greenfoot.getRandomNumber(600)+1, Greenfoot.getRandomNumber(400)+1);
        plankton3.setLocation(Greenfoot.getRandomNumber(600)+1, Greenfoot.getRandomNumber(400)+1);
        plankton4.setLocation(Greenfoot.getRandomNumber(600)+1, Greenfoot.getRandomNumber(400)+1);
        plankton5.setLocation(Greenfoot.getRandomNumber(600)+1, Greenfoot.getRandomNumber(400)+1);
        plankton6.setLocation(Greenfoot.getRandomNumber(600)+1, Greenfoot.getRandomNumber(400)+1);
        plankton7.setLocation(Greenfoot.getRandomNumber(600)+1, Greenfoot.getRandomNumber(400)+1);
        plankton8.setLocation(Greenfoot.getRandomNumber(600)+1, Greenfoot.getRandomNumber(400)+1);
        plankton9.setLocation(Greenfoot.getRandomNumber(600)+1, Greenfoot.getRandomNumber(400)+1);
        plankton10.setLocation(Greenfoot.getRandomNumber(600)+1, Greenfoot.getRandomNumber(400)+1);
    }

    /**
     * Act - do whatever the SeaWorld wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // increment gameTimer each act cycle
        gameTimer++;

        // method call to display score        
        displayScore();   
    }

    public void displayScore()
    {              
        // display running score from planktonsEaten at x = 80, y = 40 during play       
        showText("Score: " + Nemo.planktonsEaten, 80, 40);

        // display running time from gameTimer at x = 200, y = 40 during play      
        showText("Time: " + gameTimer, 200, 40);

        // display highest score achieved
        if (previousHighestTime != 0)
        {
            showText("Highest score: " + previousHighestTime, 450, 40);
        }
    }  
    
    public int previousTimeCheck()
    {
        // check value of previousHighestTime during testing
        return previousHighestTime;
    }

    public void playUnderwaterSound()
    {        
        // initialising value of sound variable
        underwaterSound = new GreenfootSound("underwater.mp3"); 

        // play underwaterSound in a loop
        underwaterSound.playLoop(); 

        // set volume to 50        
        underwaterSound.setVolume(50); 
    }
}
