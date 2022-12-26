import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * To show which achievements have been done.
 * 
 * @author Tan
 * @version January 2021
 */
public class Checkmark extends Actor
{
    /**
     * Act - do whatever the Checkmark wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage checkmark = new GreenfootImage("images/checkmark.png");
    
    public Checkmark()
    {
        setImage(checkmark);
        checkmark.scale(35,35);
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
