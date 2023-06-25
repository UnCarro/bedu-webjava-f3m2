package com.test.interviewer;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    Scanner sc;

    public Menu() {
        sc = new Scanner(System.in);
        Interviewer.data = new ArrayList<>();

        showMainMenu();
    }

    public void showMainMenu() {
        int option = 0;

        while (option != 4 ) {
            System.out.println("Seleccione la operacion a realizar:");
            System.out.println("1. Dar de alta un entrevistador");
            System.out.println("2. Consultar un entrevistador");
            System.out.println("3. Modificar un entrevistador");
            System.out.println("4. Salir");

            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1 -> addInterviewer();
                case 2 -> searchInterviewer();
                case 3 -> modifyInterviewer();
            }
        }

        System.out.println("Programa terminado");
    }

    public void addInterviewer() {
        System.out.println("Ingrese el nombre del entrevistador: ");
        String name = sc.nextLine();
        System.out.println("Ingrese el apellido del entrevistador: ");
        String lastName = sc.nextLine();
        System.out.println("Ingrese el email del entrevistador: ");
        String email = sc.nextLine();
        System.out.println("El entrevistador se encuentra activo? (1=Si/2=No)");
        Boolean isActive = sc.nextInt() == 1;
        sc.nextLine();

        Interviewer interviewer = new Interviewer(name, lastName, email, isActive);
        interviewer.add();

        System.out.println(interviewer);
    }

    public void searchInterviewer() {
        System.out.println("Ingrese el email del entrevistador a consultar:");
        String email = sc.nextLine();

        Interviewer interviewer = Interviewer.getByEmail(email);

        if (interviewer != null) {
            System.out.println("Entrevistador encontrado:");
            System.out.println(interviewer);
        } else {
            System.out.println("Entrevistador no encontrado");
        }
    }

    public void modifyInterviewer(){
        System.out.println("Ingrese el email del entrevistador a modificar:");
        String email = sc.nextLine();

        Interviewer interviewer = Interviewer.getByEmail(email);

        if (interviewer == null) {
            System.out.println("Entrevistador no encontrado:");
        } else {
            System.out.println(interviewer);
            System.out.println("Presionar ENTER para conservar el valor actual de cada campo");
            System.out.println("Ingrese el nuevo nombre del entrevistador:");
            String name = sc.nextLine();
            System.out.println("Ingrese el nuevo apellido del entrevistador: ");
            String lastName = sc.nextLine();
            System.out.println("Ingrese el nuevo email del entrevistador: ");
            email = sc.nextLine();
            System.out.println("El entrevistador se encuentra activo? (1=Si/2=No)");
            Boolean isActive = sc.nextInt() == 1;
            sc.nextLine();
            interviewer.save(name, lastName, email, isActive);

        }
    }

    public static void main(String[] args) {
        new Menu();
    }
}
