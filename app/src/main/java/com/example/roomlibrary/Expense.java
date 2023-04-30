package com.example.roomlibrary;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "expense")
public class Expense {

  @PrimaryKey(autoGenerate = true)
  private  int id;
  @ColumnInfo(name="title")
    private  String title;
  @ColumnInfo(name="amount")
    private  String amount;
// creating a constructor for get all the data using getter and setter
  // Main Constructor
  public Expense(int id, String title, String amount) {
    this.id = id;
    this.title = title;
    this.amount = amount;
  }
  // for preventing from the because id is autodata taking so we dont know what ill n=be its starting value so thats why we create anothe r constructor
  @Ignore // to ignore it its help from preventing from runtime error
 public Expense(String title , String amount){
    this.amount= amount;
    this.title =title;
 }
// we are using here getter and setter for the particular variable getting and setting it but constructor also can do same things
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }
}
