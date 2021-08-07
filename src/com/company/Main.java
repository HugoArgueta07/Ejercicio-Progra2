package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entradaDeTeclado = new Scanner(System.in);
        boolean llave = true;
        int seleccion = 0;
        System.out.println("Bienvenido al sistema de registro, antes de iniciar configure la cantidad de registros a manejar: \n");
        RegistroAlumno registros = new RegistroAlumno(Integer.parseInt(entradaDeTeclado.nextLine()));
        while(llave) {
            //mostrar el menu
            System.out.println("\n----Menu Principal----\n1.- Registrar Alumnos\n2.- Mostrar Alumnos\n3.- Modificar Alumnos\n4.- Salir\n");
            seleccion = Integer.parseInt(entradaDeTeclado.nextLine());
            //Evaluar la seleccion
            if(seleccion == 1){
                String[][] vector = registros.obtenerAlumnosRegistrados();
                for (int i=0; i<vector.length; i++){
                    //registro del primer alumno
                    System.out.println("\nIngresar nombres del alumno " + i + ": ");
                    String nombreAlumno = entradaDeTeclado.nextLine();
                    System.out.println("Ingresar apellidos del alumno " + i + ": ");
                    String apellidoAlumno = entradaDeTeclado.nextLine();
                    System.out.println("Ingresar correo del alumno " + i + ": ");
                    String correoAlumno = entradaDeTeclado.nextLine();
                    System.out.println("Ingresar telefono del alumno " + i + ": ");
                    String telefonoAlumno = entradaDeTeclado.nextLine();
                    System.out.println("Ingresar DPI del encargado del alumno " + i + ": ");
                    String dpiAlumno = entradaDeTeclado.nextLine();
                    Alumno alumn = new Alumno(nombreAlumno, apellidoAlumno, correoAlumno, telefonoAlumno, dpiAlumno, "");
                    alumn.generarCarne(registros);
                    System.out.println("\nSe ha generado el carne: " + alumn.mostrar_carne());
                    if(registros.registrarAlumno(alumn)){
                        System.out.println("\nAlumno registrado exitosamente");
                    }else{
                        System.out.println("\nEl alumno ingresado ya está registrado");
                        i = i - 1;
                    }
                }

            }
            if(seleccion == 2){
                //Codigo de mostrar alumnos
                String[][] vector = registros.obtenerAlumnosRegistrados();
                System.out.println("\nLista de Alumnos Registrados ");
                for(int i=0; i<vector.length; i++){
                    if(!(vector[i]==null)){//se valida si el registro no es nulo
                        System.out.println("\nNombre: " + vector[i][0]);
                        System.out.println("Apellidos: " + vector[i][1]);
                        System.out.println("Carne: " + vector[i][2]);
                        System.out.println("Correo: " + vector[i][3]);
                        System.out.println("Telefono: " + vector[i][4]);
                        System.out.println("Dpi: " + vector[i][5]);
                    }
                }
            }
            if(seleccion == 3){
                //Codigo de modificar info de alumnos
                System.out.println("\nIngrese # de carne: ");
                String n_carne = entradaDeTeclado.nextLine();
                registros.modificarAlumno(n_carne);
            }
            if(seleccion == 4){
                //Cerrar el programa
                System.out.println("\nCerrando el sistema....");
                break;
            }
        }

    }
}