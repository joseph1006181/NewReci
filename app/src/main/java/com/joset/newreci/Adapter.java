package com.joset.newreci;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.vistaViewHolder> {




   ArrayList<Usuario> lista ;

private comu comu;



    public void setOncl(comu comu) {


        this.comu = comu;
    }





    public Adapter(ArrayList<Usuario> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public vistaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rec,null,false);





        return new vistaViewHolder(view , comu);
    }

    @Override
    public void onBindViewHolder(@NonNull vistaViewHolder holder, int position) {

        Usuario  usuario = lista.get(position);


holder.tex1.setText(usuario.getNombre());
        holder.tx2.setText(usuario.getId().toString());









    }

    @Override
    public int getItemCount() {
        return lista.size();
    }



    public class vistaViewHolder extends RecyclerView.ViewHolder {



        TextView tex1 , linea , tx2;
        View view;
        Button btq;
        public vistaViewHolder(@NonNull View itemView, com.joset.newreci.comu comu) {
            super(itemView);

              tex1=itemView.findViewById(R.id.text11);
              linea=itemView.findViewById(R.id.raya);
            tx2=itemView.findViewById(R.id.textView2);
              btq = itemView.findViewById(R.id.button2);

itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {


        int pos = getAdapterPosition();
comu.comu(pos);


    }
});


        }
    }
}
