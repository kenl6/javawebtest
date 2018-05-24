package cn.dw.utils;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;

import cn.dw.model.Product;

// 此类时切面类,用来存储"通知"(在运行时动态切入的代码),AOP是Spring的功能,因此切面类必须交给Spring管理
public class AopClass {

	
	// 创建一个方法(通知),当操作正常时切入
	// 通知参数不能为Object,因此获取不到被切方法的信息，AOP中,被切的方法,称为“连接点”
	public void logs(JoinPoint jp) {  // Joinpoint就是被切的方法,通过被切的方法可以获取参数信息,和方法信息
		System.out.println("日志入库........");
		System.out.println("被切的目标对象:" + jp.getTarget());
		System.out.println("被切的方法声明:" + jp.getSignature());
		System.out.println("被切的方法的参数信息:" + Arrays.toString(jp.getArgs()));
//		Integer.parseInt("xxxx");
	}
	
	public void ex(Exception e) {  // e与xml中指定的名称要相匹配
		System.out.println("异常处理==>" + e);
	}
	
}
