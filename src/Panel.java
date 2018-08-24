import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Panel extends JPanel {

    private JButton numbers[] = new JButton[10];
    private Font font = new Font("SanSerif", Font.BOLD, 20);
    private JTextField output = new JTextField();
    private JButton backspace = new JButton("<");
    private JButton equ = new JButton("=");
    private JButton plus = new JButton("+");
    private JButton minus = new JButton("-");
    private JButton multiple = new JButton("*");
    private JButton divide = new JButton("/");


    public Panel() {
        setLayout(null);
        setFocusable(true);
        grabFocus();

        plus.setBounds(190, 70, 50, 50);
        plus.setFont(font);
        add(plus);

        minus.setBounds(190, 130, 50, 50);
        minus.setFont(font);
        add(minus);

        multiple.setBounds(190, 190, 50, 50);
        multiple.setFont(font);
        add(multiple);

        divide.setBounds(190, 250, 50, 50);
        divide.setFont(font);
        add(divide);

        equ.setBounds(130, 250, 50, 50);
        equ.setFont(font);
        add(equ);

        backspace.setBounds(10, 250, 50, 50);
        backspace.setFont(font);
        add(backspace);

        numbers[0] = new JButton("0");
        numbers[0].setBounds(70, 250, 50, 50);
        numbers[0].setFont(font);
        add(numbers[0]);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                numbers[j * 3 + i + 1] = new JButton((j * 3 + i + 1) + "");
                numbers[j * 3 + i + 1].setBounds(i * (60) + 10, j * (60) + 70, 50, 50);
                numbers[j * 3 + i + 1].setFont(font);
                add(numbers[j * 3 + i + 1]);
            }
        }

        output.setBounds(10, 10, 220, 50);
        output.setEditable(false);
        output.setFont(font);
        add(output);

        ActionListener l = (ActionEvent e) -> {
            JButton b = (JButton) e.getSource();
            output.setText(output.getText() + b.getText());
        };

        for (JButton b : numbers) {
            b.addActionListener(l);
        }

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                char symbol = e.getKeyChar();
                if (!Character.isDigit(symbol))
                    return;
                output.setText(output.getText() + symbol);
            }
        });
    }
}
