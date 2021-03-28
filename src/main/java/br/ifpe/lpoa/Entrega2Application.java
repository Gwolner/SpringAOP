package br.ifpe.lpoa;

import org.springframework.beans.BeanInstantiationException;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import br.ifpe.lpoa.negocio.Conta;
import br.ifpe.lpoa.negocio.ContaCorrente;
import br.ifpe.lpoa.negocio.ContaAspect;

@SpringBootApplication
@EnableAspectJAutoProxy
@ComponentScan
public class Entrega2Application {

	public static void main(String[] args) {
		//SpringApplication.run(Entrega2Application.class, args);
		ApplicationContext applicationContext = SpringApplication.run(Entrega2Application.class, args);
		
		Conta ctxConta = applicationContext.getBean(Conta.class);
		
		ctxConta.setSaldo(100.0);
		ctxConta.setNumero("123");

		Conta ctxCC = applicationContext.getBean(ContaCorrente.class);
		
		ctxCC.setSaldo(100.0);	
		ctxCC.setNumero("1234");
//		Conta c = new Conta("123", 100.0);
//		ContaCorrente cc = new ContaCorrente("1234", 100.0);
		
		try {
			ctxConta.creditar(100);
			ctxConta.debitar(10);
			
//			c.creditar(100);
//			c.debitar(10);
			
			ctxCC.creditar(100);
			ctxCC.debitar(10);
			
			//Descomentar para testar EXCEÇÃO
			//ctxConta.debitar(500);
			
		}catch (BeansException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
