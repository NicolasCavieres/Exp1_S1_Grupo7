/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo7.exp1_s1_grupo7;

/**
 *
 * @author ariel
 */
public class Validar {

    /**
     * Valida que el número de cuenta sea un entero de 9 dígitos.
     * Ejemplo válido: 123456789
     *
     * @param numeroCuenta el número de cuenta a validar.
     * @return true si el número de cuenta es de 9 dígitos, false en caso contrario.
     */
    public static boolean validarNumeroCuenta(int numeroCuenta) {
        if (numeroCuenta < 100000000 || numeroCuenta > 999999999) {
            System.out.println("Error: El número de cuenta debe ser un número entero de 9 dígitos.");
            return false;
        }
        return true;
    }

    /**
     * Valida que el saldo sea un número entero no negativo.
     *
     * @param saldo el saldo a validar.
     * @return true si el saldo es mayor o igual a 0, false en caso contrario.
     */
    public static boolean validarSaldo(int saldo) {
        if (saldo < 0) {
            System.out.println("Error: El saldo no puede ser negativo.");
            return false;
        }
        return true;
    }

    /**
     * Valida la operación de giro (retiro) comprobando que:
     * - El saldo sea mayor a 0.
     * - El monto a girar sea mayor a 0.
     * - El monto a girar no exceda el saldo.
     *
     * @param giro   monto a retirar.
     * @param saldo  saldo actual de la cuenta.
     * @return true si el giro es válido, false de lo contrario.
     */
    public static boolean validarGiro(int giro, int saldo) {
        if (saldo <= 0) {
            System.out.println("Error: Para realizar un Giro, su saldo debe ser mayor que 0.");
            return false;
        }
        if (giro <= 0) {
            System.out.println("Error: El monto a girar debe ser mayor que 0.");
            return false;
        }
        if (giro > saldo) {
            System.out.println("Error: No puede realizar un Giro mayor a su saldo.");
            return false;
        }
        return true;
    }

    /**
     * Valida el abono (depósito) comprobando que el monto sea mayor a cero.
     *
     * @param abono monto a depositar.
     * @return true si el abono es mayor a cero, false en caso contrario.
     */
    public static boolean validarAbono(int abono) {
        if (abono <= 0) {
            System.out.println("Error: El monto abonado debe ser mayor que 0.");
            return false;
        }
        return true;
    }

    /**
     * Valida que una cadena (por ejemplo, nombre, apellido, domicilio, comuna)
     * no sea nula, esté vacía o contenga caracteres especiales o dígitos.
     * Se permite únicamente letras (incluyendo acentos y la ñ) y espacios.
     *
     * @param cadena la cadena a validar.
     * @return true si la cadena es válida, false de lo contrario.
     */
    public static boolean validarCadena(String cadena) {
        if (cadena == null || cadena.trim().isEmpty()) {
            System.out.println("Error: La entrada no puede estar vacía.");
            return false;
        }
        // Se permite solo letras (mayúsculas, minúsculas, acentos, ñ) y espacios.
        if (!cadena.matches("[A-Za-zÁÉÍÓÚáéíóúÑñ ]+")) {
            System.out.println("Error: La entrada debe contener únicamente letras y espacios, sin números ni caracteres especiales.");
            return false;
        }
        return true;
    }

    /**
     * Valida que una opción numérica (por ejemplo, escogida en un menú)
     * se encuentre entre un valor mínimo y máximo.
     *
     * @param opcion la opción ingresada.
     * @param min    valor mínimo permitido.
     * @param max    valor máximo permitido.
     * @return true si la opción está dentro del rango, false en caso contrario.
     */
    public static boolean validarOpcionNumero(int opcion, int min, int max) {
        if (opcion < min || opcion > max) {
            System.out.println("Error: La opción debe ser un número entre " + min + " y " + max + ".");
            return false;
        }
        return true;
    }

    /**
     * Valida que la opción ingresada para un menú (por ejemplo, "S" o "F")
     * sea correcta. Se ignoran espacios y mayúsculas/minúsculas.
     *
     * @param opcion la opción ingresada (se espera "S" o "F").
     * @return true si la opción es S o F, false en caso contrario.
     */
    public static boolean validarOpcionSN(String opcion) {
        if (opcion == null || opcion.trim().isEmpty()) {
            System.out.println("Error: Debe ingresar una opción (S o F).");
            return false;
        }
        String opcionMod = opcion.trim().toUpperCase();
        if (!opcionMod.equals("S") && !opcionMod.equals("F")) {
            System.out.println("Error: La opción ingresada es inválida. Debe ser 'S' o 'F'.");
            return false;
        }
        return true;
    }
}