//Rhea Rai

public class HeavySprite extends BouncingSprite
{
    public HeavySprite(double hx, double hy, int hWidth, int hHeight, String hImage, double hVX, double hVY)
    {
        super(hx, hy, hWidth, hHeight, hImage, hVX, hVY);
    }

    @Override
    public void step(World wld) 
    {
        super.step(wld);
        setVy(getVy() - 0.1);
    }
}
