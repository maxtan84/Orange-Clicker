import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The orange that falls when you click the main orange.
 * 
 * @author Tan 
 * @version January 2021
 */
public class FallingOrange extends Actor
{
    /**
     * Act - do whatever the FallingOrange wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage fallingOrange = new GreenfootImage("images/realorange.png");
    
    public FallingOrange()
    {
        setImage(fallingOrange);
        fallingOrange.scale(50,50);
    }
    
    //Whenever the falling orange appears on the screen, the orange animates and 
    //falls
    public void act() 
    {
        setLocation(getX(), getY()+1);
        MyWorld world = (MyWorld)getWorld();
        turn(1);
        if(getY() >= world.getHeight())
        {
            world.removeObject(this);
        }
    }    
}
