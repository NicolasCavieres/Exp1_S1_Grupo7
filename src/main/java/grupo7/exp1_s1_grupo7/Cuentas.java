/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo7.exp1_s1_grupo7;

/**
 *
 * @author ariel
 */
public class Cuentas {
    // Atributos encapsulados
    private int numeroCuenta; // Debe ser un entero de 9 dígitos.
    private int saldo;        // Valor entero que representa el saldo actual.

    // Constructor por defecto
    public Cuentas() {
        // Inicializamos con valores por defecto. Se recomienda modificar si es necesario.
        this.numeroCuenta = 0;
        this.saldo = 0;
    }

    // Constructor con parámetros, usando validación interna.
    public Cuentas(int numeroCuenta, int saldo) {
        // Validamos el número de cuenta. Si es inválido se asigna 0 (o se puede lanzar una excepción).
        if (Validar.validarNumeroCuenta(numeroCuenta)) {
            this.numeroCuenta = numeroCuenta;
        } else {
            System.out.println("No se pudo crear la cuenta: número de cuenta inválido.");
            this.numeroCuenta = 0; // Valor por defecto o se puede abortar la creación.
        }
        
        // Validamos el saldo inicial. Si es inválido, asignamos 0.
        if (Validar.validarSaldo(saldo)) {
            this.saldo = saldo;
        } else {
            System.out.println("No se pudo crear la cuenta: saldo inicial inválido.");
            this.saldo = 0;
        }
    }

    // Métodos accesadores (getters)
    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public int getSaldo() {
        return saldo;
    }

    // Métodos modificadores (setters) con validación
    public void setNumeroCuenta(int numeroCuenta) {
        if (Validar.validarNumeroCuenta(numeroCuenta)) {
            this.numeroCuenta = numeroCuenta;
        }
    }

    public void setSaldo(int saldo) {
        if (Validar.validarSaldo(saldo)) {
            this.saldo = saldo;
        }
    }

    /**
     * Método para realizar un depósito (abono).  
     * Solo se permite depositar montos mayores a cero.
     * Se invoca la validación a través de Validacion.validarAbono().
     *
     * @param monto El monto a depositar.
     */
    public void depositar(int monto) {
        if (Validar.validarAbono(monto)) {
            this.saldo += monto;
            System.out.println("Depósito realizado. Saldo actual: " + this.saldo);
        }
        // En caso de error, el mensaje ya fue impreso en el método de Validacion.
    }

    /**
     * Método para realizar un giro (retiro).  
     * La operación se realiza solo si:
     * - El saldo es mayor que 0.
     * - El monto a retirar es mayor que 0.
     * - El monto no exceda el saldo.
     *
     * @param monto El monto a retirar.
     */
    public void girar(int monto) {
        if (Validar.validarGiro(monto, this.saldo)) {
            this.saldo -= monto;
            System.out.println("Giro realizado. Saldo actual: " + this.saldo);
        }
        // Si la validación falla, el método Validacion.validarGiro imprime el error correspondiente.
    }

    /**
     * Método para consultar el saldo actual.
     * Muestra el saldo en pantalla.
     */
    public void consultarSaldo() {
        System.out.println("Su saldo actual es: " + this.saldo);
    }

    /**
     * Método toString para mostrar información de la cuenta.
     */
    @Override
    public String toString() {
        return "Número de cuenta: " + this.numeroCuenta + " | Saldo: " + this.saldo;
    }
}