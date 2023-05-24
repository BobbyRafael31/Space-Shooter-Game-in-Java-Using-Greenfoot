import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy3 extends Enemies
{
    /**
     * Act - do whatever the Enemy3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int enemy3Health = 6;
    
    public Enemy3()
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth()-2, image.getHeight()-2);
        setImage(image);
        setRotation(0);
    }
    
    public void act()
    {
        // Add your action code here.
        Enemy3Direction();
        hitByProjectile();
    }
    
    public void Enemy3Direction()
    {
         setLocation(getX(),getY()+1);
        if(getY()==70)
        {
            enemy3Fire();
            enemySfx();
        }
        
    }
    
    public void removeEnemy3()
    {
        if(getY()==399){
            getWorld().removeObject(this);
        }
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
            enemy3Health--;
        }else if(playerProjectile2 != null)
        {
            getWorld().removeObject(playerProjectile2);
            enemy3Health = enemy3Health-2;
        }else if(playerProjectile3 != null)
        {
            getWorld().removeObject(playerProjectile3);
            enemy3Health = enemy3Health-3;
        }else if(playerProjectile4 != null)
        {
            getWorld().removeObject(playerProjectile4);
            enemy3Health = enemy3Health-4;
        }
        if(enemy3Health <= 0)
        {
            getScoreCounter();
            getWorld().addObject(new Explosion(), getX(), getY());
            getWorld().removeObject(this);
            return;
        }
        else if(getY()==399){
            World world  = getWorld();
            MyWorld myWorld = (MyWorld)world;
            HealthBar healthbar = myWorld.getHealthBar();
            healthbar.loseHealth();
            
            getWorld().removeObject(this);
        }
    }
    
    public void getScoreCounter()
    {
        World world = getWorld();
        MyWorld myWorld = (MyWorld)world;
        Counter counter =myWorld.getCounter();
        counter.addScore();
    }
    
    public void enemy3Fire()
    {
        getWorld().addObject(new enemyProjectile3(),getX(),getY()+5);
    }
    
    private void enemySfx()
    {
        GreenfootSound enemySfx1 = new GreenfootSound ( "enemyFire3.wav" );
        enemySfx1.setVolume (95);
        enemySfx1.play();        
    }
}
