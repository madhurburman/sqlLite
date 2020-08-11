package com.papahades.sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class myDbHandler extends SQLiteOpenHelper {
    private static final int dataBaseVersion = 1 ;
    private static final String dataBaseName="products.db";
    private static final String Tables="products";
    private static final String columnId="id";
    private static final String ColumnProduct="productName";






    public myDbHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, dataBaseName, factory, dataBaseVersion);
    }









    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String querry = "Create Table "+Tables+"("+columnId+"INTEGER PRIMARY KEY AUTOINCREMENT,"+ColumnProduct+"Text"+");";
        sqLiteDatabase.execSQL(querry);
    }








    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
      sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+Tables);
      onCreate(sqLiteDatabase);
    }




    public void  addProducts(products product){
        ContentValues values = new ContentValues();

        values.put(ColumnProduct,product.getProductName());
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        sqLiteDatabase.insert(Tables,null,values);
        sqLiteDatabase.close();

    }




    public  void deleteProduct (String ProductName){
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        sqLiteDatabase.execSQL(" DELETE FROM " + " Tables " + " WHERE " +  ColumnProduct + " =\""  + ProductName + "\";");
    }





    public String  DATABASEtoSTRING() {
        String dbString = "";
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        String query = " SELECT * FROM " + " Tables " + " WHERE 1 ";

         Cursor c = sqLiteDatabase.rawQuery(query, null);   //perform operation row by row
        c.moveToFirst();

        while (!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("productName"))!=null){
                dbString+=c.getString(c.getColumnIndex("productName"));
                dbString+="\n";

            }
            c.moveToNext();
        }
        sqLiteDatabase.close();
        return dbString;
    }



}
