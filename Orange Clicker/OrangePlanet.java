import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * One of the Upgrades that a player can buy to increase idle oranges.
 * 
 * @author Tan
 * @version January 2021
 */
public class OrangePlanet extends Actor
{
    /**
     * Act - do whatever the OrangePlanet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage orangePlanet = new GreenfootImage("images/orangePlanet.png");
    
    public OrangePlanet()
    {
        setImage(orangePlanet);
        orangePlanet.scale(50,53);
    }
    
    
    public void act() 
    {
        // Add your action code here.
    }    
}
