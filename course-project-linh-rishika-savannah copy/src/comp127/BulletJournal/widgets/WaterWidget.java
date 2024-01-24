package comp127.BulletJournal.widgets;
import edu.macalester.graphics.Image;
import java.awt.Color;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.ui.Button;

/**
 * A widget that displays a water icon and two buttons to raise the water level. Each level displays a different string text.
 */

public class WaterWidget implements BulletJournalWidget{

    private GraphicsGroup group;
    private GraphicsText label;
    private GraphicsText description;
    private Image icon;
    private double size;
    private String[] images;
    private int counter;
    private String[] texts;

    /**
     * Creates a Water widget of dimensions specefied by size.
     */

    public WaterWidget(double size){
        this.size=size;
        counter = 0;

        group = new GraphicsGroup();

        icon = new Image(0, 0);
        icon.setMaxWidth(size);
        icon.setMaxHeight(size * 0.5);
        icon.setImagePath("GlassImages/0p.jpg");
        icon.setCenter(size * 0.55, size * 0.60);
        group.add(icon);

        
        label = new GraphicsText();
        label.setText("How much water did you drink today?");
        label.setFillColor(Color.blue);
        label.setFont(FontStyle.BOLD, size * 0.05);
        label.setPosition(size*0.1,size*0.30);
        group.add(label);

        description = new GraphicsText();
        description.setFont(FontStyle.BOLD_ITALIC , size * 0.05);
        description.setText("Don't you need water to survive?");
        description.setCenter(size * 0.55, size * 0.95);
        group.add(description);
        
        images= new String[6];
        images[0]="GlassImages/0p.jpg";
        images[1]="GlassImages/25p.jpg";
        images[2]="GlassImages/30p.jpg";
        images[3]="GlassImages/50p.jpg";
        images[4]="GlassImages/75p.jpg";
        images[5]="GlassImages/100p.jpg";

        texts= new String[6];
        texts[0]="Don't you need water to survive?";
        texts[1]="Way to get started!";
        texts[2]="Keep going!";
        texts[3]="Almost there!";
        texts[4]="Great! You achieved the water goal!";
        texts[5]="Way to go, you're an overachiever!";
        
        createButton();

    }

    /**
     * Loops over the array of images and texts. 
     * Sets the icon to the new image and text to the new text. 
     */

    public void update(){
        String path = images[counter];
        icon.setImagePath(path);
        icon.setCenter(size * 0.55, size * 0.60);
        String text= texts[counter];
        description.setText(text);
        description.setCenter(size * 0.55, size * 0.95);
        
        
    }

    /**
     * Creates the add and remove buttons and sets them on the canvas
     * Updates the counter on the click of the button and calls the update method
     */

    public void createButton(){
        Button button= new Button("More Water!");
        button.setPosition(size*0.55,size*1.05);
        group.add(button);
        
        button.onClick(() -> {
            ++counter;
            if (counter > 5){
            counter=5;
            } update();
        });
        Button button1= new Button("Less Water!");
        button1.setPosition(size*0.25,size*1.05);
        group.add(button1);
        
        button1.onClick(() -> {
            --counter;
            if (counter < 0){
            counter=0;
            } update();
         });
    }


    @Override
    public GraphicsObject getGraphics() {
        return group;
    }

    
}
