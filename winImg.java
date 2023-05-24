import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class winImg here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class winImg extends Image
{
    /**
     * Act - do whatever the winImg wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act()
    {
        // Add your action code here.
        pressToMenu();
    }
    
    public void pressToMenu()
    {
        if(Greenfoot.isKeyDown("enter"))
        {
            stopbgm();
            Greenfoot.setWorld(new ScreenMenu());
        }
    }
    
    private void stopbgm()
    {
        World world = getWorld(); // as a World object, members of MyWorld are inaccessible
        WinningScreen winningscreen = (WinningScreen) world; // the world cast as a MyWorld object
        winningscreen.bgm.stop(); 
    }
}
