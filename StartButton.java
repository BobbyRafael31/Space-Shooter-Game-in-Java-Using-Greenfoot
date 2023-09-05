import greenfoot.*;

/**
 * Class StartButton is to run Start Button function.
 * 
 * @BobbyRafaelSembiring  
 * 
 */
public class StartButton extends Button
{
    public StartButton()
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth(), image.getHeight());
        setImage(image);
        setRotation(0);
    }
    
    public void act()
    {
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
