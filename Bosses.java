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
        Actor[] playerProjectiles ={
            getOneIntersectingObject(playerProjectile.class),
            getOneIntersectingObject(playerProjectile2.class),
            getOneIntersectingObject(playerProjectile3.class),
            getOneIntersectingObject(playerProjectile4.class)
        };
        
        for (Actor projectile : playerProjectiles){
            if(projectile != null){
                if(projectile instanceof playerProjectile){
                    getWorld().removeObject(projectile);
                    bossHealth--;
                }else if(projectile instanceof playerProjectile2){
                    getWorld().removeObject(projectile);
                    bossHealth = bossHealth-2;
                }else if(projectile instanceof playerProjectile3){
                    getWorld().removeObject(projectile);
                    bossHealth = bossHealth-3;
                }else if(projectile instanceof playerProjectile4){
                    getWorld().removeObject(projectile);
                    bossHealth = bossHealth-4;
                }
            }
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
