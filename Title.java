import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Title here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Title extends Image
{
    /**
     * Act - do whatever the Title wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Title()
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth()+80, image.getHeight()+80);
        setImage(image);
        setRotation(0);
    }
    
    public void act()
    {
        // Add your action code here.
        moveTitle();
    }
    
    public void moveTitle()
    {
        if(getY()!=130)
        {
            setLocation(getX(),getY()+3);
        }
        else if(getY()==130)
        {
            setLocation(getX(), getY());
        }
        
    }
    
    
}
