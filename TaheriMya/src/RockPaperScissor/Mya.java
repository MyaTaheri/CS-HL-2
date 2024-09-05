package RockPaperScissor;

public class Mya 
{
    private String name;
    private String currentMove;
    private int wins;
    private int tie;

    private String opponentMove = "womp";

    public Mya()
    {
        this.name = "mya";
        this.currentMove = "";
        this.wins = 0;
        this.tie = 0;
    }

    public void setCurrentMove()
    {
        if (opponentMove.equalsIgnoreCase("womp"))
        {
            int move = (int)(Math.random()*(3));
            //0 = rock, 1 = paper, 2 = scissors
            if (move == 1)
                currentMove = "paper";
            if (move == 2)
                currentMove = "scissors";
            if (move == 3)
                currentMove = "rock";
        }
        else if (tie >= 2)
        {
            currentMove = "paper";
        }
        else
        {
            currentMove = opponentMove;
        }
            
    }

    public void setWins(String opponentMove)
    {
        if (opponentMove.equals("rock") && currentMove.equals("paper"))
            wins++;
        if (opponentMove.equals("paper") && currentMove.equals("scissors"))
            wins++;
        if (opponentMove.equals("scissors") && currentMove.equals("rock"))
            wins++;        
        if (opponentMove.equalsIgnoreCase(currentMove))
            tie++;
    }
    
    public String getName() {
        return name;
    }

    public String getCurrentMove() {
        return currentMove;
    }

    public int getWins() {
        return wins;
    }

}
