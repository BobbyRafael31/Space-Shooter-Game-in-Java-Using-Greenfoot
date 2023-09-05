import greenfoot.*; 


/**
 * Class ScreenMenu is to handle Start Menu in the beggining.
 * 
 * @BobbyRafaelSembiring 
 * 
 */

public class ScreenMenu extends World {
    private static final String bgImageName = "space1.jpg";
    private static final int picHeight = (new GreenfootImage(bgImageName)).getHeight();
  
    private GreenfootImage bgImage, bgBase;
    private int scrollPosition = 0;
    GreenfootSound bgm = new GreenfootSound("1. Into The Spaceship.wav");
    
    public ScreenMenu()
    {    
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
