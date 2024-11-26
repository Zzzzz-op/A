package game;
import java.awt.Image;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import game.stage.Stage1;
import game.stage.Stage2;
import game.stage.Stage3;

public class Chapter1Stage extends JPanel {
    private GameFrame gameFrame;
    private JButton[] buttons = {
            new JButton("Stage 1"),
            new JButton("Stage 2"),
            new JButton("Stage 3"),
            new JButton("돌아가기")
    };
    private Stage1 stage1;
    private Stage2 stage2;
    private Stage3 stage3;
    private Image backgroundImage;

    public Chapter1Stage(GameFrame gameFrame) {
        this.gameFrame = gameFrame;

        backgroundImage = new ImageIcon("/images/Stage1Background.png").getImage();

        // 스테이지 객체 생성
        stage1 = new Stage1();
        stage2 = new Stage2();
        stage3 = new Stage3();

        setLayout(null);

        // Stage1 버튼
        buttons[0].setBounds(100, 100, 150, 50);
        add(buttons[0]);
        buttons[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InGame inGame = new InGame(stage1.getMonsters());
                gameFrame.setPanel(inGame);
            }
        });

        // Stage2 버튼
        buttons[1].setBounds(100, 200, 150, 50);
        add(buttons[1]);
        buttons[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InGame inGame = new InGame(stage2.getMonsters());
                gameFrame.setPanel(inGame);
            }
        });

        // Stage3 버튼
        buttons[2].setBounds(100, 300, 150, 50);
        add(buttons[2]);
        buttons[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InGame inGame = new InGame(stage3.getMonsters());
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