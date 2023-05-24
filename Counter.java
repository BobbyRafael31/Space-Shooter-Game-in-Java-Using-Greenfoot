import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Event
{
    private int score = 0;
    String str = "Score: ";
    /**
     * Act - do whatever the Counter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public int Score(){
        return score;
    }
    
    public Counter(){
         setImage(new GreenfootImage(str+ score,20,Color.WHITE,null));
    }
    public void act()
    {
        // Add your action code here.
        setImage(new GreenfootImage(str+ score,20,Color.WHITE,null));
    }

    public void addScore()
    {
        score++;
    }
}
