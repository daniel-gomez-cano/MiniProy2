import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
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

    public FerreteriaGUI() {
        setTitle("Ferretería Mi Fierrote");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        articulos = new ArrayList<>();
        model = new ArticuloTableModel(articulos);

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        agregarButton = new JButton("Agregar artículo");
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AgregarArticuloDialog(FerreteriaGUI.this, articulos, model);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(agregarButton);
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