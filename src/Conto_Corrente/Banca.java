/* Gestione Conto Corrente Bancario */
package Conto_Corrente;

public class Banca {
    public static void main(String args[]) {
        Conto_Corrente mioCC = new Conto_Corrente("Rossi", "Mario");
        new Versamento(mioCC, 1020, "Stipendio");
        new Prelievo(mioCC, 250, "Bancomat");
        new Versamento(mioCC, 120, "Contanti");
        new Prelievo(mioCC, 87, "Bolletta Gas");
    }
}
