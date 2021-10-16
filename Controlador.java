/*
Nombre: Andrés Estuardo Montoya Wilhelm
Programa: Controlador.java
Lenguaje: Java
Creación: 24/09/2021
Modificacion: 27/09/2021
*/
public class Controlador {
    
    /** 
     * @param args
     */
    public static void main(String[] args){
        Vista v = new Vista();
        int njugadores=0;
        while(njugadores!=1 && njugadores!=2 && njugadores!=3){//Numero de jugadores
            njugadores=v.numero_jugadores();
        }
        String[] nombres= new String[njugadores];
        String[] clases= new String[njugadores];
        for(int i=0;i<njugadores;i++){
            String nombre="";
            while(nombre==""){//elegir nombre
                nombre=v.ingreso_nombre();
            }
            nombres[i]=nombre;
            int nclase=0;
            while(nclase!=1 && nclase!=2&&nclase!=3){//Seleccion de clase
                nclase=v.seleccion_clase();
            }
            if(nclase==1){//clase guerrero
                clases[i]="Guerrero";
            }else if(nclase==2){//clase explorador
                clases[i]="Explorador";
            }else if(nclase==3){//clase cazador
                clases[i]="Cazador";
            }
        }
        Juego juego = new Juego(clases, nombres, njugadores);
        v.separador();
        for(int i=0;i<juego.ncombatientes();i++){//mensajes de inicio
            v.mostrar_mensaje(juego.getNombre(i), juego.getMsgInicio(i));
        }
        v.separador();
        boolean salir=false;
        int turno=0;
        while(salir==false){//ciclo de turnos
            v.separador();
            v.mostrar_combatientes(juego.mostrar_combatientes());//mostrar combatientes
            v.separador();
            if(juego.getTipocombatiente(turno).equals("Guerrero")||juego.getTipocombatiente(turno).equals("Explorador")||juego.getTipocombatiente(turno).equals("Cazador")){//turno del jugador
                int r=0;
                boolean nomascota=true;
                while(r!=1&&r!=2&&r!=3&&r!=4&&nomascota){
                    v.mostrar_turno(juego.getNombre(turno));//mostrar turno
                    nomascota=true;
                    r=v.menu_jugador();
                    switch (r) {
                        case 1://atacar
                            v.objetivo();
                            int r2=-1;
                            while(r2<0||r2>juego.ncombatientes()){//elegir objetivo
                                r2=v.elegir_objetivo(juego.mostrar_combatientes());
                            }
                            juego.atacar(turno, r2);//ataque
                            if(juego.getTipocombatiente(turno)=="Cazador"){
                                if(juego.acompañante_lanzado(turno, 0)){
                                    juego.usar_habilidad(juego.turno_acompañante(turno, 0),0,r2);
                                    v.separador();
                                    v.ataque_acompañante();
                                    v.separador();
                                }
                            }
                            break;
                        case 2://usar item
                            v.item();
                            int r_item=-1;   
                            if(juego.numero_items(turno)>0){                       
                                while(r_item<0||r_item>juego.numero_items(turno)-1){//elegir item
                                    r_item=v.elegir_item(juego.mostrar_items(turno));
                                }
                            }else{
                                v.noItems();
                            }
                            v.objetivo();
                            int r_objetivo=-1;
                            while(r_objetivo<0||r_objetivo>juego.ncombatientes()){//elegir objetivo
                                r_objetivo=v.elegir_objetivo(juego.mostrar_combatientes());
                            }
                            juego.usar_item(turno,r_item,r_objetivo);//usar item en objetivo
                            break;
                        case 3://lanzar mascota
                            if(juego.getTipocombatiente(turno)!="Cazador"){
                                v.separador();
                                v.nomascota();
                                v.separador();
                                r=0;
                            }else{
                                if(juego.getEfecto(turno)!=0){
                                    v.separador();
                                    v.mascota_recuperandose(juego.getEfecto(turno));
                                    v.separador();
                                    r=0;
                                }else{
                                    if(juego.acompañante_lanzado(turno, 0)){
                                        v.separador();
                                        v.lanzado();
                                        v.separador();
                                    }else{
                                        nomascota=false;
                                        juego.lanzar_acompañante(turno, 0);
                                    }
                                }
                            }
                            break;
                        case 4://saltar turno
                            
                            break;
                        default:
                            break;
                    }
                }
            }else if(juego.getTipocombatiente(turno).equals("Enemigo")){//turno de los enemigos
                int r=0;
                while(r!=1&&r!=2&&r!=3){
                    v.mostrar_turno(juego.getNombre(turno));//mostrar turno
                    r=v.menu_enemigo();//menu
                    switch (r) {
                        case 1:// atacar
                            v.objetivo();
                            int r2=-1;
                            while(r2<0||r2>juego.ncombatientes()){//elegir objetivo
                                r2=v.elegir_objetivo(juego.mostrar_combatientes());
                            }
                            juego.atacar(turno, r2);//atacar objetivo
                            break;
                        case 2://usar habilidad
                            v.habilidad();
                            int r_habilidad=-1;
                            while(r_habilidad<0||r_habilidad>juego.numero_habilidades(turno)-1){//mostrar habilidades
                                r_habilidad=v.elegir_habilidad(juego.mostrar_habilidades(turno));
                            }
                            v.objetivo();
                            int r_objetivo=-1;
                            while(r_objetivo<0||r_objetivo>juego.ncombatientes()){// mostrar objetivos
                                r_objetivo=v.elegir_objetivo(juego.mostrar_combatientes());
                            }
                            juego.usar_habilidad(turno,r_habilidad,r_objetivo);//usar habilidad en objetivo
                            break;
                        case 3://saltar turno
                            
                            break;
                        default:
                            break;
                    }
                }
            }else if(juego.getTipocombatiente(turno).equals("Jefe")){//turno de el raid boss
                int r=0;
                boolean nomascota=true;
                while(r!=1&&r!=2&&r!=3&&r!=4&&r!=5&&r!=6&&r!=7&&nomascota){
                    v.mostrar_turno(juego.getNombre(turno));//mostrar turno
                    nomascota=true;
                    r=v.menu_boss();//menu
                    switch (r) {
                        case 1:// atacar
                            v.objetivo();
                            int r2=-1;
                            while(r2<0||r2>juego.ncombatientes()){//elegir objetivo
                                r2=v.elegir_objetivo(juego.mostrar_combatientes());
                            }
                            juego.atacar(turno, r2);//atacar objetivo
                            break;
                        case 2://usar habilidad
                            v.habilidad();
                            int r_habilidad=-1;
                            while(r_habilidad<0||r_habilidad>juego.numero_habilidades(turno)-1){//mostrar habilidades
                                r_habilidad=v.elegir_habilidad(juego.mostrar_habilidades(turno));
                            }
                            v.objetivo();
                            int r_objetivo=-1;
                            while(r_objetivo<0||r_objetivo>juego.ncombatientes()){// mostrar objetivos
                                r_objetivo=v.elegir_objetivo(juego.mostrar_combatientes());
                            }
                            juego.usar_habilidad(turno,r_habilidad,r_objetivo);//usar habilidad en objetivo
                            break;
                        case 3://Lanzar acompañantes
                            if(juego.numeroAcompanantes(turno)!=0){
                                for(int i=0;i<juego.numeroAcompanantes(turno);i++){
                                    if(juego.acompañante_lanzado(turno, i)){
                                        v.separador();
                                        v.lanzado2();
                                        v.separador();
                                        r=0;
                                    }else{
                                        nomascota=false;
                                        juego.lanzar_acompañante(turno, i);
                                    }
                                }
                            }else{
                                v.separador();
                                v.noacompanante();
                                v.separador();
                                r=0;
                            }
                            break;
                        case 4://clonar
                            v.objetivo();
                            r_objetivo=-1;
                            boolean clonable=false;
                            while(r_objetivo<0||r_objetivo>juego.ncombatientes()||!clonable){// mostrar objetivos
                                r_objetivo=v.elegir_objetivo(juego.mostrar_combatientes());
                                if(juego.getTipocombatiente(r_objetivo).equals("Guerrero")||juego.getTipocombatiente(r_objetivo).equals("Explorador")||juego.getTipocombatiente(r_objetivo).equals("Cazador")||juego.getTipocombatiente(r_objetivo).equals("Jefe")||juego.getTipocombatiente(r_objetivo).equals("Acompanante_enemigo")){
                                    v.separador();
                                    v.noclonable();
                                    v.separador();
                                }else{
                                    clonable=true;
                                }
                            }
                            break;
                        case 5://Variar
                            
                            break;
                        case 6://liberar
                            
                            break;
                        case 7://saltar turno
                            
                            break;
                        default:
                            break;
                    }
                }
            }
            
            for(int i=0;i<juego.ncombatientes();i++){//verificar muertes
                if(!juego.verificar_vivo(i)){
                    if(juego.verificar_mascota(i)){
                        juego.reiniciar(i);
                        juego.setEfecto(i,3);
                    }
                    v.separador();
                    v.mostrar_mensaje(juego.getNombre(i), juego.getMsgMuerte(i));//mensaje de muerte
                    v.separador();
                    juego.eliminar_combatiente(i);
                }
            }
            //verificar ganar  
            boolean ganar=false;
            ganar=juego.verificar_win();
            if(ganar){
                salir=true;
                v.separador();
                v.win();
                v.separador();
            }
            
            //verificar perder
            boolean perder=false;
            perder=juego.verificar_derrota();
            if(perder){
                salir=true;
                v.separador();
                v.lose();
                v.separador();
            }
            turno++;//cambia el turno
            if(turno>juego.ncombatientes()-1){//verificar si los turnos ya dieron una vuelta
                turno=0;//regresar al inicio
                for(int i=0;i<juego.ncombatientes();i++){
                    if(juego.getTipocombatiente(i)=="Cazador"){
                        if(juego.getEfecto(i)!=0){
                            juego.reducirEfecto(i);
                        }
                    }
                }
            }
        }
    }
}
