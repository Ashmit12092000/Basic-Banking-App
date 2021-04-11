package com.example.bankingapp.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper
{
    private String TABLE_NAME = "user_table";
    private String TABLE_NAME1 = "transfers_table";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "User.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (PHONENUMBER INTEGER PRIMARY KEY ,NAME TEXT,BALANCE DECIMAL,EMAIL VARCHAR,ACCOUNT_NO VARCHAR,IFSC_CODE VARCHAR)");
        db.execSQL("create table " + TABLE_NAME1 +" (TRANSACTIONID INTEGER PRIMARY KEY AUTOINCREMENT,DATE TEXT,FROMNAME TEXT,TONAME TEXT,AMOUNT DECIMAL,STATUS TEXT)");
        db.execSQL("insert into user_table values(9264909932,'Ashmit Singh',5000.00,'ashmitsingh204@gmail.com','XXXXXXXXXXXX1247','CBI08576543')");
        db.execSQL("insert into user_table values(8542136521,'Ayush Singh',5000.00,'ayush@gmail.com','XXXXXXXXXXXX6521','CBI98765432')");
        db.execSQL("insert into user_table values(7452301259,'Adarsh Singh',5000.00,'adarsh@gmail.com','XXXXXXXXXXXX7451','SBI87654321')");
        db.execSQL("insert into user_table values(9471203215,'Shristi rani',5000.00,'shrist1304@gmail.com','XXXXXXXXXXXX5201','PIB76543210')");
        db.execSQL("insert into user_table values(7854120214,'Abuzar Ahmed Quadri',5000.00,'abuzar@gmail.com','XXXXXXXXXXXX7433','BOI65432109')");
        db.execSQL("insert into user_table values(9784514747,'Sarthak Swapnil',5000.00,'sarthak@gmail.com','XXXXXXXXXXXX5214','UBOI54321098')");
        db.execSQL("insert into user_table values(6301547854,'Alisha',5000.00,'alisha@gmail.com','XXXXXXXXXXXX3021','SIB43210987')");
        db.execSQL("insert into user_table values(8520147963,'Shaurya Srivastav',5000.00,'shaurya@gmail.com','XXXXXXXXXXXX5234','ICIC32109876')");
        db.execSQL("insert into user_table values(9517538246,'Heenal Keshwani',5000.00,'heenal@gmail.com','XXXXXXXXXXXX3456','CORP21098765')");
        db.execSQL("insert into user_table values(7458967430,'Dennis Sidney',5000.00,'dennis@gmail.com','XXXXXXXXXXXX4563','IND10987654')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME1);
        onCreate(db);
    }

    public Cursor readalldata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user_table", null);
        return cursor;
    }

    public Cursor readparticulardata(String phonenumber){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user_table where phonenumber = " +phonenumber, null);
        return cursor;
    }

    public Cursor readselectuserdata(String phonenumber) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from user_table except select * from user_table where phonenumber = " +phonenumber, null);
        return cursor;
    }

    public void updateAmount(String phonenumber, String amount){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update user_table set balance = " + amount + " where phonenumber = " +phonenumber);
    }

    public Cursor readtransferdata(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from transfers_table", null);
        return cursor;
    }

    public boolean insertTransferData(String date,String from_name, String to_name, String amount, String status){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("DATE", date);
        contentValues.put("FROMNAME", from_name);
        contentValues.put("TONAME", to_name);
        contentValues.put("AMOUNT", amount);
        contentValues.put("STATUS", status);
        Long result = db.insert(TABLE_NAME1, null, contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }
}
