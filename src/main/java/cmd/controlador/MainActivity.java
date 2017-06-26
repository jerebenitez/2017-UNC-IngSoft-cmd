package cmd.controlador;

import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import cmd.reservafcefyn.R;
import modelo.AulasLibres;
import modelo.ResDocente;
import modelo.Reservas;

public class MainActivity extends AppCompatActivity {

    private BDDHelper dbh;
    private GestorDeDatos gdd;
    private Reservas reservas;

    private String fecha = "\"23-06-2017\"";
    private String doc = "1";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbh = new BDDHelper(this);
        gdd = new GestorDeDatos(dbh);
        reservas = new Reservas(gdd,fecha);

        String[] columns = new String[]{"Aula", "Docente", "Materia", "Modulo"};
        int[] to = new int[] { R.id.aula, R.id.docente, R.id.materia, R.id.modulo};
        SimpleCursorAdapter dataAdapter = new SimpleCursorAdapter(
                this,
                R.layout.tabla,
                reservas.obtenerReservas(),
                columns,
                to,
                0);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(dataAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        reservas.obtenerReservas().close();
        dbh.close();
    }
}