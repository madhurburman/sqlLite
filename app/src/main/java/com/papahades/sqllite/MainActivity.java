package com.papahades.sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {



    EditText minput;
   TextView mTextView;
   myDbHandler dbHandler ;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        minput=findViewById(R.id.editTextTextPersonName);
        mTextView=findViewById(R.id.textView);
        dbHandler= new myDbHandler(this ,null,null,1);
        printDataBase();

    }






    public void printDataBase(){
        String dbString=dbHandler.DATABASEtoSTRING();
        mTextView.setText(dbString);
        minput.setText("");
    }





    public void delete(View view) {
        String inputText =minput.getText().toString();
        dbHandler.deleteProduct(inputText);
    }






    public void add(View view) {
        products products= new products(minput.getText().toString());
        dbHandler.addProducts(products);
        printDataBase();
    }
}