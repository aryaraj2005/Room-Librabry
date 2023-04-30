package com.example.roomlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   EditText edtittle , edamount;
   Button add_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtittle= findViewById(R.id.edittitle);
        edamount = findViewById(R.id.editamount);
        add_btn = findViewById(R.id.button);
        DatabaseHelper databaseHelper = DatabaseHelper.getDB(this);
        // button or click karne se user ke dwara data enter kiya hua data ko acess kar sakte hai

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = edtittle.getText().toString();
                String amount = edamount.getText().toString();
             databaseHelper.expenseDAO().addTx(new Expense(title  , amount));
              ArrayList<Expense> arrExpense =  (ArrayList<Expense>)databaseHelper.expenseDAO().getAllExpense();
                for (int i = 0; i <arrExpense.size() ; i++) {
                    Log.d("Data" ,"Title"+arrExpense.get(i).getTitle() + "Amount" + arrExpense.get(i).getAmount() );


                }
            }
        });
    }
}