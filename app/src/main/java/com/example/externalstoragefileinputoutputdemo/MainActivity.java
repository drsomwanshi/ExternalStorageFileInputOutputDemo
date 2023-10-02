package com.example.externalstoragefileinputoutputdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void savedata(View view) {

      File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
      File f1=new File(folder,"patel.txt");

        try {
            FileOutputStream f2=new FileOutputStream(f1);
            String n="";
            EditText txt1=findViewById(R.id.txt1);
            n=txt1.getText().toString();

            f2.write(n.getBytes());
            f2.close();
            Toast.makeText(this, "Data is Saved", Toast.LENGTH_SHORT).show();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }




    }

    public void readdata(View view) {

        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File f1=new File(folder,"patel.txt");
        try {
            FileInputStream f2=new FileInputStream(f1);
            int ch=f2.read();
            String n="";
            while(ch!=-1)
            {
                n=n+(char)ch;
                ch=f2.read();
            }
            EditText txt1=findViewById(R.id.txt1);
            txt1.setText("" + n);

            Toast.makeText(this, "Data in File=" + n, Toast.LENGTH_SHORT).show();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}