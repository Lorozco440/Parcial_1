
package Inicio;

import java.io.Serializable;
import java.util.ArrayList;


public class Proceso implements Serializable{

    private ArrayList<Object> a = new ArrayList<Object>();

    public Proceso() {
    }

    public Proceso(ArrayList<Object> a) {
        this.a = a;
    }

    public void agregarRegistro(Producto p) {
        this.a.add(p);
    }

    public void modificarRegistro(int i, Producto p) {
        this.a.set(i, p);
    }

    public void eliminarRegistro(int i) {
        this.a.remove(i);
    }

    public Producto obtenerRegistro(int i) {
        return (Producto) a.get(i);
    }

    public int cantidadRegistro() {
        return this.a.size();
    }

    public int buscaCodigo(int codigo) {
        for (int i = 0; i < cantidadRegistro(); i++) {
            if (codigo == obtenerRegistro(i).getCodigo()) {
                return i;
            }
        }
        return -1;
    }

}
