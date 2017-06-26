package modelo;

import android.database.Cursor;

import cmd.controlador.GestorDeDatos;

/**
 * Created by Lucas on 25/06/2017.
 */

public class AulasLibres {
    private Cursor libres;

    public AulasLibres (GestorDeDatos gdd, String fecha){
        libres = gdd.getAulasLibres(fecha);
    }

    public Cursor obtenerAulasLibres () {
        return libres;
    }
}
