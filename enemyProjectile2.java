import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class enemyProjectile2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class enemyProjectile2 extends EnemyProjectileList
{
    /**
     * Act - do whatever the enemyProjectile2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        enemyProjectile2Move();
        removeEnemyProjectile2();
    }
    
    public void enemyProjectile2Move()
    {
        setLocation(getX(),getY()+3);
    }
    
    public void removeEnemyProjectile2()
    {
        if(getY()==399)
        {
            getWorld().removeObject(this);
        }
    }
}
