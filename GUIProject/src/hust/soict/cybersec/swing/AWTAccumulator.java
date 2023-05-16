package hust.soict.cybersec.swing;
import java.awt.*;
import java.awt.event.*;

public class AWTAccumulator extends Frame {
    
    private TextField tfInput;
    private TextField tfOutput;
    private int sum = 0;

    // Constructor to setup the GUI components and event handlers
    public AWTAccumulator() {
        setLayout(new GridLayout(2,2));

        add(new Label("Enter an Integer: "));

        tfInput = new TextField(10);
        add(tfInput);
        tfInput.addActionListener(new TfInputListener());

        add(new Label("The Accumulated Sum is: "));

        tfOutput = new TextField(10);
        tfOutput.setEditable(false);
        add(tfOutput);

        setTitle("AWT Accumulator");
        setSize(350, 120);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AWTAccumulator();
    }

    private class TfInputListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int numberIn = Integer.parseInt(tfInput.getText());
            sum += numberIn;
            tfInput.setText("");
            tfOutput.setText(sum +"");;
        }
        
    }

}
