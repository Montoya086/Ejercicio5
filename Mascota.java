/*
Nombre: Andrés Estuardo Montoya Wilhelm
Programa: Mascota.java
Lenguaje: Java
Creación: 10/10/2021
Modificacion: 16/10/2021
*/
public class Mascota extends Acompanante{
    public Mascota(String nombre){
        super(nombre);
        tipo="Mascota";
        habilidad.add("Mordida");
        vida=500;
        vida_inicial=500;
        atq=90;
        atq_inicial=90;
        msg_muerte="*c muere unu*";
    }
    
}
