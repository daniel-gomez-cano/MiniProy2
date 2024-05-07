import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
        setLayout(new GridLayout(9, 2));

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

        add(idLabel);
        add(idField);
        add(nombreLabel);
        add(nombreField);
        add(precioLabel);
        add(precioField);
        add(stockLabel);
        add(stockField);
        add(materialLabel);
        add(materialField);
        add(usoLabel);
        add(usoField);
        add(herramientasLabel);
        add(herramientasField);
        add(descripcionLabel);
        add(descripcionField);

        JButton guardarButton = new JButton("Guardar cambios");
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los nuevos datos de los componentes
                int id = Integer.parseInt(idField.getText());
                String nombre = nombreField.getText();
                int precio = Integer.parseInt(precioField.getText());
                int stock = Integer.parseInt(stockField.getText());
                String material = materialField.getText();
                String uso = usoField.getText();
                String herramientas = herramientasField.getText();
                String descripcion = descripcionField.getText();

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
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(guardarButton);
        add(buttonPanel);

        pack();
        setLocationRelativeTo(owner);
        setVisible(true);
    }
}
