import greenfoot.*;

/**
 * Class Enemies is to handle Enemies child class.
 * 
 * @BobbyRafaelSembiring
 * 
 */
public class Enemies extends Actor
{
    public void EnemyDirection()
    {
        setLocation(getX(),getY()+1);
        if(getY()==0)
        {
            enemyFire();
        }
    }
    
    public void enemyFire()
    {
        getWorld().addObject(new enemyProjectile(),getX(),getY());
    }
}
