/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo7.exp1_s1_grupo7;

/**
 *
 * @author ariel
 */
import java.util.Scanner;

public class Clientes {
    final private String rut;
    final private String nombre;
    final private String apellidoPaterno;
    final private String apellidoMaterno;
    final private String domicilio;
    final private String comuna;
    final private String telefono;
    // final private CuentaCorriente cuentaCorriente;

    // Constructor
    public Clientes(String rut, String nombre, String apellidoPaterno, String apellidoMaterno,
                    String domicilio, String comuna, String telefono) // + CuentaCorriente cuentaCorriente
                    
                    {
        this.rut = rut;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.domicilio = domicilio;
        this.comuna = comuna;
        this.telefono = telefono;
        // this.cuentaCorriente = cuentaCorriente;
    }

    // Mostrar datos del cliente
    public void mostrarInformacion() {
        System.out.println("---- Datos del Cliente ----");
        System.out.println("RUT: " + rut);
        System.out.println("Nombre: " + nombre + " " + apellidoPaterno + " " + apellidoMaterno);
        System.out.println("Domicilio: " + domicilio + ", Comuna: " + comuna);
        System.out.println("Teléfono: " + telefono);
        // cuentaCorriente; Mostrar información de la cuenta asociada
        System.out.println("---------------------------");
    }

    // Método para registrar un cliente usando validaciones
    public static Clientes registrarCliente() {
        Scanner scanner = new Scanner(System.in);
        String rut, nombre, apellidoPaterno, apellidoMaterno, domicilio, comuna, telefono;

        // RUT
        do {
            System.out.print("Ingrese RUT (formato sin puntos, con guión, ej: 12345678-9): ");
            rut = scanner.nextLine();
        } while (!Validar.validarRut(rut));

        // Nombre
        do {
            System.out.print("Ingrese nombre: ");
            nombre = scanner.nextLine();
        } while (!Validar.validarCadena(nombre));

        // Apellido Paterno
        do {
            System.out.print("Ingrese apellido paterno: ");
            apellidoPaterno = scanner.nextLine();
        } while (!Validar.validarCadena(apellidoPaterno));

        // Apellido Materno
        do {
            System.out.print("Ingrese apellido materno: ");
            apellidoMaterno = scanner.nextLine();
        } while (!Validar.validarCadena(apellidoMaterno));

        // Domicilio
        System.out.print("Ingrese domicilio: ");
        domicilio = scanner.nextLine();

        // Comuna
        do {
            System.out.print("Ingrese comuna: ");
            comuna = scanner.nextLine();
        } while (!Validar.validarCadena(comuna));

        // Teléfono
        System.out.print("Ingrese teléfono: ");
        telefono = scanner.nextLine();

        // Cuenta Corriente (se pide número y saldo)
        // Llamamos a la clase Cuenta Corriente

        return new Clientes(rut, nombre, apellidoPaterno, apellidoMaterno, domicilio, comuna, telefono); //+cuentaCorriente     
    }
}