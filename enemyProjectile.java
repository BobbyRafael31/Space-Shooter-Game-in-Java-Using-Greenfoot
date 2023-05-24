import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class enemyProjectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class enemyProjectile extends EnemyProjectileList
{
    /**
     * Act - do whatever the enemyProjectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        enemyProjectileMove();
        removeEnemyProjectile();
    }
    
    public void enemyProjectileMove()
    {
        setLocation(getX(),getY()+4);
    }
    
    public void removeEnemyProjectile()
    {
        if(getY()==399)
        {
            getWorld().removeObject(this);
        }
    }
}
