import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ExitButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExitButton extends Button
{
    /**
     * Act - do whatever the ExitButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public ExitButton()
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth()-10, image.getHeight()-10);
        setImage(image);
        setRotation(0);
    }
    public void act()
    {
        // Add your action code here.
        moveStart();
        checkMouse();
        checkExitButton();
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
