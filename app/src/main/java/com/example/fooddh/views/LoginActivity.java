package com.example.fooddh.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fooddh.R;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {


    private TextInputLayout textInputLayoutEmailLog;
    private TextInputLayout textInputLayoutSenha;
    private Button btnLogin;
    private Button btnRegistrar;
    private String email;
    private String senha;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validarCampos();
            }
        });

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity(intent);
            }
        });

    }

    private void validarCampos() {

        email = textInputLayoutEmailLog.getEditText().getText().toString();
        senha = textInputLayoutSenha.getEditText().getText().toString();

        if(email.isEmpty() || senha.isEmpty() ){
            textInputLayoutEmailLog.setError("Preencha seu e-mail");
            textInputLayoutSenha.setError("Coloque sua senha");
        } else {
            Intent intentRegistrado= new Intent(LoginActivity.this,HomeActivity.class);
            startActivity(intentRegistrado);
        }




    }

    private void initViews() {
        textInputLayoutEmailLog = findViewById(R.id.textInputLayoutEmailLog);
        textInputLayoutSenha = findViewById(R.id.textInputLayoutSenha);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        btnLogin = btnLogin.findViewById(R.id.btnLogin);

    }
}
