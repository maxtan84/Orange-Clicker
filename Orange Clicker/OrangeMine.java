import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * One of the Upgrades that a player can buy to increase idle oranges.
 * 
 * @author Tan 
 * @version January 2021
 */
public class OrangeMine extends Actor
{
    /**
     * Act - do whatever the OrangeMine wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage orangeMine = new GreenfootImage("images/orangeMine.png");
    
    public OrangeMine()
    {
        setImage(orangeMine);
        orangeMine.scale(50,40);
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
