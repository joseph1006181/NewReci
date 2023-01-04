package com.joset.newreci;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.joset.newreci.Utilidades.Utilidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class MainActivity2 extends AppCompatActivity {
 RecyclerView reci ;
 ArrayList<Usuario> lista;
 Cone conn;
 EditText nombre;
 Adapter adapter;
 SwipeRefreshLayout swip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        conn = new Cone(getApplicationContext(), "dosi", null, 1);




        nombre = findViewById(R.id.txt1);
        swip =findViewById(R.id.refesa);




        lista =  new ArrayList<>();
        rec();

       recicler();









        swip.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                rec();

                recicler();


                swip.setRefreshing(false);



            }
        });














    }

public void recicler(){

    reci=findViewById(R.id.rec);


    reci.setLayoutManager(new LinearLayoutManager(getApplication(),LinearLayoutManager.VERTICAL,false));




    adapter = new Adapter(lista);

    reci.setAdapter(adapter);



}

public void actulizar (View view){

    conn = new Cone(getApplicationContext(), "dosi", null, 1);

    SQLiteDatabase db = conn.getWritableDatabase();


    ContentValues values = new ContentValues();

    //
    // values.put(Utilidades.CAMPO_HORA, textView3.getText().toString());

    values.put(Utilidades.CAMPO_NOMBRE,"ress");


    db.update(Utilidades.TABLA_USUARIO, values, Utilidades.CAMPO_NOMBRE+ "= 're'",null);
    //db.update(Utilidades.TABLA_USUARIO, values, Utilidades.CAMPO_ID + "=?", in);

    Toast.makeText(getApplicationContext(), "actualiza bien", Toast.LENGTH_SHORT).show();
    adapter.notifyDataSetChanged();

}





    public  void rec (){






        SQLiteDatabase db = conn.getReadableDatabase();





        Usuario usuario = null;




        Cursor cursor = db.rawQuery(" select  "+ Utilidades.CAMPO_NOMBRE+ " from " + Utilidades.TABLA_USUARIO, null);



        while (cursor.moveToNext()) {


            usuario = new Usuario();


            usuario.setNombre(cursor.getString(0));

            lista.add(usuario);


        }
        db.close();


    }



}