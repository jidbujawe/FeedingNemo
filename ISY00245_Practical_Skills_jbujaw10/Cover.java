import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title Page and all attributions listed here.
 * 
 * Trigger: 
 * Start of game 
 * Win class | Method: winRestart();
 * Lose class | Method: loseRestart();
 * 
 * Functions of class Cover:
 * - Display title and other information
 * - Play start background music
 * - Load instructions on how to play
 * 
 * References:
 * - The "this" parameter checks mouse click of the current/given object
 * - Reference for Greenfoot.mouseClicked(this) - https://www.greenfoot.org/topics/3136 
 * - Static variables allows variable to be accessed from different classes -
 *  - by typing fromWorld.variableName and will only contain one value throughout classes
 * - Reference for calling and using static variables - https://www.greenfoot.org/topics/4327
 * - Reference for controlling audio options - https://www.greenfoot.org/topics/2808
 * 
 * Please see README.TXT file in this same directory for enhancements and more details.
 * 
 * List of attributions: 
 * Graphics:
 * Clown Fish (By http://icons8.com)
 * http://www.iconarchive.com/show/windows-8-icons-by-icons8/Animals-Clown-Fish-icon.html   
 * 
 * Shark (By Iconic)
 * https://thenounproject.com/term/shark/703164/
 * 
 * Plankton (By dear_theophilus)
 * http://www.clipartlogo.com/image/zooplankton-silhouette_111818.html
 *
 * Finding Nemo Logo
 * http://logonoid.com/finding-nemo-logo/
 * 
 * Finding Nemo Font (Personal use)
 * http://www.fontspace.com/filmfonts/findet-nemo
 * 
 * Sound Effects: 
 * All sound effects from:
 * https://www.zapsplat.com/
 * 
 * @author Jaydel Bujawe 
 * @version 1.0
 */
public class Cover extends World
{
    // create instance of GreenfootSound
    public static GreenfootSound startSound; 

    /**
     * Constructor for objects of class Cover.
     */
    public Cover()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        // method call to play startSound 
        playStartSound(); 
    }

    /**
     * Act - do whatever the Cover wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */    
    public void act()
    {               
        // method call to proceed loading instructions
        loadInstructions();        
    }

    public void loadInstructions()
    {
        // check if user clicked on screen (this)      
        if (Greenfoot.mouseClicked(this))
        {            
            createHow();
        }
    } 

    public void createHow()
    {
        // create new object (how) of How class
        How how = new How(); 

        // set location of object in world
        addObject(how,300,200); 
    } 

    public void playStartSound()
    {
        // set value of sound variable        
        startSound = new GreenfootSound("start.mp3"); 

        // set sound to loop
        startSound.playLoop();

        // set volume to 50
        startSound.setVolume(50); 
    }
}
