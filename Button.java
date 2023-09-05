import greenfoot.*;  

/**
 * Class Button is to handle all button child class and show it into the screen.
 * 
 * @BobbyRafaelSembiring  
 * 
 */
public class Button extends Actor
{ 
    private boolean mouseOver = false;
    private static int MAX_TRANS = 255;
    
    public void checkMouse()
    {
        if(Greenfoot.mouseMoved(null))
        {
            mouseOver = Greenfoot.mouseMoved(this);
        }
        if(mouseOver)
        {
            adjTrans(MAX_TRANS/2);
        }else{
            adjTrans(MAX_TRANS);
        }
    }
    
    public void adjTrans(int adjust)
    {
        GreenfootImage image = getImage();
        image.setTransparency(adjust);
        setImage(image);
    }
    
    public void checkClick(World world)
    {
        if(Greenfoot.mouseClicked(this))
        {
            stopbgm();
            Greenfoot.setWorld(world);
        }
    }
    
    public void checkExitButton()
    {
        if(Greenfoot.mousePressed(this))
        {
            System.exit(0);
        }
    }
    
    private void stopbgm()
    {
        World world = getWorld();
        ScreenMenu screenmenu = (ScreenMenu) world;
        screenmenu.bgm.stop(); 
    }
}
