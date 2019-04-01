package Conta;

public class App {
	public static void main(String[] args) {
		ContaCorrente corrente = new ContaCorrente("00001", "48685198836", 0.00, 300.00, 1.10);
        ContaPoupanca poupanca = new ContaPoupanca("00002", "48685198836", 0.00, 1.1);
    
        System.out.println("Saldo conta corrente: "+corrente.getSaldo());
        System.out.println("Saldo conta poupança: "+poupanca.getSaldo());
        System.out.println("");
        
        corrente.depositar(1000);
        poupanca.depositar(500);
        
        System.out.println("Depositando 1000 na conta corrente");
        System.out.println("Depositando 500 na conta poupança");
        System.out.println("");
        
        System.out.println("saldo conta corrente: "+corrente.getSaldo());
        System.out.println("saldo conta poupança: "+poupanca.getSaldo());
        System.out.println("");
        
        corrente.transferir(poupanca,100);
        
        System.out.println("Transferindo 100 da conta corrente para poupança");
        System.out.println("");
        
        System.out.println("saldo conta corrente: "+corrente.getSaldo());
        System.out.println("saldo conta poupança: "+poupanca.getSaldo());
        System.out.println("");
        
        corrente.depositar(100);
        
        System.out.println("Depositando 100 na conta corrente");
        System.out.println("");
        
        System.out.println("saldo conta corrente: "+corrente.getSaldo());
        System.out.println("saldo conta poupança: "+poupanca.getSaldo());
        System.out.println("");
        
        corrente.sacar(1050);
        
        poupanca.sacar(50);
        
        System.out.println("Sacando 1050 na conta corrente");
        System.out.println("Sacando 50 na conta poupança");
        System.out.println("");
        
        System.out.println("saldo conta corrente: "+corrente.getSaldo());
        System.out.println("saldo conta poupança: "+poupanca.getSaldo());
        System.out.println("");
        
        System.out.println("Debitando juros cheque especial");
        System.out.println("");
        
        System.out.println("Limite do cheque especial: "+corrente.getLimiteChequeEspecial());
        System.out.println("Juros do cheque especial: "+corrente.getTaxaDeJurosDoChequeEspecial());
        System.out.println("");
        
        corrente.debitarJuros();
        
        System.out.println("saldo conta corrente: "+corrente.getSaldo());
        System.out.println("saldo conta poupança: "+poupanca.getSaldo());
        System.out.println("");
        
        poupanca.aplicarRendimento();
        
        System.out.println("Aplicando rendimento");
        System.out.println("Taxa de rendimento: "+poupanca.getTaxaRendimento());
        System.out.println("");
        
        System.out.println("saldo conta corrente: "+corrente.getSaldo());
        System.out.println("saldo conta poupança: "+poupanca.getSaldo());
        System.out.println("");
        
        System.out.println("Titular conta corrente: "+corrente.getTitular());
        System.out.println("Número da conta da conta corrente: "+corrente.getNumeroDaConta());
        System.out.println("");
        
        System.out.println("Titular conta poupança: "+poupanca.getTitular());
        System.out.println("Número da conta da conta poupança: "+poupanca.getNumeroDaConta());       
	} 
}
