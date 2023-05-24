import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WinningScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WinningScreen extends World
{

    /**
     * Constructor for objects of class WinningScreen.
     * 
     */
    GreenfootSound bgm = new GreenfootSound("4. Space Riddle.mp3");
    public WinningScreen(final Counter score)
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
    
    private void prepare()
    {
        winImg winImg = new winImg();
        addObject(winImg,289,189);
    }
}
