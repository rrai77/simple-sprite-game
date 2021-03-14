//Rhea Rai

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import java.util.Random;

public class World
{
    private List<Sprite> sprites;
    private int width;
    private int height;
    private Random rand = new Random();
    
    private double timeMillSec;
    private int floorCount;
    
    private HeavySprite triangle1 ;
    private HeavySprite triangle2 ;
    private HeavySprite triangle3 ;
    private ControllableSprite player ;

    
     
    /** construct a world 600x600 */
    public World() {
        this(600, 600);
    }
    public World(int h, int w)
    {
        height = h;
        width  = w;
        
        sprites = new ArrayList<>();

        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);
        StdDraw.clear(Color.BLACK);
        addSprites();
        
        timeMillSec = 0;
        floorCount = 0;
    }
    
    /** main method */
    public static void main(String[] args)
    {
        World world = new World(600, 600);
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(300, 400, ("Goal - touch the floor as much as possible, but avoid triangles. ")); 
        StdDraw.text(300, 300, ("Use arrowkeys. Game starts in 5 seconds")); 
        StdDraw.show(5000);
        StdDraw.clear(Color.BLACK);
        world.run();
    }
    
    
    /** run the simulation */
    public void run()
    {
        while (true)
        {
            if ((player.overlaps(triangle1)) || (player.overlaps(triangle2)) || (player.overlaps(triangle3)))
                {
                    floorCount = player.getCount();
                    StdDraw.clear(Color.BLACK);
                    StdDraw.show(1000); 
                    StdDraw.setPenColor(StdDraw.WHITE);
                    StdDraw.text(300, 400, ("GAME OVER - TRIANGLES TOUCHED PLAYER")); 
                    StdDraw.text(300, 300, ("You lasted: " + timeMillSec/1000 + " seconds & touched the floor " + floorCount + " times. SCORE: " + (timeMillSec/500)*(1 + floorCount)));
                    StdDraw.show(1); 
                    break;
                }
                
            this.stepAll();
            this.drawAll();
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.text(300, 300, ("Time | " + timeMillSec/1000)); 
            
            StdDraw.show(10); 
            timeMillSec += 10;
            StdDraw.clear(Color.BLACK);
            
            
        }
    }

    
    /** the following 4 methods all create the specific sprites needed for this game */
    private void addSprites()
    {
            triangle1 = addGravityBounce();
            triangle2 = addGravityBounce();
            triangle3 = addGravityBounce();
            
            sprites.add(triangle1);
            sprites.add(triangle2);
            sprites.add(triangle3);
            
            player = addPacman();
            sprites.add(player);
            
    }
    private HeavySprite addGravityBounce() 
    {
        return new HeavySprite(rand.nextInt(width), rand.nextInt(height-100), 30, 30, "triangle.png", -1 * (rand.nextInt(10)+1),-1 * (rand.nextInt(10)+1));
    }
    private BouncingSprite addBounce() 
    {
        return new BouncingSprite(rand.nextInt(width), rand.nextInt(height-30), 30, 30, "circle.png", rand.nextInt(10)+1, rand.nextInt(10)+1);
    }
    private ControllableSprite addPacman()
    {
        return new ControllableSprite(rand.nextInt(width), (height-5), 100, 100, "pacman.png",  50, 50);
    }
    
        
    /** draw all sprites in the simulation at their current positions */
    public void drawAll() {
        for (Sprite sprite : this.sprites)
            sprite.draw();
    }

    
    /** add a sprite to the simulation */
    public void add(Sprite sprite)
    {
        this.sprites.add(sprite);
    }

    /** update positions and velocities */
    public void stepAll()
    {
        for (int i = 0; i < sprites.size(); i++)
            this.sprites.get(i).step(this);
    }

    /** get the width of the world */
    public int getWidth()
    {
        return width;
    }

    /** get the height of the world */
    public int getHeight()
    {
        return height;
    }

    /** get the number of sprites in the simulation currently */
    public int getNumSprites()
    {
        return sprites.size();
    }

    /** get the sprite at the given index */
    public Sprite getSprite(int index)
    {
        return sprites.get(index);
    }

}
