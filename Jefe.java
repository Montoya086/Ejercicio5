/*
Nombre: Andrés Estuardo Montoya Wilhelm
Programa: Jefe.java
Lenguaje: Java
Creación: 24/09/2021
Modificacion: 27/09/2021
*/
public class Jefe extends Enemigo{
    public Jefe(String nombre){
        super(nombre);
        tipo="Enemigo";
        if(nombre=="Slime"){
            this.nombre="Slime boss";
            habilidad.add("Veneno refinado");
            vida=600;
            atq=60;
        }
        if(nombre=="Undead"){
            this.nombre="Undead boss";
            habilidad.add("Fuerza de la muerte");
            vida=400;
            atq=120;
        }
        if(nombre=="Goblin"){
            this.nombre="Goblin boss";
            habilidad.add("Curacion ancestral");
            vida=1000;
            atq=30;
        }
    }
}
