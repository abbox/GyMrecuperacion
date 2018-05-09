package com.example.aboukili.gymrecuperacion;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    EditText login_usuario;
    EditText login_contraseya;
    Button btn_login_registrar;
    Button btn_login_login;

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_usuario = (EditText) findViewById(R.id.Text_login_usuario);
        login_contraseya = (EditText) findViewById(R.id.Text_login_contraseña);
        btn_login_registrar = (Button) findViewById(R.id.btn_login_registrar);
        btn_login_login = (Button) findViewById(R.id.btn_login_login);


        btn_login_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = login_usuario.getText().toString();
                String pass = login_contraseya.getText().toString();

                login(email,pass);
            }
        });

        btn_login_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = login_usuario.getText().toString();
                String pass = login_contraseya.getText().toString();

                registrar(email,pass);

            }
        });

    }

    private void registrar (String email, String pass){

        mAuth = FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){
                    FirebaseUser user = mAuth.getCurrentUser();

                    Toast.makeText(Login.this, "Registro aceptado."+user.getUid(),
                            Toast.LENGTH_SHORT).show();

                }else {

                    Toast.makeText(Login.this, "failed.",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });

    }




    private void login (final String email, String pass){

        mAuth = FirebaseAuth.getInstance();
        mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){
                    FirebaseUser user = mAuth.getCurrentUser();

                    Toast.makeText(Login.this, "has iniciado sesion."+user.getUid(),
                            Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(Login.this,MainActivity.class);

                    Bundle bolsa = new Bundle();
                    bolsa.putString("nombreKey",email);
                    intent.putExtras(bolsa);

                    startActivity(intent);
                }else {

                    Toast.makeText(Login.this, "failed.",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

}
