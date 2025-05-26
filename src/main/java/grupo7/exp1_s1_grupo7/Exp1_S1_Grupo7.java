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
        Clientes cliente = null;   // No hay un cliente registrado inicialmente.
        Cuentas cuenta = null;     // No hay cuenta asociada al cliente inicialmente.
        int opcion;

        do {
            // Menú de opciones 
            System.out.println("\n=== Menú Bank Boston ===");
            System.out.println("1. Depósitos");
            System.out.println("2. Giros");
            System.out.println("3. Consulta de saldo");
            System.out.println("4. Registro de clientes");
            System.out.println("5. Visualización de los datos personales");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            // Validar que el usuario ingrese un entero.
            while (!scanner.hasNextInt()) {
                System.out.println("Error: debe ingresar un número entero.");
                scanner.next(); // Descarta la entrada inválida
                System.out.print("Seleccione una opción: ");
            }
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1: // Depósitos
                    if (cliente == null || cuenta == null) {
                        System.out.println("Debe registrar un cliente y su cuenta (opción 4) primero.");
                    } else {
                        System.out.print("Ingrese el monto a depositar: ");
                        int montoDep = scanner.nextInt();
                        scanner.nextLine(); // Limpia buffer
                        // El método depositar() internamente llama a Validar.validarAbono y muestra el error si es necesario.
                        cuenta.depositar(montoDep);
                    }
                    break;
                case 2: // Giros
                    if (cliente == null || cuenta == null) {
                        System.out.println("Debe registrar un cliente y su cuenta (opción 4) primero.");
                    } else {
                        System.out.print("Ingrese el monto a girar: ");
                        int montoGiro = scanner.nextInt();
                        scanner.nextLine(); // Limpia buffer
                        // El método girar() se encarga de validar que el giro pueda realizarse.
                        cuenta.girar(montoGiro);
                    }
                    break;
                case 3: // Consulta de saldo
                    if (cliente == null || cuenta == null) {
                        System.out.println("Debe registrar un cliente y su cuenta (opción 4) primero.");
                    } else {
                        cuenta.consultarSaldo();
                    }
                    break;
                case 4: // Registro de clientes
                    System.out.println("\n=== Registro de Cliente ===");
                    // Se registra el cliente usando el método estático de la clase Clientes.
                    cliente = Clientes.registrarCliente();
                    
                    // Luego, solicitamos la información de la cuenta asociada.
                    System.out.print("Ingrese el número de cuenta (9 dígitos): ");
                    int numCuenta = scanner.nextInt();
                    if (!Validar.validarNumeroCuenta(numCuenta)) {  // O, si usas Validacion, ajusta el nombre.
                        scanner.nextLine();
                        System.out.println("Número de cuenta inválido.");
                        break;
                    }
                    
                    System.out.print("Ingrese saldo inicial: ");
                    int saldoInicial = scanner.nextInt();
                    if (!Validar.validarSaldo(saldoInicial)) {
                        scanner.nextLine();
                        System.out.println("Saldo inicial inválido.");
                        break;
                    }
                    scanner.nextLine(); // Limpiar el buffer

                    // Creamos el objeto de tipo Cuentas.
                    cuenta = new Cuentas(numCuenta, saldoInicial);
                    System.out.println("Cliente y cuenta registrados exitosamente.");
                    break;
                case 5: // Visualización de datos personales
                    if (cliente == null) {
                        System.out.println("No hay cliente registrado. Registre un cliente (opción 4) primero.");
                    } else {
                        System.out.println("\n=== Datos del Cliente ===");
                        cliente.mostrarInformacion();
                        if (cuenta != null) {
                            System.out.println("\n=== Información de la Cuenta ===");
                            System.out.println(cuenta);
                        } else {
                            System.out.println("No existe una cuenta asociada.");
                        }
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente nuevamente.");
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }
}