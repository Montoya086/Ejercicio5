/*
Nombre: Andrés Estuardo Montoya Wilhelm
Programa: Acompañante.java
Lenguaje: Java
Creación: 10/10/2021
Modificacion: 16/10/2021
*/
public class Acompanante_enemigo extends Acompanante{
    public Acompanante_enemigo(String nombre, String habilidad, int atq, int vida){
        super(nombre);
        tipo="Acompanante_enemigo";
        this.habilidad.add(habilidad);
        this.atq=atq;
        atq_inicial=this.atq;
        this.vida=vida;
        vida_inicial=this.vida;
    }
}
