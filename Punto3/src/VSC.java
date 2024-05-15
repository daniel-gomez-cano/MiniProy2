import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class VSC extends JFrame {
    Container contenedorPrincipal;

    public VSC(){
        contenedorPrincipal = getContentPane();
        BorderLayout borderLayout = new BorderLayout();
        contenedorPrincipal.setLayout(borderLayout);
        JLabel WaterM = new JLabel(new ImageIcon(new ImageIcon("Punto3/Images/Captura_de_pantalla_2024-05-14_141632-removebg-preview.png").getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH)));
        contenedorPrincipal.add(WaterM);
        //Estetica General
        Color HyperDarkGray = new Color(24, 24, 24);
        Color submenuColor = Color.LIGHT_GRAY;
        Border border = BorderFactory.createLineBorder(Color.DARK_GRAY, 1);
        JSeparator separador = new JSeparator();

        getContentPane().setBackground(Color.DARK_GRAY);
        
        //Se crea una barra para simular la barra de tareas
        // el JMenu y JMenuItem Sirven para simular las opciones en la barra
        JMenuBar barra = new JMenuBar();
        barra.setBorder(border);
        ImageIcon imagenlogo = new ImageIcon(new ImageIcon("Punto3/Images/visual-studio-code-logo.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        JLabel logo = new JLabel(imagenlogo);
        JLabel Arrows = new JLabel(new ImageIcon(new ImageIcon("Punto3/Images/Captura de pantalla 2024-05-14 153240.png").getImage().getScaledInstance(50, 25, Image.SCALE_SMOOTH)));
        JTextField Buscador = new JTextField(25);
        Buscador.setBackground(Color.gray);
        Buscador.setPreferredSize(new Dimension(10,25));
        JLabel Toggles = new JLabel(new ImageIcon(new ImageIcon("Punto3/Images/Captura de pantalla 2024-05-14 161540.png").getImage().getScaledInstance(150, 25, Image.SCALE_SMOOTH)));
        
        JMenu File = new JMenu("File");
        JMenuItem NewTextFile = new JMenuItem("New Text File");
        JMenuItem NewFile = new JMenuItem("New File...");
        JMenuItem NewWindow = new JMenuItem("New Window");
        JMenuItem OpenFile = new JMenuItem("Open File");
        JMenuItem OpenFolder = new JMenuItem("Open Folder");
        JMenuItem OpenWorkSpacefromfile = new JMenuItem("Open Workspace from file");
        JMenu  OpenRecent = new JMenu("Open Recent");
        JMenuItem ReopenClosed = new JMenuItem("Reopen Closed Editor");
        JMenuItem More = new JMenuItem("More...");
        JMenuItem ClearRecently = new JMenuItem("Clear Recently Open");
        JMenuItem AddFolder = new JMenuItem("Add Folder to workSpace");
        JMenuItem Saveworkspace = new JMenuItem("Save Workspace as...");
        JMenuItem Duplicateworkspace = new JMenuItem("Duplicate Workspace");
        JMenuItem Save = new JMenuItem("Save");
        JMenuItem SaveAs = new JMenuItem("Save as");
        JMenuItem SaveAll = new JMenuItem("Save all");
        JMenu Share = new JMenu("Share");
        JMenuItem ExportProfile = new JMenuItem("Export Profile (Default)");
        JMenuItem ImportProfile = new JMenuItem("Import Profile");
        JMenuItem AutoSave = new JMenuItem("Auto Save");



        JMenu Edit = new JMenu("Edit");

        JMenu Selection = new JMenu("Selection");

        JMenu View = new JMenu("View");

        JMenu Go = new JMenu("Go");

        JMenu Run = new JMenu("Run");

        JMenu Terminal = new JMenu("Terminal");

        JMenu Help = new JMenu("Help");

        //Elementos de la barra superior
        barra.setBackground(HyperDarkGray);


        File.setForeground(submenuColor);
        NewTextFile.setBackground(submenuColor);
        NewFile.setBackground(submenuColor);
        NewWindow.setBackground(submenuColor);
        OpenFile.setBackground(submenuColor);
        OpenFolder.setBackground(submenuColor);
        OpenWorkSpacefromfile.setBackground(submenuColor);
        OpenRecent.setBackground(submenuColor);
        ReopenClosed.setBackground(submenuColor);
        More.setBackground(submenuColor);
        ClearRecently.setBackground(submenuColor);
        AddFolder.setBackground(submenuColor);
        Saveworkspace.setBackground(submenuColor);
        Duplicateworkspace.setBackground(submenuColor);
        Save.setBackground(submenuColor);
        SaveAs.setBackground(submenuColor);
        SaveAll.setBackground(submenuColor);
        Share.setBackground(submenuColor);
        ExportProfile.setBackground(submenuColor);
        ImportProfile.setBackground(submenuColor);

        Edit.setForeground(Color.LIGHT_GRAY);

        Selection.setForeground(Color.LIGHT_GRAY);

        View.setForeground(Color.LIGHT_GRAY);
        
        Go.setForeground(Color.LIGHT_GRAY);
        
        Run.setForeground(Color.LIGHT_GRAY);
        
        Terminal.setForeground(Color.LIGHT_GRAY);
        
        Help.setForeground(Color.LIGHT_GRAY);

        //agrego los items de File
        File.add(NewTextFile);
        File.add(NewFile);
        File.add(NewWindow);
        File.add(separador);//linea horizontal de separacion
        File.add(OpenFile);
        File.add(OpenFolder);
        File.add(OpenWorkSpacefromfile);
        OpenRecent.add(ReopenClosed);
        OpenRecent.add(separador);
        OpenRecent.add(More);
        OpenRecent.add(separador);
        OpenRecent.add(ClearRecently);
        File.add(OpenRecent);
        File.add(separador);
        File.add(AddFolder);
        File.add(Saveworkspace);
        File.add(Duplicateworkspace);
        File.add(separador);
        File.add(Save);
        File.add(SaveAs);
        File.add(SaveAll);
        File.add(separador);
        File.add(Share);
        Share.add(ExportProfile);
        Share.add(ImportProfile);
        File.add(separador);
        File.add(AutoSave);

        //empiezo a agregar los componentes
        barra.add(logo);
        barra.add(File);
        barra.add(Edit);
        barra.add(Selection);
        barra.add(View);
        barra.add(Go);
        barra.add(Run);
        barra.add(Terminal);
        barra.add(Help);
        barra.add(Arrows);
        barra.add(Buscador);
        barra.add(Toggles);


        JPanel barraInferior = new JPanel();
        barraInferior.setPreferredSize(new Dimension(contenedorPrincipal.getWidth(), 15));
        barraInferior.setBackground(HyperDarkGray);
        barraInferior.setBorder(border);
        contenedorPrincipal.add(barraInferior, BorderLayout.SOUTH);

        JPanel contenedorIzquieda = new JPanel();
        contenedorIzquieda.setLayout(new GridLayout(1,2));

        JPanel barraIzquierda_1 = new JPanel();
        barraIzquierda_1.setPreferredSize(new Dimension(45, contenedorIzquieda.getHeight()));
        barraIzquierda_1.setBackground(HyperDarkGray);
        barraIzquierda_1.setBorder(border);
        contenedorIzquieda.add(barraIzquierda_1);
        barraIzquierda_1.setLayout(new BoxLayout(barraIzquierda_1, BoxLayout.Y_AXIS));
        
        JLabel Explorer = new JLabel(new ImageIcon(new ImageIcon("Punto3/Images/Captura de pantalla 2024-05-14 142046.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
        JLabel Search = new JLabel(new ImageIcon(new ImageIcon("Punto3/Images/Captura de pantalla 2024-05-14 142053.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
        JLabel Source = new JLabel(new ImageIcon(new ImageIcon("Punto3/Images/Captura de pantalla 2024-05-14 142103.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
        JLabel RaD = new JLabel(new ImageIcon(new ImageIcon("Punto3/Images/Captura de pantalla 2024-05-14 142109.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
        JLabel Extencion = new JLabel(new ImageIcon(new ImageIcon("Punto3/Images/Captura de pantalla 2024-05-14 142118.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
        JLabel Testing = new JLabel(new ImageIcon(new ImageIcon("Punto3/Images/Captura de pantalla 2024-05-14 142128.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
        JLabel Account = new JLabel(new ImageIcon(new ImageIcon("Punto3/Images/Captura de pantalla 2024-05-14 162002.png").getImage().getScaledInstance(40, 80, Image.SCALE_SMOOTH)));
        barraIzquierda_1.add(Explorer);
        barraIzquierda_1.add(Search);
        barraIzquierda_1.add(Source);
        barraIzquierda_1.add(RaD);
        barraIzquierda_1.add(Extencion);
        barraIzquierda_1.add(Testing);

        JPanel barraIzquierda_1Inf = new JPanel();
        barraIzquierda_1Inf.setLayout(new BorderLayout());
        barraIzquierda_1Inf.setBackground(HyperDarkGray);
        barraIzquierda_1.add(barraIzquierda_1Inf);
        barraIzquierda_1Inf.add(Account, BorderLayout.SOUTH);
        

        JPanel barraIzquierda_2 = new JPanel();
        barraIzquierda_2.setPreferredSize(new Dimension(45, contenedorIzquieda.getHeight()));
        barraIzquierda_2.setBackground(HyperDarkGray);
        barraIzquierda_2.setBorder(border);
        contenedorIzquieda.add(barraIzquierda_2);

        contenedorPrincipal.add(contenedorIzquieda, BorderLayout.WEST);



        setJMenuBar(barra);
        setSize(1000,600);
        setTitle("Visual GUI");
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    
}
