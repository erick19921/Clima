package ec.com.utn.application.clima;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Editar extends AppCompatActivity implements View.OnClickListener {
    EditText txtediUsuario, txtediclave,txtediNombre, txtediApellido;
    Button btnediActualizar, btnediCancelar;
    int id=0;
    Usuario u;
    daoUsuario dao;
    Intent x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        txtediUsuario = (EditText) findViewById(R.id.txtUsuarioE);
        txtediclave= (EditText) findViewById(R.id.txtClaveE);
        txtediNombre= (EditText) findViewById(R.id.txtNombreE);
        txtediApellido= (EditText) findViewById(R.id.txtApellidoE);

        btnediActualizar= (Button) findViewById(R.id.btnEditarE);
        btnediCancelar= (Button) findViewById(R.id.btnCancelarE);

        btnediActualizar.setOnClickListener(this);
        btnediCancelar.setOnClickListener(this);

        Bundle b= getIntent().getExtras();
        id= b.getInt("id");
        dao= new daoUsuario(this);
        u= dao.getUsuarioById(id);
        txtediUsuario.setText(u.getUsuario());
        txtediclave.setText(u.getClave());
        txtediNombre.setText(u.getNombre_usuario());
        txtediApellido.setText(u.getApellido_usuario());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnEditarE:
                u.setUsuario(txtediUsuario.getText().toString());
                u.setClave(txtediclave.getText().toString());
                u.setNombre_usuario(txtediNombre.getText().toString());
                u.setApellido_usuario(txtediApellido.getText().toString());

                if(!u.isNull()){
                    Toast.makeText(this, "Error de campos vacios", Toast.LENGTH_LONG).show();
                }else if(dao.updateUsuario(u)){
                    Toast.makeText(this, "Actualización Exitosa", Toast.LENGTH_LONG).show();
                    Intent i2= new Intent(Editar.this, Inicio.class);
                    i2.putExtra("id", u.getId());
                    startActivity(i2);
                    finish();
                }else {
                    Toast.makeText(this, "No se puede editar", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btnCancelarE:
                Intent i2 = new Intent(Editar.this, Inicio.class);
                i2.putExtra("id", u.getId());
                startActivity(i2);
                finish();
                break;
        }
    }
}