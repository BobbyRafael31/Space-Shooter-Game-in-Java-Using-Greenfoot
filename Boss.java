import greenfoot.*; 

/**
 * Class Boss is to handle Boss object in the game.
 * 
 * @BobbyRafaelSembiring  
 * 
 */
public class Boss extends Bosses
{
    private int direction = 1;
    
    public Boss(){
        super(600); //pass boss health
        GreenfootImage image = getImage();
        image.scale(image.getWidth()+1, image.getHeight()+1);
        setImage(image);
        setRotation(0);
    }
    
    public void act()
    {
        bossDirection();
        hitByProjectile();
    }
    
    private void bossDirection(){
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
    
    private void bossFire()
    {
        getWorld().addObject(new bossProjectile(),getX(),getY()+5);
    }
    
    private void stop(){
        setLocation(getX(),getY());
    }
    
    private void move()
    {
        setLocation(getX(),getY()+1);
    }
    
    private void setBossSfx(){
        GreenfootSound fireBossSfx = new GreenfootSound ( "bossFire.wav" );
        fireBossSfx.setVolume(72);
        fireBossSfx.play();
    }
}
