import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class enemyProjectile3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class enemyProjectile3 extends EnemyProjectileList
{
    /**
     * Act - do whatever the enemyProjectile3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        enemyProjectileMove3();
        removeEnemyProjectile3();
    }
    
    public void enemyProjectileMove3()
    {
        setLocation(getX(),getY()+4);
    }
    
    public void removeEnemyProjectile3()
    {
        if(getY()==399)
        {
            getWorld().removeObject(this);
        }
    }
}
