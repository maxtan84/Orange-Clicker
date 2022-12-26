import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Where the main clicking and buying takes place. Can access settings from here.
 * 
 * @author Tan 
 * @version January 2021
 */
public class MyWorld extends World
{
    //creates all the objects so it is class scope
    Gear gear;
    Orange orange;
    FallingOrange fallingOrange;
    PowerClicker powclk;
    OrangeTree orgTree;
    OrangeMine orgMine;
    OrangeFactory orgFactory;
    OrangeTemple orgTemp;
    OrangePlanet orgPlan;
    
    Label orangePerSec;// shows the oranges per second
    Label clickPower;
    //creates the buy labels to class scope
    Label buyPowclk;
    Label buyOrgTree;
    Label buyOrgMine;
    Label buyOrgFactory;
    Label buyOrgTemp;
    Label buyOrgPlan;
    
    /*
     * creates the total score counter, total oranges produced and spent,
     * total clicks, score counter and label
     */
    public static int totalOrg;
    public static int totalOrgSpent;
    public static int totalClicks;
    public static Counter score;
    Label scoreLabel;
    
    //creates all the costs of upgrades(cost) and variables of increase score(cnt)
    public static int numPowclk;
    public static int numOrgTree;
    public static int numOrgMine;
    public static int numOrgFactory;
    public static int numOrgTemp;
    public static int numOrgPlan;
    
    public static int cntpowclk; 
    public static int cntOrgTree;
    public static int cntOrgPlan;
    public static int cntOrgMine;
    public static int cntOrgFactory;
    public static int cntOrgTemp;
    
    private int costPowclk = 150;
    private int costOrgTree = 60; 
    private int costOrgMine = 250;
    private int costOrgFactory = 1000;
    private int costOrgTemp = 8500;
    private int costOrgPlan = 100000;
    
    //creates all the timers for the idleOrange() method
    SimpleTimer timerTree = new SimpleTimer();
    SimpleTimer timerMine = new SimpleTimer();
    SimpleTimer timerFactory = new SimpleTimer();
    SimpleTimer timerTemp = new SimpleTimer();
    SimpleTimer timerPlan = new SimpleTimer();
    
    GreenfootSound backgroundMusic = new GreenfootSound("backgroundMusic.mp3");
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        
        gear = new Gear();
        addObject(gear, 30,30);
        
        setPaintOrder(Orange.class,FallingOrange.class);// makes the orange in front of falling ones
        
        //sets the static variables to 0 when game is reset
        totalOrg = 0;
        totalOrgSpent = 0;
        totalClicks = 0;
        numPowclk = 0;
        numOrgTree = 0;
        numOrgMine = 0;
        numOrgFactory = 0;
        numOrgTemp = 0;
        numOrgPlan = 0;
        
        cntpowclk = 1; 
        cntOrgTree = 0;
        cntOrgPlan = 0;
        cntOrgMine = 0;
        cntOrgFactory = 0;
        cntOrgTemp = 0;
        
        //creates orange
        orange = new Orange();
        addObject(orange, 175, 200);
        
        //creates the score
        score = new Counter();
        scoreLabel = new Label("You have " + score.getValue() + " oranges", 22);
        scoreLabel.setFillColor(greenfoot.Color.ORANGE);
        addObject(scoreLabel, 180,30);
        
        //creates the idle OPS
        int allAdded = cntOrgTree+cntOrgMine+cntOrgFactory+cntOrgTemp+cntOrgPlan;
        orangePerSec = new Label("Idle OPS: " + allAdded, 18);
        orangePerSec.setFillColor(greenfoot.Color.PINK);
        addObject(orangePerSec, 100,60);
        
        //creates the click power
        clickPower = new Label("Click Power: 1 ", 18);
        clickPower.setFillColor(greenfoot.Color.BLACK);
        addObject(clickPower, 260,60);

        //creates powerclicker upgrade
        powclk = new PowerClicker();
        addObject(powclk, 575, 40);
        Label powclkLb = new Label("Power Clicker: x2 your oranges per click!", 15);
        addObject(powclkLb, 475,13);//adds label in
        powclkLb.setFillColor(greenfoot.Color.RED);//sets the colour
        buyPowclk = new Label("Buy for "+ costPowclk + " oranges!", 17);//buy label
        buyPowclk.setFillColor(greenfoot.Color.GREEN);//sets colour
        addObject(buyPowclk, 450, 40);// adds label
        
