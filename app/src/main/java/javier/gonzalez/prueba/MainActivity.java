package javier.gonzalez.prueba;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javier.gonzalez.prueba.modelos.Direccion;
import javier.gonzalez.prueba.modelos.Usuario;

public class MainActivity extends AppCompatActivity {

    private EditText txtPassword;
    private Button btnDesencriptar;
    private EditText txtEmail;

    private Button btnCrearDir;
    private ActivityResultLauncher<Intent> launcherDirecciones;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarVariables();
        inicializarLaunchers();


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
                launcherDirecciones.launch(intent);


            }
        });


    }
    private void inicializarLaunchers() {

        launcherDirecciones = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result)
                    {
                        if(result.getResultCode() == RESULT_OK){
                            if(result.getData() != null){
                                Bundle bundle =
                                        result.getData().getExtras();
                                Direccion dir = (Direccion)
                                        bundle.getSerializable("DIR");
                                Toast.makeText(MainActivity.this,
                                        dir.toString(), Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(MainActivity.this, "No hay datos", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(MainActivity.this, "Ventana Cancelada", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }

    private void inicializarVariables() {
        txtPassword = findViewById(R.id.txtInfo);
        txtEmail = findViewById(R.id.txtEmail);
        btnDesencriptar = findViewById(R.id.btnEnviar);
        btnCrearDir = findViewById(R.id.btnDireccionCrear);
    }
}

