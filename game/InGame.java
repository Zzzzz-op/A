package game;

import game.monster.Monster;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InGame extends JPanel {
    private Monster[] monsters;
    private JButton clearButton;
    private JButton backButton;
    private Runnable onStageCleared;

    public InGame(Monster[] monsters) {
        this.monsters = monsters;
        this.onStageCleared = onStageCleared;
        setLayout(new BorderLayout());


        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("SansSerif", Font.PLAIN, 20));
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // 몬스터 출력
        StringBuilder sb = new StringBuilder("이 스테이지의 몬스터들:\n\n");
        for (Monster monster : monsters) {
            sb.append(monster.getName()).append("\n");
        }
        textArea.setText(sb.toString());


        JPanel buttonPanel = new JPanel(new FlowLayout());


        // 돌아가기 버튼
        backButton = new JButton("돌아가기");
        buttonPanel.add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(InGame.this);
                if (frame instanceof GameFrame) {
                    ((GameFrame) frame).showCard("Chapter1Stage");
                }
            }
        });

        add(buttonPanel, BorderLayout.SOUTH);
    }
}