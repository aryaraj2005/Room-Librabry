package com.example.roomlibrary;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import kotlin.jvm.Synchronized;

@Database(entities = Expense.class , exportSchema = false  ,version = 1 )
public abstract class DatabaseHelper extends RoomDatabase {
    private  static final  String DB_NAME="ExpenseDB";
    private  static DatabaseHelper instance;
     // synchronised ke help se help se hume data ek particular order me milega like
    //at a time this database coll by many one so at first jo query pahle execute hui hogi vo phle rum hogi
    public  static synchronized DatabaseHelper getDB(Context context){
        // at initially there was no any query was  define so first case instance was null
        // so first we design a our first instance
        if (instance==null){
           instance= Room.databaseBuilder(context , com.example.roomlibrary.DatabaseHelper.class , DB_NAME)
                   .fallbackToDestructiveMigration()
                   .allowMainThreadQueries()
                   .build();
        }
      return instance;
    }
    public  abstract ExpenseDAO expenseDAO();

}
