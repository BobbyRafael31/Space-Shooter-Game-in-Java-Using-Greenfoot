import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Write a description of class ScreenMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class ScreenMenu extends World{

    /**
     * Constructor for objects of class ScreenMenu.
     * 
     */
    private static final String bgImageName = "space1.jpg";
    private static final int picHeight = (new GreenfootImage(bgImageName)).getHeight();
  
    private GreenfootImage bgImage, bgBase;
    private int scrollPosition = 0;
    GreenfootSound bgm = new GreenfootSound("1. Into The Spaceship.wav");
    
    public ScreenMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }
    
    public void act()
    {
        paint(scrollPosition);
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
    
    private void paint(int position)
    {
        int scrollAmt = 4; 
        GreenfootImage bg = new GreenfootImage(getBackground());
        getBackground().drawImage(bg, 0, scrollAmt); // scroll image down
        getBackground().drawImage(bg, 0, scrollAmt-getHeight());
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Title title = new Title();
        addObject(title,361,186);
        title.setLocation(290,34);
        StartButton startButton = new StartButton();
        addObject(startButton,39,204);
        startButton.setLocation(100,242);
        ExitButton exitButton = new ExitButton();
        addObject(exitButton,293,303);
        exitButton.setLocation(100,312);   
    }
}
