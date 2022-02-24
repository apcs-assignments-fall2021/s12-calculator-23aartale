import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    // Swing instance variables
    JFrame frame;
    JTextField field1;
    JPanel panel1, panel2, panel3, panel4, panel5;
    JButton button1, button2, button3, button4, button5,
            button6, button7, button8, button9, button0,
            buttonDivide, buttonTimes, buttonMinus, buttonPlus,
            buttonClear, buttonEquals, buttonSqrt, buttonPow, buttonSqrty, buttonFact;

    // Instance variables that will be used for our math
    String op;
    int arg1;

    public Calculator() {
        // 1. Create the frame (the window that will pop up)
        frame = new JFrame("Calculator");
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        // 2. Choose what happens when you click the exit button
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 3. Create components and put them in the frame
        field1 = new JTextField(15);
        field1.setHorizontalAlignment(SwingConstants.RIGHT);

        panel1 = new JPanel();
        button7 = new JButton("7");
        panel1.add(button7);
        button8 = new JButton("8");
        panel1.add(button8);
        button9 = new JButton("9");
        panel1.add(button9);
        buttonDivide = new JButton("/");
        panel1.add(buttonDivide);

        panel2 = new JPanel();
        button4 = new JButton("4");
        panel2.add(button4);
        button5 = new JButton("5");
        panel2.add(button5);
        button6 = new JButton("6");
        panel2.add(button6);
        buttonTimes = new JButton("*");
        panel2.add(buttonTimes);

        panel3 = new JPanel();
        button1 = new JButton("1");
        panel3.add(button1);
        button2 = new JButton("2");
        panel3.add(button2);
        button3 = new JButton("3");
        panel3.add(button3);
        buttonMinus = new JButton("-");
        panel3.add(buttonMinus);

        panel4 = new JPanel();
        button0 = new JButton("0");
        panel4.add(button0);
        buttonClear = new JButton("AC");
        panel4.add(buttonClear);
        buttonEquals = new JButton("=");
        panel4.add(buttonEquals);
        buttonPlus = new JButton("+");
        panel4.add(buttonPlus);

        panel5 = new JPanel();
        buttonSqrt = new JButton("sqrt");
        panel5.add(buttonSqrt);
        buttonPow = new JButton("Pow");
        panel5.add(buttonPow);
        buttonSqrty = new JButton("sqrty");
        panel5.add(buttonSqrty);
        buttonFact = new JButton("Fact");
        panel5.add(buttonFact);



        // Add implemented actionListener method to each button
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);
        button9.addActionListener(this);
        button0.addActionListener(this);
        buttonClear.addActionListener(this);
        buttonDivide.addActionListener(this);
        buttonEquals.addActionListener(this);
        buttonMinus.addActionListener(this);
        buttonPlus.addActionListener(this);
        buttonTimes.addActionListener(this);
        buttonPow.addActionListener(this);
        buttonFact.addActionListener(this);
        buttonSqrt.addActionListener(this);
        buttonSqrty.addActionListener(this);

        // Add panels and everything to the actual frame
        frame.add(field1);
        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.add(panel4);
        frame.add(panel5);

        // 4. Size the frame
        frame.pack();

        // 5. Show the frame
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String buttonName = ae.getActionCommand();

        if ("1234567890".contains(buttonName)){
            field1.setText(field1.getText() + buttonName);
        }

        else if (buttonName.equals("AC")) {
            field1.setText("");
        }

        else if (buttonName.equals("+")){
            op = "+";
            arg1 = Integer.parseInt(field1.getText());
            field1.setText("");
        }

        else if (buttonName.equals("-")){
            op = "-";
            arg1 = Integer.parseInt(field1.getText());
            field1.setText("");
        }

        else if (buttonName.equals("*")){
            op = "*";
            arg1 = Integer.parseInt(field1.getText());
            field1.setText("");
        }

        else if (buttonName.equals("/")){
            op = "/";
            arg1 = Integer.parseInt(field1.getText());
            field1.setText("");
        }

        else if (buttonName.equals("sqrt")){
            arg1 = Integer.parseInt(field1.getText());
            op = "" + Math.sqrt(arg1);
            field1.setText(op);
        }

        else if (buttonName.equals("Pow")){
            op = "Pow";
            arg1 = Integer.parseInt(field1.getText());
            field1.setText("");
        }

        else if (buttonName.equals("sqrty")){
            op = "sqrty";
            arg1 = Integer.parseInt(field1.getText());
            field1.setText("");
        }

        else if (buttonName.equals("Fact")){
            arg1 = Integer.parseInt(field1.getText());
            int arg2 = 1;
            for(int i=1;i<=arg1;i++) {
                arg2 = arg2 * i;
            }
            op = "" + arg2;
                field1.setText(op);
        }

        else if (buttonName.equals("=")){
            if (op.equals("+")) {
                int arg2 = Integer.parseInt(field1.getText());
                String op2 = "" + (arg1 + arg2);
                field1.setText(op2);
            }
            else if (op.equals("-")){
                int arg2 = Integer.parseInt(field1.getText());
                String op2 = "" + (arg1 - arg2);
                field1.setText(op2);
            }
            else if (op.equals("*")){
                int arg2 = Integer.parseInt(field1.getText());
                String op2 = "" + (arg1 * arg2);
                field1.setText(op2);
            }
            else if (op.equals("/")){
                int arg2 = Integer.parseInt(field1.getText());
                String op2 = "" + (arg1 / arg2);
                field1.setText(op2);
            }
            else if (op.equals("Pow")){
                int arg2 = Integer.parseInt(field1.getText());
                String op2 = "" + Math.pow(arg1,arg2);
                field1.setText(op2);
            }
            else if (op.equals("sqrty")){
                int arg2 = Integer.parseInt(field1.getText());
                String op2 = "" + Math.pow(arg1, (1.0/arg2));
                field1.setText(op2);
            }
        }


    }

    public static void main(String[] args) {
        Calculator c = new Calculator();
    }
}
