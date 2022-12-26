import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Where the player finds their statistics and achievements.
 * 
 * @author Tan 
 * @version January 2021
 */
public class Settings extends World
{
    public MyWorld prevWorld;
    
    BackArrow backArrow;
    
    //labels and transferring information between worlds
    Label totalOranges;
    Label totalSpentOrg;
    Label clickTotal;
    int totalOrg = MyWorld.totalOrg;
    int totalOrgSpent = MyWorld.totalOrgSpent;
    int totalClicks = MyWorld.totalClicks;
    int cntpowclk = MyWorld.numPowclk; 
    int cntOrgTree = MyWorld.numOrgTree;
    int cntOrgPlan = MyWorld.numOrgPlan;
    int cntOrgMine = MyWorld.numOrgMine;
    int cntOrgFactory = MyWorld.numOrgFactory;
    int cntOrgTemp = MyWorld.numOrgTemp;
    
    //objects to represent finished achievements
    Checkmark check1;
    Checkmark check2;
    Checkmark check3;
    Checkmark check4;
    Checkmark check5;
    Checkmark check6;
    Checkmark check7;
    Checkmark check8;
    
    Cross cross1;
    Cross cross2;
    Cross cross3;
    Cross cross4;
    Cross cross5;
    Cross cross6;
    Cross cross7;
    Cross cross8;
    
    //labels for stats 
    Label numPowclk;
    Label numOrgTree;
    Label numOrgMine;
    Label numOrgFactory;
    Label numOrgTemp;
    Label numOrgPlan;
    
    /**
     * Constructor for objects of class Settings.
     * 
     */
    public Settings()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        // creates the back arrow
        backArrow = new BackArrow();
        addObject(backArrow, 30,25);
        
        // creates the stats title
        Label stats = new Label("STATS ", 30);
        stats.setFillColor(greenfoot.Color.DARK_GRAY);
        addObject(stats, 145,25);
        //creates the acheivements label
        Label achievements = new Label("ACHIEVEMENTS ", 30);
        achievements.setFillColor(greenfoot.Color.GREEN);
        addObject(achievements, 420,25);
        
        //total oranges label
        totalOranges =  new Label("Total Oranges Created : " + totalOrg + " ", 17);
        totalOranges.setFillColor(greenfoot.Color.CYAN);
        addObject(totalOranges, 120, 70);
        //total spent oranges label
        totalSpentOrg =  new Label("Total Oranges Spent : " + totalOrgSpent + " ", 17);
        totalSpentOrg.setFillColor(greenfoot.Color.CYAN);
        addObject(totalSpentOrg, 120, 100);
        //total clicks 
        clickTotal =  new Label("Total Clicks : " + totalClicks + " ", 17);
        clickTotal.setFillColor(greenfoot.Color.CYAN);
        addObject(clickTotal, 120, 130);
        //number of power clickers bought
        numPowclk =  new Label("Total Power Clickers Bought :  " + cntpowclk + " ", 17);
        numPowclk.setFillColor(greenfoot.Color.GREEN);
        addObject(numPowclk, 125, 160);
        //number of oranges trees bought
        numOrgTree =  new Label("Total Orange Trees Grown :  " + cntOrgTree + " ", 17);
        numOrgTree.setFillColor(greenfoot.Color.GREEN);
        addObject(numOrgTree, 125, 190);
        //number of orange mines bought
        numOrgMine =  new Label("Total Mines Owned :  " + cntOrgMine + " ", 17);
        numOrgMine.setFillColor(greenfoot.Color.GREEN);
        addObject(numOrgMine, 125, 220);
        //number of oranges factories bought
        numOrgFactory =  new Label("Total Factories Owned :  " + cntOrgFactory + " ", 17);
        numOrgFactory.setFillColor(greenfoot.Color.GREEN);
        addObject(numOrgFactory, 125, 250);
        //number of oranges temples bought
        numOrgTemp =  new Label("Total Temples Owned :  " + cntOrgTemp + " ", 17);
        numOrgTemp.setFillColor(greenfoot.Color.GREEN);
        addObject(numOrgTemp, 125, 280);
        //number of orange planets bought
        numOrgPlan =  new Label("Total Planets Owned :  " + cntOrgPlan + " ", 17);
        numOrgPlan.setFillColor(greenfoot.Color.GREEN);
        addObject(numOrgPlan, 125, 310);
        
