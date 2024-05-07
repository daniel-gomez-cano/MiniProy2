import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ArticuloTableModel extends AbstractTableModel {
    private ArrayList<Articulo> articulos;
    private String[] columnNames = {"ID", "Nombre", "Precio", "Stock", "Descripción"};

    public ArticuloTableModel(ArrayList<Articulo> articulos) {
        this.articulos = articulos;
    }

    @Override
    public int getRowCount() {
        return articulos.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int row, int column) {
        Articulo articulo = articulos.get(row);
        switch (column) {
            case 0:
                return articulo.getId();
            case 1:
                return articulo.getNombre();
            case 2:
                return articulo.getPrecio(); // Agrega un método getPrecio() en la clase Articulo
            case 3:
                return articulo.getStock();
            case 4:
                return articulo.getDescripcion();
            default:
                return null;
        }
    }

    // Agrega este método para actualizar la lista de artículos en el modelo
    public void setArticulos(ArrayList<Articulo> articulos) {
        this.articulos = articulos;
        fireTableDataChanged();
    }
}
