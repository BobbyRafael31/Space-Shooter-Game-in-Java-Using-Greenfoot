import greenfoot.*;

/**
 * Class Enemies is to handle Enemies child class.
 * 
 * @BobbyRafaelSembiring
 * 
 */
public class Enemies extends Actor
{
    private int enemyHealth;
 
    public Enemies(int health)
    {
        enemyHealth = health;
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
            if(projectile != null) {
                if(projectile instanceof playerProjectile){
                    getWorld().removeObject(projectile);
                    enemyHealth--;
                }else if(projectile instanceof playerProjectile2){
                    getWorld().removeObject(projectile);
                    enemyHealth = enemyHealth-2;
                }else if(projectile instanceof playerProjectile3){
                    getWorld().removeObject(projectile);
                    enemyHealth = enemyHealth-3;
                }else if(projectile instanceof playerProjectile4){
                    getWorld().removeObject(projectile);
                    enemyHealth = enemyHealth-4;
                }
            }
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

}
