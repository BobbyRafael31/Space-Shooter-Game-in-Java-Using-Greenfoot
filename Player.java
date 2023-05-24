import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static int cooldownMax = 12;
    private static int cooldownMax2 = 5;
    private static int cooldownMax3 = 8;
    private static int cooldownMax4 = 7;
    
    private int fireCooldown = 0;
    
    private int powerUpCooldown = 0;
    private int powerUpCooldown2= 0;
    private int powerUpCooldown3= 0;
    private int powerUpCooldown4= 0;
    public Player()
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth()+5, image.getHeight()+5);
        setImage(image);
        setRotation(0);
        
    }
    public void act()
    {
        // Add your action code here.
        moveAround();
        fireProjectile();
        hitByEnemyProjectile();
        hitEnemy();
        hitHealthUp();
        
       
    }
    
    public void moveAround(){
        if(Greenfoot.isKeyDown("right"))
        {
            setLocation(getX()+5,getY());
        }
        if(Greenfoot.isKeyDown("left"))
        {
            setLocation(getX()-5,getY());
        }
         if(Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(),getY()-5);
        }
         if(Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(),getY()+5);
        }    
    }
    
    public void fireProjectile(){
        if(fireCooldown > 0)
        {
            fireCooldown--;
        }
        else if(Greenfoot.isKeyDown("space"))
        {
            Actor Projectile2 = getOneIntersectingObject(Projectile2.class);
            Actor Projectile3 = getOneIntersectingObject(Projectile3.class);
            Actor Projectile4 = getOneIntersectingObject(Projectile4.class);
            if(Projectile2!=null){
                powerUpCooldown = 0;
                powerUpCooldown3 = 0;
                powerUpCooldown4 = 0;
                powerUpCooldown2 = 100;
                getWorld().removeObject(Projectile2);
            }else if(Projectile3!=null){
                powerUpCooldown = 0;
                powerUpCooldown2 = 0;
                powerUpCooldown4 = 0;
                powerUpCooldown3 =100;
                getWorld().removeObject(Projectile3);
            }else if(Projectile4!=null){
                powerUpCooldown = 0;
                powerUpCooldown2 = 0;
                powerUpCooldown3 = 0;
                powerUpCooldown4 = 100;
                getWorld().removeObject(Projectile4);
            }
            if(powerUpCooldown2 > 0)
            {
                 getWorld().addObject(new playerProjectile2(),getX(),getY()-10);
                 setSfx();
                 fireCooldown = cooldownMax2; 
                 powerUpCooldown2--;
            }else if(powerUpCooldown3 > 0)
            {
                getWorld().addObject(new playerProjectile3(),getX(),getY()-10);
                setSfx2();
                fireCooldown = cooldownMax3; 
                powerUpCooldown3--;
            }else if(powerUpCooldown4 > 0)
            {
                getWorld().addObject(new playerProjectile4(),getX(),getY()-10);
                setSfx3();
                fireCooldown = cooldownMax4; 
                powerUpCooldown4--;
            }
           else
           {
                getWorld().addObject(new playerProjectile(),getX(),getY()-10);
                setSfx();
                fireCooldown = cooldownMax; 
           }
        }
        
    }
    
    private void setSfx()
    {
        GreenfootSound fireSfx1 = new GreenfootSound ( "fire2.wav" );
        fireSfx1.setVolume (100);
        fireSfx1.play();
    }
    
     private void setSfx2(){
        GreenfootSound fireSfx3 = new GreenfootSound ( "fire3.wav" );
        fireSfx3.setVolume (85);
        fireSfx3.play();
    }
    
    private void setSfx3(){
        GreenfootSound fireSfx4 = new GreenfootSound ( "fire4.wav" );
        fireSfx4.setVolume (65);
        fireSfx4.play();
    }
    
    public void hitByEnemyProjectile()
    {
        Actor enemyProjectile = getOneIntersectingObject(enemyProjectile.class);
        Actor enemyProjectile2 = getOneIntersectingObject(enemyProjectile2.class);
        Actor enemyProjectile3 = getOneIntersectingObject(enemyProjectile3.class);
        Actor bossProjectile = getOneIntersectingObject(bossProjectile.class);
        if(enemyProjectile != null)
        {
            getWorld().removeObject(enemyProjectile);
            playerloseHealth();
        }else if(enemyProjectile2 != null){
            getWorld().removeObject(enemyProjectile2);
            playerloseHealth();
        }else if(enemyProjectile3 != null){
            getWorld().removeObject(enemyProjectile3);
            playerloseHealth();
        }else if(bossProjectile != null){
            getWorld().removeObject(bossProjectile);
            playerloseHealthFromBoss();
        }
    }
    
    
    public void hitEnemy(){
        Actor Enemy1 = getOneIntersectingObject(Enemy1.class);
        Actor Enemy2 = getOneIntersectingObject(Enemy2.class);
        Actor Enemy3 = getOneIntersectingObject(Enemy3.class);
        if(Enemy1 != null){
             getWorld().removeObject(Enemy1);
             playerloseHealth();
        }else if(Enemy2 != null){
            getWorld().removeObject(Enemy2);
            playerloseHealth();
        }else if(Enemy3 != null){
            getWorld().removeObject(Enemy3);
            playerloseHealth();
        }
    }
   
    private void playerloseHealth()
    {
        World world  = getWorld();
        MyWorld myWorld = (MyWorld)world;
        HealthBar healthbar = myWorld.getHealthBar();
        healthbar.loseHealth();
    }
    
    private void playerloseHealthFromBoss(){
        World world = getWorld();
        MyWorld myWorld = (MyWorld)world;
        HealthBar healthbar = myWorld.getHealthBar();
        healthbar.loseHealthFromBoss();

    }
    
    public void hitHealthUp()
    {
        Actor HealthUp = getOneIntersectingObject(HealthUp.class);
        if(HealthUp != null)
        {
            World world  = getWorld();
            MyWorld myWorld = (MyWorld)world;
            HealthBar healthbar = myWorld.getHealthBar();
            healthbar.addHealth();
            getWorld().removeObject(HealthUp);
            
        }
    }

}
