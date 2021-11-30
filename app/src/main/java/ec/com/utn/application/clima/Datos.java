package ec.com.utn.application.clima;

import java.sql.Timestamp;

public class Datos {
    int id;
    String fecha;
    String hora;
    String sector;
    Double latitud;
    Double longitud;
    String id_sensor;
    Double valor_grados;
    int id_usuario;
    String fecha_hora_ingreso;

    public Datos() {

    }

    public Datos(String fecha, String hora, String sector, Double latitud, Double longitud, String id_sensor, Double valor_grados, int id_usuario, String fecha_hora_ingreso) {


        this.fecha = fecha;
        this.hora = hora;
        this.sector = sector;
        this.latitud = latitud;
        this.longitud = longitud;
        this.id_sensor = id_sensor;
        this.valor_grados = valor_grados;
        this.id_usuario = id_usuario;
        this.fecha_hora_ingreso = fecha_hora_ingreso;
    }

    @Override
    public String toString() {
        return "Datos{" +
                "id=" + id +
                ", fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                ", sector='" + sector + '\'' +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                ", id_sensor='" + id_sensor + '\'' +
                ", valor_grados=" + valor_grados +
                ", id_usuario=" + id_usuario +
                ", fecha_hora_ingreso='" + fecha_hora_ingreso + '\'' +
                '}';
    }

   public boolean isNull(){
     return !fecha.equals("") || !hora.equals("") || !sector.equals("") || !latitud.equals("") || !longitud.equals("") || !id_sensor.equals("") || !valor_grados.equals("") || id_usuario != 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public String getId_sensor() {
        return id_sensor;
    }

    public void setId_sensor(String id_sensor) {
        this.id_sensor = id_sensor;
    }

    public Double getValor_grados() {
        return valor_grados;
    }

    public void setValor_grados(Double valor_grados) {
        this.valor_grados = valor_grados;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getFecha_hora_ingreso() {
        return fecha_hora_ingreso;
    }

    public void setFecha_hora_ingreso(String fecha_hora_ingreso) {
        this.fecha_hora_ingreso = fecha_hora_ingreso;
    }
}
