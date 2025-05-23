/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package grupo7.exp1_s1_grupo7;

/**
 *
 * @author ariel
 */
import java.util.Scanner;

public class Exp1_S1_Grupo7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    
        // Solicitar número de cuenta (se espera un entero de 9 dígitos).
        System.out.print("Ingrese número de cuenta (9 dígitos): ");
        int numeroCuenta = scanner.nextInt();
        if (!Validar.validarNumeroCuenta(numeroCuenta)) {
            // El método validarNumeroCuenta ya imprime el mensaje de error correspondiente.
            return;
        }

        // Solicitar saldo. Se asume que el saldo no puede ser negativo.
        System.out.print("Ingrese saldo: ");
        int saldo = scanner.nextInt();
        if (!Validar.validarSaldo(saldo)) {
            return;
        }

        // Solicitar monto para girar.
        System.out.print("Ingrese monto a girar: ");
        int giro = scanner.nextInt();
        if (!Validar.validarGiro(giro, saldo)) {
            return;
        }

        // Solicitar monto para depositar (abono).
        System.out.print("Ingrese monto a depositar: ");
        int abono = scanner.nextInt();
        if (!Validar.validarAbono(abono)) {
            return;
        }

        scanner.nextLine(); // Limpiar el buffer del scanner

        // Solicitar nombre (se valida que sea una cadena compuesta solo por letras y espacios).
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        if (!Validar.validarCadena(nombre)) {
            return;
        }

        // Solicitar una opción numérica para un menú (por ejemplo, entre 1 y 5).
        System.out.print("Ingrese una opción de menú (entre 1 y 5): ");
        int opcion = scanner.nextInt();
        if (!Validar.validarOpcionNumero(opcion, 1, 5)) {
            return;
        }

        scanner.nextLine(); // Limpiar el buffer

        // Solicitar una opción tipo VF (debe ser "S" o "F").
        System.out.print("Ingrese una opción (S o F): ");
        String opcionVF = scanner.nextLine();
        if (!Validar.validarOpcionSN(opcionVF)) {
            return;
        }

        System.out.println("Todos los datos han sido validados correctamente.");
        scanner.close();
    }
}