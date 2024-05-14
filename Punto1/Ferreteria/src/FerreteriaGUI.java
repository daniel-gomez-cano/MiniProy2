import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.table.TableColumn;

public class FerreteriaGUI extends JFrame {
    private ArrayList<Articulo> articulos;
    private ArticuloTableModel model;
    private JTable table;
    private JButton agregarButton;
    JButton eliminarButton;

    public FerreteriaGUI() {
        setTitle("Ferretería Mi Fierrote");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 400);
        setLayout(new BorderLayout());

        //Label de título (con nombre chistoso(espero)) y demás detalles del programa
        JLabel titulo = new JLabel("Ferretería Mi Fierrote :D", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(Color.BLACK);
        add(titulo, BorderLayout.NORTH);

        //Creación ArrayList la cual inserta los datos del artículo en filas de la tabla
        articulos = new ArrayList<>();
        //Artículos agregados para ejemplo
        articulos.add(new Articulo(1, "Martillo", 15000,54, "Madera","Albañilería","Manualmente","Martillo de goma, ideal para clavar sin dañar las superficies"));
        articulos.add(new Articulo(2, "Tornillo", 3500,100, "Hierro (o derivados)","Albañilería","Martillo","Tornillo perforante de acero inoxidable"));
        articulos.add(new Articulo(3, "Llave Inglesa", 10000,23, "Hierro (o derivados)","Alfarería","Manualmente","Llave inglesa ajustable de 250 mm"));

        model = new ArticuloTableModel(articulos);
        //Creación de Tabla para mostrar artículos
        table = new JTable(model);
        TableColumn columna = null;//Modificación de ancho de columnas, tema diseño
        columna = table.getColumnModel().getColumn(0); //Columna para el ID más estrecha
        columna.setPreferredWidth(50);

        columna = table.getColumnModel().getColumn(3); //Columna para el Stock más estrecha
        columna.setPreferredWidth(50);

        columna = table.getColumnModel().getColumn(4); // Columna para la descripción más ancha
        columna.setPreferredWidth(300);
        
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int clickCount = e.getClickCount();
                int row = table.rowAtPoint(e.getPoint());
        
                if (row != -1) {
                    if (clickCount == 1) {
                        // Seleccionar la fila
                        table.setRowSelectionInterval(row, row);
                    } else if (clickCount == 2) {
                        // Manejar el doble clic
                        Articulo seleccionado = articulos.get(row);
                        mostrarVentanaEmergente(seleccionado);
                    }
                }
            }

            private void mostrarVentanaEmergente(Articulo articulo) {
                JDialog dialog = new JDialog();
                dialog.setTitle("Detalles del artículo");
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setModal(true);
                //Tratepe de usar varios Layour a lo largo del programa para tener variedad
                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margen alrededor del panel

                JLabel materialLabel = new JLabel("Material de elaboración: " + articulo.getMaterial());
                JLabel usoLabel = new JLabel("Ejemplos de uso: " + articulo.getUso());
                JLabel herramientasLabel = new JLabel("Herramientas para su uso: " + articulo.getHerramientas());
                panel.add(materialLabel);
                panel.add(usoLabel);
                panel.add(herramientasLabel);

                dialog.add(panel);
                // Ajustar tamaño del diálogo según su contenido
                dialog.pack();
                // Centrar el diálogo en la pantalla
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            }

        });

        //Creación del scrollPane que contiene la tabla, junto con un Border, el cuál es una margen para la tabla
        Border border = BorderFactory.createEmptyBorder(50, 10, 10, 20); // Arriba, Izquierda, Abajo, Derecha
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(border);
        add(scrollPane, BorderLayout.CENTER);

        //Creación de Botón para agregar artículo, el cual despliega una ventana para definir el nuevo producto
        agregarButton = new JButton("Agregar artículo");
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AgregarArticuloDialog(FerreteriaGUI.this, articulos, model);
            }
        });

        //Creación de Botón para eliminar artículo, el cual al seleccionar una fila en la tabla y al dar click en el botón, el artículo se elimina
        eliminarButton = new JButton("Eliminar");
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();

                if (row != -1) {
                    Articulo seleccionado = articulos.remove(row);
                    model.fireTableRowsDeleted(row, row);
                } else {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar un artículo para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //Creación de Botón para editar artículo, el cual al seleccionar una fila en la tabla y al dar click en el botón,
        //Se abre una ventana para editar los valores del producto, excepto el ID ya que es único
        JButton editarButton = new JButton("Editar");
        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();

                if (row != -1) {
                    Articulo seleccionado = articulos.get(row);
                    new EditarArticuloDialog(FerreteriaGUI.this, seleccionado, articulos, model);
                } else {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar un artículo para editar.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(agregarButton);
        buttonPanel.add(eliminarButton);
        buttonPanel.add(editarButton);
        add(buttonPanel, BorderLayout.SOUTH);
        add(buttonPanel, BorderLayout.SOUTH);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FerreteriaGUI().setVisible(true);
            }
        });
    }
}