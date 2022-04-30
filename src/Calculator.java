import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Calculator{



    JTextField operand1,operand2;

    JComboBox<String> operations;

    JButton calculateButton;

    JLabel resultLabel;



    public Calculator() {

        JFrame frame = new JFrame("Calculator");
        operand1 = new JTextField();
        operand2 = new JTextField();
        operations = new JComboBox<>();
        calculateButton = new JButton("Calculate");
        resultLabel = new JLabel("=     Result");


        operand1.setBounds(50,100,100,25);
        operations.setBounds(175,100,100,25);
        operand2.setBounds(300,100,100,25);
        resultLabel.setBounds(425,100,100,25);
        calculateButton.setBounds(50,150,350,25);


        operations.addItem("+");
        operations.addItem("-");
        operations.addItem("x");
        operations.addItem("/");


        calculateButton.addActionListener(e -> calculatorButtonAction(frame));

        frame.add(operand1);
        frame.add(operand2);
        frame.add(operations);
        frame.add(resultLabel);
        frame.add(calculateButton);


        frame.setSize(550,300);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    }

    public void calculatorButtonAction(Frame frame){
        String input1 = operand1.getText();
        String input2 = operand2.getText();

        int i1,i2,r;


        try {

            i1 = Integer.parseInt(input1);
            i2 = Integer.parseInt(input2);
            r = 0;


            switch (Objects.requireNonNull(operations.getSelectedItem()).toString()){

                case "+":
                    r = i1+i2;
                    break;
                case "-":
                    r = i1-i2;
                    break;
                case "x":
                    r = i1*i2;
                    break;
                case "/":
                    r = i1/i2;
                    break;


            }


            resultLabel.setText("=     " + r);

            operand1.setText(null);
            operand2.setText(null);
            operations.setSelectedIndex(0);

        } catch (final NumberFormatException exception) {

            JOptionPane.showMessageDialog(frame, "Inputs should be an integer.", "Error", JOptionPane.ERROR_MESSAGE);
            operand1.setText(null);
            operand2.setText(null);
            operations.setSelectedIndex(0);
            resultLabel.setText("=     Result");

        }


    }

}
