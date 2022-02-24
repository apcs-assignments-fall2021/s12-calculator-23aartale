import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quadratic {

    public JFrame frame;
    public LTPanel aPanel, bPanel, cPanel, answerPanel;
    public JPanel buttonPanel;

    public Quadratic() {
        // Set up the frame
        frame = new JFrame("Quadratic Formula");
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set up and add the panels
        JPanel formulaPanel = new JPanel();
        aPanel = new LTPanel("a =", 10);
        bPanel = new LTPanel("b =", 10);
        cPanel = new LTPanel("c =", 10);
        buttonPanel = new JPanel();
        answerPanel = new LTPanel("Answer:", 10);

        frame.add(formulaPanel);
        frame.add(aPanel);
        frame.add(bPanel);
        frame.add(cPanel);
        frame.add(buttonPanel);
        frame.add(answerPanel);

        // Set up individual panels
        // formulaPanel code
        JLabel formulaLabel = new JLabel("ax^2 + bx + c = 0");
        formulaPanel.add(formulaLabel);

        // buttonPanel code
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                aPanel.setText("");
                bPanel.setText("");
                cPanel.setText("");
            }
        });

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                quadForm();
            }
        });

        buttonPanel.add(clearButton);
        buttonPanel.add(calculateButton);

        // pack and show
        frame.pack();
        frame.setVisible(true);
    }

    public void quadForm() {
        double a = Double.parseDouble(aPanel.getText());
        double b = Double.parseDouble(bPanel.getText());
        double c = Double.parseDouble(cPanel.getText());
        Double ans = (-b + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / 2 * a;
        String answer = "" + ans;
        answerPanel.setText(answer);
    }


    public static void main(String[] args) {
        Quadratic q = new Quadratic();
    }
}
