import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Skills here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Skills extends Actor
{    
    public void moveObj()
    {
        setLocation(getX(),getY()+2);
    }
    
    public void removeProjectileObj()
    {
        if(getY()==399)
        {
            getWorld().removeObject(this);
        }
    }
}
