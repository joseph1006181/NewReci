package com.joset.newreci;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.joset.newreci.Utilidades.Utilidades;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
     EditText tx1 , tx2 , tx3 , txCon;
      Adapter adaptador;
       Button bt1 ,  bt2 , bt3 , btInsertar , cancelar ,  btConta;
        private ArrayList<Usuario> lista ;
          private  int position = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        array();
        recicler();


        tx1= findViewById(R.id.e1);
        tx2= findViewById(R.id.e2);
        tx3= findViewById(R.id.editTextTextPersonName3);
        bt1=findViewById(R.id.button1);
        bt2=findViewById(R.id.button3);
        bt3=findViewById(R.id.button4);
        btInsertar=findViewById(R.id.button5);
        cancelar=findViewById(R.id.cancelar);
        btConta=findViewById(R.id.button7);
        txCon = findViewById(R.id.textoConta);




adaptador.setOncl(new comu() {
    @Override
    public void comu(int pos) {


        Toast.makeText(getApplicationContext(), "posision"+pos, Toast.LENGTH_SHORT).show();

    }
});





btConta.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        position = position+1;


        Toast.makeText(MainActivity.this,"este"+position,Toast.LENGTH_SHORT).show();


    }
});


 cancelar.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View view) {

         Cone conn = new Cone(getApplicationContext(), "dosi", null, 1);

         SQLiteDatabase db = conn.getWritableDatabase();


         ContentValues values = new ContentValues();

         //

         values.put(Utilidades.CAMPO_NOMBRE, "jos");


         db.update(Utilidades.TABLA_USUARIO, values, Utilidades.CAMPO_ID + "= 3", null);

         Toast.makeText(getApplicationContext(), "actualiza bien", Toast.LENGTH_SHORT).show();

lista.add(new Usuario(1,"dd",null,null));

adaptador.notifyItemInserted(1);


arc();








     }

 });


 bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Usuario usuario = null;



                lista.add(new Usuario(1,"fff","dddd","rr445"));






//////
            }



        });





bt2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        int position = Integer.parseInt(tx2.getText().toString());

            borrarIte(position);
    }
});

//actualizar
bt3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {


        update(0);

//




        lista.remove(0);
        adaptador.notifyItemRemoved(0);
       // array();
        //recicler();
    }
});


//insert
        btInsertar.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {


        Cone conn = new Cone(getApplicationContext(), "dosi", null, 1);

        SQLiteDatabase db = conn.getWritableDatabase();

        Cursor cursor = db.rawQuery(" select max (id) from  sabado ",null );

        cursor.moveToNext();

        position =  cursor.getInt(0);


        position = position+1;
       //insertar en base de datos
        if (!tx1.getText().toString().isEmpty()){



            String insert = " INSERT INTO " + Utilidades.TABLA_USUARIO + " (  "+Utilidades.CAMPO_NOMBRE+" ) " + " VALUES ('" + tx1.getText().toString() + "' )";

            db.execSQL(insert);



            db.close();

        }else {

            Toast.makeText(MainActivity.this,"debes ingresar name",Toast.LENGTH_SHORT).show();



        }

        //insertar en recicler
        insertarI(position);






                                 }
                             });

                          }


