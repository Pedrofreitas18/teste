package Test;

import Conta.ContaCorrente;
import Conta.ContaPoupanca;
import junit.framework.TestCase;

public class TestContaCorrente extends TestCase {
	
	public void test_Construtor() {
		String numeroDaConta = "001-001";
		String titular = "Antonio João Gomes";
		double saldo = 7234.45;
		double limiteChequeEspecial = 243.50;
		double taxaDeJurosDoChequeEspecial = 1.05;
		
		ContaCorrente Corrente = new ContaCorrente(numeroDaConta, titular, saldo, limiteChequeEspecial, taxaDeJurosDoChequeEspecial);
        
		assertEquals(numeroDaConta,Corrente.getNumeroDaConta());
		assertEquals(titular,Corrente.getTitular());
		assertEquals(saldo, Corrente.getSaldo());
		assertEquals(limiteChequeEspecial, Corrente.getLimiteChequeEspecial());
		assertEquals(taxaDeJurosDoChequeEspecial, Corrente.getTaxaDeJurosDoChequeEspecial());
	}
	
	public void test_SetLimiteChequeEspecial() {
		double limiteChequeEspecial = 200;
		ContaCorrente Corrente = new ContaCorrente("001-001", "Antonio João Gomes", 1000, limiteChequeEspecial, 1.05);
		
		limiteChequeEspecial = 1000;
		Corrente.setLimiteChequeEspecial(limiteChequeEspecial);
		
		assertEquals(limiteChequeEspecial, Corrente.getLimiteChequeEspecial());
	}
	
	public void test_SetTaxaDeJurosDoChequeEspecial() {
		double taxaDeJurosDoChequeEspecial = 1.05;
		ContaCorrente Corrente = new ContaCorrente("001-001", "Antonio João Gomes", 1000, 1000, taxaDeJurosDoChequeEspecial);
        
		Corrente.setTaxaDeJurosDoChequeEspecial(1.10);
		assertEquals(1.10, Corrente.getTaxaDeJurosDoChequeEspecial());
	}
	
	public void test_Sacar(){
		double saldo = 1000;
		ContaCorrente Corrente = new ContaCorrente("001-001", "Antonio João Gomes", saldo, 1000, 1.05);
       
		Corrente.sacar(100);
		
		assertEquals(saldo-(100*1.01), Corrente.getSaldo());
	}	
	
	public void test_Transferir() {
		double saldoInicial = 1000;
		double valorTransferencia = 100;
		
		ContaCorrente Corrente1 = new ContaCorrente("001-001", "Antonio João Gomes", saldoInicial, 1000, 1.05);
		ContaCorrente Corrente2 = new ContaCorrente("001-001", "Antonio João Gomes", saldoInicial, 1000, 1.05);
        
		
		Corrente1.transferir(Corrente2, valorTransferencia);
		
		assertEquals(saldoInicial-valorTransferencia, Corrente1.getSaldo());
		assertEquals(saldoInicial+valorTransferencia, Corrente2.getSaldo());

		
		ContaCorrente Corrente3 = new ContaCorrente("001-001", "Antonio João Gomes", saldoInicial, 1000, 1.05);
		ContaPoupanca Poupanca = new ContaPoupanca( "001-001", "Antonio João Gomes", saldoInicial, 1.01);  
		
        Corrente3.transferir(Poupanca, valorTransferencia);
		
		assertEquals(saldoInicial-valorTransferencia, Corrente1.getSaldo());
		assertEquals(saldoInicial+valorTransferencia, Poupanca.getSaldo());
	}
	
	
}
