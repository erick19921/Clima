package ec.com.utn.application.clima;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registrar extends AppCompatActivity implements View.OnClickListener {
    EditText us, pas, nom, ap;
    Button btnRegistar, btnCancelar;
    daoUsuario dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        us= (EditText) findViewById(R.id.txtUsuarioR);
        pas= (EditText) findViewById(R.id.txtClaveR);
        nom= (EditText) findViewById(R.id.txtNombreR);
        ap= (EditText) findViewById(R.id.txtApellidoR);

        btnRegistar= (Button) findViewById(R.id.btnRegistrarR);
        btnCancelar=(Button) findViewById(R.id.btnCancelarR);

        btnRegistar.setOnClickListener(this);
        btnCancelar.setOnClickListener(this);

        dao= new daoUsuario(this);

    }

    @Override
    public void onClick(View v) {
     switch (v.getId()){
        case R.id.btnRegistrarR:
        Usuario u= new Usuario();
        u.setUsuario(us.getText().toString());
        u.setClave(pas.getText().toString());
        u.setNombre_usuario(nom.getText().toString());
        u.setApellido_usuario(ap.getText().toString());

        if(!u.isNull()){
            Toast.makeText(this, "Error de campos vacios", Toast.LENGTH_LONG).show();
        }else if(dao.insertUsuario(u)){
            Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_LONG).show();
            Intent i2= new Intent(Registrar.this, MainActivity.class);
            startActivity(i2);
            finish();
        }else {
            Toast.makeText(this, "Usuario existente", Toast.LENGTH_LONG).show();
        }
        break;

        case R.id.btnCancelarR:
        Intent i= new Intent(Registrar.this, MainActivity.class);
        startActivity(i);
        finish();
        break;

    }

    }
}