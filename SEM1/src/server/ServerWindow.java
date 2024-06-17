package server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerWindow extends JFrame {
    private static final int WIDTH = 530;
    private static final int HEIGHT = 650;

    JButton btnStart, btnStop;

    public ServerWindow() {
        setTitle("Chat Client");
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);


        btnStart = new JButton("start");
        btnStop = new JButton("stop");
        JPanel panBottom = new JPanel(new GridLayout(1,2));
        panBottom.add(btnStart);
        panBottom.add(btnStop);

        add(panBottom, BorderLayout.SOUTH);

        setVisible(true);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(ServerWindow.this,
                        "Сервер запущен");
            }
        });
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(ServerWindow.this,
                        "Сервер отключен");
            }
        });
    }
}
