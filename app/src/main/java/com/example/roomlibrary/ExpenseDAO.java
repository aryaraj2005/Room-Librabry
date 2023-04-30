package com.example.roomlibrary;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ExpenseDAO {

    //Query ke liy
    @Query("select * from expense")
    List<Expense> getAllExpense(); // return type and its object getAllExpense
    // insert k liy
    @Insert
   void  addTx(Expense expense); // return type void hume insert me kabhi luch retiurn nhi chahiye hota hi
    //update
    @Update
    void  upTx(Expense expense);
    @Delete
    void delTx(Expense expense);
}