        //creates orange tree upgrade
        orgTree = new OrangeTree();
        addObject(orgTree, 575, 110);
        Label orgTreeLb = new Label("Orange Tree: +1 orange per second!", 15);
        addObject(orgTreeLb, 475,80);
        orgTreeLb.setFillColor(greenfoot.Color.RED);
        buyOrgTree = new Label("Buy for "+ costOrgTree + " oranges!", 17);
        buyOrgTree.setFillColor(greenfoot.Color.GREEN);
        addObject(buyOrgTree, 450, 105);
        
        //creates orange mine upgrade
        orgMine = new OrangeMine();
        addObject(orgMine, 575, 175);
        Label orgMineLb = new Label("Orange Mine: +5 orange per second!", 15);
        addObject(orgMineLb, 475,145);
        orgMineLb.setFillColor(greenfoot.Color.RED);
        buyOrgMine = new Label("Buy for "+ costOrgMine + " oranges!", 17);
        buyOrgMine.setFillColor(greenfoot.Color.GREEN);
        addObject(buyOrgMine, 450, 170);
        
        //creates orange factory upgrade
        orgFactory = new OrangeFactory();
        addObject(orgFactory, 575, 240);
        Label orgFactoryLb = new Label("Orange Factory: +15 orange per second!", 15);
        addObject(orgFactoryLb, 475,210);
        orgFactoryLb.setFillColor(greenfoot.Color.RED);
        buyOrgFactory = new Label("Buy for "+ costOrgFactory + " oranges!", 17);
        buyOrgFactory.setFillColor(greenfoot.Color.GREEN);
        addObject(buyOrgFactory, 450, 235);
        
        //creates orange temple upgrade
        orgTemp = new OrangeTemple();
        addObject(orgTemp, 575, 305);
        Label orgTempLb = new Label("Orange Temple: +40 orange per second!", 15);
        addObject(orgTempLb, 475,275);
        orgTempLb.setFillColor(greenfoot.Color.RED);
        buyOrgTemp = new Label("Buy for "+ costOrgTemp + " oranges!", 17);
        buyOrgTemp.setFillColor(greenfoot.Color.GREEN);
        addObject(buyOrgTemp, 450, 300);
        
        //creates orange planet upgrade
        orgPlan = new OrangePlanet();
        addObject(orgPlan, 575, 370);
        Label orgPlanLb = new Label("Orange Planet: +300 orange per second!", 15);
        addObject(orgPlanLb, 475,340);
        orgPlanLb.setFillColor(greenfoot.Color.RED);
        buyOrgPlan = new Label("Buy for "+ costOrgPlan + " oranges!", 17);
        buyOrgPlan.setFillColor(greenfoot.Color.GREEN);
        addObject(buyOrgPlan, 450, 365);
        
