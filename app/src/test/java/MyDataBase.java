import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDataBase extends SQLiteOpenHelper {
    private Context context;
    private static final String DbName="Contact Manager";
    private static final int version=1;

    private static final String TableName="Contacts";
    private static final String Col_Name="Name";
    private static final String Col_Number="Number";
    private static final String Col_Id="Id";
    public MyDataBase(@Nullable Context context) {
        super(context, DbName, null, version);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE "+TableName+"("+Col_Id+" INTEGER PRIMARY KEY AUTOINCREMENT, "+Col_Name+" TEXT,"
                                +Col_Number+" TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TableName);
        onCreate(db);
    }
}
