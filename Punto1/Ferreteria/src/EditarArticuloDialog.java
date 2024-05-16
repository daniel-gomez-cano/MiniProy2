import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Excepciones.EmptyException;
import Excepciones.NegativeStockException;

public class EditarArticuloDialog extends JDialog {
    private Articulo articulo;
    private ArrayList<Articulo> articulos;
    private ArticuloTableModel model;
    private JTextField idField, nombreField, precioField, stockField, materialField, usoField, herramientasField, descripcionField;
    private ButtonGroup herramientasGroup;
    private JRadioButton manualButton, martilloButton, alicateButton, llavesButton, destornilladoresButton, grapadoraButton, maquinaButton;
    private JPanel herramientasPanel;

    public EditarArticuloDialog(JFrame owner, Articulo articulo, ArrayList<Articulo> articulos, ArticuloTableModel model) {
        super(owner, true);
        this.articulo = articulo;
        this.articulos = articulos;
        this.model = model;

        setTitle("Editar artículo");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField(String.valueOf(articulo.getId()));
        idField.setEditable(false);

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreField = new JTextField(articulo.getNombre());

        JLabel precioLabel = new JLabel("Precio:");
        precioField = new JTextField(String.valueOf(articulo.getPrecio()));

        JLabel stockLabel = new JLabel("Stock:");
        stockField = new JTextField(String.valueOf(articulo.getStock()));

        JLabel materialLabel = new JLabel("Material de elaboración:");
        materialField = new JTextField(articulo.getMaterial());

        JLabel usoLabel = new JLabel("Ejemplos de uso:");
        usoField = new JTextField(articulo.getUso());

        JLabel herramientasLabel = new JLabel("Herramientas para su uso:");
        herramientasGroup = new ButtonGroup();
        manualButton = new JRadioButton("Manual");
        martilloButton = new JRadioButton("Martillo");
        alicateButton = new JRadioButton("Alicate");
        llavesButton = new JRadioButton("Llaves");
        destornilladoresButton = new JRadioButton("Destornilladores");
        grapadoraButton = new JRadioButton("Grapadora");
        maquinaButton = new JRadioButton("Máquina");

        herramientasGroup.add(manualButton);
        herramientasGroup.add(martilloButton);
        herramientasGroup.add(alicateButton);
        herramientasGroup.add(llavesButton);
        herramientasGroup.add(destornilladoresButton);
        herramientasGroup.add(grapadoraButton);
        herramientasGroup.add(maquinaButton);

        herramientasPanel = new JPanel(new GridLayout(7, 1));
        herramientasPanel.add(manualButton);
        herramientasPanel.add(martilloButton);
        herramientasPanel.add(alicateButton);
        herramientasPanel.add(llavesButton);
        herramientasPanel.add(destornilladoresButton);
        herramientasPanel.add(grapadoraButton);
        herramientasPanel.add(maquinaButton);

        JLabel descripcionLabel = new JLabel("Descripción:");
        descripcionField = new JTextField(articulo.getDescripcion());

        // Ajustar las restricciones de gbc para cada componente, una cosa muy larga como cojones lo hago más corto
        gbc.gridx = 0;
        gbc.gridy = 0;
        contentPanel.add(idLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5; // Ajustar el ancho relativo del JTextField
        contentPanel.add(idField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        contentPanel.add(nombreLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5; // Ajustar el ancho relativo del JTextField
        contentPanel.add(nombreField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        contentPanel.add(precioLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5; // Ajustar el ancho relativo del JTextField
        contentPanel.add(precioField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        contentPanel.add(stockLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5; // Ajustar el ancho relativo del JTextField
        contentPanel.add(stockField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        contentPanel.add(materialLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5; // Ajustar el ancho relativo del JTextField
        contentPanel.add(materialField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        contentPanel.add(usoLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5; // Ajustar el ancho relativo del JTextField
        contentPanel.add(usoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        contentPanel.add(herramientasLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        contentPanel.add(herramientasPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        contentPanel.add(descripcionLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1; // Ajustar el ancho relativo del JTextField
        contentPanel.add(descripcionField, gbc);

        JButton guardarButton = new JButton("Guardar cambios");
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Obtener los nuevos datos de los componentes
                    int id = Integer.parseInt(idField.getText());
                    String nombre = nombreField.getText();
                    int precio = Integer.parseInt(precioField.getText());
                    int stock = Integer.parseInt(stockField.getText());
                    String material = materialField.getText();
                    String uso = usoField.getText();

                    String herramientas = "";
                    if (manualButton.isSelected()) {
                        herramientas = "Manual";
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
                        herramientas = "Máquina";
                    } 
                    String descripcion = descripcionField.getText();

                    if(stock < 0){
                        throw new NegativeStockException("No se puede tener cantidad en el inventario negativa");
                    }

                    if("".equals(nombre) || "".equals(material) || "".equals(uso) || "".equals(herramientas) || "".equals(descripcion)){
                        //Excepcion que evita campos vacios
                        throw new EmptyException("No dejar ningun espacio vacio");
                    }
                    // Actualizar el objeto Artículo con los nuevos datos
                    articulo.setId(id);
                    articulo.setNombre(nombre);
                    articulo.setPrecio(precio);
                    articulo.setStock(stock);
                    articulo.setMaterial(material);
                    articulo.setUso(uso);
                    articulo.setHerramientas(herramientas);
                    articulo.setDescripcion(descripcion);

                    // Actualizar la fila correspondiente en el JTable
                    int rowIndex = articulos.indexOf(articulo);
                    model.fireTableRowsUpdated(rowIndex, rowIndex);

                    // Cerrar la ventana emergente
                    dispose();
                }catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese números válidos en los campos correspondientes.", "Entrada inválida", JOptionPane.ERROR_MESSAGE);
                } catch (NegativeStockException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Cantidad de inventario invalida", JOptionPane.ERROR_MESSAGE);
                } catch (EmptyException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Campos vacios", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(guardarButton);

        add(contentPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(owner);
        setVisible(true);
    }
}
