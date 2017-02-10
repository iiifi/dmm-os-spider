/*
 *  Copyright 20016-2016 Edencity, Inc.
 */
package com.dmm.framework.common.mongo;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 2016年8月27日下午1:53:19
 * 
 * @author xiaoyu
 * @description 计算方法执行耗时
 * @version 1.0
 */
@Aspect
public class ExecuteTimeAop {

	protected Logger logger = Logger.getLogger(ExecuteTimeAop.class);

	@Pointcut("execution(public String com.edencity.edencity.server.interact.modules.*.service..*.*(..))")
	public void timeAop() {
	}

	@Around("timeAop()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		long start = System.currentTimeMillis();
		Object object = point.proceed();
		long end = System.currentTimeMillis();
		logger.info(point.toShortString() + "执行耗时: " + (end - start) + "ms");
		return object;
	}
}
