package javier.gonzalez.prueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import javier.gonzalez.prueba.modelos.Usuario;

public class DesencriptarActivity extends AppCompatActivity {

    private TextView txtRespuesta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desencriptar);
        inicializarVariables();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle != null){


            Usuario user = (Usuario) bundle.getSerializable("USER");
            Toast.makeText(this, user.toString(),
                    Toast.LENGTH_SHORT).show();
            txtRespuesta.setText(user.toString());



        }
}
    private void inicializarVariables() {

        txtRespuesta =findViewById(R.id.txtRespuesta);
    }
}
