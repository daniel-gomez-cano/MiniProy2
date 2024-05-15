import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
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
        JMenuItem Undo = new JMenuItem("Undo");
        JMenuItem Redo = new JMenuItem("Redo");
        JMenuItem Cut = new JMenuItem("Cut");
        JMenuItem Copy = new JMenuItem("Copy");
        JMenuItem Paste = new JMenuItem("Paste");




        JMenu Selection = new JMenu("Selection");
        JMenuItem SelectAll = new JMenuItem("Select All");
        JMenuItem ExpandSelection = new JMenuItem("Expand Selection");
        JMenuItem ShrinkSelection = new JMenuItem("Shrink Selection");
        JMenuItem CopyLineUp = new JMenuItem("Copy Line Up");
        JMenuItem CopyLineDown = new JMenuItem("Copy Line Down");



        JMenu View = new JMenu("View");
        JMenuItem CommandPalette = new JMenuItem("Command Pallette");
        JMenuItem OpenView = new JMenuItem("OpenView");
        JMenu Appearance = new JMenu("Appearance");
        JMenuItem FullScreen = new JMenuItem("Full Screen");
        JMenuItem ZenMode = new JMenuItem("Zen Mode");
        JMenuItem CenteredLayout = new JMenuItem("Centered Layout");
        
        JMenu EditorLayout = new JMenu("Editor Layout");
        JMenuItem SplitUp = new JMenuItem("Split Up");
        JMenuItem SplitDown = new JMenuItem("Split Down");
        JMenuItem SplitLeft = new JMenuItem("Split Left");

        JMenuItem ExplorerView = new JMenuItem("Explorer");



        JMenu Go = new JMenu("Go");
        JMenuItem Back = new JMenuItem("Back");
        JMenuItem Forward = new JMenuItem("Forward");
        JMenuItem LastEditLocation = new JMenuItem("Last Edit Location");

        JMenu SwitchEditor = new JMenu("Switch Editor");
        JMenuItem NextEditor = new JMenuItem("Next Editor");
        JMenuItem PreviusEditor= new JMenuItem("Previus Editor");
        JMenuItem NextUsedEditor= new JMenuItem("Next Used Editor");

        JMenu SwitchGroup = new JMenu("Switch Group");
        JMenuItem Group1 = new JMenuItem("Group 1");
        JMenuItem Group2 = new JMenuItem("Group 2");
        JMenuItem Group3 = new JMenuItem("Group 3");



        JMenu Run = new JMenu("Run");
        JMenuItem Debug = new JMenuItem("Start Debugging");
        JMenuItem Debugnt = new JMenuItem("Run Without Debugging");
        JMenuItem StopDebug = new JMenuItem("Stop Debugging");
        JMenuItem RestartDebug = new JMenuItem("Restart Debugging");
        JMenuItem OpenConfig = new JMenuItem("Open Configurations");


        JMenu Terminal = new JMenu("Terminal");
        JMenuItem NewTerm = new JMenuItem("New Terminal");
        JMenuItem SplitTerm = new JMenuItem("Split Terminal");
        JMenuItem RunTask= new JMenuItem("Run Task");
        JMenuItem RunBuildTask = new JMenuItem("Run Build Task");
        JMenuItem RunActiveFile = new JMenuItem("Run Active File");




        JMenu Help = new JMenu("Help");
        JMenuItem Welcome = new JMenuItem("Welcome");
        JMenuItem ShowComands= new JMenuItem("Show All Commands");
        JMenuItem Docum = new JMenuItem("Documentation");
        JMenuItem EditorPlayG= new JMenuItem("Editor Playground");
        JMenuItem ShowReleaseNotes = new JMenuItem("Show Release Notes");


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
        AutoSave.setBackground(submenuColor);


        Edit.setForeground(Color.LIGHT_GRAY);
        Undo.setBackground(submenuColor);
        Redo.setBackground(submenuColor);
        Cut.setBackground(submenuColor);
        Copy.setBackground(submenuColor);
        Paste.setBackground(submenuColor);

        Selection.setForeground(Color.LIGHT_GRAY);
        SelectAll.setBackground(submenuColor);
        ExpandSelection.setBackground(submenuColor);
        ShrinkSelection.setBackground(submenuColor);
        CopyLineUp.setBackground(submenuColor);
        CopyLineDown.setBackground(submenuColor);

        View.setForeground(Color.LIGHT_GRAY);
        CommandPalette.setBackground(submenuColor);
        OpenView.setBackground(submenuColor);

        Appearance.setBackground(submenuColor);
        FullScreen.setBackground(submenuColor);
        ZenMode.setBackground(submenuColor);
        CenteredLayout.setBackground(submenuColor);

        EditorLayout.setBackground(submenuColor);
        SplitUp.setBackground(submenuColor);
        SplitDown.setBackground(submenuColor);
        SplitLeft.setBackground(submenuColor);

        ExplorerView.setBackground(submenuColor);
        
        Go.setForeground(Color.LIGHT_GRAY);
        Back.setBackground(submenuColor);
        Forward.setBackground(submenuColor);
        LastEditLocation.setBackground(submenuColor);

        SwitchEditor.setBackground(submenuColor);
        NextEditor.setBackground(submenuColor);
        PreviusEditor.setBackground(submenuColor);
        NextUsedEditor.setBackground(submenuColor);

        SwitchGroup.setBackground(submenuColor);
        Group1.setBackground(submenuColor);
        Group2.setBackground(submenuColor);
        Group3.setBackground(submenuColor);
        
        Run.setForeground(Color.LIGHT_GRAY);
        Debug.setBackground(submenuColor);
        Debugnt.setBackground(submenuColor);
        StopDebug.setBackground(submenuColor);
        RestartDebug.setBackground(submenuColor);
        OpenConfig.setBackground(submenuColor);

        
        Terminal.setForeground(Color.LIGHT_GRAY);
        NewTerm.setBackground(submenuColor);
        SplitTerm.setBackground(submenuColor);
        RunTask.setBackground(submenuColor);
        RunBuildTask.setBackground(submenuColor);
        RunActiveFile.setBackground(submenuColor);
        
        Help.setForeground(Color.LIGHT_GRAY);
        Welcome.setBackground(submenuColor);
        ShowComands.setBackground(submenuColor);
        Docum.setBackground(submenuColor);
        EditorPlayG.setBackground(submenuColor);
        ShowReleaseNotes.setBackground(submenuColor);

        //agrego los items de File
        File.add(NewTextFile);
        File.add(NewFile);
        File.add(NewWindow);
        File.add(new JSeparator());//linea horizontal de separacion
        File.add(OpenFile);
        File.add(OpenFolder);
        File.add(OpenWorkSpacefromfile);
        OpenRecent.add(ReopenClosed);
        OpenRecent.add(new JSeparator());
        OpenRecent.add(More);
        OpenRecent.add(new JSeparator());
        OpenRecent.add(ClearRecently);
        File.add(OpenRecent);
        File.add(new JSeparator());
        File.add(AddFolder);
        File.add(Saveworkspace);
        File.add(Duplicateworkspace);
        File.add(new JSeparator());
        File.add(Save);
        File.add(SaveAs);
        File.add(SaveAll);
        File.add(new JSeparator());
        File.add(Share);
        Share.add(ExportProfile);
        Share.add(ImportProfile);
        File.add(new JSeparator());
        File.add(AutoSave);

        //Agrego Items de edit
        Edit.add(Undo);
        Edit.add(Redo);
        Edit.add(new JSeparator());
        Edit.add(Cut);
        Edit.add(Copy );
        Edit.add(Paste);

        //Agrego Items de Selection
        Selection.add(SelectAll);
        Selection.add(ExpandSelection);
        Selection.add(ShrinkSelection);
        Selection.add(new JSeparator());
        Selection.add(CopyLineUp);
        Selection.add(CopyLineDown);

        //Agrego Items de View
        View.add(CommandPalette);
        View.add(OpenView);
        View.add(new JSeparator());

        View.add(Appearance);
        Appearance.add(FullScreen);
        Appearance.add(ZenMode);
        Appearance.add(CenteredLayout);

        View.add(EditorLayout);
        EditorLayout.add(SplitUp);
        EditorLayout.add(SplitDown);
        EditorLayout.add(SplitLeft);

        View.add(new JSeparator());
        View.add(ExplorerView);

        //Agrego Items de Go
        Go.add(Back);
        Go.add(Forward);
        Go.add(LastEditLocation);
        Go.add(new JSeparator());

        Go.add(SwitchEditor);
        SwitchEditor.add(NextEditor);
        SwitchEditor.add(PreviusEditor);
        SwitchEditor.add(new JSeparator());
        SwitchEditor.add(NextUsedEditor);

        Go.add(SwitchGroup);
        SwitchGroup.add(Group1);
        SwitchGroup.add(Group2);
        SwitchGroup.add(Group3);

        //Agrego Items de Run
        Run.add(Debug);
        Run.add(Debugnt);
        Run.add(StopDebug);
        Run.add(RestartDebug);
        Run.add(new JSeparator());
        Run.add(OpenConfig);

        //Agrego Items de Terminal
        Terminal.add(NewTerm);
        Terminal.add(SplitTerm);
        Terminal.add(new JSeparator());
        Terminal.add(RunTask);
        Terminal.add(RunBuildTask);
        Terminal.add(RunActiveFile);

        //Agrego Items de Help
        Help.add(Welcome);
        Help.add(ShowComands);
        Help.add(Docum);
        Help.add(EditorPlayG);
        Help.add(ShowReleaseNotes);

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
        barraInferior.setPreferredSize(new Dimension(contenedorPrincipal.getWidth(), 20));
        barraInferior.setBackground(HyperDarkGray);
        barraInferior.setBorder(border);
        contenedorPrincipal.add(barraInferior, BorderLayout.SOUTH);
        
        barraInferior.setLayout(new BoxLayout(barraInferior, BoxLayout.X_AXIS));
        JLabel Warning = new JLabel(new ImageIcon("Punto3/Images/Captura de pantalla 2024-05-15 141802.png"));
        JLabel Warningnumber = new JLabel("0 ");
        Warningnumber.setForeground(Color.WHITE);
        JLabel Warning2 = new JLabel(new ImageIcon("Punto3/Images/Captura de pantalla 2024-05-15 141819.png"));
        JLabel Warning2number = new JLabel("0     ");
        Warning2number.setForeground(Color.WHITE);
        JLabel Ports = new JLabel(new ImageIcon("Punto3/Images/Captura de pantalla 2024-05-15 141829.png"));
        JLabel Portsnumber = new JLabel("0     ");
        Portsnumber.setForeground(Color.WHITE);
        JLabel Notifications = new JLabel(new ImageIcon("Punto3/Images/Captura de pantalla 2024-05-14 162058.png"));
        
        barraInferior.add(Warning);
        barraInferior.add(Warningnumber);
        barraInferior.add(Warning2);
        barraInferior.add(Warning2number);
        barraInferior.add(Ports);
        barraInferior.add(Portsnumber);
        JPanel barraInferior_Izq = new JPanel();
        barraInferior_Izq.setLayout(new BorderLayout());
        barraInferior_Izq.setBackground(HyperDarkGray);
        barraInferior.add(barraInferior_Izq);
        barraInferior_Izq.add(Notifications, BorderLayout.EAST);

        JPanel contenedorIzquieda = new JPanel();
        contenedorIzquieda.setLayout(new GridLayout(1,2));

        JPanel barraIzquierda_1 = new JPanel();
        barraIzquierda_1.setPreferredSize(new Dimension(45, contenedorIzquieda.getHeight()));
        barraIzquierda_1.setBackground(HyperDarkGray);
        barraIzquierda_1.setBorder(border);
        contenedorIzquieda.add(barraIzquierda_1);
        barraIzquierda_1.setLayout(new BoxLayout(barraIzquierda_1, BoxLayout.Y_AXIS));
        
        JLabel Explorer = new JLabel(new ImageIcon(new ImageIcon("Punto3/Images/Captura de pantalla 2024-05-14 142046.png").getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH)));
        JLabel Search = new JLabel(new ImageIcon(new ImageIcon("Punto3/Images/Captura de pantalla 2024-05-14 142053.png").getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH)));
        JLabel Source = new JLabel(new ImageIcon(new ImageIcon("Punto3/Images/Captura de pantalla 2024-05-14 142103.png").getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH)));
        JLabel RaD = new JLabel(new ImageIcon(new ImageIcon("Punto3/Images/Captura de pantalla 2024-05-14 142109.png").getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH)));
        JLabel Extencion = new JLabel(new ImageIcon(new ImageIcon("Punto3/Images/Captura de pantalla 2024-05-14 142118.png").getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH)));
        JLabel Testing = new JLabel(new ImageIcon(new ImageIcon("Punto3/Images/Captura de pantalla 2024-05-14 142128.png").getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH)));
        JLabel Account = new JLabel(new ImageIcon(new ImageIcon("Punto3/Images/Captura de pantalla 2024-05-14 162002.png").getImage().getScaledInstance(35, 70, Image.SCALE_SMOOTH)));
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
