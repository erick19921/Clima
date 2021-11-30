package ec.com.utn.application.clima;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener {
EditText user, pass;
Button btnEntrar, btnRegistar;
daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user= (EditText) findViewById(R.id.txtUsuarioLogin);
        pass= (EditText) findViewById(R.id.txtclaveLogin);

        btnEntrar= (Button) findViewById(R.id.btnIngresarLogin);
        btnRegistar=(Button) findViewById(R.id.btnRegistrarLogin);

        btnEntrar.setOnClickListener(this);
        btnRegistar.setOnClickListener(this);
        dao= new daoUsuario(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnIngresarLogin:
                String u= user.getText().toString();
                String p= pass.getText().toString();
                if (u.equals("") && p.equals("")) {
                    Toast.makeText(this, "Error: Campos vacios", Toast.LENGTH_LONG).show();
                }else  if (dao.login(u,p)==1){
                    Usuario ux =dao.getUsuario(u,p);
                    Toast.makeText(this, "Datos correctos", Toast.LENGTH_LONG).show();
                    Intent i2= new Intent(MainActivity.this, Inicio.class);
                    i2.putExtra("id", ux.getId());
                    startActivity(i2);
                    finish();
                }else {
                    Toast.makeText(this, "Usuario y/o clave incorrectos", Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.btnRegistrarLogin:
                Intent i= new Intent(MainActivity.this, Registrar.class);
                startActivity(i);
        break;


        }
    }
}