package br.ifpe.lpoa.negocio;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class Conta {
	private String numero;
	protected double saldo;
	
	public Conta() {

	}

	public Conta(String numero, double value) {
		this.numero = numero;
		this.saldo = value;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void creditar(double valor) {
		this.saldo = this.saldo + valor;
		System.out.println(this.saldo);
	}
	
	public void debitar(double valor) throws Exception {
		if ((this.saldo - valor) > 0.0) {
			this.saldo -= valor;
		} else {
			throw new Exception("Saldo Insuficiente!");
		}		
	}
	
	public void transferir(Conta c, double valor) throws Exception {
		this.debitar(valor);
		c.creditar(valor);
	}

	@Override
	public String toString() {
		String tostr= "Numero = " + this.numero;
		tostr += "\nSaldo = " + this.saldo;
		return tostr;
	}
}
