package com.ojas.app.bussinesslogic;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopService {
	
	@Pointcut("execution(public void com.ojas.app.bussinesslogic.BussinessLogic.saveEmployee())")
	public void p1() {
	}
	
	@Before("p1()")
	public void tX() {
		System.out.println("Begin Tx");
	}
	
	@After("p1()")
	public void commit() {
		System.out.println("Tx commited");
	}
	
	@AfterReturning("p1()")
	public void commitAr() {
		System.out.println("AfterReturning demo");
	}
	
	@AfterThrowing(value = "p1()", throwing = "th")
	public void commitTh(Throwable th) {
		System.out.println("After Throwing Demo" + th.getMessage());
		
	}
	@Around("p1()")
	public void aroundDemo(ProceedingJoinPoint jp) {
		try {
			jp.proceed();
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}

}
