import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Mainly for introduction purposes, to show what to do in the game.
 * 
 * @author Tan 
 * @version January 2021
 */
public class titleScreen extends World
{
    Orange orange;
    PowerClicker powclk;
    OrangeTree orgTree;
    
    int counter = 0;
    /**
     * Constructor for objects of class titleScreen.
     * 
     */
    public titleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        Label title = new Label("ORANGE CLICKER: JUST KEEP CLICKING THE ORANGE ", 25);
        title.setFillColor(greenfoot.Color.ORANGE);
        addObject(title, 300, 25);
        
        orange = new Orange();
        orange.getImage().scale(150,150);
        addObject(orange, 300,150);
        Label toGame = new Label("Click on the orange to start! ", 20);
        toGame.setFillColor(greenfoot.Color.RED);
        addObject(toGame, 300, 60);
        
        Label buyingIntruc = new Label("Buy items by clicking on the pictures! ", 18);
        buyingIntruc.turn(-10);
        buyingIntruc.setFillColor(greenfoot.Color.GREEN);
        addObject(buyingIntruc, 450, 210);
        orgTree = new OrangeTree();
        orgTree.getImage().scale(75, 75);
        orgTree.turn(10);
        addObject(orgTree, 500,275);

        Label powclkBuy= new Label("Buy Power Clickers to increase your oranges 2x per click! ", 16);
        powclkBuy.turn(10);
        powclkBuy.setFillColor(greenfoot.Color.GREEN);
        addObject(powclkBuy, 200, 250);
        powclk = new PowerClicker();
        powclk.getImage().scale(100,75);
        addObject(powclk, 100, 300);
        powclk.turn(-10);
        
        Label achievements = new Label("Get all the achievements!", 20);
        achievements.setFillColor(greenfoot.Color.GREEN);
        addObject(achievements, 300, 325);
        
        Gear gear = new Gear();
        addObject(gear, 300, 360);
        
        Label disclamer = new Label("Not a rip off Cookie Clicker made by a high school student ", 10);
        disclamer.setFillColor(greenfoot.Color.BLACK);
        addObject(disclamer, 480, 390);
    }
    
    public void act()
    {  
       orangeIsPressed();
       if(Greenfoot.mouseClicked(orange))
       {
            MyWorld main = new MyWorld();
            Greenfoot.setWorld(main);
       } 
    }
    
    public void orangeIsPressed()
    { 
        GreenfootSound eat = new GreenfootSound("click6.mp3");
        if(Greenfoot.mousePressed(orange))
        {
            orange.getImage().scale(200,200);
        }
    }
    
}
