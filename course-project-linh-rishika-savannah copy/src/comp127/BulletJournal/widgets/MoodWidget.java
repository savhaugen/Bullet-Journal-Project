package comp127.BulletJournal.widgets;
import java.awt.Color;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.ui.Button;

/**
 * A widget that displays the 6 emojis and buttons, and each button displays a string text.
 */

public class MoodWidget implements BulletJournalWidget{

    private GraphicsGroup group;
    private GraphicsText label;
    private GraphicsText description;
    private double size;
    private String[] texts;

    /**
    * Creates a Mood widget of dimensions specefied by size.
    */

    public MoodWidget(double size){
        this.size=size;
        group = new GraphicsGroup();
        label= new GraphicsText();
        label.setText("How are you feeling today?");
        label.setFont(FontStyle.BOLD, size * 0.05);
        label.setPosition(size*0.25,size*0.30);
        group.add(label);
        createEmojis();

        description= new GraphicsText();
        description.setFont(FontStyle.ITALIC, size*0.04);
        description.setFillColor(Color.RED);

        texts= new String[6];
        texts[0]= "You must be having a peaceful day";
        texts[1]= "Time to pop open the Pepto Bismol!";
        texts[2]= "Maybe you should cry it out and get some boba";
        texts[3]= "Life is good!";
        texts[4]= "Don't get into too much trouble!";
        texts[5]= "Sorry you day is lame, go do something fun!";

        createButton();


    }

    /**
     * Creates 6 emojis with the using the Emoji Helper Class. 
     */

    public void createEmojis(){
        GraphicsObject emoji1= EmojiHelper.createContentedFace(100);
        emoji1.setPosition(size * 0.20, size * 0.40);
        group.add(emoji1);

        GraphicsObject emoji2= EmojiHelper.createNauseousFace(100);
        emoji2.setPosition(size * 0.50, size * 0.40);
        group.add(emoji2);

        GraphicsObject emoji3= EmojiHelper.createFrownyFace(100);
        emoji3.setPosition(size * 0.80, size * 0.40);
        group.add(emoji3);

        GraphicsObject emoji4= EmojiHelper.createSmileyFace(100);
        emoji4.setPosition(size * 0.20, size * 0.70);
        group.add(emoji4);

        GraphicsObject emoji5= EmojiHelper.createWinkingFace(100);
        emoji5.setPosition(size * 0.50, size * 0.70);
        group.add(emoji5);

        GraphicsObject emoji6= EmojiHelper.createBoredFace(100);
        emoji6.setPosition(size * 0.80, size * 0.70);
        group.add(emoji6);
        
    }
    /**
     * Creates 6 buttons for each emojis. 
     * Loops over the array of text 
     */

    public void createButton(){
        Button button1= new Button("Content");
        button1.setPosition(size * 0.20, size * 0.60);
        group.add(button1);
        
        button1.onClick(() -> {
            description.setText(texts[0]);
            description.setPosition(size * 0.20, size*1.05);
            group.add(description);

    
        });

        Button button2= new Button("Nauseous");
        button2.setPosition(size * 0.50, size * 0.60);
        group.add(button2);
        
        button2.onClick(() -> {
            description.setText(texts[1]);
            description.setPosition(size * 0.20, size*1.05);
            group.add(description);
        });

        Button button3= new Button("Sad");
        button3.setPosition(size * 0.80, size * 0.60);
        group.add(button3);
        
        button3.onClick(() -> {
            description.setText(texts[2]);
            description.setPosition(size*0.15, size*1.05);
            group.add(description);
        });

        Button button4= new Button("Happy");
        button4.setPosition(size * 0.20, size * 0.90);
        group.add(button4);
        
        button4.onClick(() -> {
            description.setText(texts[3]);
            description.setPosition(size * 0.40, size*1.05);
            group.add(description);
        });

        Button button5= new Button("Mischevious");
        button5.setPosition(size * 0.47, size * 0.90);
        group.add(button5);
        
        button5.onClick(() -> {
            description.setText(texts[4]);
            description.setPosition(size * 0.25, size*1.05);
            group.add(description);
        });

        Button button6= new Button("Bored");
        button6.setPosition(size * 0.80, size * 0.90);
        group.add(button6);
        
        button6.onClick(() -> {
            description.setText(texts[5]);
            description.setPosition(size*0.15, size*1.05);
            group.add(description);
        });
        

    }

    @Override
    public GraphicsObject getGraphics() {
        return group;
    }

    

    





    
    
}
