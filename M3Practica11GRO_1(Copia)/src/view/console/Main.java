package view.console;

import java.util.Scanner;
import model.validations.UserDataValidations;

public class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {  // Cambiar aquí a 'static'
        input.useDelimiter("\n");
        String opcion;
        do {
            System.out.println("TESTER FUNCIONES UserDataValidations");
            System.out.println("1 - testCheckId");
            System.out.println("2 - testCheckFormatDate");
            System.out.println("3 - testCalculateAge");
            System.out.println("4 - testCheckPostalCode");
            System.out.println("5 - testIsNumeric");
            System.out.println("6 - testIsAlphabetic");
            System.out.println("7 - testCheckEmail");
            System.out.println("8 - testCheckName");
            System.out.println("0 - SALIR");

            System.out.println("opcion: ");
            opcion = input.next();

            switch (opcion) {
                case "1":
                    testCheckId();
                    break;
                case "2":
                    testDate();
                    break;
                case "3":
                    calculateAge();
                    break;
                case "4":
                    testPostalCode();
                    break;
                case "5":
                    testIsNumeric();
                    break;
                case "6":
                    testIsAlphabetic();
                    break;
                case "7":
                    testEmail();
                    break;
                case "8":
                    testName();
                    break;
                case "z":
                    System.out.println("Abandonando el programa");
                    break;

                default:
                    System.out.println("Opcion Incorrecta");
            }
        } while (!opcion.equals("z"));
    }

    static void testCheckId() {
        boolean dniOK = false;
        System.out.println("Introduce el DNI: ");
        String dni = input.next();
        String[] partesDNI = dni.split("(?<=\\d)(?=[A-Za-z])");
        String parteNum = partesDNI[0];
        String parteLetra = partesDNI[1];
        
        boolean numerosOK = false; 
        boolean strOK = false;
        numerosOK = UserDataValidations.checkNumeric(parteNum, numerosOK);
        strOK = UserDataValidations.isAlphabetic(parteLetra, strOK);

        if (strOK && numerosOK) {
            System.out.println("el formato es correcto, voy a comprobar si la letra es real");
        } else{
            System.out.println("DNI incorrecto (mal formato)");
        }
        
        if (UserDataValidations.checkId(dni)) {
            System.out.println("Dni correcto");
        }else {
            System.out.println("el DNI es falso");

        }
    }

    static void testDate() {
        System.out.println("Introduce una fecha (dd/mm/yyyy): ");
        String date = input.next();

        if (UserDataValidations.checkDate(date)) {
            System.out.println("La fecha es válida.");
        } else {
            System.out.println("La fecha NO es válida.");
        }
    }

    static void calculateAge() {
        int añoActual =  2025;
        int edad = 0;
        boolean dateOK = false;
        System.out.println("Introduce tu fecha de nacimiento (dd/mm/yyyy): ");
        String date = input.next();
        if (UserDataValidations.checkDate(date)){
            System.out.println("la fecha que me has dado es correcta, voy a calcular la edad que tienes: ");
            String[] partes = date.split("/");
            int año = Integer.parseInt(partes[2]);
            edad = UserDataValidations.calculateAge(añoActual ,año);
            System.out.println("tienes " + edad + " años");
        }else {
            System.out.println("la fecha que me has dado esta mal");
        }

    }

    static void testIsNumeric() {
        boolean numerosOk = false;
        System.out.println("Dame un string y te diré sí es de números.");
        String numeros = input.next();
        numerosOk = UserDataValidations.checkNumeric(numeros, numerosOk);
        if (numerosOk) {
            System.out.println("El string es de todo números");
        } else {
            System.out.println("El string NO es de todo números");
        }
    }

    static void testIsAlphabetic() {
        boolean strOk = false;
        System.out.println("Introduce una texto: ");
        String texto = input.next();
        strOk = UserDataValidations.isAlphabetic(texto, strOk);  //

        if (strOk) {
            System.out.println("La cadena es alfabética.");
        } else {
            System.out.println("La cadena NO es alfabética.");
        }
    }

    static void testEmail() {
        boolean emailOK = false;
        System.out.println("Introduce un correo electrónico: ");
        String email = input.next();

        if (UserDataValidations.checkEmail(email)) {
            System.out.println("El correo es válido.");
        } else {
            System.out.println("El correo NO es válido.");
        }
    }

    static void testName() {
        boolean nameOK = false;
        System.out.println("¿Como te llamas? ");
        String name = input.next();
        nameOK = UserDataValidations.checkName(name);
        if (nameOK) {
            System.out.println("El nombre es válido.");
        } else {
            System.out.println("El nombre no es válido.");
        }
    }

    static void testPostalCode() {
        boolean zipOK = false;
        System.out.println("Introduce una código postal , 5 números: ");
        String codigoPostal = input.next();
        zipOK = UserDataValidations.checkZIP(codigoPostal);  //

        if (zipOK) {
            System.out.println("El codigo postal es correcto (5 dígitos)");
        } else {
            System.out.println("El codigo postal es incorrecto (no tiene 5 dígitos)");
        }
    }

}
