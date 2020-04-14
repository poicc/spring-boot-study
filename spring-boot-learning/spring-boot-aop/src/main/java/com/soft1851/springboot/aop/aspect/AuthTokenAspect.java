package com.soft1851.springboot.aop.aspect;

import com.soft1851.springboot.aop.annotation.AuthToken;
import com.soft1851.springboot.aop.common.Result;
import com.soft1851.springboot.aop.common.ResultCode;
import com.soft1851.springboot.aop.mapper.SysUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author CRQ
 */
@Aspect
@Component
@Slf4j
public class AuthTokenAspect {

//    @Resource
//    private UserMapper userMapper;
//
//    /**
//     * 配置加上自定义注解的方法为切点
//     * @param authToken
//     */
//    @Pointcut("@annotation(authToken)")
//    public void doAuthToken(AuthToken authToken){
//    }
//
//    @Around(value = "doAuthToken(authToken)",argNames = "pjp,authToken")
//    public Object doAround(ProceedingJoinPoint pjp,AuthToken authToken) throws Throwable{
//        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        assert sra != null;
//        HttpServletRequest request = sra.getRequest();
//        //取得注解中的role_name的值
//        String[] roleNames = authToken.role_name();
//        //没有role的值
//        if(roleNames.length <= 1){
//            //只需要登陆
//           String id = request.getHeader("id");
//            //如果id为空，证明用户没有登陆
//            if(userMapper.selectAdminById(id) !=null) {
//                return pjp.proceed();
//            }
//            return "没有登陆";
//
//           // return ResponseBean.failure(ResultCode.USER_NOT_SIGN_IN);
//        }else {
//            //验证身份
//            String role = userMapper.selectAdminById(request.getHeader("id")).getIsAdmin();
//            log.info("权限级别"+role);
//           // 遍历roleNames数组，匹配role
//          //  for (String roleName : roleNames) {
//                if("1".equals(role)){
//                    //匹配成功，调用目标方法
//                    return  pjp.proceed();
//                }
//           // }
//
//            return "没有权限";
//           //return ResponseBean.failure(ResultCode.USER_NOT_AUTH);
//        }
//    }

    @Resource
    private SysUserMapper mapper;

    private ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<>();

    /**
     * 配置加上自定义注解的方法为切点
     * @param authToken
     */
    @Pointcut("@annotation(authToken)")
    public void doAuthToken(AuthToken authToken) {
    }

//    @Pointcut("execution(public * com.soft1851.springboot.aop.controller..*.*(..))")
//    public void webLog(){
//    }

    /**
     * object是指controller方法返回的类型
     */
    @Around(value = "doAuthToken(authToken)", argNames = "pjp,authToken")
    public Object doAround(ProceedingJoinPoint pjp,AuthToken authToken) throws Throwable{
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert sra != null;
        HttpServletRequest request = sra.getRequest();
        // 取得注解中的role_name的值
        String[] roleNames = authToken.role_name();
        //没有role的值
        if (roleNames.length <= 1) {
            // 只需认证
            String token = request.getHeader("token");
            String id = request.getParameter("id");
            Map<String, Object> map = mapper.getUserById(id);
            // 如果id为空， 证明用户没有登录
            if (token != null && roleNames[0].equals(map.get("role_name"))) {
                // 返回controller方法的值
                return pjp.proceed();
            }
            return Result.success(ResultCode.PERMISSION_NO_ACCESS);
        }else {
            // 请求头中取出role，验证身份
            String id = request.getParameter("id");
            Map<String, Object> map = mapper.getUserById(id);
            for (String roleName : roleNames) {
                if (roleName.equals(map.get("role_name"))) {
                    // 身份匹配成功
                    return pjp.proceed();
                }
            }
            return Result.success(ResultCode.PERMISSION_NO_ACCESS);
        }

    }
}
