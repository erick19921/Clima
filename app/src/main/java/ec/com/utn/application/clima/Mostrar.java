package ec.com.utn.application.clima;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Mostrar extends AppCompatActivity {
    ListView lista;
    daoUsuario dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        lista=(ListView) findViewById(R.id.listView_usuarios);
        dao= new daoUsuario(this);
        ArrayList<Usuario> l= dao.selectUsuarios();
        ArrayList<String> list = new ArrayList<String>();
        for (Usuario u:l) {
         list.add(u.getNombre_usuario()+"  "+u.getApellido_usuario());
        }
        ArrayAdapter<String> a = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,list);
        lista.setAdapter(a);

    }
}