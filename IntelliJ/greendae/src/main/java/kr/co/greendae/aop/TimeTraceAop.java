package kr.co.greendae.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * Aop 적용 - Service 시간 체크 
 * Aop 필요 시 추가 예정
 * 
 * 관련 빈 등록은 AppConfig에서 활성화
 */
@Aspect
public class TimeTraceAop {

    @Around("execution(* kr.co.greendae.service..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());
        try{
            return joinPoint.proceed();
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END : " + joinPoint.toString() + " " + timeMs + "ms");
        }
    }
}
