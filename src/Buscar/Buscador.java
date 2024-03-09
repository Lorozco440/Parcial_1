/*Parcial_1 Luis Armando Orozco Cifuentes 1190-22-102*/
package Buscar;

import Inicio.Proceso;
import Inicio.Producto;
import Otros.imgTabla;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Buscador {
    
    public void buscar_nombre(JTable tabla, Producto producto, Proceso proceso, String nombre) {
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        dt.addColumn("ID");
        dt.addColumn("Nombres");
        dt.addColumn("Sueldo");
        dt.addColumn("Direccion");
        dt.addColumn("Foto");

        tabla.setDefaultRenderer(Object.class, new imgTabla());

        Object fila[] = new Object[dt.getColumnCount()];
        for (int i = 0; i < proceso.cantidadRegistro(); i++) {
            producto = proceso.obtenerRegistro(i);
            if (producto.getNombre().contains(nombre)) {
                fila[0] = producto.getCodigo();
                fila[1] = producto.getNombre();
                fila[2] = producto.getPrecio();
                fila[3] = producto.getDescripcion();

                try {
                    byte[] bi = producto.getFoto();
                    BufferedImage image = null;
                    InputStream in = new ByteArrayInputStream(bi);
                    image = ImageIO.read(in);
                    ImageIcon img = new ImageIcon(image.getScaledInstance(50, 60, 60));
                    fila[4] = new JLabel(img);
                } catch (Exception ex) {

                    fila[4] = "No hay Imagen";
                }
                dt.addRow(fila);
            }

        }
        tabla.setModel(dt);
        tabla.setRowHeight(60);
    }
    
     public void buscar_codigo(JTable tabla, Producto producto, Proceso proceso, int codigo) {
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        dt.addColumn("ID");
        dt.addColumn("Nombres");
        dt.addColumn("Sueldo");
        dt.addColumn("Direccion");
        dt.addColumn("Foto");

        tabla.setDefaultRenderer(Object.class, new imgTabla());

        Object fila[] = new Object[dt.getColumnCount()];
        for (int i = 0; i < proceso.cantidadRegistro(); i++) {
            producto = proceso.obtenerRegistro(i);
            if (producto.getCodigo()==codigo) {
                fila[0] = producto.getCodigo();
                fila[1] = producto.getNombre();
                fila[2] = producto.getPrecio();
                fila[3] = producto.getDescripcion();

                try {
                    byte[] bi = producto.getFoto();
                    BufferedImage image = null;
                    InputStream in = new ByteArrayInputStream(bi);
                    image = ImageIO.read(in);
                    ImageIcon img = new ImageIcon(image.getScaledInstance(50, 60, 60));
                    fila[4] = new JLabel(img);
                } catch (Exception ex) {

                    fila[4] = "No hay Imagen";
                }
                dt.addRow(fila);
            }

        }
        tabla.setModel(dt);
        tabla.setRowHeight(60);
    }
     
      public void buscar_precio(JTable tabla, Producto producto, Proceso proceso, double precio) {
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        dt.addColumn("Codigo");
        dt.addColumn("Nombre");
        dt.addColumn("Precio");
        dt.addColumn("Descripcion");
        dt.addColumn("Foto");

        tabla.setDefaultRenderer(Object.class, new imgTabla());

        Object fila[] = new Object[dt.getColumnCount()];
        for (int i = 0; i < proceso.cantidadRegistro(); i++) {
            producto = proceso.obtenerRegistro(i);
            if (producto.getPrecio()==precio) {
                fila[0] = producto.getCodigo();
                fila[1] = producto.getNombre();
                fila[2] = producto.getPrecio();
                fila[3] = producto.getDescripcion();

                try {
                    byte[] bi = producto.getFoto();
                    BufferedImage image = null;
                    InputStream in = new ByteArrayInputStream(bi);
                    image = ImageIO.read(in);
                    ImageIcon img = new ImageIcon(image.getScaledInstance(50, 60, 60));
                    fila[4] = new JLabel(img);
                } catch (Exception ex) {

                    fila[4] = "No hay Imagen";
                }
                dt.addRow(fila);
            }

        }
        tabla.setModel(dt);
        tabla.setRowHeight(60);
    }

}
