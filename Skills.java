import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Skills here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Skills extends Actor
{
    /**
     * Act - do whatever the Skills wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    public void moveObj()
    {
        setLocation(getX(),getY());
    }
    
    public void removeProjectileObj()
    {
        if(getY()==399)
        {
            getWorld().removeObject(this);
        }
    }
}
