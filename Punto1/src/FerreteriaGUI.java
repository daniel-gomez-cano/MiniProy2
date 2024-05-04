import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FerreteriaGUI extends JFrame implements ActionListener{
    JButton quehondapa;

    public FerreteriaGUI(){
        setTitle("Que honda pa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);

        quehondapa = new JButton("quehondapa");
        add(quehondapa,BorderLayout.CENTER);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
