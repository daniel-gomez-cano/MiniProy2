import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class AgregarArticuloDialog extends JDialog {
    public AgregarArticuloDialog(JFrame owner, ArrayList<Articulo> articulos, ArticuloTableModel model) {
    super(owner, true);
    setTitle("Agregar nuevo artículo");
    setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    setSize(400, 400);
    setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();

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

    // Agregar componentes al contenedor
    gbc.gridx = 0;
    gbc.gridy = 0;
    add(nombreLabel, gbc);
    gbc.gridx = 1;
    add(nombreField, gbc);

    gbc.gridx = 0;
    gbc.gridy = 1;
    add(idLabel, gbc);
    gbc.gridx = 1;
    add(idField, gbc);
    
    gbc.gridx = 0;
    gbc.gridy = 2;
    add(precioLabel,gbc);
    gbc.gridx = 1;
    add(precioField,gbc);

    gbc.gridx = 0;
    gbc.gridy = 3;
    add(descripcionLabel, gbc);
    gbc.gridx = 1;
    add(descripcionField, gbc);

    gbc.gridx = 0;
    gbc.gridy = 4;
    add(stockLabel, gbc);
    gbc.gridx = 1;
    add(stockSpinner, gbc);

    gbc.gridx = 0;
    gbc.gridy = 5;
    add(materialLabel, gbc);
    gbc.gridx = 1;
    add(hierroCheckBox, gbc);
    gbc.gridx = 2;
    add(gomaCheckBox, gbc);
    gbc.gridx = 3;
    add(maderaCheckBox, gbc);
    gbc.gridx = 4;
    add(plasticoCheckBox, gbc);

    gbc.gridx = 0;
    gbc.gridy = 6;
    add(usoLabel, gbc);
    gbc.gridx = 1;
    add(usoComboBox, gbc);

    gbc.gridx = 0;
    gbc.gridy = 7;
    add(herramientasLabel, gbc);
    gbc.gridx = 1;
    add(manualButton, gbc);
    gbc.gridx = 2;
    add(martilloButton, gbc);
    gbc.gridx = 3;
    add(alicateButton, gbc);
    gbc.gridx = 4;
    add(llavesButton, gbc);
    gbc.gridx = 0;
    gbc.gridy = 8;
    add(destornilladoresButton, gbc);
    gbc.gridx = 1;
    add(grapadoraButton, gbc);
    gbc.gridx = 2;
    add(maquinaButton, gbc);

    herramientasGroup.add(manualButton);
    herramientasGroup.add(martilloButton);
    herramientasGroup.add(alicateButton);
    herramientasGroup.add(llavesButton);
    herramientasGroup.add(destornilladoresButton);
    herramientasGroup.add(grapadoraButton);
    herramientasGroup.add(maquinaButton);

    // Botón para agregar el artículo
    JButton agregarButton = new JButton("Agregar artículo");
    gbc.gridx = 1;
    gbc.gridy = 9;
    add(agregarButton, gbc);

    // Acción del botón "Agregar artículo"
    agregarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Obtener los datos de los componentes
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

            // Crear un nuevo artículo con los datos obtenidos
            Articulo nuevoArticulo = new Articulo(id, nombre,precio, stock, material, uso, herramientas, descripcion);

            // Agregar el nuevo artículo al ArrayList
            articulos.add(nuevoArticulo);

            // Actualizar la JTable
            model.fireTableDataChanged();

            // Cerrar la ventana emergente
            dispose();
        }
    });

    pack();
    setLocationRelativeTo(owner);
    setVisible(true);
}


    // Métodos y eventos
}
