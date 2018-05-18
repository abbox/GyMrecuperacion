package com.example.aboukili.gymrecuperacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.aboukili.gymrecuperacion.Model.adaptador;
import com.example.aboukili.gymrecuperacion.Model.ejercicio;
import com.example.aboukili.gymrecuperacion.Model.rutina;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class RecycleActivity extends AppCompatActivity {

    RecyclerView rv;
    List<rutina> rutinas;
    DatabaseReference bbdd, bbdd2;
    List<ejercicio> ejercicios;

    adaptador adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

        rv = (RecyclerView) findViewById(R.id.recycle);

        rv.setLayoutManager(new LinearLayoutManager(this));



        rutinas = new ArrayList<>();
        ejercicios = new ArrayList<>();

        //final DatabaseReference database = FirebaseDatabase.getInstance().getReference("Rutinas");

        //adapter = new Adapter(rutinas);
        adapter = new adaptador(rutinas, ejercicios);

        bbdd = FirebaseDatabase.getInstance().getReference("Rutinas");
        bbdd2=FirebaseDatabase.getInstance().getReference("Ejercicios");
        rv.setAdapter(adapter);


        bbdd.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                rutinas.removeAll(rutinas);

                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    rutina rutina =snapshot.getValue(com.example.aboukili.gymrecuperacion.Model.rutina.class);
                    final String dia= rutina.getDia();

                    rutinas.add(rutina);



                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        bbdd2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot1) {
                ejercicios.removeAll(ejercicios);

                for (DataSnapshot snapshot1 : dataSnapshot1.getChildren()) {
                    ejercicio ejercicio = snapshot1.getValue(com.example.aboukili.gymrecuperacion.Model.ejercicio.class);
                    ejercicios.add(ejercicio);
                }
                Toast.makeText(RecycleActivity.this, ejercicios.get(0).getEjercicio(), Toast.LENGTH_SHORT).show();
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
