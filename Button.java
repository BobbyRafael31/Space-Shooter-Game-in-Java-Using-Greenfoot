import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{ 
    private boolean mouseOver = false;
    private static int MAX_TRANS = 255;
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
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
        World world = getWorld(); // as a World object, members of MyWorld are inaccessible
        ScreenMenu screenmenu = (ScreenMenu) world; // the world cast as a MyWorld object
        screenmenu.bgm.stop(); 
    }

}
