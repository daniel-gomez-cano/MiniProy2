import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

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

public class FerreteriaGUI extends JFrame {
    private ArrayList<Articulo> articulos;
    private ArticuloTableModel model;
    private JTable table;
    private JButton agregarButton;
    JButton eliminarButton;

    public FerreteriaGUI() {
        setTitle("Ferretería Mi Fierrote");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        //Label de título (con nombre chistoso(espero)) y demás detalles del programa
        JLabel titulo = new JLabel("Ferretería Mi Fierrote", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        add(titulo, BorderLayout.NORTH);

        //Creación ArrayList la cual inserta los datos del artículo en filas de la tabla
        articulos = new ArrayList<>();
        //Artículos agregados para ejemplo
        articulos.add(new Articulo(1, "Martillo", 15000,54, "Madera","Albañilería","Manualmente","Martillo de goma, ideal para clavar sin dañar las superficies"));
        articulos.add(new Articulo(1, "Tornillo", 3500,100, "Hierro (o derivados)","Albañilería","Martillo","Tornillo perforante de acero inoxidable"));
        articulos.add(new Articulo(1, "Llave Inglesa", 10000,23, "Hierro (o derivados)","Alfarería","Manualmente","Llave inglesa ajustable de 250 mm"));

        model = new ArticuloTableModel(articulos);

        table = new JTable(model);
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

                JLabel materialLabel = new JLabel("Material de elaboración: " + articulo.getMaterial());
                JLabel usoLabel = new JLabel("\nEjemplos de uso: " + articulo.getUso());
                JLabel herramientasLabel = new JLabel("\nHerramientas para su uso: " + articulo.getHerramientas());

                JPanel panel = new JPanel();
                panel.add(materialLabel);
                panel.add(usoLabel);
                panel.add(herramientasLabel);

                dialog.add(panel);
                dialog.pack();
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            }

        });
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        agregarButton = new JButton("Agregar artículo");
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AgregarArticuloDialog(FerreteriaGUI.this, articulos, model);
            }
        });

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