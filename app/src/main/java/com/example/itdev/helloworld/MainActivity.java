package com.example.itdev.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.itdev.helloworld._model.Login_model;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    // deklarasi variable
    private EditText EdtUserName;
    private EditText EdtUserPassword;
    private DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHandler(this);
        db.addNewUser(new Login_model(null,"Admin", "admin", "Admin"));
        db.addNewUser(new Login_model(null, "tampan", "tampan", "tampan"));
        db.addNewUser(new Login_model(null, "woi", "woi", "woi"));


        List<Login_model> lsUser= db.getAllData();
        Log.v("Row", "Helllooooo Guys..." );
        Log.v("Row", "Data" + lsUser.toString());

        for (Login_model ls : lsUser){
            String isi = ls.get_NamaUser();
            Log.v("Row", "Field Nama: " + isi );
        }
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        // initialize Button/Text

        EdtUserName = (EditText) findViewById(R.id.UserName);
        EdtUserPassword = (EditText) findViewById(R.id.UserPassword);

        Button BtnLogin = (Button) findViewById(R.id.login);
        BtnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //ambil nilai dari Form
                    String UserName = EdtUserName.getText().toString();
                    String UserPassword = EdtUserPassword.getText().toString();
                    int isValid = 0;
                    // validasi Form Input
                    if(UserName.equals("")){
                        isValid = 9;
                    }
                    else if(UserPassword.equals((""))){
                        isValid=8;
                    }
                    else {
                        // konek db

                    }


                }
            }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
