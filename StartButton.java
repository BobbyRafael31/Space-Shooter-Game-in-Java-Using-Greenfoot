import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartButton extends Button
{
    /**
     * Act - do whatever the StartButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public StartButton()
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth(), image.getHeight());
        setImage(image);
        setRotation(0);
    }
    
    public void act()
    {
        // Add your action code here.
        moveStart();
        checkMouse();
        checkClick(new MyWorld());
    }
    
    public void moveStart()
    {
        if(getX()!=275)
        {
            setLocation(getX()+5, getY());
        }
        else if(getX()==275)
        {
            setLocation(getX(), getY());
        }
    }
    
}
