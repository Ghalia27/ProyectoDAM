package com.example.proyectodam;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DAOUsuario {
    Context c;
    Usuario u;
    ArrayList<Usuario> lista;
    SQLiteDatabase sql;
    String bd="BD_RESERVACIONES";
    String tabla="create table usuario(idusuario integer primary key autoincrement, nombres text, apellidos text, fecha_nacimiento text, correo text, password text, celular text, idperfil int ,FOREIGN KEY(idperfil) REFERENCES Perfil(idperfil))";

    public DAOUsuario(Context c){
        this.c=c;
        sql = c.openOrCreateDatabase(bd, c.MODE_PRIVATE, null);
        sql.execSQL(tabla);
        u = new Usuario();
    }
    public boolean insertUsuario(Usuario u){
        if (buscar(u.getCorreo())==0){
            ContentValues cv= new ContentValues();
            cv.put("nombres", u.getNombres());
            cv.put("apellidos", u.getApellidos());
            cv.put("fecha_nacimiento", u.getFecha_nacimiento());
            cv.put("correo", u.getCorreo());
            cv.put("password", u.getPassword());
            cv.put("celular", u.getCelular());
            cv.put("idperfil", u.getIdperfil());
            return (sql.insert("usuario", null, cv)>0);
        }else{
            return false;
        }
    }
    public int buscar (String u){
        int x=0;
        lista= selectUsuario();
        for (Usuario ur: lista){
            if (ur.getCorreo().equals(u));
            x++;
        }
        return x;
    }
    public ArrayList<Usuario> selectUsuario(){
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        lista.clear();
        Cursor cr = sql.rawQuery("select * from usuario", null);
        if (cr!=null&&cr.moveToFirst()){
            do{
                Usuario u = new Usuario();
                u.setIdusuario(cr.getInt(0));
                u.setNombres(cr.getString(1));
                u.setApellidos(cr.getString(2));
                u.setFecha_nacimiento(cr.getString(3));
                u.setCorreo(cr.getString(4));
                u.setPassword(cr.getString(5));
                u.setCelular(cr.getString(6));
                u.setIdperfil(cr.getInt(7));
                lista.add(u);

            }while (cr.moveToNext());
        }
        return lista;


    }
}
