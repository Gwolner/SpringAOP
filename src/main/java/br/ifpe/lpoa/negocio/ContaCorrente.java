package br.ifpe.lpoa.negocio;

import org.springframework.stereotype.Component;

@Component
public class ContaCorrente  extends Conta{

	public ContaCorrente() {

	}
	
	public ContaCorrente(String numero, double value) {
		super(numero, value);
	}
	
	public void creditar(double valor) {
		this.saldo += valor;
		System.out.println("Conta Corrente");
	} 
}
