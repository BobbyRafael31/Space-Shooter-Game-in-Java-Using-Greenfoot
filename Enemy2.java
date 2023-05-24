import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy2 extends Enemies
{
    /**
     * Act - do whatever the Enemy2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int enemy2Health = 4;
    public Enemy2()
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth()-2, image.getHeight()-2);
        setImage(image);
        setRotation(0);
    }
    
    public void act()
    {
        // Add your action code here.
        Enemy2Direction();
        hitByProjectile();
    }
    
    public void Enemy2Direction()
    {
         setLocation(getX(),getY()+1);
        if(getY()==70)
        {
            enemy2Fire();
            enemySfx2();
        }
        
    }
    
    public void removeEnemy2(){
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
            enemy2Health--;
        }else if(playerProjectile2 != null)
        {
            getWorld().removeObject(playerProjectile2);
            enemy2Health = enemy2Health-2;
        }else if(playerProjectile3 != null)
        {
            getWorld().removeObject(playerProjectile3);
            enemy2Health = enemy2Health-3;
        }else if(playerProjectile4 != null)
        {
            getWorld().removeObject(playerProjectile4);
            enemy2Health = enemy2Health-4;
        }
        if(enemy2Health <= 0)
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
    
    public void enemy2Fire()
    {
        getWorld().addObject(new enemyProjectile2(),getX(),getY()+5);
    }
    
    private void enemySfx2()
    {
        GreenfootSound enemySfx2 = new GreenfootSound ("enemyFire2.wav");
        enemySfx2.setVolume (90);
        enemySfx2.play();        
    }
}
