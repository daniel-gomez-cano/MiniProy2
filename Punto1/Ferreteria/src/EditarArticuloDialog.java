import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Excepciones.EmptyException;
import Excepciones.NegativeStockException;

public class EditarArticuloDialog extends JDialog {
    private Articulo articulo;
    private ArrayList<Articulo> articulos;
    private ArticuloTableModel model;
    private JTextField idField, nombreField, precioField, stockField, materialField, usoField, herramientasField, descripcionField;

    public EditarArticuloDialog(JFrame owner, Articulo articulo, ArrayList<Articulo> articulos, ArticuloTableModel model) {
        super(owner, true);
        this.articulo = articulo;
        this.articulos = articulos;
        this.model = model;

        setTitle("Editar artículo");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        JPanel contentPanel = new JPanel(new GridLayout(9, 2));
        contentPanel.setBorder(new EmptyBorder(10,10,10,10));

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
        herramientasField = new JTextField(articulo.getHerramientas());

        JLabel descripcionLabel = new JLabel("Descripción:");
        descripcionField = new JTextField(articulo.getDescripcion());

        contentPanel.add(idLabel);
        contentPanel.add(idField);
        contentPanel.add(nombreLabel);
        contentPanel.add(nombreField);
        contentPanel.add(precioLabel);
        contentPanel.add(precioField);
        contentPanel.add(stockLabel);
        contentPanel.add(stockField);
        contentPanel.add(materialLabel);
        contentPanel.add(materialField);
        contentPanel.add(usoLabel);
        contentPanel.add(usoField);
        contentPanel.add(herramientasLabel);
        contentPanel.add(herramientasField);
        contentPanel.add(descripcionLabel);
        contentPanel.add(descripcionField);

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
                    String herramientas = herramientasField.getText();
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
