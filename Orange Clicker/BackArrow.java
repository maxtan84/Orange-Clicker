import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Backarrow to return to main world.
 * 
 * @author Tan 
 * @version January 2021
 */
public class BackArrow extends Actor
{
    /**
     * Act - do whatever the BackArrow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage backArrow = new GreenfootImage("backArrow.png");
    
    public BackArrow()
    {
        setImage(backArrow);
        backArrow.scale(75,50);
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
