/*
Nombre: Andrés Estuardo Montoya Wilhelm
Programa: Raidboss.java
Lenguaje: Java
Creación: 10/10/2021
Modificacion: 16/10/2021
*/
import java.util.ArrayList;

public class Raidboss extends Jefe{
    public Raidboss(String nombre){
        super(nombre);
        tipo="Jefe";
        if(nombre=="Borg"){
            acompañantes=new ArrayList<Acompanante>();
            this.nombre="Borg: Protector de almas";
            habilidad.add("Robar alma");
            habilidad.add("Destruir alma");
            vida=1200;
            atq=95;//95
            msg_inicio="Gracias por traer sus almas a mi";
            msg_muerte="Las almas son eternas...";
            msg_victoria="Almas debiles, mis favoritas";          
        }
    }
}
