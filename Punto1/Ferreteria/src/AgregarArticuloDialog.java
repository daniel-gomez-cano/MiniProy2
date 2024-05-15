import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
//Ya no lo muestro con un grid personalizado, si no con un JPAnel
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

public class AgregarArticuloDialog extends JDialog {
    public AgregarArticuloDialog(JFrame owner, ArrayList<Articulo> articulos, ArticuloTableModel model) {
    super(owner, true);
    setTitle("Agregar nuevo artículo");
    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

    JPanel contentPanel = new JPanel(new GridLayout(15, 3, 5, 5)); // GridLayout(rows, cols, hgap, vgap)
    contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Establecer un margen de 10 píxeles en todos los lados

    // JLabels
    JLabel nombreLabel = new JLabel("Nombre:");
    JLabel idLabel = new JLabel("ID:");
    JLabel precioLabel = new JLabel("Precio:");
    JLabel descripcionLabel = new JLabel("Descripción:");
    JLabel stockLabel = new JLabel("Stock:");
    JLabel materialLabel = new JLabel("Material de elaboración:");
    JLabel usoLabel = new JLabel("Ejemplos de uso:");
    JLabel herramientasLabel = new JLabel("Herramientas para su uso:");

    // JTextFields
    JTextField nombreField = new JTextField(20);
    JTextField idField = new JTextField(20);
    JTextField descripcionField = new JTextField(20);
    JTextField precioField = new JTextField(20);

    // JSpinner
    SpinnerModel stockModel = new SpinnerNumberModel(1, 1, 100, 1);
    JSpinner stockSpinner = new JSpinner(stockModel);

    // CheckBoxes
    JCheckBox hierroCheckBox = new JCheckBox("Hierro (o derivados)");
    JCheckBox gomaCheckBox = new JCheckBox("Goma");
    JCheckBox maderaCheckBox = new JCheckBox("Madera");
    JCheckBox plasticoCheckBox = new JCheckBox("Plástico");

    // ComboBox
    String[] ejemplosUso = {"Marquetería", "Albañilería", "Alfarería", "Fontanería", "Electricidad", "Otros"};
    JComboBox<String> usoComboBox = new JComboBox<>(ejemplosUso);

    // RadioButtons
    ButtonGroup herramientasGroup = new ButtonGroup();
    JRadioButton manualButton = new JRadioButton("Manualmente");
    JRadioButton martilloButton = new JRadioButton("Martillo");
    JRadioButton alicateButton = new JRadioButton("Alicate");
    JRadioButton llavesButton = new JRadioButton("Llaves");
    JRadioButton destornilladoresButton = new JRadioButton("Destornilladores");
    JRadioButton grapadoraButton = new JRadioButton("Grapadora");
    JRadioButton maquinaButton = new JRadioButton("Máquina especial");

    herramientasGroup.add(manualButton);
    herramientasGroup.add(martilloButton);
    herramientasGroup.add(alicateButton);
    herramientasGroup.add(llavesButton);
    herramientasGroup.add(destornilladoresButton);
    herramientasGroup.add(grapadoraButton);
    herramientasGroup.add(maquinaButton);

    // Agregar componentes al panel de contenido
    contentPanel.add(nombreLabel);
    contentPanel.add(nombreField);
    contentPanel.add(idLabel);
    contentPanel.add(idField);
    contentPanel.add(precioLabel);
    contentPanel.add(precioField);
    contentPanel.add(descripcionLabel);
    contentPanel.add(descripcionField);
    contentPanel.add(stockLabel);
    contentPanel.add(stockSpinner);
    contentPanel.add(materialLabel);
    contentPanel.add(hierroCheckBox);
    contentPanel.add(new JLabel()); // Espacio vacío para alinear CheckBoxes
    contentPanel.add(gomaCheckBox);
    contentPanel.add(new JLabel()); // Espacio vacío para alinear CheckBoxes
    contentPanel.add(maderaCheckBox);
    contentPanel.add(new JLabel()); // Espacio vacío para alinear CheckBoxes
    contentPanel.add(plasticoCheckBox);
    contentPanel.add(usoLabel);
    contentPanel.add(usoComboBox);
    contentPanel.add(herramientasLabel);
    contentPanel.add(manualButton);
    contentPanel.add(martilloButton);
    contentPanel.add(alicateButton);
    contentPanel.add(llavesButton);
    contentPanel.add(destornilladoresButton);
    contentPanel.add(grapadoraButton);
    contentPanel.add(maquinaButton);

    // Botón para agregar el artículo
    JButton agregarButton = new JButton("Agregar artículo");
    contentPanel.add(agregarButton,BorderLayout.SOUTH); // Agregar el botón al panel

    // Acción del botón "Agregar artículo"
    agregarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Obtener los datos de los componentes
            try{
            String nombre = nombreField.getText();
            int id = Integer.parseInt(idField.getText());
            int precio = Integer.parseInt(precioField.getText());
            String descripcion = descripcionField.getText();
            int stock = (int) stockSpinner.getValue();
            String material = "";
            if (hierroCheckBox.isSelected()) {
                material += "Hierro (o derivados), ";
            }
            if (gomaCheckBox.isSelected()) {
                material += "Goma, ";
            }
            if (maderaCheckBox.isSelected()) {
                material += "Madera, ";
            }
            if (plasticoCheckBox.isSelected()) {
                material += "Plástico, ";
            }
            String uso = (String) usoComboBox.getSelectedItem();
            String herramientas = "";
            if (manualButton.isSelected()) {
                herramientas = "Manualmente";
            } else if (martilloButton.isSelected()) {
                herramientas = "Martillo";
            } else if (alicateButton.isSelected()) {
                herramientas = "Alicate";
            } else if (llavesButton.isSelected()) {
                herramientas = "Llaves";
            } else if (destornilladoresButton.isSelected()) {
                herramientas = "Destornilladores";
            } else if (grapadoraButton.isSelected()) {
                herramientas = "Grapadora";
            } else if (maquinaButton.isSelected()) {
                herramientas = "Máquina especial";
            }

            // Verificar si el ID ya existe en la lista de artículos
            for (Articulo articulo : articulos) {
                if (articulo.getId() == id) {
                    throw new DuplicateIDException("Ya existe un artículo con el mismo ID.");
                }
            }

            // Crear un nuevo artículo con los datos obtenidos
            Articulo nuevoArticulo = new Articulo(id, nombre,precio, stock, material, uso, herramientas, descripcion);

            // Agregar el nuevo artículo al ArrayList
            articulos.add(nuevoArticulo);

            // Actualizar la JTable
            model.fireTableDataChanged();

            // Cerrar la ventana emergente
            dispose();
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, "Por favor, ingrese números válidos en los campos correspondientes.", "Entrada inválida", JOptionPane.ERROR_MESSAGE);
        }catch(DuplicateIDException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ID duplicado", JOptionPane.ERROR_MESSAGE);
        }
    }
    });

    // Agregar el panel de contenido al diálogo
    getContentPane().add(contentPanel, BorderLayout.CENTER);

    pack();
    setLocationRelativeTo(owner);
    setVisible(true);
}
}
