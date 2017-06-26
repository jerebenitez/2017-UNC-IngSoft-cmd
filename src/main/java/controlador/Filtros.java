package controlador;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Lucas on 25/06/2017.
 */

public class Filtros {

    private Cursor reserva;

    public void Filtros (Cursor reserva) {
        this.reserva = reserva;
    }

    public Cursor filtrarAula (String aula) {

        return reserva;
    }
}
