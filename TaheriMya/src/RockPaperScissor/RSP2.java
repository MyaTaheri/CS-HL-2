package RockPaperScissor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;

public class RSP2 extends JFrame implements ActionListener
{
    private JLabel compWinLabel,playerRoundsLabel,compRoundsLabel, playerWinLabel, resultsLabel;
    private JButton submitButton;
    private JComboBox<String> cb;
    private String[] choices = { "rock","paper", "scissors"};
    private int compWins, compRounds = 0;
    private int playerWins, playerRounds = 0;


	public RSP2() {
		super("RSP2");
		setSize(400,300);
        this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

        Color backgroundColor = new Color(237, 242, 194);
        Color fontColor = new Color (41, 77, 120);

        getContentPane().setBackground(backgroundColor);

        cb = new JComboBox<String>(choices);
            cb.setBounds(40, 40, 100, 50);
            add(cb);
        submitButton = new JButton("Submit");
            submitButton.setBounds(200, 40, 100, 50);
            submitButton.addActionListener(this);
            add(submitButton);
        resultsLabel  = new JLabel("results will appear here");
            resultsLabel.setBounds(40, 120, 750, 50);
            resultsLabel.setFont(new Font("Ariel", Font.PLAIN, 16));
            resultsLabel.setForeground(fontColor);
			add(resultsLabel);
        playerWinLabel = new JLabel("Player wins: " + playerWins);
            playerWinLabel.setBounds(40, 160, 750, 50);
            playerWinLabel.setFont(new Font("Ariel", Font.PLAIN, 16));
            playerWinLabel.setForeground(fontColor);
			add(playerWinLabel);
        playerRoundsLabel = new JLabel("Player Rounds: " + playerRounds);
            playerRoundsLabel.setBounds(200, 160, 750, 50);
            playerRoundsLabel.setFont(new Font("Ariel", Font.PLAIN, 16));
            playerRoundsLabel.setForeground(fontColor);
			add(playerRoundsLabel);
        compRoundsLabel = new JLabel("Computer Rounds: " + compRounds);
            compRoundsLabel.setBounds(200, 200, 750, 50);
            compRoundsLabel.setFont(new Font("Ariel", Font.PLAIN, 16));
            compRoundsLabel.setForeground(fontColor);
			add(compRoundsLabel);
		compWinLabel = new JLabel("Computer wins: " + compWins);
            compWinLabel.setBounds(40, 200, 750, 50);
            compWinLabel.setFont(new Font("Ariel", Font.PLAIN, 16));
            compWinLabel.setForeground(fontColor);
			add(compWinLabel);
        
		
	}

	
	public void actionPerformed(ActionEvent e) 
    {
        if(e.getActionCommand().equals("Submit"))
        {
            String compPlay = computersChoice();
            String playerPlay = (String)cb.getSelectedItem();
            String winner = "";
           
            if (playerPlay.equals("rock") && compPlay == "scissors")
            {
                playerWins++;
                winner = "Player";
            }
            else if(playerPlay=="paper" && compPlay=="rock")
            {
                playerWins++;
                winner = "Player";
            }
            else if (playerPlay== "scissors" && compPlay =="paper")
            {
                playerWins++;
                winner = "Player";
            }
            else if (compPlay=="rock" && playerPlay == "scissors")
            {
                compWins++;
                winner = "Computer";
            }
            else if(compPlay=="paper" && playerPlay=="rock")
            {
                compWins++;
                winner = "Computer";
            }
            else if (compPlay=="scissors" && playerPlay =="paper")
            {
                compWins++;
                winner = "Computer";
            }
            else
            {
                winner = "no one";
            }

            resultsLabel.setText(compPlay + " vs " + playerPlay + ": " + winner + " won this round");
            playerWinLabel.setText("Player wins: " + playerWins);
            compWinLabel.setText("Computer wins: " + compWins);
            
            // each round out of 3
            // play 5 rounds
            if (compWins >= 2 || playerWins >= 2)
            {
                if (compWins == 2)
                    compRounds++;
                if (playerWins == 2)
                    playerRounds++;
               playerWins = 0;
               compWins = 0;
            }
            if (compRounds == 3 || playerRounds == 3)
                submitButton.setEnabled(false);
            
            playerRoundsLabel.setText("Player Rounds: " + playerRounds);
            compRoundsLabel.setText("Computer Rounds: " + compRounds);
        }
    }

    private String computersChoice()
    {
        int move = (int)(Math.random()*(3));
        //0 = rock, 1 = paper, 2 = scissors
        if (move == 0)
            return "rock";
        if (move == 1)
            return "paper";
        else
            return "scissors";
    }
    public static void main(String[] args) {
		RSP2 rsp2 = new RSP2();
		rsp2.setVisible(true);	
	}
}
