package ec.com.utn.application.clima;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class reg_datos extends AppCompatActivity implements View.OnClickListener {
    EditText fecha, hora, sector, latitud, longitud, idsensor, vgrados, nombreUs;
    Button btnRegistar, btnCancelar;
    daoDatos dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_datos);

        fecha= (EditText) findViewById(R.id.txtFechaD);
        hora= (EditText) findViewById(R.id.txtHoraD);
        sector= (EditText) findViewById(R.id.txtSectorD);
        latitud= (EditText) findViewById(R.id.txtLatitudD);
        longitud= (EditText) findViewById(R.id.txtLongitudD);
        idsensor= (EditText) findViewById(R.id.txtIdsensorD);
        vgrados= (EditText) findViewById(R.id.txtValorGradosD);
        nombreUs= (EditText) findViewById(R.id.txtUsuarioD);
        //fechaIngreso= (EditText) findViewById(R.id.txtFechaIngresoDato);

        btnRegistar= (Button) findViewById(R.id.btnRegistrarD);
        btnCancelar=(Button) findViewById(R.id.btnCancelarD);

        btnRegistar.setOnClickListener(this);
        btnCancelar.setOnClickListener(this);

        dao= new daoDatos(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnRegistrarD:
                Datos d= new Datos();

                    d.setFecha(fecha.getText().toString());
                    d.setHora(hora.getText().toString());
                    d.setSector(sector.getText().toString());
                    d.setLatitud(Double.parseDouble(latitud.getText().toString()));
                    d.setLongitud(Double.parseDouble(longitud.getText().toString()));
                    d.setId_sensor(idsensor.getText().toString());
                    d.setValor_grados(Double.parseDouble(vgrados.getText().toString()));
                    d.setId_usuario(Integer.parseInt(nombreUs.getText().toString()));
                    //d.setFecha_hora_ingreso(fechaIngreso.getText().toString());

                    if(!d.isNull()){
                        Toast.makeText(this, "Error de campos vacios", Toast.LENGTH_LONG).show();
                    }else if(dao.insertDatos(d)){
                        Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_LONG).show();
                        Intent i2= new Intent(reg_datos.this, Inicio.class);
                        startActivity(i2);
                        finish();

                    }else {
                        Toast.makeText(this, "Dato existente", Toast.LENGTH_LONG).show();
                    }

                break;
            case R.id.btnCancelarD:
                //Datos d= new Datos();
                Intent i= new Intent(reg_datos.this, Inicio.class);
                startActivity(i);
                finish();
                break;

        }

    }
}