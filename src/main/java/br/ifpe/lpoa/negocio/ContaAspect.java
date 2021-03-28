package br.ifpe.lpoa.negocio;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class ContaAspect {
	
	public ContaAspect() {
		
	}
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//###### Item 1 - Criar um pointcut para interceptar a execução do método creditar de Conta ######
	@Before(value = "execution(void Conta.creditar(double))")
	public void pdcItem1Before() {
		logger.info("Before Item 1");
	}
	
	@Around(value = "execution(void Conta.creditar(double))")
	public void pdcItem1Around(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("Before-around Item 1");
		joinPoint.proceed();
		logger.info("After-around Item 1");
	}
	
	@After(value = "execution(void Conta.creditar(double))")
	public void pdcItem1After() {
		logger.info("After Item 1");
	}
	
	
	//###### Item 2 - Criar um pointcut para interceptar a execução do método creditar de Conta Corrente ######
	@Before(value = "execution(* Conta.creditar(double))")
	public void pdcItem2Before() {
		logger.info("Before Item 2");
	}
	
	@Around(value = "execution(* Conta.creditar(double))")
	public void pdcItem2Around(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("Before-around Item 2");
		joinPoint.proceed();
		logger.info("After-around Item 2");
	}
	
	@After(value = "execution(* Conta.creditar(double))")
	public void pdcItem2After() {
		logger.info("After Item 2");
	}
	
	
	//###### Item 3 - Criar um pointcut para interceptar a execução do método creditar de Conta e de Conta Corrente ######
	@Before(value = "execution(* Conta+.creditar(double))")
	public void pdcItem3Before() {
		logger.info("Before Item 3");
	}
	
	@Around(value = "execution(* Conta+.creditar(double))")
	public void pdcItem3Around(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("Before-around Item 3");
		joinPoint.proceed();
		logger.info("After-around Item 3");
	}
	
	@After(value = "execution(* Conta+.creditar(double))")
	public void pdcItem3After() {
		logger.info("After Item 3");
	}
	
	
	//###### Item 4 - Criar um pointcut para interceptar toda vez que o saldo for alterado ######
	@Before(value = "execution(* setSaldo(double)) "
			+ "|| execution(* creditar(double)) "
			+ "|| execution(* debitar(double)) "
			+ "|| execution(* transferir(double)) ")
	public void pdcItem4Before() {
		logger.info("Before Item 4");
	}
	
	@Around(value = "execution(* setSaldo(double)) "
			+ "|| execution(* creditar(double)) "
			+ "|| execution(* debitar(double)) "
			+ "|| execution(* transferir(double)) ")
	public void pdcItem4Around(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("Before-around Item 4");
		joinPoint.proceed();
		logger.info("After-around Item 4");
	}
	
	@After(value = "execution(* setSaldo(double)) "
			+ "|| execution(* creditar(double)) "
			+ "|| execution(* debitar(double)) "
			+ "|| execution(* transferir(double)) ")
	public void pdcItem4After() {
		logger.info("After Item 4");
	}
	
	
	//###### Item 5 - Criar um pointcut para interceptar toda vez que o saldo for alterado dentro de Conta ######
	@Before(value = "execution(* setSaldo(double)) "
			+ "|| execution(* creditar(double)) "
			+ "|| execution(* debitar(double)) "
			+ "|| execution(* transferir(double)) "
			+ "&& within(Conta)")
	public void pdcItem5Before() {
		logger.info("Before Item 5");
	}	
	
	@Around(value = "(execution(* setSaldo(double)) "
			+ "|| execution(* creditar(double)) "
			+ "|| execution(* debitar(double)) "
			+ "|| execution(* transferir(double)))"
			+ "&& within(Conta)")
	public void pdcItem5Around(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("Before-around Item 5");
		joinPoint.proceed();
		logger.info("After-around Item 5");
	}
	
	@After(value = "execution(* setSaldo(double)) "
			+ "|| execution(* creditar(double)) "
			+ "|| execution(* debitar(double)) "
			+ "|| execution(* transferir(double)) "
			+ "&& within(Conta)")
	public void pdcItem5After() {
		logger.info("After Item 5");
	}
	
	
	//###### Item 6 - Criar um pointcut para interceptar toda vez que o saldo for alterado dentro de um objeto de Conta ######
	@Before(value = "execution(* Conta.setSaldo(double)) "
			+ "|| execution(* Conta.creditar(double)) "
			+ "|| execution(* Conta.debitar(double)) "
			+ "|| execution(* Conta.transferir(double))")	
	public void pdcItem6Before() {
		logger.info("Before Item 6");
	}	
	
	@Around(value = "execution(* Conta.setSaldo(double)) "
			+ "|| execution(* Conta.creditar(double)) "
			+ "|| execution(* Conta.debitar(double)) "
			+ "|| execution(* Conta.transferir(double))")
	public void pdcItem6Around(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("Before-around Item 6");
		joinPoint.proceed();
		logger.info("After-around Item 6");
	}
	
	@After(value = "execution(* Conta.setSaldo(double)) "
			+ "|| execution(* Conta.creditar(double)) "
			+ "|| execution(* Conta.debitar(double)) "
			+ "|| execution(* Conta.transferir(double))")
	public void pdcItem6After() {
		logger.info("After Item 6");
	}
	
	
	//###### Item 7 - Criar um pointcut para interceptar toda chamada após a execução do método transferir de Conta, dentro de Conta ######
	//###### Item 8 - Criar um pointcut para interceptar a chamada do método creditar de Conta dentro do código do método transferir ######
	
	//Não consegui adaptar os itens 7 e 8 já que no Spring AOP não é possível usar o cflowbelow e o withincode, respectivamente.
	
	
	//###### Item 9 - Criar um pointcut para interceptar qualquer excpetion levantada dentro da classe Conta ######
		@AfterThrowing("within(Conta)")	
		public void pdcItem9Before() {
			logger.info("@AfterThrowing Item 9");
		}	
	
	
	//###### Item 10 - Criar um pointcut para interceptar toda vez que o saldo for acessado dentro do método creditar da Conta Corrente ######
	//Não consegui adaptar o item 10 pela mesma razão do item 8 (withincode).
}
