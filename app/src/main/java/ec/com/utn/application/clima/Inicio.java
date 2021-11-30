package ec.com.utn.application.clima;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Inicio extends AppCompatActivity implements View.OnClickListener {
    Button btnEditar, btnEliminar, btnMostrar, btnSalir, regDatos;
    TextView nombre;
    int id =0;
    Usuario u;
    daoUsuario dao;
    Datos d;
    daoDatos daod;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        nombre=(TextView) findViewById(R.id.txtnombreinicio);
        //btnEditar=(Button) findViewById(R.id.btneditarInicio);
       // btnEliminar=(Button) findViewById(R.id.btnEliminarInicio);
        btnMostrar=(Button) findViewById(R.id.btnMostrarInicio);
        btnSalir=(Button) findViewById(R.id.btnSalirInicio);
        regDatos=(Button) findViewById(R.id.btnRegNewD);

        //btnEditar.setOnClickListener(this);
        //btnEliminar.setOnClickListener(this);
        btnMostrar.setOnClickListener(this);
        btnSalir.setOnClickListener(this);
        regDatos.setOnClickListener(this);

        Bundle b= getIntent().getExtras();
        id= b.getInt("id");
        dao= new daoUsuario(this);
        u= dao.getUsuarioById(id);
        nombre.setText("Bienvenido "+u.getNombre_usuario()+" "+ u.getApellido_usuario());


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
           /* case R.id.btneditarInicio:
                Intent e = new Intent(Inicio.this, Editar.class);
                e.putExtra("id",id);
                startActivity(e);

                break;
            case R.id.btnEliminarInicio:
        //Evento para eliminar un usuario
                AlertDialog.Builder b= new AlertDialog.Builder(this);
                b.setMessage("¿Estas seguro de eliminar la cuenta?");
                b.setCancelable(false);
                b.setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        if (dao.deleteUsuario(id)){
                            Toast.makeText(Inicio.this, "Eliminación exitosa!!", Toast.LENGTH_LONG).show();
                            Intent a = new Intent(Inicio.this, MainActivity.class);
                            startActivity(a);
                            finish();
                        }else{
                            Toast.makeText(Inicio.this, "Error, No se pudo eliminar cuenta!!", Toast.LENGTH_LONG).show();
                        }
                    }
                });

                b.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                b.show();
                break;*/
            case R.id.btnMostrarInicio:
                Intent m = new Intent(Inicio.this, Mostrar.class);
                startActivity(m);

                break;
            case R.id.btnSalirInicio:
                Intent i = new Intent(Inicio.this, MainActivity.class);
                i.putExtra("id",id);
                startActivity(i);
                finish();
                break;

            case R.id.btnRegNewD:
                Intent d = new Intent(Inicio.this, reg_datos.class);
                d.putExtra("id", d.getExtras());
                startActivity(d);
                break;
            case R.id.btnTempUserSensor:
                Intent e = new Intent(Inicio.this, TemperaturasRegistradas_user_sensor.class);
                startActivity(e);
                break;
            case R.id.btnTempMediaSector:
                Intent g = new Intent(Inicio.this, TempMediaSector.class);
                startActivity(g);
                break;
            case R.id.btnTempUsSecSensor:
                Intent h = new Intent(Inicio.this, TemperaturaUserSector.class);
                startActivity(h);
                break;

            case R.id.btnTempInterHorasSec:
                Intent k = new Intent(Inicio.this, TemperaturaUserSector.class);
                startActivity(k);
                break;
        }
    }
}