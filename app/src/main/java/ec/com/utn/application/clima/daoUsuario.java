package ec.com.utn.application.clima;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;


    public class daoUsuario {
        Context c;
        Usuario u;
        Datos d;
        ArrayList<Usuario> lista;
        ArrayList<Datos> listad;
        SQLiteDatabase sql;
        String bd = "DBUsuarios";
        String tabla = "create table if not exists usuario(id integer primary key autoincrement, usuario text, clave text, nombre text, apellido text)";
        String tabla2 = "CREATE TABLE IF NOT EXISTS datos(" +
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

        public daoUsuario(Context c) {
            this.c = c;
            sql = c.openOrCreateDatabase(bd, c.MODE_PRIVATE, null);
            sql.execSQL(tabla);
            sql.execSQL(tabla2);
            u = new Usuario();
            d = new Datos();
        }

        public boolean insertUsuario(Usuario u) {
            if (buscar(u.getUsuario()) == 0) {
                ContentValues cv = new ContentValues();
                cv.put("usuario", u.getUsuario());
                cv.put("clave", u.getClave());
                cv.put("nombre", u.getNombre_usuario());
                cv.put("apellido", u.getApellido_usuario());
                return (sql.insert("usuario", null, cv) > 0);

            } else {
                return false;
            }
        }

        public int buscar(String u) {
            int x = 0;
            lista = selectUsuarios();
            for (Usuario us : lista) {
                if (us.getUsuario().equals(u)) {
                    x++;
                }
            }
            return x;
        }

        public ArrayList<Usuario> selectUsuarios() {

            ArrayList<Usuario> lista = new ArrayList<Usuario>();
            lista.clear();
            Cursor cr = sql.rawQuery("select * from usuario", null);
            if (cr != null && cr.moveToFirst()) {
                do {
                    Usuario u = new Usuario();
                    u.setId(cr.getInt(0));
                    u.setUsuario(cr.getString(1));
                    u.setClave(cr.getString(2));
                    u.setNombre_usuario(cr.getString(3));
                    u.setApellido_usuario(cr.getString(4));
                    lista.add(u);

                } while (cr.moveToNext());

            }
            return lista;
        }

        //Metodo para verificar las credenciales de usuario
        public int login(String u, String p) {
            int a = 0;
            Cursor cr = sql.rawQuery("select * from usuario", null);
            if (cr != null && cr.moveToFirst()) {
                do {
                    if (cr.getString(1).equals(u) && cr.getString(2).equals(p)) {
                        a++;
                    }

                } while (cr.moveToNext());

            }
            return a;
        }


        public Usuario getUsuario(String u, String p) {
            lista = selectUsuarios();
            for (Usuario us : lista) {
                if (us.getUsuario().equals(u) && us.getClave().equals(p)) {
                    return us;
                }
            }
            return null;

        }


        public Usuario getUsuarioById(int id) {
            lista = selectUsuarios();
            for (Usuario us : lista) {
                if (us.getId() == id) {
                    return us;
                }
            }
            return null;
        }

        public boolean updateUsuario(Usuario u) {
            ContentValues cv = new ContentValues();
            cv.put("usuario", u.getUsuario());
            cv.put("clave", u.getClave());
            cv.put("nombre", u.getNombre_usuario());
            cv.put("apellido", u.getApellido_usuario());
            return (sql.update("usuario", cv, "id=" + u.getId(), null) > 0);

        }

        public boolean deleteUsuario(int id) {
            return (sql.delete("usuario", "id=" + id, null) > 0);
        }


    }
