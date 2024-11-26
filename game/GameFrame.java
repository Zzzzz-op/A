package game;
import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel gamePanel;

    public GameFrame() {

        setTitle("Game");
        setSize(1366, 900);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        cardLayout = new CardLayout();
        gamePanel = new JPanel(cardLayout);


        gamePanel.add(new Chapter(this), "Chapter");
        gamePanel.add(new Chapter1Stage(this), "Chapter1Stage");
        gamePanel.add(new Chapter2Stage(this), "Chapter2Stage");


        add(gamePanel);
    }


    public void showCard(String cardName) {
        cardLayout.show(gamePanel, cardName);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameFrame().setVisible(true);
            }
        });
    }
    
    public void setPanel(JPanel panel) {
        gamePanel.add(panel, "DynamicPanel");
        cardLayout.show(gamePanel, "DynamicPanel");
    }
}
