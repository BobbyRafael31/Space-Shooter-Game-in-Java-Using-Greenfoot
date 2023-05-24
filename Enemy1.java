import greenfoot.*; 
// (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy1 extends Enemies
{
    /**
     * Act - do whatever the Enemy1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int enemyHealth = 2;
    public Enemy1()
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth()-2, image.getHeight()-2);
        setImage(image);
        setRotation(0);
    }
    public void act()
    {
        // Add your action code here.
        EnemyDirection();
        hitByProjectile();
    }
    
    public void EnemyDirection()
    {
        setLocation(getX(),getY()+1);
        if(getY()==70)
        {
            enemyFire();
            enemySfx();
        }
    }
    
    public void removeEnemy(){
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
            enemyHealth--;
        }else if(playerProjectile2 != null)
        {
            getWorld().removeObject(playerProjectile2);
            enemyHealth = enemyHealth-2;
        }else if(playerProjectile3 != null)
        {
            getWorld().removeObject(playerProjectile3);
            enemyHealth = enemyHealth-3;
        }else if(playerProjectile4 != null)
        {
            getWorld().removeObject(playerProjectile4);
            enemyHealth = enemyHealth-4;
        }
        if(enemyHealth <= 0)
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
    
    public void enemyFire()
    {
        getWorld().addObject(new enemyProjectile(),getX(),getY()+5);
    }
    
    private void enemySfx()
    {
        GreenfootSound enemySfx1 = new GreenfootSound ( "enemyFire1.wav" );
        enemySfx1.setVolume (75);
        enemySfx1.play();        
    }
    
    
}
