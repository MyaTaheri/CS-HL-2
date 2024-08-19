public class RockPaperScissor
{    public static void main (String[] args)
    {
        int p1Win = 0;
        int p2Win = 0;

        for (int game = 0; game < 3; game++)
        {
            int move1 = (int)(Math.random()*(3));
            int move2 = (int)(Math.random()*(3));
            if (move1==0 && move2 == 2)
                p1Win++;
        }
    }
}