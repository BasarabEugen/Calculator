import javax.swing.*;

public class MainCalc {
private JFrame window;

public MainCalc(){
    window = new JFrame("Calculator");
    window.setSize(265,350);
    window.add(new Panel());
    window.setLocationRelativeTo(null);
    window.setResizable(false);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setVisible(true);
}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainCalc();
            }
        });
    }
}
