import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Class HealthBar is to handle player health and showing health in the screen.
 * 
 * @BobbyRafaelSembiring 
 * 
 */
public class HealthBar extends Event
{
    int health = 20;
    int healthbarWidth = 80;
    int healthbarHeight = 10;
    int remainingHealth;
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
        if(health <20) {
            remainingHealth = 20 - health;
            if(remainingHealth >= 5){ 
                health +=5;
            } else {
                health += remainingHealth;
            }
        }
        
        Update();
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
        World world = getWorld();
        MyWorld myWorld = (MyWorld) world;
        myWorld.bgm.stop(); 
    }
    

}
