import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class VSC extends JFrame {
    Container contenedorPrincipal;

    public VSC(){
        contenedorPrincipal = getContentPane();
        FlowLayout flowLayoutleft = new FlowLayout(FlowLayout.LEFT);

        getContentPane().setBackground(Color.DARK_GRAY);
        
        //Se crea una barra para simular la barra de tareas
        

        // el JMenu y JMenuItem Sirven para simular las opciones en la barra
        JMenuBar barra = new JMenuBar();
        JMenu File = new JMenu("File");
        JMenuItem NewTextFile = new JMenuItem("New Text File");

        
        barra.setBackground(new Color(33,37,42));
        File.setForeground(Color.WHITE);

        //agrego los items de File
        File.add(NewTextFile);
        //empiezo a agregar los componentes
        barra.add(File);
        setJMenuBar(barra);
        setSize(500,300);
        setTitle("Visual GUI");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    
}
