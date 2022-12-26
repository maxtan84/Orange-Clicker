import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Upgrade the player buys to increase their click power.
 * 
 * @author Tan
 * @version January 2021
 */
public class PowerClicker extends Actor
{
    /**
     * Act - do whatever the PowerClicker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage powclk = new GreenfootImage("images/powerClicker.png");
    
    public PowerClicker()
    {
        setImage(powclk);
        powclk.scale(50,40);
    }
    
    public void act() 
    {
        
    }    
}
