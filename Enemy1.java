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
    private int enemyHealth = 2;
    public Enemy1()
    {
        super(2); //Pass health
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
