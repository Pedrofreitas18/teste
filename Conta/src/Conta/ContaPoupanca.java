package Conta;

public class ContaPoupanca extends Conta {
	private static double taxaRendimento;

	public static double getTaxaRendimento() {
		return taxaRendimento;
	}

	public static void setTaxaRendimento(double taxaRendimento) {
	    if(taxaRendimento < 1) {
	    	throw new IllegalArgumentException("Taxa de rendimento menor que 1");
	    }else {
		    ContaPoupanca.taxaRendimento = taxaRendimento;
	    }
	}
	
	public ContaPoupanca(String numeroDaConta, String titular, double saldo,double taxaRendimento) {
		super(numeroDaConta, titular, saldo);
		ContaPoupanca.taxaRendimento = taxaRendimento;
		// TODO Auto-generated constructor stub
	}

	public void aplicarRendimento() {
		if(getSaldo() < 0) {
	    	throw new IllegalArgumentException("Saldo negativo");
	    }else {
		    setSaldo(getSaldo() * getTaxaRendimento());
	    }
	}

	@Override
	public void transferir(Conta conta, double valor) {
		// TODO Auto-generated method stub
		super.transferir(conta, valor);
	}

}

