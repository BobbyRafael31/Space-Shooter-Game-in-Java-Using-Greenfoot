import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bosses here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bosses extends Actor
{
    private int bossHealth;
    
    public Bosses(int health)
    {
        bossHealth = health;
    }
    
    public void hitByProjectile()
    {
        Actor playerProjectile = getOneIntersectingObject(playerProjectile.class);
        Actor playerProjectile2 = getOneIntersectingObject(playerProjectile2.class);
        Actor playerProjectile3 = getOneIntersectingObject (playerProjectile3.class);
        Actor playerProjectile4 = getOneIntersectingObject (playerProjectile4.class);
        if(playerProjectile != null)
        {
            getWorld().removeObject(playerProjectile);
            bossHealth--;
        }else if(playerProjectile2 != null)
        {
            getWorld().removeObject(playerProjectile2);
            bossHealth = bossHealth-2;
        }else if(playerProjectile3 != null)
        {
            getWorld().removeObject(playerProjectile3);
            bossHealth = bossHealth-3;
        }else if(playerProjectile4 != null)
        {
            getWorld().removeObject(playerProjectile4);
            bossHealth = bossHealth-4;
        }
        if(bossHealth <= 0)
        {
            getScoreCounter();
            stopbgm();
            
            World world = getWorld();
            MyWorld myWorld = (MyWorld)world;
            Counter counter =myWorld.getCounter();
            
            Greenfoot.setWorld(new WinningScreen(counter));
            
            Greenfoot.stop(); 
            Greenfoot.start();
    
        }
    }
    
     public void getScoreCounter()
    {
        World world = getWorld();
        MyWorld myWorld = (MyWorld)world;
        Counter counter =myWorld.getCounter();
        counter.addScore();
    }
    
    private void stopbgm()
    {
        World world = getWorld();
        MyWorld myWorld = (MyWorld) world;
        myWorld.bgm.stop(); 
    }
}
