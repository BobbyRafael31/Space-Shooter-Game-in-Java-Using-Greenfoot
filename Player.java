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
    
    private void moveAround(){
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
    
    private void fireProjectile(){
        if(fireCooldown > 0) {
            fireCooldown--;
        }
        else if(Greenfoot.isKeyDown("space")) {
            Actor[] playerProjectiles = {
                getOneIntersectingObject(Projectile2.class),
                getOneIntersectingObject(Projectile3.class),
                getOneIntersectingObject(Projectile4.class)
            };
            
            for (Actor projectile : playerProjectiles) {
                if(projectile != null) {
                    if (projectile instanceof Projectile2) {
                        resetPowerUpCooldown();
                        powerUpCooldown[1] = 100;
                        getWorld().removeObject(projectile);
                    } else if (projectile instanceof Projectile3) {
                        resetPowerUpCooldown();
                        powerUpCooldown[2] =100;
                        getWorld().removeObject(projectile);
                    } else if (projectile instanceof Projectile4) {
                        resetPowerUpCooldown();
                        powerUpCooldown[3] = 100;
                        getWorld().removeObject(projectile);
                    }
                }
            }
            
            if(powerUpCooldown[1] > 0) {
                 getWorld().addObject(new playerProjectile2(),getX(),getY()-10);
                 fireCooldown = cooldownMax[1]; 
                 powerUpCooldown[1]--; //5
                 setSfx("fire2.wav", 100);//fire2.wav
            } else if(powerUpCooldown[2] > 0) {
                getWorld().addObject(new playerProjectile3(),getX(),getY()-10);
                fireCooldown = cooldownMax[2]; //8
                powerUpCooldown[2]--;
                setSfx("fire3.wav", 85);//fire3.wav
            } else if(powerUpCooldown[3] > 0) {
                getWorld().addObject(new playerProjectile4(),getX(),getY()-10);
                fireCooldown = cooldownMax[3]; //7
                powerUpCooldown[3]--;
                setSfx("fire4.wav", 65);//fire4.wav
            } else {
                getWorld().addObject(new playerProjectile(),getX(),getY()-10);
                fireCooldown = cooldownMax[0]; //12
                 setSfx("fire2.wav", 100);//fire2.wav
           }
        }
    }
    
    private void resetPowerUpCooldown() {
        for (int i = 0; i < powerUpCooldown.length; i++) {
            powerUpCooldown[i] = 0;
        }
    }
    
    private void setSfx(String soundFileName, int volume) {
        GreenfootSound soundEffect = new GreenfootSound(soundFileName);
        soundEffect.setVolume(volume);
        soundEffect.play();
    }
    
    private void hitByEnemyProjectile()
    {
        Actor[] enemyProjectiles = {
            getOneIntersectingObject(enemyProjectile.class),
            getOneIntersectingObject(enemyProjectile2.class),
            getOneIntersectingObject(enemyProjectile3.class),
            getOneIntersectingObject(bossProjectile.class)
        };
        
        for (Actor projectile : enemyProjectiles){
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
    
    
    private void hitEnemy(){
        Actor[] enemiesObj = {
            getOneIntersectingObject(Enemy1.class),
            getOneIntersectingObject(Enemy2.class),
            getOneIntersectingObject(Enemy3.class)
        };

        for(Actor enemy : enemiesObj) {
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
    
    private void hitHealthUp() {
        Actor HealthUp = getOneIntersectingObject(HealthUp.class);
        if(HealthUp != null) {
            World world  = getWorld();
            MyWorld myWorld = (MyWorld)world;
            HealthBar healthbar = myWorld.getHealthBar();
            healthbar.addHealth();
            getWorld().removeObject(HealthUp);
        }
    }
}
