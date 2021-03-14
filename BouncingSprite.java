//Rhea Rai


public class BouncingSprite extends MobileSprite
{
    public BouncingSprite(double bx, double by, int bWidth, int bHeight, String bImage, double bVX, double bVY)
    {
        super( bx, by, bWidth, bHeight, bImage, bVX, bVY);
    }

    private void bounce(World w) 
    {
        if (this.getX() <= 0 || this.getX() >= w.getWidth()) {
            setVx(getVx() * -1);
        }
        if (this.getY() <= 0 || this.getY() >= w.getHeight()) {
            setVy(getVy() * -1);
        }
    }
    
    @Override
    public void step(World world) 
    {
        super.step(world);
        bounce(world);
    }
}
