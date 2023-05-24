import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class playerProjectile3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class playerProjectile3 extends PlayerProjectileList
{
    /**
     * Act - do whatever the playerProjectile3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        projectileMove();
        removePlayerProjectile3();
    }
    
    public void projectileMove(){
        setLocation(getX(),getY() -5);
    }
    
    public void removePlayerProjectile3(){
       
        if(getY()==0)
        {
            getWorld().removeObject(this);
            
        }
    }
}
