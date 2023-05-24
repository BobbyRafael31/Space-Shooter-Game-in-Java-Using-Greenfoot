import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class playerProjectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class playerProjectile extends PlayerProjectileList
{
    /**
     * Act - do whatever the playerProjectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        projectileMove();
        removePlayerProjectile();
    }
    
    public void projectileMove(){
        setLocation(getX(),getY() -5);
    }
    
    public void removePlayerProjectile(){
       
        if(getY()==0)
        {
            getWorld().removeObject(this);
            
        }
    }
}
