package Conta;

public class ContaCorrente extends Conta {
	private double limiteChequeEspecial;
	private static double taxaDeJurosDoChequeEspecial;
	
	public ContaCorrente(String numeroDaConta, String titular, double saldo, double limiteChequeEspecial, double taxaDeJurosDoChequeEspecial) {
		super(numeroDaConta, titular, saldo);
		this.limiteChequeEspecial = limiteChequeEspecial;
		ContaCorrente.taxaDeJurosDoChequeEspecial = taxaDeJurosDoChequeEspecial;
	}
	
	public double getLimiteChequeEspecial() {
		return limiteChequeEspecial;
	}
	
	public void setLimiteChequeEspecial(double limiteChequeEspecial) {
		if (limiteChequeEspecial < 0) {
	         throw new IllegalArgumentException("O limite do cheque especial não pode ser negativo");
		} else {
		this.limiteChequeEspecial = limiteChequeEspecial;
		}
	}

	public double getTaxaDeJurosDoChequeEspecial() {
		return taxaDeJurosDoChequeEspecial;
	}

	public void setTaxaDeJurosDoChequeEspecial(double taxaDeJurosDoChequeEspecial) {
		if (taxaDeJurosDoChequeEspecial < 1) {
	         throw new IllegalArgumentException("A taxa de juros do cheque especial não pode ser menor que 1");
		} else {
		     ContaCorrente.taxaDeJurosDoChequeEspecial = taxaDeJurosDoChequeEspecial;
		}
	}

	@Override
	public void sacar(double valor) {
		    if (getLimiteChequeEspecial()*-1 > getSaldo() - (valor*1.01)) {
		        throw new IllegalArgumentException("Valor estipulado reduz o saldo para abaixo do limite do cheque especial");
		    }else {
		    	setSaldo( (getSaldo()) - (valor*1.01));      
		    }        
	}
	
	public void debitarJuros() {
	     if (getSaldo() >= 0) {   
	    	 throw new IllegalArgumentException("Operação válida apenas para saldo negativado");
		}else {
		     super.sacar(-1*getSaldo()*getTaxaDeJurosDoChequeEspecial());
	    }
	}
    
	    @Override
    public void transferir(Conta conta, double valor) {
	    	if(getSaldo() - valor <= getLimiteChequeEspecial()*-1) {
	    		 throw new IllegalArgumentException("Saldo insuficiente na conta");
	    	}else {
	    		super.sacar(valor);
				conta.depositar(valor);	
	    	}
	}

}

