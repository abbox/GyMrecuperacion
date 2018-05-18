package com.example.aboukili.gymrecuperacion.Model;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aboukili.gymrecuperacion.R;

import java.util.List;

public class adaptador extends RecyclerView.Adapter<adaptador.RutinasviewHolder> {

    List<rutina> rutinas;
    List<ejercicio> ejercicios;

    public adaptador() {
    }

    public adaptador(List<rutina> rutinas, List<ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
        this.rutinas = rutinas;
    }

    @Override
    public RutinasviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contenido_recycle,parent,false);
        RutinasviewHolder holder = new RutinasviewHolder(v);
        return  holder;
    }

    @Override
    public void onBindViewHolder(RutinasviewHolder holder, int position) {

        rutina rutina = rutinas.get(position);
        holder.tex_dia.setText(rutina.getDia());
        holder.tex_musculo.setText(rutina.getMusculo());
        //holder.tex_no_ejercicio.setText(ejercicios.get(0).getEjercicio());
        String cadEjer="";
        String cadDesc="";
        String cadSeries="";
        String cadRep="";

        for(int i=0;i<ejercicios.size();i++) {

            if (rutina.getDia().toString().equals(ejercicios.get(i).getDia())) {

                String ejer = ejercicios.get(i).getEjercicio();

                cadEjer=cadEjer+ejer+"\n";
                holder.tex_no_ejercicio.setText(cadEjer);

                String desc = ejercicios.get(i).getDescanso();

                cadDesc=cadDesc+desc+"\n";
                holder.tex_descanso.setText(cadDesc);

                String series = ejercicios.get(i).getSeries();

                cadSeries=cadSeries+series+"\n";
                holder.tex_series.setText(cadSeries);

                String rep = ejercicios.get(i).getRepeticiones();

                cadRep=cadRep+rep+"\n";
                holder.tex_repeticiones.setText(cadRep);
            }

        }
         Log.d("prueba",cadEjer);

        //Toast.makeText(adaptador.this, , Toast.LENGTH_SHORT).show();
    }

    @Override
    public int getItemCount() {
        return rutinas.size();
    }

    public static class RutinasviewHolder extends RecyclerView.ViewHolder{


        TextView tex_dia;
        TextView tex_musculo;
        TextView tex_no_ejercicio;
        TextView tex_series;
        TextView tex_repeticiones;
        TextView tex_descanso;


        public  RutinasviewHolder(View itemView){
            super(itemView);

            tex_dia =(TextView) itemView.findViewById(R.id.t_dia);

            tex_musculo = (TextView)itemView.findViewById(R.id.t_musculo);
            tex_no_ejercicio =(TextView) itemView.findViewById(R.id.t_no_ejercicio);
            tex_series =(TextView) itemView.findViewById(R.id.t_series);
            tex_repeticiones =(TextView) itemView.findViewById(R.id.t_repeticiones);
            tex_descanso = (TextView) itemView.findViewById(R.id.t_descanso);
        }
    }
}
