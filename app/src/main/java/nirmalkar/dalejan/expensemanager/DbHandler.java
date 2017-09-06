package nirmalkar.dalejan.expensemanager;

/**
 * Created by DALEJAN1 on 3/30/2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CG-DTE on 29-03-2017.
 */

public class DbHandler extends SQLiteOpenHelper {


    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "ExpenseManager";
    // Contacts table name
    private static final String TABLE_ALARM = "ExpenseDetail";
    // Shops Table Columns names
    private static final String ITEM_ID = "Id";
    private static final String ITEM_NAME = "I_name";
    private static final String ITEM_PRICE = "I_price";
    private static final String ITEM_DATE = "I_date";
    private static final String ITEM_pay = "I_pay";
    private static final String ITEM_desc = "I_desc";
    private static final String ITEM_day = "day";
    private static final String ITEM_month = "month";



    public DbHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ALARM_TABLE = "CREATE TABLE " + TABLE_ALARM + "("
                + ITEM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ITEM_NAME + " TEXT,"
                + ITEM_PRICE + " TEXT,"
                + ITEM_DATE + " TEXT,"
                + ITEM_pay + " TEXT,"
                + ITEM_desc + " TEXT,"
                + ITEM_day + " INTEGER,"
                + ITEM_month + " INTEGER" + ")";
        db.execSQL(CREATE_ALARM_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ALARM);

        onCreate(db);

    }

    // Adding new shop
    public void addAlarm(DatabaseExpense expense) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        //  values.put(ALARM_ID, alarm.getId());
        //values.put(ALARM_NAME, alarm.getName()); // Shop Name
        values.put(ITEM_NAME, expense.getItemname());
        values.put(ITEM_PRICE, expense.getItempric());
        values.put(ITEM_DATE, expense.getItemdate());
        values.put(ITEM_pay, expense.getItempay());
        values.put(ITEM_desc, expense.getItemdescrip());
        values.put(ITEM_day, expense.getDay());
        values.put(ITEM_month, expense.getMonth());
        // Shop Phone Number

// Inserting Row
        db.insert(TABLE_ALARM, null, values);
        db.close(); // Closing database connection
    }


    public List<DatabaseExpense> getAllAlarm() {
        List<DatabaseExpense> Expenselist = new ArrayList<DatabaseExpense>();
        String selectQuery = "SELECT * FROM " + TABLE_ALARM;


        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);


        if (cursor.moveToFirst()) {
            do {
                DatabaseExpense databaseAlarm = new DatabaseExpense();
                // databaseAlarm.setId(Integer.parseInt(cursor.getString(0)));

                databaseAlarm.setItemname(cursor.getString(1));
                databaseAlarm.setItempric(cursor.getString(2));
                databaseAlarm.setItemdate(cursor.getString(3));
                databaseAlarm.setItempay(cursor.getString(4));
                databaseAlarm.setItemdescrip(cursor.getString(5));
                databaseAlarm.setDay(cursor.getInt(6));
                databaseAlarm.setDay(cursor.getInt(7));
// Adding contact to list
                Expenselist.add(databaseAlarm);
            } while (cursor.moveToNext());
        }
        return Expenselist;
    }

    public List<DatabaseExpense> getAllAlarmBYdaY() {
        List<DatabaseExpense> Expenselist = new ArrayList<DatabaseExpense>();
        String selectQuery = "SELECT * FROM " + TABLE_ALARM+" ORDER BY "+ITEM_day +" ASC ";


        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);


        if (cursor.moveToFirst()) {
            do {
                DatabaseExpense databaseAlarm = new DatabaseExpense();
                // databaseAlarm.setId(Integer.parseInt(cursor.getString(0)));

                databaseAlarm.setItemname(cursor.getString(1));
                databaseAlarm.setItempric(cursor.getString(2));
                databaseAlarm.setItemdate(cursor.getString(3));
                databaseAlarm.setItempay(cursor.getString(4));
                databaseAlarm.setItemdescrip(cursor.getString(5));
                databaseAlarm.setDay(cursor.getInt(6));
                databaseAlarm.setDay(cursor.getInt(7));
// Adding contact to list
                Expenselist.add(databaseAlarm);
            } while (cursor.moveToNext());
        }
        return Expenselist;
    }
    public List<DatabaseExpense> getAllAlarmBYmonth() {
        List<DatabaseExpense> Expenselist = new ArrayList<DatabaseExpense>();
        String selectQuery = "SELECT * FROM " + TABLE_ALARM+" ORDER BY "+ITEM_month+" ASC";


        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);


        if (cursor.moveToFirst()) {
            do {
                DatabaseExpense databaseAlarm = new DatabaseExpense();
                // databaseAlarm.setId(Integer.parseInt(cursor.getString(0)));

                databaseAlarm.setItemname(cursor.getString(1));
                databaseAlarm.setItempric(cursor.getString(2));
                databaseAlarm.setItemdate(cursor.getString(3));
                databaseAlarm.setItempay(cursor.getString(4));
                databaseAlarm.setItemdescrip(cursor.getString(5));
                databaseAlarm.setDay(cursor.getInt(6));
                databaseAlarm.setDay(cursor.getInt(7));
// Adding contact to list
                Expenselist.add(databaseAlarm);
            } while (cursor.moveToNext());
        }
        return Expenselist;
    }


}




