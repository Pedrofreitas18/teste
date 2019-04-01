package Conta;

public abstract class Conta {
	private String numeroDaConta;
	private String titular;
	private double saldo;
	
	public String getNumeroDaConta() {
		return numeroDaConta;
	}
	
	public String getTitular() {
		return titular;
	}
	
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		    this.saldo = saldo;
		    //limitação de valor minimo são descritas por sobrescrita das classes filhas
	}
	
	public Conta(String numeroDaConta, String titular, double saldo) {
		if(numeroDaConta == null || numeroDaConta.isEmpty()) {
			throw new IllegalArgumentException("numeroDaConta invalido(String nula ou vazia)");
		}else if(titular == null || titular.isEmpty()) {
			throw new IllegalArgumentException("Titular invalido(String nula ou vazia)");
		}else if(saldo < 0) {
			throw new IllegalArgumentException("Saldo negativo");
		}else {
		    this.numeroDaConta = numeroDaConta;
		    this.titular = titular;
		    this.saldo = saldo;
		}
	}
	
	public void depositar(double valor) {
		if(valor < 0) {
			throw new IllegalArgumentException("Valor negativo");
		}else {
		    setSaldo(getSaldo()+valor);
		}
	}
	
	public void sacar(double valor) {
	    if (valor < 0) {
            throw new IllegalArgumentException("Valor negativo");
        } else {	
    	    setSaldo(getSaldo()-valor);        
        }
    }
   
	public void transferir(Conta conta, double valor) {
		this.sacar(valor);
		conta.depositar(valor);
	}
}





