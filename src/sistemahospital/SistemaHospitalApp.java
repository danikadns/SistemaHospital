/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemahospital;

/**
 *
 * @author Dany
 */



public class SistemaHospitalApp {

    public static int tamanoGlobal = 4;
    //Pilas de Turnos
    public static Pila neurologia = new Pila(tamanoGlobal); //si da error en el this se coloca static
    public static Pila maternidad = new Pila(tamanoGlobal);
    public static Pila pediatria = new Pila(tamanoGlobal);
    public static Pila oncologia = new Pila(tamanoGlobal);
    public static Pila odontologia = new Pila(tamanoGlobal);
    public static Pila dr_house = new Pila(tamanoGlobal);  
    
    //Cola de Pacientes
    public static Cola colaPacientes = new Cola(tamanoGlobal);
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("PASO 1: CREAR TURNOS "
                + "********************************************************");
        generarFichasTurnos();
        
        System.out.println("PASO 2: CREAR COLA DE PACIENTES "
                + "********************************************************");
        formacionColaPacientes();
        
        System.out.println("PASO 3: MOSTRAR LOS PACIENTES EN COLA "
                + "********************************************************");
        mostrarPacientesEncola(colaPacientes);
        
        System.out.println("PASO 4: ASIGNAR TURNOS "
                + "********************************************************");
        asignarTurnos();
        
        System.out.println("PASO 5: MOSTRAR LAS PILAS DE TURNOS "
                + "********************************************************");
        imprimirTodosTurnos();
        
        System.out.println("PASO 6: ATENDIENDO A JAVIER "
                + "********************************************************");
        Paciente pa1 = (Paciente) colaPacientes.quitar();
        Paciente pa2 = (Paciente) colaPacientes.quitar();
        Paciente pa3 = (Paciente) colaPacientes.quitar();
        atenderPaciente(pa1);
        atenderPaciente(pa2);
        atenderPaciente(pa3);
        
        
        System.out.println("PASO 6.1: ESPECIALIDAD MÁS CONCURRIDA "
                + "********************************************************");
        calcularEspecialidadMasRequerida();