        //draws all the lines to separate the orange and the upgrades
        this.getBackground().drawLine(345,1,345,400);
        this.getBackground().drawLine(345,65,600,65);
        this.getBackground().drawLine(345,135,600,135);
        this.getBackground().drawLine(345,200,600,200);
        this.getBackground().drawLine(345,265,600,265);
        this.getBackground().drawLine(345,330,600,330);
    }
    
    //main act method
    public void act()
    {
        orangeIsPressed();//animation
        backgroundMusic.play();
        backgroundMusic.setVolume(50);
        if(click())// if clicked it changes the score label
        {
            removeObject(scoreLabel);
            scoreLabel = new Label("You have " + score.getValue() + " oranges", 22);
            scoreLabel.setFillColor(greenfoot.Color.ORANGE);
            addObject(scoreLabel, 180,30);
        }
        fallingOrange();//drops falling orange
        idleOranges();//how many oranges are added to score per second
        buyItem();//changes the cost of items when bought
        checkSettings();//checks if user clicked settings
    }
    
    public void checkSettings()
    {
        if(Greenfoot.mouseClicked(gear))
        {
            Settings settings = new Settings();
            settings.totalOrg = totalOrg;
            settings.totalOrgSpent = totalOrgSpent;
            settings.totalClicks = totalClicks;
            settings.cntpowclk = numPowclk; 
            settings.cntOrgTree = numOrgTree;
            settings.cntOrgPlan = numOrgPlan;
            settings.cntOrgMine = numOrgMine;
            settings.cntOrgFactory = numOrgFactory;
            settings.cntOrgTemp = numOrgTemp;
            settings.prevWorld = this;
            Greenfoot.setWorld(settings);            
        }
    }
    
    
    /*
     * Animation and changing total clicks only**
     * checking if the orange is pressed, animates it if pressed
     */
    
    public void orangeIsPressed()
    { 
        GreenfootSound eat = new GreenfootSound("click6.mp3");
        if(Greenfoot.mousePressed(orange))
        {
            orange.getImage().scale(125,125);
            int i = Greenfoot.getRandomNumber(8);
            if(i == 0)
            {
                eat.play();
            }
            else
            {
                GreenfootSound eat2 = new GreenfootSound("click" + i + ".mp3");
                eat2.play();
            }
            totalClicks++;
        }
        else if(Greenfoot.mouseClicked(orange))
        {
            orange.getImage().scale(100,100);  
        }
    }
    
    /**
     * Adding to score when the orange is clicked 
     * Checks for powerclicker upgrades 
     */
    private boolean click()
    {
        if(cntpowclk == 1)
        {
            if(Greenfoot.mousePressed(orange))
            {
                score.add(1);
                totalOrg++;
            }
        }
        else if(cntpowclk != 1)
        {
            if(Greenfoot.mousePressed(orange))
            {
                int scor = score.getValue() + cntpowclk;
                score.setValue(scor);
                totalOrg += cntpowclk;
            }
        }
        return true;
    }
    
    /**
     * This method is used  when the user buys an Item.
     * It shows what the upgrade does and sets the cost of item to a new cost
     * Depending on what upgrades, either the Idle Oranges increase
     * or the click power increases and it plays a sound
     */
    public void buyItem()
    {
        GreenfootSound buy = new GreenfootSound("cashIn.mp3");
        if(Greenfoot.mousePressed(powclk))
        {
            if(score.getValue() >= costPowclk)
            {
                numPowclk++;
                cntpowclk *= 2;
                int score1 = score.getValue() - costPowclk;
                score.setValue(score1);
                totalOrgSpent += costPowclk;
                costPowclk *= 3;
                removeObject(buyPowclk);
                buyPowclk = new Label("Buy for "+ costPowclk + " oranges!", 17);
                buyPowclk.setFillColor(greenfoot.Color.GREEN);
                addObject(buyPowclk, 450, 40);
                removeObject(clickPower);
                clickPower = new Label("Click Power: " + cntpowclk + " ", 18);
                clickPower.setFillColor(greenfoot.Color.BLACK);
                addObject(clickPower, 260,60);
                buy.play();
            }
        }
        if(Greenfoot.mousePressed(orgTree))
        {
            if(score.getValue() >= costOrgTree)
            {
                numOrgTree++;
                cntOrgTree++;
                int score2 = score.getValue() - costOrgTree;
                score.setValue(score2);
                totalOrgSpent += costOrgTree;
                costOrgTree += 25;
                removeObject(buyOrgTree);
                buyOrgTree = new Label("Buy for "+ costOrgTree + " oranges!", 17);
                buyOrgTree.setFillColor(greenfoot.Color.GREEN);
                addObject(buyOrgTree, 450, 105);
                removeObject(orangePerSec);
                int allAdded = cntOrgTree+cntOrgMine+cntOrgFactory+cntOrgTemp+cntOrgPlan;
                orangePerSec = new Label("Idle OPS: " + allAdded, 18);
                orangePerSec.setFillColor(greenfoot.Color.PINK);
                addObject(orangePerSec, 100,60);
                buy.play();
            }
        }
        if(Greenfoot.mousePressed(orgMine))
        {
            if(score.getValue() >= costOrgMine)
            {
                numOrgMine++;
                cntOrgMine += 5;
                int score3 = score.getValue() - costOrgMine;
                score.setValue(score3);
                totalOrgSpent += costOrgMine;
                costOrgMine += 160;
                removeObject(buyOrgMine);
                buyOrgMine = new Label("Buy for "+ costOrgMine + " oranges!", 17);
                buyOrgMine.setFillColor(greenfoot.Color.GREEN);
                addObject(buyOrgMine, 450, 170);
                removeObject(orangePerSec);
                int allAdded = cntOrgTree+cntOrgMine+cntOrgFactory+cntOrgTemp+cntOrgPlan;
                orangePerSec = new Label("Idle OPS: " + allAdded, 18);
                orangePerSec.setFillColor(greenfoot.Color.PINK);
                addObject(orangePerSec, 100,60);
                buy.play();
            }
        } 
        if(Greenfoot.mousePressed(orgFactory))
        {
            if(score.getValue() >= costOrgFactory)
            {
                numOrgFactory++;
                cntOrgFactory += 15;
                int score4 = score.getValue() - costOrgFactory;
                score.setValue(score4);
                totalOrgSpent += costOrgFactory;
                costOrgFactory += 425;
                removeObject(buyOrgFactory);
                buyOrgFactory = new Label("Buy for "+ costOrgFactory + " oranges!", 17);
                buyOrgFactory.setFillColor(greenfoot.Color.GREEN);
                addObject(buyOrgFactory, 450, 235);
                removeObject(orangePerSec);
                int allAdded = cntOrgTree+cntOrgMine+cntOrgFactory+cntOrgTemp+cntOrgPlan;
                orangePerSec = new Label("Idle OPS: " + allAdded, 18);
                orangePerSec.setFillColor(greenfoot.Color.PINK);
                addObject(orangePerSec, 100,60);
                buy.play();
            }
        } 
        if(Greenfoot.mousePressed(orgTemp))
        {
            if(score.getValue() >= costOrgTemp)
            {
                numOrgTemp++;
                cntOrgTemp += 40;
                int score5 = score.getValue() - costOrgTemp;
                score.setValue(score5);
                totalOrgSpent += costOrgTemp;
                costOrgTemp += 1545;
                removeObject(buyOrgTemp);
                buyOrgTemp = new Label("Buy for "+ costOrgTemp + " oranges!", 17);
                buyOrgTemp.setFillColor(greenfoot.Color.GREEN);
                addObject(buyOrgTemp, 450, 300);
                removeObject(orangePerSec);
                int allAdded = cntOrgTree+cntOrgMine+cntOrgFactory+cntOrgTemp+cntOrgPlan;
                orangePerSec = new Label("Idle OPS: " + allAdded, 18);
                orangePerSec.setFillColor(greenfoot.Color.PINK);
                addObject(orangePerSec, 100,60);
                buy.play();
            }
        }  
        if(Greenfoot.mousePressed(orgPlan))
        {
            if(score.getValue() >= costOrgPlan)
            {
                numOrgPlan++;
                cntOrgPlan += 300;
                int score6 = score.getValue() - costOrgPlan;
                score.setValue(score6);
                totalOrgSpent += costOrgPlan;
                costOrgPlan += 2340;
                removeObject(buyOrgPlan);
                buyOrgPlan = new Label("Buy for "+ costOrgPlan + " oranges!", 17);
                buyOrgPlan.setFillColor(greenfoot.Color.GREEN);
                addObject(buyOrgPlan, 450, 365);
                removeObject(orangePerSec);
                int allAdded = cntOrgTree+cntOrgMine+cntOrgFactory+cntOrgTemp+cntOrgPlan;
                orangePerSec = new Label("Idle OPS: " + allAdded, 18);
                orangePerSec.setFillColor(greenfoot.Color.PINK);
                addObject(orangePerSec, 100,60);
                buy.play();
            }
        }  
    }
    
    
    /**
     * Checks to see if any upgrades have been bought and adds to score accordingly
     * Only for the Idle Oranges, adds every second depending on when the upgrade
     * was bought
     */
    public void idleOranges()
    {
        if(timerTree.millisElapsed() >= 1000) 
        {
            if(cntOrgTree != 0)
            {
                 score.add(cntOrgTree);
                 totalOrg += cntOrgTree;
            }
            timerTree.mark();
        }
        if(timerMine.millisElapsed() >= 1000) 
        {
            if(cntOrgMine != 0)
            {
                 score.add(cntOrgMine);
                 totalOrg += cntOrgMine;
            }
            timerMine.mark();
        }
        if(timerFactory.millisElapsed() >= 1000) 
        {
            if(cntOrgFactory != 0)
            {
                 score.add(cntOrgFactory);
                 totalOrg += cntOrgFactory;
            }
            timerFactory.mark();
        }
        if(timerTemp.millisElapsed() >= 1000) 
        {
            if(cntOrgTemp != 0)
            {
                 score.add(cntOrgTemp);
                 totalOrg += cntOrgTemp;
            }
            timerTemp.mark();
        }
        if(timerPlan.millisElapsed() >= 1000) 
        {
            if(cntOrgPlan != 0)
            {
                 score.add(cntOrgPlan);
                 totalOrg += cntOrgPlan;
            }
            timerPlan.mark();
        }
    }
    
    //drops a falling orange every time orange is pressed
    private void fallingOrange()
    {
        fallingOrange = new FallingOrange();
        if(Greenfoot.mousePressed(orange))
        {
            int x = Greenfoot.getRandomNumber(315);
            int y = 90;
            addObject(fallingOrange, x,y);
        }
    }
    
    //Randomizer to get numbers between start and end
    public int getRandomInt(int start,int end)
    {
           int normal = Greenfoot.getRandomNumber(end-start+1);
           return normal+start;
    }
}
