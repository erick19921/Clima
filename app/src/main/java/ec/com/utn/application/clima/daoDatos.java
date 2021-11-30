package ec.com.utn.application.clima;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class daoDatos {

    Context c;
    Datos d;
    ArrayList<Datos> lista;
    SQLiteDatabase sql;
    String bd= "DBUsuarios";
    String tabla2= "CREATE TABLE IF NOT EXISTS datos(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "fecha TEXT not null," +
            "hora TEXT not null," +
            "sector TEXT not null," +
            "latitud NUMERIC not null," +
            "longitud NUMERIC not null," +
            "id_sensor TEXT not null," +
            "valor_grados NUMERIC not null," +
            "id_usuario integer not null," +
            "fecha_hora_ingreso TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL," +
            "foreign key(id_usuario) references usuario(id))";

    public daoDatos(Context c){
        this.c=c;
        sql= c.openOrCreateDatabase(bd, c.MODE_PRIVATE, null);
        //sql.execSQL(tabla);
        sql.execSQL(tabla2);
        d=new Datos();
    }

    public  boolean insertDatos(Datos d){
        if(buscar(d.getId())==0){
            ContentValues cv = new ContentValues();
            cv.put("fecha", d.getFecha());
            cv.put("hora", d.getHora());
            cv.put("sector", d.getSector());
            cv.put("latitud",d.getLatitud());
            cv.put("longitud", d.getLongitud());
            cv.put("id_sensor", d.getId_sensor());
            cv.put("valor_grados",d.getValor_grados());
            cv.put("id_usuario", d.getId_usuario());
           // cv.put("fecha_hora_ingreso", d.getFecha_hora_ingreso());
            return (sql.insert("datos",  null, cv)>0);

        }else {
            return false;
        }
    }



    public int buscar(int d){
        int x=0;
        lista = selectDatos();
        for(Datos ds:lista){
            if(ds.getId()==d){
                x++;
            }
        }
        return x;
    }

    public ArrayList<Datos> selectDatos() {

        ArrayList<Datos> lista = new ArrayList<Datos>();
        lista.clear();
        Cursor cr= sql.rawQuery("select * from datos", null);
        if(cr!=null&&cr.moveToFirst()){
            do{
                Datos d = new Datos();
                d.setId(cr.getInt(0));
                d.setFecha(cr.getString(1));
                d.setHora(cr.getString(2));
                d.setSector(cr.getString(3));
                d.setLatitud(cr.getDouble(4));
                d.setLongitud(cr.getDouble(5));
                d.setId_sensor(cr.getString(6));
                d.setValor_grados(cr.getDouble(7));
                d.setId_usuario(cr.getInt(8));
                d.setFecha_hora_ingreso(cr.getString(9));
                lista.add(d);

            }while (cr.moveToNext());

        }
        return lista;
    }

}