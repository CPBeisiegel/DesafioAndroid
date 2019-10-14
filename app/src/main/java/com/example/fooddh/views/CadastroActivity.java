package com.example.fooddh.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fooddh.R;
import com.google.android.material.textfield.TextInputLayout;

public class CadastroActivity extends AppCompatActivity {

    private TextInputLayout textEmail;
    private TextInputLayout textPassword;
    private TextInputLayout textNome;
    private TextInputLayout textRepetirPassword;
    private Button btnRegistrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        initViews();

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                validarDados();
            }
        });

    }

    private void validarDados(){

        String nome = textNome.getEditText().getText().toString();
        String email = textEmail.getEditText().getText().toString();
        String password = textPassword.getEditText().getText().toString();
        String confirmarPassword = textRepetirPassword.getEditText().getText().toString();


        if( nome.isEmpty() ||  email.isEmpty() || password.isEmpty() || confirmarPassword.isEmpty()){
            textNome.setError("Campo obrigatório");
            textEmail.setError("Campo obrigatório");
            textPassword.setError("Campo obrigatório");
            textRepetirPassword.setError("Campo obrigatório");
        } else if((password.equals(confirmarPassword) && !password.isEmpty() && !confirmarPassword.isEmpty())) {
            textPassword.setError("As senhas não coinciedem");
            textRepetirPassword.setError("As senhas não coinciedem");
        } else{
            Intent intent = new Intent(CadastroActivity.this,HomeActivity.class);
            startActivity(intent);
        }

    }


    private void initViews() {
        textNome = findViewById(R.id.textInputLayoutNome);
        textEmail = findViewById(R.id.textInputLayoutEmail);
        textPassword = findViewById(R.id.textInputLayoutPassword);
        textRepetirPassword = findViewById(R.id.textInputLayoutRepetirPassword);
        btnRegistrar = findViewById(R.id.btnRegistrar);

    }
}
