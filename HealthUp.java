import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthUp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthUp extends Event
{
    /**
     * Act - do whatever the HealthUp wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        healthMove();
        removeHealth();
    }
    
    public void healthMove()
    {
        setLocation(getX(),getY()+2);
    }
    
    public void removeHealth()
    {
        if(getY()==399)
        {
            getWorld().removeObject(this);
            
        }
    }
}