        //adds all the cross objects + their labels under the achievements section
        cross1 = new Cross();
        addObject(cross1, 560,80);
        Label orgTreeAch =  new Label("Eco friendly : Buy 20 oranges trees ", 17);
        orgTreeAch.setFillColor(greenfoot.Color.ORANGE);
        addObject(orgTreeAch, 400, 80);
        cross2 = new Cross();
        addObject(cross2, 560,122);
        Label powclkAch =  new Label("Freshly squeezed : Buy 3 powerclickers ", 17);
        powclkAch.setFillColor(greenfoot.Color.ORANGE);
        addObject(powclkAch, 400, 122);
        cross3 = new Cross();
        addObject(cross3, 560,164);
        Label orgMineAch =  new Label("Defying physics : Buy 15 orange mines ", 17);
        orgMineAch.setFillColor(greenfoot.Color.ORANGE);
        addObject(orgMineAch, 400, 164);
        cross4 = new Cross();
        addObject(cross4, 560,206);
        Label orgFactAch =  new Label("Overproduction : Buy 10 factories ", 17);
        orgFactAch.setFillColor(greenfoot.Color.ORANGE);
        addObject(orgFactAch, 400, 206);
        cross5 = new Cross();
        addObject(cross5, 560,248);
        Label orgTempAch =  new Label("Inner peace : Buy 5 temples ", 17);
        orgTempAch.setFillColor(greenfoot.Color.ORANGE);
        addObject(orgTempAch, 400, 248);
        cross6 = new Cross();
        addObject(cross6, 560,290);
        Label clickAch =  new Label("Carpal tunnel? : Click the orange 2500x ", 17);
        clickAch.setFillColor(greenfoot.Color.ORANGE);
        addObject(clickAch, 400, 290);
        cross7 = new Cross();
        addObject(cross7, 560,332);
        Label orgPlanAch =  new Label("Orange god : Buy a planet ", 17);
        orgPlanAch.setFillColor(greenfoot.Color.ORANGE);
        addObject(orgPlanAch, 400, 332);
        cross8 = new Cross();
        addObject(cross8, 560, 374);
        Label totalOrgAch =  new Label("Hacker : Grand total of 250 000 oranges ", 17);
        totalOrgAch.setFillColor(greenfoot.Color.ORANGE);
        addObject(totalOrgAch, 400, 374);
        
        //checking if any achievements have been done
        if(cntOrgTree >= 20)
        {
            removeObject(cross1);
            check1 = new Checkmark();
            addObject(check1, 560, 80);
        }
        if(cntpowclk >= 3)
        {
            removeObject(cross2);
            check2 = new Checkmark();
            addObject(check2, 560, 122);
        }
        if(cntOrgMine >= 15)
        {
            removeObject(cross3);
            check3 = new Checkmark();
            addObject(check3, 560, 164);
        }
        if(cntOrgFactory >= 10)
        {
            removeObject(cross4);
            check4 = new Checkmark();
            addObject(check4, 560, 206);
        }
        if(cntOrgTemp >= 5)
        {
            removeObject(cross5);
            check5 = new Checkmark();
            addObject(check5, 560, 248);
        }
        if(totalClicks >= 2500)
        {
            removeObject(cross6);
            check6 = new Checkmark();
            addObject(check6, 560, 290);
        }
        if(cntOrgPlan >= 1)
        {
            removeObject(cross7);
            check7 = new Checkmark();
            addObject(check7, 560, 332);
        }
        if(totalOrg >= 250000)
        {
            removeObject(cross8);
            check8 = new Checkmark();
            addObject(check8, 560, 374);
        }
        
        //background lines separating titles and from stats and achievements
        this.getBackground().drawLine(250,1,250,400);
        this.getBackground().drawLine(1,50,600,50);
    }
    
    public void act()
    {
        goMainWorld();
    }
    
    private void goMainWorld()
    {
        if(Greenfoot.mouseClicked(backArrow))
        {
            Greenfoot.setWorld(prevWorld);
        }
    }
}
