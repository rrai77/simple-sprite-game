//Rhea Rai

public class MobileSprite extends Sprite
{
    private double vx;
    private double vy;
    
    public MobileSprite(double x, double y, int width, int height, String image, double VX, double VY)
    {
        super(x, y, width, height, image);
        vx = VX;
        vy = VY;
    }

    public void setVx(double VxNew) {vx= VxNew;}
    public void setVy(double VyNew) {vy = VyNew;}
    public double getVx() {return vx;}
    public double getVy() {return vy;}
    
    @Override
    public void step(World world) 
    {
        setX(getX() + vx);
        setY(getY() + vy);
    }
}
