import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * To show which achievements haven't been done.
 * 
 * @author Tan 
 * @version January 2021
 */
public class Cross extends Actor
{
    /**
     * Act - do whatever the Cross wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage cross = new GreenfootImage("images/cross.png");
    
    public Cross()
    {
        setImage(cross);
        cross.scale(35,35);
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
