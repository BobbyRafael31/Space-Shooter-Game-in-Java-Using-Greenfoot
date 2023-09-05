import greenfoot.*;

/**
 * Class Player is to handle all player action.
 * 
 * @BobbyRafaelSembiring 
 * 
 */
public class Player extends Actor
{
    private static int[] cooldownMax = {12,5,8,7};
    private static int[] powerUpCooldown= {0,0,0,0};
    private int fireCooldown = 0;
    
    public Player()
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth()+5, image.getHeight()+5);
        setImage(image);
        setRotation(0);
    }
    
    public void act()
    {
        moveAround();
        fireProjectile();
        hitByEnemyProjectile();
        hitEnemy();
        hitHealthUp();
    }
    
    public void moveAround(){
        int deltaX = 0;
        int deltaY = 0;
        
        if(Greenfoot.isKeyDown("right")) {
            deltaX = 5;
        } else if (Greenfoot.isKeyDown("left")) {
            deltaX = -5;
        }
        
        if(Greenfoot.isKeyDown("up")) {
            deltaY = -5;
        } else if (Greenfoot.isKeyDown("down")) {
            deltaY = 5;
        }
        
        setLocation(getX() + deltaX, getY() + deltaY);
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
            
            if(Projectile2!=null) {
                resetPowerUpCooldown();
                powerUpCooldown[1] = 100;
                getWorld().removeObject(Projectile2);
            } else if(Projectile3!=null) {
                resetPowerUpCooldown();
                powerUpCooldown[2] =100;
                getWorld().removeObject(Projectile3);
            } else if(Projectile4!=null) {
                resetPowerUpCooldown();
                powerUpCooldown[3] = 100;
                getWorld().removeObject(Projectile4);
            }
            
            if(powerUpCooldown[1] > 0){
                 getWorld().addObject(new playerProjectile2(),getX(),getY()-10);
                 fireCooldown = cooldownMax[1]; 
                 powerUpCooldown[1]--;
                 setSfx();
            } else if(powerUpCooldown[2] > 0) {
                getWorld().addObject(new playerProjectile3(),getX(),getY()-10);
                fireCooldown = cooldownMax[2]; 
                powerUpCooldown[2]--;
                setSfx2();
            } else if(powerUpCooldown[3] > 0) {
                getWorld().addObject(new playerProjectile4(),getX(),getY()-10);
                fireCooldown = cooldownMax[3]; 
                powerUpCooldown[3]--;
                setSfx3();
            } else {
                getWorld().addObject(new playerProjectile(),getX(),getY()-10);
                fireCooldown = cooldownMax[0];
                setSfx();
           }
        }
    }
    
    private void resetPowerUpCooldown() {
        for (int i = 0; i < powerUpCooldown.length; i++) {
            powerUpCooldown[i] = 0;
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
        Actor[] projectiles = {
            getOneIntersectingObject(enemyProjectile.class),
            getOneIntersectingObject(enemyProjectile2.class),
            getOneIntersectingObject(enemyProjectile3.class),
            getOneIntersectingObject(bossProjectile.class)
        };
        
        for (Actor projectile : projectiles){
            if(projectile != null){
                getWorld().removeObject(projectile);
                if(projectile instanceof bossProjectile){
                    playerloseHealthFromBoss();
                }else{
                    playerloseHealth();
                }
            }
        }
    }
    
    
    public void hitEnemy(){
        Actor[] enemies = {
            getOneIntersectingObject(Enemy1.class),
            getOneIntersectingObject(Enemy2.class),
            getOneIntersectingObject(Enemy3.class)
        };

        for(Actor enemy : enemies){
            if(enemy != null){
                getWorld().removeObject(enemy);
                playerloseHealth();
            }
        }
    }
   
    private void playerloseHealth() {
        World world  = getWorld();
        MyWorld myWorld = (MyWorld)world;
        HealthBar healthbar = myWorld.getHealthBar();
        healthbar.loseHealth();
    }
    
    private void playerloseHealthFromBoss() {
        World world = getWorld();
        MyWorld myWorld = (MyWorld)world;
        HealthBar healthbar = myWorld.getHealthBar();
        healthbar.loseHealthFromBoss();
    }
    
    public void hitHealthUp() {
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
