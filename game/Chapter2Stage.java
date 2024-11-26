package game;
import javax.swing.*;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import game.stage.Stage4;
import game.stage.Stage5;
import game.stage.Stage6;

public class Chapter2Stage extends JPanel {
    private GameFrame gameFrame;
    private Image backgroundImage;
    private JButton[] buttons = {
            new JButton("Stage 4"),
            new JButton("Stage 5"),
            new JButton("Stage 6"),
            new JButton("돌아가기")
    };
    private Stage4 stage4;
    private Stage5 stage5;
    private Stage6 stage6;

    public Chapter2Stage(GameFrame gameFrame) {
        this.gameFrame = gameFrame;

        backgroundImage = new ImageIcon("/images/Stage2Background.png").getImage();


        stage4 = new Stage4();
        stage5 = new Stage5();
        stage6 = new Stage6();

        setLayout(null);

        // Stage4 버튼
        buttons[0].setBounds(100, 100, 150, 50);
        add(buttons[0]);
        buttons[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InGame inGame = new InGame(stage4.getMonsters());
                gameFrame.setPanel(inGame);
            }
        });

        // Stage5 버튼
        buttons[1].setBounds(100, 200, 150, 50);
        add(buttons[1]);
        buttons[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InGame inGame = new InGame(stage5.getMonsters());
                gameFrame.setPanel(inGame);
            }
        });

        // Stage6 버튼
        buttons[2].setBounds(100, 300, 150, 50);
        add(buttons[2]);
        buttons[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InGame inGame = new InGame(stage6.getMonsters());
                gameFrame.setPanel(inGame);
            }
        });

        // 돌아가기 버튼
        buttons[3].setBounds(100, 400, 150, 50);
        add(buttons[3]);
        buttons[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameFrame.showCard("Chapter");
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}