package Test;

import Conta.ContaCorrente;
import Conta.ContaPoupanca;
import junit.framework.TestCase;

public class TestContaPoupanca extends TestCase {
	public void test_Construtor() {
		String numeroDaConta = "001-001";
		String titular = "Antonio João Gomes";
		double saldo = 7234.45;
		double taxaRendimento = 1.01;
		
		ContaPoupanca Poupanca = new ContaPoupanca( numeroDaConta, titular, saldo, taxaRendimento);
        
		assertEquals(numeroDaConta,Poupanca.getNumeroDaConta());
		assertEquals(titular,Poupanca.getTitular());
		assertEquals(saldo, Poupanca.getSaldo());
		assertEquals(taxaRendimento, Poupanca.getTaxaRendimento());
	}
	
	public void test_SetTaxaRendimento() {
		double taxaRendimento = 1.10;
		
		ContaPoupanca Poupanca = new ContaPoupanca( "001-001", "Antonio João Gomes", 7234.45, 1.01);  
		
		Poupanca.setTaxaRendimento(taxaRendimento);
		
		assertEquals(taxaRendimento,Poupanca.getTaxaRendimento());
	}
	
	public void test_AplicarRendimento() {
		double taxaRendimento = 1.10;
		double saldo = 100;
		
		ContaPoupanca Poupanca = new ContaPoupanca( "001-001", "Antonio João Gomes", saldo, taxaRendimento);  
		
		Poupanca.aplicarRendimento();
		
		assertEquals(saldo*taxaRendimento,Poupanca.getSaldo());
	}
	
	public void test_Transferir() {
		double saldoInicial = 1000;
		double valorTransferencia = 100;
		
		ContaPoupanca Poupanca1 = new ContaPoupanca( "001-001", "Antonio João Gomes", saldoInicial, 1.01);  
		ContaPoupanca Poupanca2 = new ContaPoupanca( "001-001", "Antonio João Gomes", saldoInicial, 1.01);  
		
		Poupanca1.transferir(Poupanca2, valorTransferencia);
		
		assertEquals(saldoInicial-valorTransferencia, Poupanca1.getSaldo());
		assertEquals(saldoInicial+valorTransferencia, Poupanca2.getSaldo());

		ContaPoupanca Poupanca3 = new ContaPoupanca( "001-001", "Antonio João Gomes", saldoInicial, 1.01);  
		ContaCorrente Corrente = new ContaCorrente("001-001", "Antonio João Gomes", saldoInicial, 1000, 1.05);
		
		Poupanca3.transferir(Corrente, valorTransferencia);
		
		assertEquals(saldoInicial-valorTransferencia, Poupanca3.getSaldo());
		assertEquals(saldoInicial+valorTransferencia, Corrente.getSaldo());
	}
}


