package helpfull;

import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AnotherJFrame{
    
	JFrame frame;
	private JButton button; 
	
	public AnotherJFrame(){
		frame = new JFrame("Another GUI");
		
		button = new JButton("on");
		frame.add(new JLabel("Empty JFrame"));
		frame.add(button);

        frame.setSize(200, 200);
       // frame.pack();
        frame.setVisible(true);
    }
}