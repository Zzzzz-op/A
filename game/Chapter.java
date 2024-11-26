package game;
import java.awt.Image;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Chapter extends JPanel {
    private GameFrame gameFrame;
    private Image backgroundImage;
    private JButton[] buttons = { new JButton("CHAPTER 1"), new JButton("CHAPTER 2"), new JButton("돌아가기") };
    public Chapter(GameFrame gameFrame) {
        this.gameFrame = gameFrame;

        backgroundImage = new ImageIcon("/ChapterBackground.png").getImage();
        // Chapter 1 버튼
        buttons[0].setBounds(200, 200, 100, 100);
        add(buttons[0]);
        buttons[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameFrame.showCard("Chapter1Stage");
            }
        });
        // Chapter 2 버튼
        buttons[1].setBounds(200, 200, 100, 100);

        add(buttons[1]);
        buttons[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameFrame.showCard("Chapter2Stage");
            }
        });

        // 돌아가기 버튼
        buttons[2].setBounds(200, 200, 100, 100);
        add(buttons[2]);
        buttons[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameFrame.showCard("Lobby");
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}