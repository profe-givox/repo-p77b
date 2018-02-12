package net.ivanvega.sqliteenandroidcurso.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

import net.ivanvega.sqliteenandroidcurso.datos.UsuariosDAO;

/**
 * Created by alcohonsilver on 01/02/18.
 */

public class ProviderUser extends ContentProvider {


    private UsuariosDAO _dao;
    // Creates a UriMatcher object.
    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        /*
         * The calls to addURI() go here, for all of the content URI patterns that the provider
         * should recognize. For this snippet, only the calls for table 3 are shown.
         */

        /*
         * Sets the integer value for multiple rows in table 3 to 1. Notice that no wildcard is used
         * in the path
         */
        sUriMatcher.addURI("net.ivanvega.sqliteenandroidcurso.provider", "usuarios", 1);

        /*
         * Sets the code for a single row to 2. In this case, the "#" wildcard is
         * used. "content://com.example.app.provider/table3/3" matches, but
         * "content://com.example.app.provider/table3 doesn't.
         */

        sUriMatcher.addURI("net.ivanvega.sqliteenandroidcurso.provider",
                "usuarios/#", 2);


        sUriMatcher.addURI("net.ivanvega.sqliteenandroidcurso.provider", "usuarios/*", 3);
    }


    @Override
    public boolean onCreate() {
        _dao = new UsuariosDAO(getContext());
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {

        Cursor c=null;

        /*
         * Choose the table to query and a sort order based on the code returned for the incoming
         * URI. Here, too, only the statements for table 3 are shown.
         */
        switch (sUriMatcher.match(uri)) {


            // If the incoming URI was for all of table3
            case 1:

                c = _dao.getAll();

                break;

            // If the incoming URI was for a single row
            case 2:

                /*
                 * Because this URI was for a single row, the _ID value part is
                 * present. Get the last path segment from the URI; this is the _ID value.
                 * Then, append the value to the WHERE clause for the query
                 */

                c = _dao.getOneCursorByID(  Integer.valueOf(  uri.getLastPathSegment()));

                break;

            case 3:

                c = _dao.getAllFilterByName(   uri.getLastPathSegment());

                break;
            default:
                break;
                // If the URI is not recognized, you should do some error handling here.
        }
        // call the code to actually do the query

        return c;
    }

    @Override
    public String getType(Uri uri) {
        String strTipoMIME="";

        switch (sUriMatcher.match(uri)) {


            // If the incoming URI was for all of table3
            case 1:

                strTipoMIME = "vnd.android.cursor.dir/vnd.net.ivanvega.sqliteenandroidcurso.provider.usuario";

                break;

            // If the incoming URI was for a single row
            case 2:


                strTipoMIME = "vnd.android.cursor.item/vnd.net.ivanvega.sqliteenandroidcurso.provider.usuario";
                break;

            case 3:

                strTipoMIME = "vnd.android.cursor.dir/vnd.net.ivanvega.sqliteenandroidcurso.provider.usuario";


                break;
            default:
                break;
            // If the URI is not recognized, you should do some error handling here.
        }


        return strTipoMIME;
    }

    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        long idinsertado =0;

        switch (sUriMatcher.match(uri)) {


            // If the incoming URI was for all of table3
            case 1:
                  idinsertado = _dao.insert(contentValues);

                break;

            // If the incoming URI was for a single row
            case 2:
                break;

            case 3:

                break;
            default:
                break;
            // If the URI is not recognized, you should do some error handling here.
        }


        return Uri.withAppendedPath(uri,String.valueOf(idinsertado));
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }
}
