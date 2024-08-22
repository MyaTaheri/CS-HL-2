public class RockPaperScissor
{    public static void main (String[] args)
    {
        int p1Win = 0;
        int p2Win = 0;
        int tie = 0;

        System.out.println("----------");
        for (int game = 0; game < 3; game++)
        {
            int move1 = (int)(Math.random()*(3));
            int move2 = (int)(Math.random()*(3));
            //0 = rock, 1 = paper, 2 = scissors
            if (move1==0 && move2 == 2)
                p1Win++;
            else if(move1==1 && move2==0)
                p1Win++;
            else if (move1== 2 && move2 ==1)
                p1Win++;
            else if (move2==0 && move1 == 2)
                p2Win++;
            else if(move2==1 && move1==0)
                p2Win++;
            else if (move2== 2 && move1 ==1)
                p2Win++;
            else
            {
                tie++;
                game--;
            }

            System.out.println("Player1: " + p1Win + " wins");
            System.out.println("Player2: " + p2Win + " wins");
            System.out.println("Ties: " + tie);
            System.out.println("----------");

            if (p1Win ==2 || p2Win ==2)
                break;
        }
        //p1-p2 = -1 and p1-p2 = 2
        //p1 - p2 == 1 || p1 - p2 == -2
    }
}