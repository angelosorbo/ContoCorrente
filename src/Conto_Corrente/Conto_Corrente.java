package Conto_Corrente;

class Conto_Corrente {
    String cognome1;
    String nome;
    int saldo;
    public Conto_Corrente(String cog, String nom) {
        cognome1 = cog;
        nome = nom;
        saldo = 0;
    }

    synchronized void aggiungi(int cifra) {
       saldo += cifra;
    }
    synchronized void sottrai(int cifra) {
       saldo -= cifra;
    }
    synchronized void stampa_saldo() {
       System.out.println("Saldo del sig. " + cognome1 + " " + nome + " = " + saldo);
    }
}

class Prelievo implements Runnable {
    Conto_Corrente conto_corrente;
    int cifra;
    String motivo;
        Prelievo(Conto_Corrente un_cc, int c, String m) {
        conto_corrente = un_cc;
        cifra = c;
        motivo = m;
        new Thread(this).start();
    }
    public void run() {
        try {
            Thread.sleep((int)(Math.random()*10000));    // attesa fittizia
        } catch (Exception e) {};
        conto_corrente.sottrai(cifra);
        System.out.println("Prelievo del sig. " + conto_corrente.cognome1 +
                ": Euro " + cifra + " Causale: " + motivo);
        conto_corrente.stampa_saldo();
    }
}

class Versamento implements Runnable {
    Conto_Corrente conto_corrente;
    int cifra;
    String motivo;
        Versamento(Conto_Corrente un_cc, int c, String m) {
        conto_corrente = un_cc;
        cifra = c;
        motivo = m;
        new Thread(this).start();
    }
    public void run() {
         try {
            Thread.sleep((int)(Math.random()*10000));    // attesa fittizia
        } catch (Exception e) {};
        conto_corrente.aggiungi(cifra);
        System.out.println("Versamento del sig. " + conto_corrente.cognome1 +
                ": Euro " + cifra + " Causale: " + motivo);
        conto_corrente.stampa_saldo();
    }
}

