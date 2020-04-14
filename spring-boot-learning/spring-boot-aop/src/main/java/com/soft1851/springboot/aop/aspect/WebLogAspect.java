package com.soft1851.springboot.aop.aspect;

/**
 * @author CRQ
 */
//@Aspect
//@Component
//@Order(1)
//@Slf4j
public class WebLogAspect {
//    private ThreadLocal<Map<String,Object>> threadLocal = new ThreadLocal<>();
//    /**
//     * d定义切点
//     * @return
//     */
//    @Pointcut("@annotation(authToken)")
//    public void doAuthToken(AuthToken authToken){
//    }
//
//
//    /**
//     * 前置增强
//     * @param joinPoint
//     * @param controllerWebLog
//     */
//    @Before(value ="doAuthToken(authToken) && @annotation(controllerWebLog)")
//    public void doBefore(JoinPoint joinPoint, ControllerWebLog controllerWebLog, AuthToken authToken){
//        RequestAttributes at = RequestContextHolder.getRequestAttributes();
//        ServletRequestAttributes sra = (ServletRequestAttributes) at;
//        assert sra != null;
//        HttpServletRequest request = sra.getRequest();
//        log.info("请求URI"+request.getRequestURI());
//        log.info("请求URL"+request.getRequestURL());
//        log.info("请求头的User-Agent:"+request.getHeader("User-Agent"));
//        log.info("请求方法"+request.getMethod());
//        log.info("请求地址"+request.getRemoteAddr());
//        log.info("连接点对象通过反射获得类名和方法名"+joinPoint.getSignature().getDeclaringTypeName()+
//                "."+joinPoint.getSignature().getName());
//        log.info("AOP拦截获得参数"+ Arrays.toString(joinPoint.getArgs()));
//        log.info("执行方法"+controllerWebLog.name());
//        //定义map用来记录日志信息，并put进threadLocal
//        Map<String,Object> map = new HashMap<>(16);
//        map.put("url",request.getRequestURI());
//        map.put("url",request.getRequestURL());
//        map.put("user-agent",request.getHeader("User-Agent"));
//        map.put("request-method",request.getMethod());
//        map.put("remote-address",request.getRemoteAddr());
//        map.put("class-method",joinPoint.getSignature().getDeclaringTypeName()+
//                "."+joinPoint.getSignature().getName());
//        map.put("arguments",Arrays.toString(joinPoint.getArgs()));
//        map.put("execute-method",controllerWebLog.name());
//        threadLocal.set(map);
//    }
//
//    /**
//     * 执行成功后处理
//     * @param controllerWebLog
//     * @param ret
//     * @throws Throwable
//     */
//    @AfterReturning(value = "doAuthToken(authToken)&& @annotation(controllerWebLog)",returning = "ret")
//    public void doAfterReturning(ControllerWebLog controllerWebLog,Object ret,AuthToken authToken)throws Throwable{
//        //从当前线程变量取出数据
//        Map<String,Object> threadInfo = threadLocal.get();
//        threadInfo.put("result",ret);
//        if(controllerWebLog.isSaved()){
//            //真实场景可做定时插入数据库操作
//            log.info("日志已存入数据库");
//        }
//        log.info("response"+ret);
//    }
//
//    /**
//     * 环绕增强
//     * @param proceedingJoinPoint
//     * @return
//     * @throws Throwable
//     */
//    @Around(value = "doAuthToken(authToken)")
//    public Object doAround(ProceedingJoinPoint proceedingJoinPoint, AuthToken authToken) throws Throwable{
//        //得到开始时间
//        long startTime = System.currentTimeMillis();
//        //执行连接点的目标方法getHello()
//        Object ob = proceedingJoinPoint.proceed();
//        Map<String,Object> threadInfo = threadLocal.get();
//        //计算出方法的真实执行时间
//        Long takeTime = System.currentTimeMillis() -startTime;
//        //存入线程变量
//        threadInfo.put("takeTime",takeTime);
//        log.info("耗时"+takeTime);
//        threadLocal.set(threadInfo);
//        return ob;
//    }
//
//    /**
//     * 异常
//     * @param throwable
//     */
//    @AfterThrowing(value = "doAuthToken(authToken)",throwing = "throwable")
//    public void doAfterThrowing(Throwable throwable, AuthToken authToken){
//        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
//        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
//        assert  sra != null;
//        HttpServletRequest request =  sra.getRequest();
//        //异常信息
//        log.error("{}接口调用异常，异常信息{}",request.getRequestURI(),throwable);
//    }
}
