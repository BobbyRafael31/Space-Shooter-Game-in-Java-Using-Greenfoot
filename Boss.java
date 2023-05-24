import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss extends Enemies
{
    /**
     * Act - do whatever the Boss wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int bossHealth = 600;
    private int direction = 1;
    
    public Boss(){
        GreenfootImage image = getImage();
        image.scale(image.getWidth()+1, image.getHeight()+1);
        setImage(image);
        setRotation(0);
    }
    public void act()
    {
        // Add your action code here.
        bossDirection();
        hitByProjectile();
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
            bossHealth--;
        }else if(playerProjectile2 != null)
        {
            getWorld().removeObject(playerProjectile2);
            bossHealth = bossHealth-2;
        }else if(playerProjectile3 != null)
        {
            getWorld().removeObject(playerProjectile3);
            bossHealth = bossHealth-3;
        }else if(playerProjectile4 != null)
        {
            getWorld().removeObject(playerProjectile4);
            bossHealth = bossHealth-4;
        }
        if(bossHealth <= 0)
        {
            getScoreCounter();
            stopbgm();
            
            World world = getWorld();
            MyWorld myWorld = (MyWorld)world;
            Counter counter =myWorld.getCounter();
            
            Greenfoot.setWorld(new WinningScreen(counter));
            
            Greenfoot.stop(); 
            Greenfoot.start();
    
        }
    }
    
    public void bossDirection(){
        if(getY()>=0 && getY() <79)
        {
            move();
            if(getY()==79){
                stop();
            }
        }
        if ((direction < 0 && getX() < 20) || (direction > 0 && getX() > getWorld().getWidth()-20))
        {
            direction = -direction; // change direction
        }
        setLocation(getX()+1*direction, getY());
        
        if(getX()==184 || getX()==232 ||getX() ==362 ||getX()==462)
        {
            bossFire();
            setBossSfx();
        }
    }
    
    public void getScoreCounter()
    {
        World world = getWorld();
        MyWorld myWorld = (MyWorld)world;
        Counter counter =myWorld.getCounter();
        counter.addScore();
    }
    
    public void bossFire()
    {
        getWorld().addObject(new bossProjectile(),getX(),getY()+5);
    }
    
    public void stop(){
        setLocation(getX(),getY());
    }
    
    public void move()
    {
        setLocation(getX(),getY()+1);
    }
    
    private void setBossSfx(){
        GreenfootSound fireBossSfx = new GreenfootSound ( "bossFire.wav" );
        fireBossSfx.setVolume(72);
        fireBossSfx.play();
    }
    
    private void stopbgm()
    {
        World world = getWorld(); // as a World object, members of MyWorld are inaccessible
        MyWorld myWorld = (MyWorld) world; // the world cast as a MyWorld object
        myWorld.bgm.stop(); 
    }
}
