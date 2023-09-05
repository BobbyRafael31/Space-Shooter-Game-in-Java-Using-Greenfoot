import greenfoot.*;

/**
 * Class ExitButton is to run ExitButton function.
 * 
 * @BobbyRafaelSembiring  
 * 
 */
public class ExitButton extends Button
{
    public ExitButton()
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth()-10, image.getHeight()-10);
        setImage(image);
        setRotation(0);
    }
    
    public void act()
    {
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
