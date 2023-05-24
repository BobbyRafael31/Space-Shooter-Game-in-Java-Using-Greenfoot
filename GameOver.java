import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{

    /**
     * Constructor for objects of class GameOver.
     * 
     */
    GreenfootSound bgm = new GreenfootSound("3. Goodbye Sweet Alien.wav");
    public GameOver(final Counter score)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
        addObject(score, 284, 360);
    }
    
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            bgm.stop();
        }
        else if(!bgm.isPlaying())
        {
            bgm.setVolume(31);
            bgm.playLoop();
        }
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        loseImg loseImg = new loseImg();
        addObject(loseImg,289,189);
    }
}
