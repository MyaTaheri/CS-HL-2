package ThreeEnvelopes;

import javax.swing.JOptionPane;

public class ThreeEnvelopes 
{
    int[] envelopes = new int[3];
    String[] players = new String[3];
    static int chosenEnvelope = -1;
    static int winningEnvelope = -1;

    public static void main (String[] args)
    {
        String[] options = { "Automatic", "Manual"};
        var selection = JOptionPane.showOptionDialog(null, "Select one:", "Type of Play", 
                                                        0, 2, null, options, options[0]);
        if (selection == 0) {
            JOptionPane.showMessageDialog(null, "You chose automatic!");
        }
        if (selection == 1) { 
            int[] envelopes = {0,0,0};
            //pick the envolope
            envelopes = setUpGame(envelopes);
            //player picks a card
            pickCard();
            //computer switches the wrong one
            switchCard(envelopes);
            //determine winner
            revealWinner();
        }
    }

    public static int[] setUpGame (int[] winner)
    {
        int randomNum = (int)(Math.random() * 3);
        winningEnvelope = randomNum;
        //selects 0, 1, 2
        winner[randomNum] = 1000;

        System.out.println("wining: " + randomNum);

        return winner;
    }

    public static void pickCard()
    {
        String[] options = { "Envelope 1", "Envelope 2", "Envelope 3"};
        var selection = JOptionPane.showOptionDialog(null, "Select one:", "Card Selection", 
                                                        1, 3, null, options, options[0]);
        if (selection == 0) {
            chosenEnvelope = 0;
        }
        if (selection == 1) { 
            chosenEnvelope = 1;
        }
        if (selection == 2)
        {
            chosenEnvelope = 2;
        }
    }

    public static void switchCard(int[] envelopes)
    {
        int randomNum = (int)(Math.random() * 3);
        boolean isChosen = (randomNum == chosenEnvelope);
        boolean isWinning = envelopes[randomNum] == 1000;
        while (isChosen && isWinning)
        {
            randomNum = (int)(Math.random() * 3);
        }

        System.out.println(envelopes[randomNum] + randomNum);

        String[] options = {"Envelope 1", "Envelope 2", "Envelope 3"};
        var selection = JOptionPane.showOptionDialog(null, (randomNum +  1) + " envelope is empty", "Card Selection", 
                                                        1, 3, null, options, options[0]);
        if (selection == 0) {
            chosenEnvelope = 0;
        }
        if (selection == 1) { 
            chosenEnvelope = 1;
        }
        if (selection == 2)
        {
            chosenEnvelope = 2;
        }
    }

    public static void revealWinner()
    {
        JOptionPane.showMessageDialog(null, "Winning Card: " + (winningEnvelope + 1) + "\n" + "Chosen card: " + (chosenEnvelope + 1), "Results", JOptionPane.INFORMATION_MESSAGE);
    }
}
