package cmd.controlador;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by Lucas on 24/06/2017.
 */

public class BDDHelper extends SQLiteAssetHelper{

    private static final String DATABASE_NAME = "gbnew.sqlite";
    private static final int DATABASE_VERSION = 1;

    public BDDHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
