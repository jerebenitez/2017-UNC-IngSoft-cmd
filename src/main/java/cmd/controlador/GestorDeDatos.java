package cmd.controlador;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

/**
 * Created by Lucas on 24/06/2017.
 */

public class GestorDeDatos {

    private SQLiteDatabase db;
    private SQLiteQueryBuilder qb;
    private BDDHelper dbh;

    public GestorDeDatos(BDDHelper dbh) {
        db = dbh.getReadableDatabase();
        //qb = new SQLiteQueryBuilder();
    }

    public Cursor getReservas(String fecha) {
        String select = "select idreserva as _id, numero as Aula, (apellido || ', '||nombre) as Docente, nombremat as Materia,(hora_inicio||'-'||hora_fin) as Modulo from reserva r\n" +
                "join aula a join docente d join materia mat join modulo m \n" +
                "where r.idaula = a.idaula and r.idocente = d.idocente and r.idmateria = mat.idmateria and r.idmodulo = m.idmodulo and r.fecha_reserva = " + fecha;
        Cursor c = db.rawQuery(select, null);
        return c;
    }

    public Cursor getAulasLibres(String fecha) {
        String select = "select Aula, Capacidad, Proyector, (hora_inicio||'-'||hora_fin) as Modulo \n" +
                "from (select numero as Aula, capacidad as Capacidad, proyector as Proyector, idmodulo from aula a join reserva r where a.idaula != r.idaula and r.fecha_reserva = " + fecha +") libres\n" +
                "join modulo m where m.idmodulo = libres.idmodulo;";
        Cursor c = db.rawQuery(select, null);
        c.moveToFirst();
        return c;
    }

    public Cursor getReservasDocente(String idocente) {
        String select = "select idaula as Aula, nombremat as Materia, (hora_inicio||'-'||hora_fin) as Modulo \n" +
                "from reserva r join docente d join materia mat join modulo m\n" +
                "where d.idocente = " + idocente + " and r.idocente = " + idocente + " and r.idmodulo = m.idmodulo and r.idmateria = mat.idmateria;";
        Cursor c = db.rawQuery(select, null);
        return c;
    }
}
