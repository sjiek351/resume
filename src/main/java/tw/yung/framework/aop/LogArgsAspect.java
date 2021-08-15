package tw.yung.framework.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * <pre>
 * 日誌 Aop
 * </pre>
 *
 * @author 崔永昀
 * @since 2021-08-11
 * @version 2021-08-11 崔永昀
 */
@Aspect
@Component
public class LogArgsAspect {
	private static final Logger LOGGER = LoggerFactory.getLogger(LogArgsAspect.class);

	/**
	 * <pre>
	 * 對所有Controller, Dao的方法做傳入參數的log
	 * </pre>
	 *
	 * @since 2021-08-11 崔永昀
	 */
	@Before("execution(* tw.yung.rs.controller.*.*(..)) || execution(* tw.yung.rs.dao.*.*(..))")
	public void logJdbcTemplateArg(JoinPoint joinPoint) {
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();

		LOGGER.info(String.format("%s.%s %s", className, methodName, Arrays.toString(args)));
	}

}
