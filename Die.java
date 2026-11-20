import java.util.Random;
public class Die
{
    private int value;
    public Die()
    {
        Random generator = new Random();
        value = generator.nextInt(6) + 1;
    }
    public int getValue()
    {
        return value;
    }
}