package controlador;

import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import modelo.Reservas;

/**
 * Created by Lucas on 25/06/2017.
 */

public class CargaDeDatos {

    public CargaDeDatos () {
    }

    public List<Reservas> CargarReservas (Cursor r) {

        List<Reservas>ListaDeReservas = new ArrayList<>();

        if(r.moveToFirst()) {
            while (!r.isAfterLast()) {
                /*Reservas res = new Reservas();
                res.setIdreserva(r.getInt(r.getColumnIndex("id")));
                res.setAula(r.getInt(r.getColumnIndex("Aula")));
                res.setDocente(r.getString(r.getColumnIndex("Docente")));
                res.setMateria(r.getString(r.getColumnIndex("Materia")));
                res.setModulo(r.getString(r.getColumnIndex("Modulo")));
                res.setModulo(r.getString(r.getColumnIndex("Fecha")));

                ListaDeReservas.add(res);
                r.moveToNext();*/
            }
            r.close();
        }
        return ListaDeReservas;
    }
}