        System.out.println("PASO 7: MOSTRAR LAS PILAS DE TURNOS "
                + "********************************************************");
        imprimirTodosTurnos();
        
        
        
    }
    
    public static void imprimirTodosTurnos(){
        System.out.println("PILA TURNOS NEUROLOGIA");
    mostrarTurnosPorEspecialidad(neurologia);
    
    System.out.println("PILA TURNOS MATERNIDAD");
    mostrarTurnosPorEspecialidad(maternidad);
    
    System.out.println("PILA TURNOS PEDIATRIA");
    mostrarTurnosPorEspecialidad(pediatria);
        
    System.out.println("PILA TURNOS ONCOLOGIA");
    mostrarTurnosPorEspecialidad(oncologia);
    
    System.out.println("PILA TURNOS ODONTOLOGIA");
    mostrarTurnosPorEspecialidad(odontologia);
    
    System.out.println("PILA TURNOS DOCTOR_HOUSE");
    mostrarTurnosPorEspecialidad(dr_house);
    }
    
    public static void generarFichasTurnos(){
    
    //Llenar las pilas de turnos
    
    for(int i = 1; i<=tamanoGlobal; i++){
        FichaTurno fichaTurnoNeurologia = new FichaTurno(ParametrosGenerales.NEUROLOGIA, i);
        FichaTurno fichaTurnoMaternidad = new FichaTurno(ParametrosGenerales.MATERNIDAD, i);
        FichaTurno fichaTurnoPediatria = new FichaTurno(ParametrosGenerales.PEDIATRIA, i);
        FichaTurno fichaTurnoOncologia = new FichaTurno(ParametrosGenerales.ONCOLOGIA, i);
        FichaTurno fichaTurnoOdontologia = new FichaTurno(ParametrosGenerales.ODONTOLOGIA, i);
        FichaTurno fichaTurnoDrHouse = new FichaTurno(ParametrosGenerales.DOCTOR_HOUSE, i);
        
        neurologia.push(fichaTurnoNeurologia);
        maternidad.push(fichaTurnoMaternidad);
        pediatria.push(fichaTurnoPediatria);
        oncologia.push(fichaTurnoOncologia);
        odontologia.push(fichaTurnoOdontologia);
        dr_house.push(fichaTurnoDrHouse);
    }
        
    System.out.println("PILA TURNOS NEUROLOGIA");
    mostrarTurnosPorEspecialidad(neurologia);
    
    System.out.println("PILA TURNOS MATERNIDAD");
    mostrarTurnosPorEspecialidad(maternidad);
    
    System.out.println("PILA TURNOS PEDIATRIA");
    mostrarTurnosPorEspecialidad(pediatria);
        
    System.out.println("PILA TURNOS ONCOLOGIA");
    mostrarTurnosPorEspecialidad(oncologia);
    
    System.out.println("PILA TURNOS ODONTOLOGIA");
    mostrarTurnosPorEspecialidad(odontologia);
    
    System.out.println("PILA TURNOS DOCTOR_HOUSE");
    mostrarTurnosPorEspecialidad(dr_house);
    
    }
    
    public static void mostrarTurnosPorEspecialidad(Pila p){
        Pila temporal = new Pila(tamanoGlobal);
        
        while (!p.pilaVacia()){
            FichaTurno fichaTurno = (FichaTurno) p.pop();
            
            System.out.println("FICHA: ESPECIALIDAD->" +fichaTurno.getEspecialidad() + " "
                    + "TURNO->"+ fichaTurno.getNumeroTurno());
            temporal.push(fichaTurno);
            
        }
        
        while(!temporal.pilaVacia()){
            //p.push(p.pop());
            FichaTurno fichaTurno = (FichaTurno) temporal.pop();
            p.push(fichaTurno);
        }
    }
    
    public static void formacionColaPacientes(){
        int p_ningunaEspecialidad = ParametrosGenerales.NINGUNA_ESPECIALIDAD;
        int p_neurologia = ParametrosGenerales.NEUROLOGIA;
        int p_maternidad = ParametrosGenerales.MATERNIDAD;
        int p_pediatria = ParametrosGenerales.PEDIATRIA;
        int p_oncologia = ParametrosGenerales.ONCOLOGIA;
        int p_odontologia = ParametrosGenerales.ODONTOLOGIA;
        int p_doctor_house = ParametrosGenerales.DOCTOR_HOUSE;
        Paciente paciente1 = new Paciente("Javier","Linares", 99.99, 20, 1, null, null, p_neurologia, p_ningunaEspecialidad);
        Paciente paciente2 = new Paciente("Jacob","Martinez", 130, 22, 1, null, null, p_doctor_house, p_odontologia);
        Paciente paciente3 = new Paciente("Maria","Gomez", 115, 40, 1, null, null, p_maternidad, p_pediatria);
        Paciente paciente4 = new Paciente("Juana","De Arco", 220, 50, 1, null, null, p_oncologia, p_neurologia);
        
        colaPacientes.insertar(paciente1);
        colaPacientes.insertar(paciente2);
        colaPacientes.insertar(paciente3);
        colaPacientes.insertar(paciente4);
    }
    
    public static void mostrarPacientesEncola(Cola listaPacientes){
        int tamanoCola = listaPacientes.tamanoCola();
        
        for(int i = 0; i< tamanoCola; i++){
            Paciente p = (Paciente ) listaPacientes.quitar();
            System.out.println("PACIENTE: ->" +p.getNombre()
                    + " " + p.getApellido() 
                    + " ESPECIALIDAD ->"
                    + p.getEspecialidad_1()
                    + "-"+ getNombreEspecialidad(p.getEspecialidad_1())
                    + " " + p.getEspecialidad_2() + "-" + getNombreEspecialidad(p.getEspecialidad_2()));
            listaPacientes.insertar(p);
            
        }
    }
    
    public static String getNombreEspecialidad(int codigoEspecialidad){
        String nombreEspecialidad = "";
        switch (codigoEspecialidad){
            case ParametrosGenerales.NINGUNA_ESPECIALIDAD:
                nombreEspecialidad = "NINGUNA ESPECIALIDAD";
                break;
            case ParametrosGenerales.NEUROLOGIA:
                nombreEspecialidad = "NEUROLOGIA";
                break;
            case ParametrosGenerales.MATERNIDAD:
                nombreEspecialidad = "MATERNIDAD";
                break;
            case ParametrosGenerales.PEDIATRIA:
                nombreEspecialidad = "PEDIATRIA";
                break;
            case ParametrosGenerales.ODONTOLOGIA:
                nombreEspecialidad = "ODONTOLOGIA";
                break;
            case ParametrosGenerales.ONCOLOGIA:
                nombreEspecialidad = "ONCOLOGIA";
                break;
            case ParametrosGenerales.DOCTOR_HOUSE:
                nombreEspecialidad = "DOCTOR_HOUSE";
                break;
            default:
                nombreEspecialidad = "INDEFINIDA";
                break;
        }
        return nombreEspecialidad;
    }
    
    public static void asignarTurnos(){
        int tamanoColaPacientes = colaPacientes.tamanoCola();
        
        for(int i = 0; i< tamanoColaPacientes; i++){
            
            Paciente paciente = (Paciente) colaPacientes.quitar();
            
            if(paciente.getEspecialidad_1() == ParametrosGenerales.NEUROLOGIA){
                FichaTurno turno = (FichaTurno) neurologia.pop();
                paciente.setTurno1(turno);
            }else if (paciente.getEspecialidad_1() == ParametrosGenerales.MATERNIDAD){
                FichaTurno turno = (FichaTurno) maternidad.pop();
                paciente.setTurno1(turno);
            }else if (paciente.getEspecialidad_1() == ParametrosGenerales.PEDIATRIA){
                FichaTurno turno = (FichaTurno) pediatria.pop();
                paciente.setTurno1(turno);
            }else if (paciente.getEspecialidad_1() == ParametrosGenerales.ONCOLOGIA){
                FichaTurno turno = (FichaTurno) oncologia.pop();
                paciente.setTurno1(turno);
            }else if (paciente.getEspecialidad_1() == ParametrosGenerales.ODONTOLOGIA){
                FichaTurno turno = (FichaTurno) odontologia.pop();
                paciente.setTurno1(turno);
            }else if (paciente.getEspecialidad_1() == ParametrosGenerales.DOCTOR_HOUSE){
                FichaTurno turno = (FichaTurno) dr_house.pop();
                paciente.setTurno1(turno);
            }
            
            if(paciente.getEspecialidad_2() != ParametrosGenerales.NINGUNA_ESPECIALIDAD){
                if(paciente.getEspecialidad_2() == ParametrosGenerales.NEUROLOGIA){
                FichaTurno turno = (FichaTurno) neurologia.pop();
                paciente.setTurno2(turno);
            }else if (paciente.getEspecialidad_2() == ParametrosGenerales.MATERNIDAD){
                FichaTurno turno = (FichaTurno) maternidad.pop();
                paciente.setTurno2(turno);
            }else if (paciente.getEspecialidad_2() == ParametrosGenerales.PEDIATRIA){
                FichaTurno turno = (FichaTurno) pediatria.pop();
                paciente.setTurno2(turno);
            }else if (paciente.getEspecialidad_2() == ParametrosGenerales.ONCOLOGIA){
                FichaTurno turno = (FichaTurno) oncologia.pop();
                paciente.setTurno2(turno);
            }else if (paciente.getEspecialidad_2() == ParametrosGenerales.ODONTOLOGIA){
                FichaTurno turno = (FichaTurno) odontologia.pop();
                paciente.setTurno2(turno);
            }else if (paciente.getEspecialidad_2() == ParametrosGenerales.DOCTOR_HOUSE){
                FichaTurno turno = (FichaTurno) dr_house.pop();
                paciente.setTurno2(turno);
            }
            }
            
            
            colaPacientes.insertar(paciente);
        }
    }
    
    public static void atenderPaciente(Paciente paciente){
        if(paciente.getEspecialidad_1() == ParametrosGenerales.NEUROLOGIA){
            FichaTurno turno = paciente.getTurno1();
            neurologia.push(turno);
            paciente.setTurno1(null);
            paciente.setEspecialidad_1(ParametrosGenerales.NINGUNA_ESPECIALIDAD);
            
            }else if (paciente.getEspecialidad_1() == ParametrosGenerales.MATERNIDAD){
                FichaTurno turno = paciente.getTurno1();
            maternidad.push(turno);
            paciente.setTurno1(null);
            paciente.setEspecialidad_1(ParametrosGenerales.NINGUNA_ESPECIALIDAD);
            }else if (paciente.getEspecialidad_1() == ParametrosGenerales.PEDIATRIA){
                FichaTurno turno = paciente.getTurno1();
            pediatria.push(turno);
            paciente.setTurno1(null);
            paciente.setEspecialidad_1(ParametrosGenerales.NINGUNA_ESPECIALIDAD);
            }else if (paciente.getEspecialidad_1() == ParametrosGenerales.ONCOLOGIA){
                FichaTurno turno = paciente.getTurno1();
            oncologia.push(turno);
            paciente.setTurno1(null);
            paciente.setEspecialidad_1(ParametrosGenerales.NINGUNA_ESPECIALIDAD);
            }else if (paciente.getEspecialidad_1() == ParametrosGenerales.ODONTOLOGIA){
                FichaTurno turno = paciente.getTurno1();
            odontologia.push(turno);
            paciente.setTurno1(null);
            paciente.setEspecialidad_1(ParametrosGenerales.NINGUNA_ESPECIALIDAD);
            }else if (paciente.getEspecialidad_1() == ParametrosGenerales.DOCTOR_HOUSE){
                FichaTurno turno = paciente.getTurno1();
            dr_house.push(turno);
            paciente.setTurno1(null);
            paciente.setEspecialidad_1(ParametrosGenerales.NINGUNA_ESPECIALIDAD);
            }
        
        if (paciente.getEspecialidad_2() != ParametrosGenerales.NINGUNA_ESPECIALIDAD) {
            
            if (paciente.getEspecialidad_2() == ParametrosGenerales.NEUROLOGIA) {
                
                FichaTurno turno = paciente.getTurno2();
                neurologia.push(turno);
                paciente.setTurno2(null);
                paciente.setEspecialidad_2(ParametrosGenerales.NINGUNA_ESPECIALIDAD);
            } else if (paciente.getEspecialidad_2() == ParametrosGenerales.MATERNIDAD) {
                FichaTurno turno = paciente.getTurno2();
                maternidad.push(turno);
                paciente.setTurno2(null);
                paciente.setEspecialidad_2(ParametrosGenerales.NINGUNA_ESPECIALIDAD);
            } else if (paciente.getEspecialidad_2() == ParametrosGenerales.PEDIATRIA) {
                FichaTurno turno = paciente.getTurno2();
                pediatria.push(turno);
                paciente.setTurno2(null);
                paciente.setEspecialidad_2(ParametrosGenerales.NINGUNA_ESPECIALIDAD);
            } else if (paciente.getEspecialidad_2() == ParametrosGenerales.ONCOLOGIA) {
                FichaTurno turno = paciente.getTurno2();
                oncologia.push(turno);
                paciente.setTurno2(null);
                paciente.setEspecialidad_2(ParametrosGenerales.NINGUNA_ESPECIALIDAD);
            } else if (paciente.getEspecialidad_2() == ParametrosGenerales.ODONTOLOGIA) {
                FichaTurno turno = paciente.getTurno2();
                odontologia.push(turno);
                paciente.setTurno2(null);
                paciente.setEspecialidad_2(ParametrosGenerales.NINGUNA_ESPECIALIDAD);
            } else if (paciente.getEspecialidad_2() == ParametrosGenerales.DOCTOR_HOUSE) {
                FichaTurno turno = paciente.getTurno2();
                dr_house.push(turno);
                paciente.setTurno2(null);
                paciente.setEspecialidad_2(ParametrosGenerales.NINGUNA_ESPECIALIDAD);
            }
            
        }
        
        
    }
    
    
    public static void calcularEspecialidadMasRequerida() {
        
        int cantNeuro = neurologia.cantidadElementosPila();
        int cantMaternidad = maternidad.cantidadElementosPila();
        if (cantNeuro < cantMaternidad) {
            System.out.println("Maternidad es el mas concurrido");
        } else if (cantNeuro > cantMaternidad) {
            System.out.println("Neurologia es el mas concurrido");
        } else {
            System.out.println("Hay un perfecto equilibrio");
        }
    }
    
}
