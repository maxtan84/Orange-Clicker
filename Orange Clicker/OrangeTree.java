import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * One of the Upgrades that a player can buy to increase idle oranges.
 * 
 * @author Tan
 * @version January 2021
 */
public class OrangeTree extends Actor
{
    /**
     * Act - do whatever the OrangeTree wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage orangeTree = new GreenfootImage("images/orangeTree.png");
    
    public OrangeTree()
    {
        setImage(orangeTree);
        orangeTree.scale(50,40);
    }
    
    
    
    public void act() 
    {
        // Add your action code here.
    }    
}
