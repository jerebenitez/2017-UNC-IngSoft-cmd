package modelo;

import android.database.Cursor;

import controlador.GestorDeDatos;

/**
 * Created by Lucas on 25/06/2017.
 */

public class ResDocente {
    private Cursor resdoc;

    public ResDocente (GestorDeDatos gdd, String doc) {
        resdoc = gdd.getReservasDocente(doc);
    }

    public Cursor obtenerReservas (GestorDeDatos gdd, String doc) {
        return resdoc;
    }
}
