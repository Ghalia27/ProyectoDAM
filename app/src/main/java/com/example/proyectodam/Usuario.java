package com.example.proyectodam;

public class Usuario {
    int idusuario, idperfil;
    String nombres, apellidos,fecha_nacimiento, correo, password, celular;

    public Usuario(int idusuario, int idperfil, String nombres, String apellidos, String fecha_nacimiento, String correo, String password, String celular) {
        this.idusuario = idusuario;
        this.idperfil = idperfil;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fecha_nacimiento = fecha_nacimiento;
        this.correo = correo;
        this.password = password;
        this.celular = celular;
    }

    public boolean isNull(){
         if (nombres.equals("")&&apellidos.equals("")&&fecha_nacimiento.equals("")&& correo.equals("")&&password.equals("")&&celular.equals("")){
             return false;
         }else{
             return true;
         }
     }
    @Override
    public String toString() {
        return "Usuario{" +
                "idusuario=" + idusuario +
                ", idperfil=" + idperfil +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fecha_nacimiento='" + fecha_nacimiento + '\'' +
                ", correo='" + correo + '\'' +
                ", password='" + password + '\'' +
                ", celular='" + celular + '\'' +
                '}';
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(int idperfil) {
        this.idperfil = idperfil;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Usuario(){

    }


}
