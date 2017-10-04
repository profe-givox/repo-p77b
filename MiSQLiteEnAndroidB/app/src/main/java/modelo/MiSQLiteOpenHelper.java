package modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by alcohonsilver on 04/10/17.
 */

public class MiSQLiteOpenHelper extends SQLiteOpenHelper {

    private  final String SCRIPT_TABLE_CONTACTOS="create table CONTACTOS (_id)";
    private static final int VERSION_DB = 1;

    public MiSQLiteOpenHelper(Context contexto){
        super(contexto, "miBD", null, VERSION_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
