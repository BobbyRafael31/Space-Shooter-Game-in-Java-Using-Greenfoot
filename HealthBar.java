import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends Event
{
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    int health = 20;
    int healthbarWidth = 80;
    int healthbarHeight = 10;
    int PixelsPerHealthPoints = (int) healthbarWidth/health;
    
    public HealthBar()
    {
        Update();
    }
    
    public void act()
    {
        Update();
        lose();
    }
    
    public void Update()
    {
        setImage(new GreenfootImage(healthbarWidth+2, healthbarHeight+2));
        GreenfootImage healthImage = getImage();
        healthImage.setColor(Color.WHITE);
        healthImage.drawRect(0,0, healthbarWidth +1, healthbarHeight +1);
        healthImage.setColor(Color.RED);
        healthImage.fillRect(1,1, health*PixelsPerHealthPoints, healthbarHeight);
    }
    
    public void loseHealth()
    {
        health--;
    }
    
    public void loseHealthFromBoss(){
        health -= 3;
    }
    
    public void addHealth()
    {
        health += 5;
    }
    
    public void lose()
    {
        if(health <=0)
        {
            this.stopbgm();
            World world = getWorld();
            MyWorld myWorld = (MyWorld)world;
            Counter counter =myWorld.getCounter();
            
            Greenfoot.setWorld(new GameOver(counter));
            
            Greenfoot.stop(); 
            Greenfoot.start();
            
        }
    }
    
    private void stopbgm()
    {
        World world = getWorld(); // as a World object, members of MyWorld are inaccessible
        MyWorld myWorld = (MyWorld) world; // the world cast as a MyWorld object
        myWorld.bgm.stop(); 
    }
    

}
