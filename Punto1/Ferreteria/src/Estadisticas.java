import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Estadisticas extends JDialog {
    public Estadisticas(JFrame owner, ArrayList<Articulo> articulos, ArticuloTableModel model){
        super(owner, true);
        setTitle("Estadisticas");
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(1, 1);
        setLayout(new GridLayout(6,2));

        JLabel total_inventarioJLabel = new JLabel("Precio total de todos los productos en inventario: "); 
        add(total_inventarioJLabel);

        JLabel total_invetario = new JLabel(TotalInvetario(articulos));
        add(total_invetario);

        JLabel ProductMenosStock_JLabel = new JLabel("Los productos con menos stock en el inventario son:     "); 
        add(ProductMenosStock_JLabel);

        JLabel ProductMenosStock = new JLabel(MinStock(articulos));
        add(ProductMenosStock);

        JLabel ProductMasStock_JLabel = new JLabel("Los productos con mas stock en el inventario son: "); 
        add(ProductMasStock_JLabel);

        JLabel ProductMasStock = new JLabel(MaxStock(articulos));
        add(ProductMasStock);

        JLabel Tools_JLabel = new JLabel("Herramientas mas utilizadas por los productos: "); 
        add(Tools_JLabel);

        JLabel Tools = new JLabel(UsoHerramientas(articulos));
        add(Tools);

        if(articulos.size()>1){
            sortarticulos(articulos);
        }
        

        pack();
        setLocationRelativeTo(owner);
        setVisible(true);
    }

    String TotalInvetario(ArrayList<Articulo> articulos){
        String ValorString = "";
        int valor = 0;

        for(int i = 0; i < articulos.size(); i++){
            valor += (articulos.get(i).getPrecio())*(articulos.get(i).getStock());
        }
        ValorString = valor+"";


        return ValorString;
    }

    String MinStock(ArrayList<Articulo> articulos){
        String Productos = "";
        
        for (int e = 1; e < articulos.size(); e++){
        for (int i = 1; i < articulos.size(); i++){
            if(articulos.get(i).getStock() < articulos.get(i-1).getStock()){
                Articulo newaArticulo = articulos.get(i);
                articulos.set(i,articulos.get(i-1));
                articulos.set(i-1,newaArticulo);
            }
        }
        }
        if(articulos.size() > 1){
            Productos = articulos.get(0).getNombre() + " y " + articulos.get(1).getNombre();
        }else if(articulos.size() == 1){
            Productos = articulos.get(0).getNombre();
        }
        

        return Productos;
    }

    String MaxStock(ArrayList<Articulo> articulos){
        String Productos = "";
        for (int e = 1; e < articulos.size(); e++){
        for (int i = 1; i < articulos.size(); i++){
            if(articulos.get(i).getStock() > articulos.get(i-1).getStock()){
                Articulo newaArticulo = articulos.get(i);
                articulos.set(i,articulos.get(i-1));
                articulos.set(i-1,newaArticulo);
            }
        }
        }
        if(articulos.size() > 1){
            Productos = articulos.get(0).getNombre() + " y " + articulos.get(1).getNombre();
        }else if(articulos.size() == 1){
            Productos = articulos.get(0).getNombre();
        }

        return Productos;
    }

    void sortarticulos(ArrayList<Articulo> articulos){
        for (int e = 1; e < articulos.size(); e++){
            for (int i = 1; i < articulos.size(); i++){
                if(articulos.get(i).getId() < articulos.get(i-1).getId()){
                    Articulo newaArticulo = articulos.get(i);
                    articulos.set(i,articulos.get(i-1));
                    articulos.set(i-1,newaArticulo);
                }
            }
            }
    }




    String UsoHerramientas(ArrayList<Articulo> articulos) {
        StringBuilder herramientasString = new StringBuilder();

        ArrayList<String> nombreHerramientas = new ArrayList<>(Arrays.asList(
             "Manualmente","Martillo", "Alicate", "Llaves",
            "Destornilladores", "Grapadora", "Máquina especial"
        ));

        ArrayList<Integer> cantherramientas = new ArrayList<>(Collections.nCopies(nombreHerramientas.size(), 0));

        for (Articulo articulo : articulos) {
            for (int e = 0; e < nombreHerramientas.size(); e++) {
                if (articulo.getHerramientas().equals(nombreHerramientas.get(e))) {
                    cantherramientas.set(e, cantherramientas.get(e) + 1);
                    break;
                }
            }
        }

        for (int i = 0; i < cantherramientas.size(); i++) {
            for (int e = 1; e < cantherramientas.size(); e++) {
                if (cantherramientas.get(e) > cantherramientas.get(e - 1)) {
                    Collections.swap(cantherramientas, e, e - 1);
                    Collections.swap(nombreHerramientas, e, e - 1);
                }
            }
        }

        byte contador = 3;
        for(int i = 0 ; i < 7; i++){
            if(cantherramientas.get(i) != 0){
                herramientasString.append(nombreHerramientas.get(i));
                if(contador != 1){
                    herramientasString.append(", ");
                }
                contador -= 1;
            }
            if(contador == 0){
                break;
            }
        }

        if(contador == 3){
            herramientasString.append("No existen articulos");
        }

        return herramientasString.toString();
    }
}