import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FerreteriaGUI extends JFrame {

    JButton boton1;

    public FerreteriaGUI(){
        setTitle("Ferreteria buena honda");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200,200);

        boton1 = new JButton("que honda pa");
        add(boton1, BorderLayout.CENTER);
        
        boton1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "que honda pa", "hola pa",JOptionPane.INFORMATION_MESSAGE);
            }
            
        });
    }
}
