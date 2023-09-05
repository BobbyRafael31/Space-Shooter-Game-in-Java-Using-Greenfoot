import greenfoot.*;

/**
 * Class MyWorld is to handle everything in the main game.
 * 
 * @BobbyRafaelSembiring
 * 
 */
public class MyWorld extends World
{
    private static final String bgImageName = "Space Background.png";
    private static final int picHeight = (new GreenfootImage(bgImageName)).getHeight();
  
    private GreenfootImage bgImage, bgBase;
    private int scrollPosition = 0;
    
    HealthBar healthbar = new HealthBar();
    
    int enemyCount = 0;
    int enemy2Count = 0;
    int enemy3Count = 0;
    int healthCount = 0;
    
    int projectile2Spawn = 0;
    int projectile3Spawn = 0;
    int projectile4Spawn = 0;
    
    Counter counter = new Counter();
    GreenfootSound bgm = new GreenfootSound("2. Satellite Interruption.wav");
    
    boolean bossLevel = false;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        setBackground(bgImageName);
        this.bgImage = new GreenfootImage(getBackground());
        this.bgBase = new GreenfootImage(getHeight(), picHeight);

        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    public Counter getCounter()
    {
        return counter;
    }
    
    public HealthBar getHealthBar()
    {
        return healthbar;
    }
    
    public void act(){   
        paint(scrollPosition);
        
        if(Greenfoot.mouseClicked(this))
        {
            bgm.stop();
        }
        else if(!bgm.isPlaying())
        {
            bgm.setVolume(35);
            bgm.playLoop();
        }
        
        spawnEnemy1();
        spawnEnemy2();
        spawnEnemy3();
        spawnBoss();
        
        spawnHealth();
        spawnProjectile2();
        spawnProjectile3();
        spawnProjectile4();
            
    }
    
    private void paint(int position)
    {
        int scrollAmt = 5; 
        GreenfootImage bg = new GreenfootImage(getBackground());
        getBackground().drawImage(bg, 0, scrollAmt); // scroll image down
        getBackground().drawImage(bg, 0, scrollAmt-getHeight());
    }
    
    public void spawnProjectile2()
    {
        projectile2Spawn++;
        if(counter.Score() <50)
        {
            if(projectile2Spawn>2000){
                addObject(new Projectile2(), Greenfoot.getRandomNumber(600),0);
                projectile2Spawn = 0;
            }
            
        }
        else if(counter.Score() >= 50)
        {
            if(projectile2Spawn>900){
                addObject(new Projectile2(), Greenfoot.getRandomNumber(600),0);
                projectile2Spawn = 0;
            }
        }
    }
    
    public void spawnProjectile3()
    {
        projectile3Spawn++;
        if(counter.Score() <50)
        {
            if(projectile3Spawn>2500){
                addObject(new Projectile3(), Greenfoot.getRandomNumber(600),0);
                projectile3Spawn = 0;
            }
            
        }
        else if(counter.Score() >= 100)
        {
            if(projectile3Spawn>2000){
                addObject(new Projectile3(), Greenfoot.getRandomNumber(600),0);
                projectile3Spawn = 0;
            }
        }
    }
    
    public void spawnProjectile4()
    {
        projectile4Spawn++;
        if(counter.Score() <50)
        {
            if(projectile4Spawn>3000){
                addObject(new Projectile4(), Greenfoot.getRandomNumber(600),0);
                projectile4Spawn = 0;
            }
            
        }
        else if(counter.Score() >= 150)
        {
            if(projectile4Spawn>2500){
                addObject(new Projectile4(), Greenfoot.getRandomNumber(600),0);
                projectile4Spawn = 0;
            }
        }
        
    }
    
    public void spawnHealth()
    {
        healthCount++;
        if(counter.Score()<50){
            
            if(healthCount>1000)
            {
                addObject(new HealthUp(), Greenfoot.getRandomNumber(600),0);
                healthCount = 0;
            }
            
        }else if(counter.Score() >50){
            if(healthCount>700)
            {
                addObject(new HealthUp(), Greenfoot.getRandomNumber(600),0);
                healthCount = 0;
            }
            
        }
        
    }
    
    
        
    public void spawnEnemy1(){
        if(counter.Score() <50){
            enemyCount++;
            if(enemyCount>60)
            {
                addObject(new Enemy1(), Greenfoot.getRandomNumber(600),0);
                enemyCount = 0;
            }
            
        }else if(counter.Score()>=50){
            enemyCount++;
            if(enemyCount>80){
                addObject(new Enemy1(), Greenfoot.getRandomNumber(600),0);
                enemyCount = 0;
            }
        }
        
        
    }
    
    public void spawnEnemy2(){
        if(counter.Score() >= 50)
        {
            enemy2Count++;
            if(enemy2Count>150)
            {
                addObject(new Enemy2(), Greenfoot.getRandomNumber(600),0);
                enemy2Count = 0;
                
            }
        }
        
    }
   
    public void spawnEnemy3(){
        if(counter.Score() >=100)
        {
            enemy3Count++;
            if(enemy3Count>250)
            {
                addObject(new Enemy3(), Greenfoot.getRandomNumber(600),0);
                enemy3Count =0;
            }
        }
        
    }
    
    public void spawnBoss(){
        if(counter.Score() == 300)
        {
            if(bossLevel ==false)
            {
                addObject(new Boss(),300, 0);
                bossLevel = true;
            }
            
        }
    }
    
    private void prepare()
    {
        Player player = new Player();
        addObject(player,241,343);
        player.setLocation(295,372);

        addObject(counter,25,25);
        counter.setLocation(506,379);
        
        addObject(healthbar, 88, 378);
    }
}
