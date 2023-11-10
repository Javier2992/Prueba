package javier.gonzalez.prueba;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import javier.gonzalez.prueba.modelos.Usuario;

public class MainActivity extends AppCompatActivity {

    private EditText txtPassword;
    private Button btnDesencriptar;
    private EditText txtEmail;

    private Button btnCrearDir;

    private final int DIRECCIONES = 123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarVariables();


        btnDesencriptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = txtPassword.getText().toString();
                String email = txtEmail.getText().toString();
                Intent intent = new Intent(MainActivity.this,
                        DesencriptarActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("USER", new Usuario(email, password));
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });

        btnCrearDir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,
                        CrearDireccionActivity.class);
                startActivityForResult(intent, DIRECCIONES);
            }
        });



    }

    private void inicializarVariables() {
        txtPassword = findViewById(R.id.txtInfo);
        txtEmail = findViewById(R.id.txtEmail);
        btnDesencriptar = findViewById(R.id.btnEnviar);
        btnCrearDir = findViewById(R.id.btnDireccionCrear);
    }
}
