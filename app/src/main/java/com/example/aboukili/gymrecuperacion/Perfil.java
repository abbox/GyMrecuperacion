package com.example.aboukili.gymrecuperacion;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aboukili.gymrecuperacion.Model.Usuarios;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.io.IOError;
import java.io.IOException;
import java.util.ArrayList;


public class Perfil extends Fragment{

    EditText nombreU;
    EditText apellidoU;
    EditText edadU;
    EditText pesoU;
    Button aceptarU;
    Button modificarU;
    DatabaseReference bbdd,bbdd2;

    TextView correoU;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Perfil");
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.perfil,container,false);

        View v = inflater.inflate(R.layout.perfil, container, false);

        nombreU =(EditText) v.findViewById(R.id.edi_nombre);
        apellidoU = (EditText) v.findViewById(R.id.edi_apellido);
        edadU = (EditText) v.findViewById(R.id.edi_Edad);
        pesoU = (EditText) v.findViewById(R.id.edi_peso);
        aceptarU = (Button) v.findViewById(R.id.btn_usu_aceptar);
        modificarU = (Button) v.findViewById(R.id.btn_usu_modificar);


        //recibimos el nombre del usuario del login
        correoU = (TextView) v.findViewById(R.id.info_login_usua);
        final Bundle bolsaRecibe = getActivity().getIntent().getExtras();//getArguments().getInt();
        correoU.setText(bolsaRecibe.getString("nombreKey"));
        final String recibe = bolsaRecibe.getString("nombreKey");

        //String[] correoUsuario= recibe.split(":");
        //String co = correoUsuario[1];

        String[] correoUsuario= recibe.split("\\.");
        String co = correoUsuario[0];
        Toast.makeText(getContext(), co, Toast.LENGTH_SHORT).show();
        //comparar con la base de datos los datos del correo recibidobbbbbb

        bbdd = FirebaseDatabase.getInstance().getReference("usuarios");

        Query q = bbdd.child(co);

            q.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                        Usuarios usuarios = dataSnapshot.getValue(Usuarios.class);

                    if(usuarios!=null) {
                        String nombre = usuarios.getNombreUsuario();
                        //Toast.makeText(getContext(), nombre, Toast.LENGTH_SHORT).show();
                        String apellido = usuarios.getApellidosUsuario();
                        String edad = usuarios.getEdadUsuario();
                        String peso = usuarios.getPesoUsuario();
                        // String correo = usuarios.getCorreoUsuario();

                        nombreU.setText(nombre);
                        apellidoU.setText(apellido);
                        edadU.setText(edad);
                        pesoU.setText(peso);
                    }

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });


        aceptarU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreUsuari = nombreU.getText().toString();
                String apellidosUsuario = apellidoU.getText().toString();
                String edadUsuario = edadU.getText().toString();
                String pesoUsuario = pesoU.getText().toString();
                String[] correoUsuario= recibe.split("\\.");
                String co = correoUsuario[0];
                String correo = recibe;
                //String CorreoUsuario =;

                //Query q =bbdd.orderByChild("")
                if (!TextUtils.isEmpty(nombreUsuari)){
                    if (!TextUtils.isEmpty(apellidosUsuario)){
                        if (!TextUtils.isEmpty(edadUsuario)){
                            if (!TextUtils.isEmpty(pesoUsuario)){

                                Usuarios u = new Usuarios(nombreUsuari,apellidosUsuario,edadUsuario,pesoUsuario,correo);
                                //String clave =bbdd.push().getKey();
                                bbdd.child(co).setValue(u);

                                Toast.makeText(getContext(), "Usuario añadido", Toast.LENGTH_LONG).show();

                            }else {
                                Toast.makeText(getContext(), "debes de introducir Peso", Toast.LENGTH_LONG).show();
                            }
                        }else {
                            Toast.makeText(getContext(), "debes de introducir EDAD", Toast.LENGTH_LONG).show();
                        }
                    }else {
                        Toast.makeText(getContext(), "debes de introducir Apellidos", Toast.LENGTH_LONG).show();
                    }
                }   else {
                    Toast.makeText(getContext(), "debes de introducir Nombre", Toast.LENGTH_LONG).show();
                }
            }
        });


        modificarU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final  String nombreUsuari = nombreU.getText().toString();

                if (!TextUtils.isEmpty(nombreUsuari)){
                    Query q = bbdd.orderByChild("correoUsuario").equalTo(recibe);
                    // Query q = bbdd.child(usuario);

                    q.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                                String clave = dataSnapshot1.getKey();
                                bbdd.child(clave).child("nombreUsuario").setValue(nombreU.getText().toString());
                                bbdd.child(clave).child("apellidosUsuario").setValue(apellidoU.getText().toString());
                                bbdd.child(clave).child("edadUsuario").setValue(edadU.getText().toString());
                                bbdd.child(clave).child("pesoUsuario").setValue(pesoU.getText().toString());
                                //bbdd.child(clave).child("NombreUsuario").setValue(tNombreUsuario.getText().toString());

                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                    Toast.makeText(getContext(), "modificado "+nombreUsuari, Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getContext(), "introduce un usuario", Toast.LENGTH_LONG).show();
                }

            }
        });


        return v;

    }

}