//imsert bd
    private void insertarI(int position) {


        Cone conn = new Cone(getApplicationContext(), "dosi", null, 1);

        SQLiteDatabase db = conn.getWritableDatabase();




        Cursor cursor = db.rawQuery(" select  " + Utilidades.CAMPO_NOMBRE + ","+Utilidades.CAMPO_ID+" from " + Utilidades.TABLA_USUARIO+" where "+Utilidades.CAMPO_ID+"="+position, null);

        while (cursor.moveToNext()) {

            Usuario usuario = null;
            usuario = new Usuario();


            usuario.setNombre(cursor.getString(0));
            usuario.setId(cursor.getInt(1));
            lista.add(usuario);

            if (cursor.getString(0).equals("jos")){

                db.close();
                adaptador.notifyItemInserted(position);

            }else {
                Toast.makeText(getApplicationContext(), "no es empatado", Toast.LENGTH_SHORT).show();

                db.close();
            }


        }








              //  lista.add(new Usuario(13,"nuevo"+position,"position :"+position,"4 pm"));

                  //adaptador.notifyItemInserted(position);

    }

    private void borrarIte(int position) {


lista.remove(position);
adaptador.notifyItemRemoved(position);

    }

    public  void update(int position) {

        Cone conn = new Cone(getApplicationContext(), "dosi", null, 1);

        SQLiteDatabase db = conn.getWritableDatabase();


        ContentValues values = new ContentValues();

        //
        // values.put(Utilidades.CAMPO_HORA, textView3.getText().toString());

        values.put(Utilidades.CAMPO_NOMBRE, txCon.getText().toString());


        db.update(Utilidades.TABLA_USUARIO, values, Utilidades.CAMPO_ID + "= 3", null);
        //db.update(Utilidades.TABLA_USUARIO, values, Utilidades.CAMPO_ID + "=?", in);

        Toast.makeText(getApplicationContext(), "actualiza bien", Toast.LENGTH_SHORT).show();

    }


    public void deleteBd(int position){

        if (lista.get(position).getNombre().equals("carro")){

Toast.makeText(MainActivity.this,"este",Toast.LENGTH_SHORT).show();

        }




    }
    public void array(){

        recyclerView = findViewById(R.id.reci);




        Cone conn = new Cone(MainActivity.this,"dosi",null,1);

        SQLiteDatabase db = conn.getReadableDatabase();


        Usuario usuario = null;


        lista = new ArrayList<Usuario>();


        Cursor cursor = db.rawQuery(" select  "+Utilidades.CAMPO_NOMBRE+ ", " +Utilidades.CAMPO_ID +" from "+  Utilidades.TABLA_USUARIO+" where "+Utilidades.CAMPO_NOMBRE+"='jos'", null);



        while (cursor.moveToNext()) {


            usuario = new Usuario();


            usuario.setNombre(cursor.getString(0));
            usuario.setId(cursor.getInt(1));


            lista.add(usuario);

        }
        db.close();






     //   lista.add( new Usuario(10,"jose", "1111","12 pm"));
       // lista.add( new Usuario(11,"casti", "222","2 pm"));
        //lista.add( new Usuario(12,"david", "333","3 pm"));



    }

    public void recicler(){



        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));



          adaptador = new Adapter(lista);

        recyclerView.setAdapter(adaptador);
//        recyclerView.scrollToPosition(lista.size()-1);

    }


    public  void inser(){


        if (!tx1.getText().toString().isEmpty()){

            Cone conn = new Cone(MainActivity.this, "dosi", null, 1);


            SQLiteDatabase db = conn.getWritableDatabase();

            String insert = " INSERT INTO " + Utilidades.TABLA_USUARIO + " (  "+Utilidades.CAMPO_NOMBRE+" ) " + " VALUES ('" + tx1.getText().toString() + "' )";

            db.execSQL(insert);



            db.close();

        }else {

            Toast.makeText(MainActivity.this,"debes ingresar name",Toast.LENGTH_SHORT).show();
        }



    }



    public void arc(){

        Cone conn = new Cone(getApplicationContext(), "ani", null, 1);

        SQLiteDatabase db = conn.getWritableDatabase();

        Cursor cursor = db.rawQuery(" select  " + Utilidades.CAMPO_NOMBRE + " from " + Utilidades.TABLA_USUARIO + " where " + Utilidades.CAMPO_NOMBRE+ "='jos'", null);


        Usuario usuario = null;
        usuario = new Usuario();
        cursor.moveToNext();




            lista.get(1).setNombre(cursor.getString(0));

        adaptador.notifyItemChanged(1);



    }

}