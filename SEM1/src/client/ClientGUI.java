package client;

import server.ServerWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ClientGUI extends JFrame {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 630;
    JTextField IP, PORT, LOGIN, messageCLient;
    JPasswordField PASSWORD;
    JButton btnloginClient, btnsendMessage;

    public ClientGUI(ServerWindow serverWindow) {
        setTitle("Chat Client");
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);


        //Создаем верхнюю часть экрана
        // Создаю текстовые поля
        IP = new JTextField(15);
        IP.setToolTipText("Ip");

        PORT = new JTextField(15);
        PORT.setToolTipText("port");

        LOGIN = new JTextField(15);
        LOGIN.setToolTipText("login");

        JPasswordField PASSWORD = new JPasswordField(12);
        PASSWORD.setToolTipText("password");
        PASSWORD.setEchoChar('*');

        // Создали кнопку
        JButton btnloginClient = new JButton("Login");

        // Лейбл для диалога
        JLabel htmlLabel = new JLabel();

        //Создаем слушателя кнопки
        btnloginClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String messages = readDialogLog();
                htmlLabel.setText(messages);
            }
        });

        JPanel htmlPanel = new JPanel();
        htmlPanel.add(htmlLabel);

        // Создаем панель и добавляем виджеты
        JPanel panTop = new JPanel(new GridLayout(2,3));
        panTop.add(IP);
        panTop.add(PORT);
        panTop.add(LOGIN);
        panTop.add(PASSWORD);
        panTop.add(btnloginClient);

        //Создаем нижнюю часть окна
        messageCLient = new JTextField(50);
        messageCLient.setToolTipText("Message");

        btnsendMessage = new JButton("Send");
        btnsendMessage.setToolTipText("message");

        btnsendMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                writeDialogLog(messageCLient.getText(), LOGIN.getText());
                String messages = readDialogLog();
                htmlLabel.setText(messages);
            }
        });

        JPanel panBottom = new JPanel(new GridLayout(1,2));
        panBottom.add(messageCLient);
        panBottom.add(btnsendMessage);





        // Добавиление в итоговое окно
        add(htmlPanel, BorderLayout.CENTER);
        add(panTop, BorderLayout.NORTH);
        add(panBottom, BorderLayout.SOUTH);
        setVisible(true);

    }

    public String readDialogLog(){
       String messages = "<html>";
        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\AllPrograming\\DevelopmentKit\\SEM2\\src\\server\\log.txt"))){
            String line;
            while ((line = reader.readLine()) != null) {
                messages = messages + line + "<br>";
            }
        } catch (FileNotFoundException e) {
            e.getMessage();
        } catch (IOException e) {
            e.getMessage();
        }
        messages = messages + "</html>";
        return messages;
    }

    public void writeDialogLog(String message, String authorMessage){
        try (FileWriter writer = new FileWriter("D:\\AllPrograming\\DevelopmentKit\\SEM2\\src\\server\\log.txt", true)) {
            writer.write(authorMessage + ": " + message + "<br>");
        } catch (IOException e) {
            e.getMessage();
        }
    }



}
