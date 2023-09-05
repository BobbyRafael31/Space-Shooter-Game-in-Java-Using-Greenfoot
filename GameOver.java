import greenfoot.*;

/**
 * Class GameOver is to show Game Over menu.
 * 
 * @BobbyRafaelSembiring
 * 
 */
public class GameOver extends World
{
    GreenfootSound bgm = new GreenfootSound("3. Goodbye Sweet Alien.wav");
    public GameOver(final Counter score)
    {    
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
        loseImg loseImg = new loseImg();
        addObject(loseImg,289,189);
    }
}
