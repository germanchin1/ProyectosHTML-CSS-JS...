/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.validations;

import model.exceptions.InvalidDNIException;
import model.exceptions.InvalidDateException;

/**
 *
 * @author germanromort
 */
public class UserDataValidations {

    
//Usando la parte numerica(verificada) y la parte de letra(verificada) y el booleano que hay que devolver compruebo el largo de las 2 partes
// y el resto de la la division entre 23
public static void checkId(String dni) throws InvalidDNIException {
    String[] letrasDNI = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
    
    if (dni == null || dni.trim().isEmpty()) {
        throw new InvalidDNIException("vacío o nulo");
    }

    String parteNum = dni.substring(0, dni.length() - 1);
    String parteLetra = dni.substring(dni.length() - 1).toUpperCase();

    try {
        int numeroDni = Integer.parseInt(parteNum);
        int resto = numeroDni % 23;
        String letraCorrecta = letrasDNI[resto];

        if (!parteLetra.equals(letraCorrecta)) {
            throw new InvalidDNIException(dni);
        }
    } catch (NumberFormatException e) {
        throw new InvalidDNIException("parte numérica inválida: " + parteNum);
    }
}


    
    // Con el string fecha y el booleano que voy a devolver, separo el string con split y compruebo que la fecha no se pase de ciertos parámetros
    public static void checkDate(String date) throws InvalidDateException {
    if (date == null || date.trim().isEmpty()) {
        throw new InvalidDateException("La fecha está vacía.");
    }

    String[] partesFecha = date.split("/");

    if (partesFecha.length != 3) {
        throw new InvalidDateException("Formato de fecha incorrecto. Use dd/mm/yyyy.");
    }

    try {
        int dia = Integer.parseInt(partesFecha[0]);
        int mes = Integer.parseInt(partesFecha[1]);
        int año = Integer.parseInt(partesFecha[2]);

        if (mes < 1 || mes > 12) {
            throw new InvalidDateException("Mes fuera de rango (1-12).");
        }
        if (dia < 1 || dia > 31) {
            throw new InvalidDateException("Día fuera de rango (1-31).");
        }
        if (año < 1900 || año > 2100) {
            throw new InvalidDateException("Año fuera de rango (1900-2100).");
        }

    } catch (NumberFormatException e) {
        throw new InvalidDateException("Los valores de la fecha deben ser numéricos.");
    }
}

    
    // Con 3 valores enteros que he declarado en el main, consigo la edad y la devuelvo
    public static int calculateAge(int año, int añoActual) {
        int edad;
        edad = año - añoActual;
        return edad;
    }

    
//Con un string de texto y un booleano compruebo con la funcion isDigit que el char en el que estoy iterando es un número, 
//Si hay algo que no lo es, devuelvo false si no, true
    public static boolean checkNumeric(String numeros, boolean numerosOK) {
        for (int i = 0; i < numeros.length(); i++) {
            char indice = numeros.charAt(i);
            if (!Character.isDigit(indice)) {
                return numerosOK = false;
            }
        }
        return numerosOK = true;
    }

    
//Con un string de texto y un booleano compruebo con la funcion isLetter que el char en el que estoy iterando es una letra, 
//Si hay algo que no lo es, devuelvo false si no, true
    public static boolean isAlphabetic(String texto, boolean strOK) {
        for (int i = 0; i < texto.length(); i++) {
            char indice = texto.charAt(i);

            if (!Character.isLetter(indice)) {
                return strOK = false;
            }
        }
        return strOK = true;
    }

    //Con un número entero compruebo el largo del numero con una estructura if que comprueba el tamaño del número 
    public static boolean checkZIP(String codigoPostal) {
        return codigoPostal.matches("^[0-9]{5}$"); // Debe tener exactamente 5 dígitos numéricos
    }

    // compruebo que no hayan números ni cosa raras en el nombre
    public static boolean checkName(String name) {
        if (name.trim().isEmpty()) { // Verifica si el nombre está vacío o solo tiene espacios
            return false;
        }

        for (int i = 0; i < name.length(); i++) {
            char letra = name.charAt(i);
            if (Character.isDigit(letra)) { // Verifica si hay un número en el nombre
                return false;
            }
        }

        return true; // El nombre es válido
    }

    
    //solo pido un string que es el mail, con split lo divido a partir de "@" y compruebo que la segunda parte sea una de las que he apuntado
    public static boolean checkEmail(String email) {
        String[] partesCorreo = email.split("@");

        if (partesCorreo.length != 2) {
            return false;
        }

        String parteCorreo2 = partesCorreo[1];
        if (parteCorreo2.equals("gmail.com") || parteCorreo2.equals("hotmail.com") || parteCorreo2.equals("yahoo.com") || parteCorreo2.equals("outlook.com")) {
            return true;
        }

        return false;
    }

}
