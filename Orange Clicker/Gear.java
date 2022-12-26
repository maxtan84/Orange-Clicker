import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The link from the main world to the settings world.
 * 
 * @author Tan
 * @version January 2021
 */
public class Gear extends Actor
{
    /**
     * Act - do whatever the Gear wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage gear = new GreenfootImage("gearIcon.png");
    public Gear()
    {
        setImage(gear);
        gear.scale(50,50);
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
