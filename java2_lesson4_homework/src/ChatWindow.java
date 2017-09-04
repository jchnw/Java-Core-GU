import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatWindow extends JFrame {
    public ChatWindow() {
        setTitle("So much chat very window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 1200, 600);
        setVisible(true);
        setResizable(false);
        GridBagLayout gbl = new GridBagLayout();
        setLayout(gbl);
        JTextArea chatArea = new JTextArea();
        JScrollPane jsp = new JScrollPane(chatArea);
        GridBagConstraints constraints = new GridBagConstraints(0,0,GridBagConstraints.REMAINDER,80,1.0,0.8,GridBagConstraints.NORTH,GridBagConstraints.BOTH,new Insets(5,5,0,5),0,0);
        gbl.setConstraints(jsp, constraints);
        add(jsp,constraints);
        chatArea.setBackground(new Color(255, 240, 245));
        GridBagConstraints constraints2 =  new GridBagConstraints(0,81,70,20,1.0,0.02,GridBagConstraints.SOUTHWEST,GridBagConstraints.BOTH,new Insets(0, 5, 5, 0),0,0);
        JTextField userMessage = new JTextField();
        userMessage.setBackground(new Color(217, 250, 241));
        gbl.setConstraints(userMessage, constraints2);
        add(userMessage,constraints2);
        userMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = userMessage.getText();

                chatArea.append(s +"\n");
                userMessage.setText("");
            }
        });

        GridBagConstraints constraints3 =  new GridBagConstraints(71,81,30,20,0.1,0.02,GridBagConstraints.SOUTHEAST,GridBagConstraints.BOTH,new Insets(0, 0, 5, 5),0,0);
        JButton enterButton = new JButton("Ввод");
        gbl.setConstraints(enterButton, constraints3);
        add(enterButton,constraints3);
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = userMessage.getText();
                chatArea.append(s);
                userMessage.setText("");
            }
        });

        setVisible(true);
    }

}
