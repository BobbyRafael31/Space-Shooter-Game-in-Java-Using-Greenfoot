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
    private int enemy3Health = 6;
    
    public Enemy3()
    {
        super(6);
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
