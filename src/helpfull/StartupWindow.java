package helpfull;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class StartupWindow implements ActionListener{
    
	private JButton btn;
	JFrame frame;

    public StartupWindow(){
    	
    	frame = new JFrame("Simple GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btn = new JButton("Open the other JFrame!");
        btn.addActionListener(this);
        btn.setActionCommand("Open");
        frame.add(btn);
        frame.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e){
       
    	String cmd = e.getActionCommand();

        if(cmd.equals("Open")){
            frame.dispose();
            new AnotherJFrame();
        }
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run(){
                new StartupWindow().frame.setVisible(true);
            }
        });
    }
}