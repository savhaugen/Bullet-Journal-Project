package comp127.BulletJournal.widgets;
import edu.macalester.graphics.*;
import edu.macalester.graphics.ui.Button;
import edu.macalester.graphics.ui.TextField;
import java.awt.Color;
import java.util.ArrayList;


public class TaskWidget implements BulletJournalWidget{
    private final double size;
    private GraphicsGroup group;

    private ArrayList<String> dailyList;
    private ArrayList<String> goalList;
    private ArrayList<String> weeklyList;

    private GraphicsText dailyLabel;
    private GraphicsText goalLabel;
    private GraphicsText weeklyLabel;
    private TextField dailyField, goalField, weeklyField;

    public static final Color PASTEL_PINK = new Color(174, 198, 207, 200);
    public static final Color GRAY = new Color(128,128,128,200); 

    /**
     * The contructor lays out graphics for the widget. It consists of 3 fields (daily, goal, weekly), which each includes a label, a textfield, and a button.
     * @param size The relative size of the canvas, which will in turn affect all of the graphics object size
     * @param canvas The canvas parameter as it will affect canvas.onClick method.
     */
    public TaskWidget(double size, CanvasWindow canvas) {
        this.size = size;
        
        group = new GraphicsGroup();

        dailyList = new ArrayList<>();
        goalList = new ArrayList<>();
        weeklyList = new ArrayList<>();

        dailyLabel = new GraphicsText();
        dailyLabel.setText("Today task");
        dailyLabel.setFont(FontStyle.BOLD, size * 0.05); 
        dailyLabel.setFillColor(PASTEL_PINK);
        dailyLabel.setPosition(size*0.1, size*0.1);

        dailyField = new TextField();
        dailyField.setPosition(dailyLabel.getX(), dailyLabel.getY()+5);
        addButton(dailyField, dailyList);

        group.add(dailyLabel);
        group.add(dailyField);

        goalLabel = new GraphicsText();
        goalLabel.setText("Long-term goals");
        goalLabel.setFont(FontStyle.BOLD, size * 0.05);
        goalLabel.setFillColor(PASTEL_PINK);
        goalLabel.setPosition(size*0.5, size*0.1);

        goalField = new TextField();
        goalField.setPosition(goalLabel.getX(), goalLabel.getY()+5);
        addButton(goalField, goalList);
        group.add(goalLabel);
        group.add(goalField);

        weeklyLabel = new GraphicsText();
        weeklyLabel.setText("Weekly tasks");
        weeklyLabel.setFont(FontStyle.BOLD, size * 0.05);
        weeklyLabel.setFillColor(PASTEL_PINK);
        weeklyLabel.setPosition(size*0.5, size*0.5);

        weeklyField = new TextField();
        weeklyField.setPosition(weeklyLabel.getX(), weeklyLabel.getY()+5);
        addButton(weeklyField, weeklyList);
        group.add(weeklyLabel);
        group.add(weeklyField);

        group.setPosition(size*0.1, size*0.4);

        canvas.onClick(event -> {removeTask(event.getPosition());} );
    }

    /**
     * This method returns the widget graphics group. This is a part of the BulletJournalWidget interface.
     * @return GraphicsGroup
     */
    @Override
    public GraphicsGroup getGraphics() {
        return group;
    }

    /**
     * This method creates the add buttons which get text in the TextField, adds new task into the task lists and displays it into the graphic group
     * @param field corresponding textField 
     * @param list corresponding ArrayList
     */
    public void addButton(TextField field,ArrayList<String> list){
        Button button= new Button("Add");
        button.setPosition(field.getX()+100,field.getY());
        group.add(button);
        button.onClick(() -> {
            field.getText();
            list.add(field.getText());
            addNewTask(field, list);
            
        });
    }

    /**
     * This method creates new task Graphics Text and places it one underneath the other.
     * @param field corresponding textField 
     * @param list corresponding ArrayList
     */
    private void addNewTask(TextField field, ArrayList<String> list) {
            GraphicsText newgoal = new GraphicsText(list.get(list.size()-1));
            newgoal.setFont(FontStyle.ITALIC, size * 0.035);
            newgoal.setStrokeWidth(2);
            newgoal.setFillColor(GRAY);
            newgoal.setPosition(field.getX(),list.indexOf(list.get(list.size()-1))*20 + field.getY()+50);
            group.add(newgoal);

    }
    /**
     * This method remove the GraphicsText Object on mouse click, remove it from the canvas.
     * @param location
     */
    private void removeTask(Point location) {
        GraphicsObject taskRemove = group.getElementAt(location);
        if (taskRemove != null) {
        group.remove(taskRemove);}
    }
}
