// Ejemplo de SRP en Java
public class CalculadoraImpuestos {
    public double calcularImpuesto(double monto) {

        return monto * 0.15;
    }

    public static void main(String[] args) {
        CalculadoraImpuestos calculadora = new CalculadoraImpuestos();
        double impuesto = calculadora.calcularImpuesto(1000);
        System.out.println("El impuesto a pagar es: " + impuesto);
    }
}
