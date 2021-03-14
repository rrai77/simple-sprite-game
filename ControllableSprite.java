//Rhea Rai

public class ControllableSprite extends MobileSprite
{
    int floorCount = 0;
    public ControllableSprite(double cx, double cy, int cWidth, int cHeight, String cImage, double cVX, double cVY)
    {
        super( cx, cy, cWidth, cHeight, cImage, cVX, cVY);
        setVx(20);
        setVy(20);
    }
    
    @Override
    public void step(World world) 
    {
        if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_UP))
            setY(getY() +8);
        if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_DOWN))
            setY(getY() -8);
        if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_RIGHT))
            setX(getX() +8);
        if (StdDraw.isKeyPressed(java.awt.event.KeyEvent.VK_LEFT))
            setX(getX() -8);  
        if (this.getX() <= 0 ) {
            setX(0.5);
        }
        if (this.getX() >= 600) {
            setX(599.5);
        }
        if (this.getY() <= 0 ) {
            floorCount ++;
            setY(590.5);
        }
        if (this.getY() >= 600) {
            setY(599.5);
        }
    }
    public int getCount() {return floorCount;}
}
