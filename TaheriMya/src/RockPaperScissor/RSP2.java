package RockPaperScissor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;

public class RSP2 extends JFrame implements ActionListener
{
    private JLabel compWinLabel;
    private JLabel playerWinLabel;
    private JLabel resultsLabel;
    private JButton submitButton;
    private JComboBox<String> cb;
    private String[] choices = { "rock","paper", "scissors"};
    private int compWins = 0;
    private int playerWins = 0;


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
                // tie++;
                // game--;
                winner = "no one";
            }

            resultsLabel.setText(compPlay + " vs " + playerPlay + ": " + winner + " won this round");
            playerWinLabel.setText("Player wins: " + playerWins);
            compWinLabel.setText("Computer wins: " + compWins);

            if (Math.abs(compWins - playerWins) >= 2 || compWins > 3 || playerWins > 3)
            {
                submitButton.setEnabled(false);
            }
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
