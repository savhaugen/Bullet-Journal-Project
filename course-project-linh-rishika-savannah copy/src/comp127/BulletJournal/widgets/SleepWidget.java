package comp127.BulletJournal.widgets;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Point;
import edu.macalester.graphics.Rectangle;


import java.awt.Color;
import java.util.HashMap;


/**
 * A widget that displays a row of boxes to represent hours of sleep,
 * and allows the user to select as many boxes as needed.
 */
public class SleepWidget implements BulletJournalWidget {
    
GraphicsGroup sleepGroup;
CanvasWindow sleepCanvas;

HashMap<Rectangle, Integer> boxNums;
HashMap<Integer, Color> colorNums;

private static final double BOX_WIDTH= 4;
private static final double BOX_HEIGHT= 4;
private double size;
private GraphicsText question;

private Color colorOne;
private Color colorTwo;
private Color colorThree;
private Color colorFour;
private Color colorFive;
private Color colorSix;
private Color colorSeven;
private Color colorEight;


    /**
     * Creates the graphicsgroup for the class. Initializes the hashmaps for 
     * the boxes and colors, and creates the question. Creates bar of boxes and 
     * calls clickBox when the user clicks on the screen.
     * @param canvas
     */
    public SleepWidget(CanvasWindow canvas){
        sleepGroup = new GraphicsGroup();
       size = 15;
        question = new GraphicsText("How many hours of sleep did you get last night?");
        question.setPosition(3*size, 18*size);
        question.setFont(FontStyle.BOLD, 25);
        question.setFillColor(colorOne);
        sleepGroup.add(question);
        boxNums = new HashMap<Rectangle, Integer>();
        colorNums = new HashMap<Integer, Color>();

        colorOne= new Color(255, 0, 0);
        colorNums.put(1, colorOne);

        colorTwo= new Color(255, 63, 0);
        colorNums.put(2, colorTwo);

        colorThree= new Color(255, 126, 0);
        colorNums.put(3, colorThree);

        colorFour= new Color(255, 192, 0);
        colorNums.put(4, colorFour);

        colorFive= new Color(255, 255, 0);
        colorNums.put(5, colorFive);

        colorSix= new Color(170, 255, 0);
        colorNums.put(6, colorSix);
        
        colorSeven= new Color(85, 255, 0);
        colorNums.put(7, colorSeven);

        colorEight= new Color(0, 255, 0);
        colorNums.put(8, colorEight);

        createSleepBar();
        canvas.onClick((event) -> clickBox(event.getPosition()));
    }

    /**
     * creates a box
     * @param x the x-coordinate of the upper-lefthand corner of the box
     * @param y the y-coordinate of the upper-lefthand corner of the box
     * @param width width of the box
     * @param height height of the box
     * @return
     */
    private Rectangle createButton(double x, double y, double width, double height){
        Rectangle newBox = new Rectangle(x*size*.7, y*size*.5, width*size, height*size);
        sleepGroup.add(newBox);
        return newBox;

    }

    /**
     * Creates row of boxes and the numbers underneath them.
     * Adds each box to the box hashmap.
     */
    private void createSleepBar(){
        double x = 10;
        double y= 50;
        Integer boxCount = 1;
        for (int i=0; i<8; i++){
            GraphicsText nums = new GraphicsText(boxCount.toString(), x*size*.7+20, y*size*.5 +80);
            nums.setFontSize(20);
            sleepGroup.add(nums);
            Rectangle newBox= createButton(x, y, BOX_WIDTH, BOX_HEIGHT);
            x= x + BOX_WIDTH*1.5;
            boxCount = boxCount +1;
            boxNums.put(newBox, boxCount);
        }
    }


  /**
   * Returns the box where the user clicked if there is one.
   * @param location The location that we check for a box at. 
   * @return
   */
    private Rectangle getBoxAt(Point location){
        if (sleepGroup.getElementAt(location) instanceof Rectangle){
            return (Rectangle) sleepGroup.getElementAt(location);
        }
        return null;
    }

    /**
     * If there is a box detected where the user clicked,
     * the box gets filled in with its corresponding color. 
     * @param location Location of the user's click.
     */
    private void clickBox(Point location){
        if (getBoxAt(location)!= null){
            Integer num= boxNums.get(getBoxAt(location));
            Color color = colorNums.get(num-1);
            getBoxAt(location).setFillColor(color);
        }
    }

    /**
     * method from BulletJournalWidgets Interface. Returns graphicsgroup
     * of the class.
     */
    public GraphicsObject getGraphics() {
        return sleepGroup;
    }
}
