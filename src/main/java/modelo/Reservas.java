package modelo;

import android.database.Cursor;

import cmd.controlador.GestorDeDatos;

/**
 * Created by Lucas on 25/06/2017.
 */

public class Reservas {
    private Cursor reservas;

    public Reservas(GestorDeDatos gdd, String fecha) {
        reservas = gdd.getReservas(fecha);
    }

    public Cursor obtenerReservas() {
        return reservas;
    }
}