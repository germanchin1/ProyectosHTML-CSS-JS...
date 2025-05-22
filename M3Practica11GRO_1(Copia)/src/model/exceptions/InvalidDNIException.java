package model.exceptions;

public class InvalidDNIException extends ValidationException {
    public InvalidDNIException(String dni) {
        super("DNI inválido: " + dni);
    }
}
