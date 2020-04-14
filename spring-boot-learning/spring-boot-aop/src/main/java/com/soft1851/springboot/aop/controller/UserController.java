package com.soft1851.springboot.aop.controller;

/**
 * @author CRQ
// */
//@RestController
//@Slf4j
public class UserController {

//    @Resource
//    private UserMapper userMapper;
//
//    /**
//     * 无需任何校验，不用加注解
//     * @param name
//     * @return
//     */
//    @GetMapping(value = "hello")
//    @ControllerWebLog(name = "getHello", isSaved = true)
//    public String hello(String name){
//        log.info("hello()方法无需鉴权，也无需认证,当前用户名："+name);
//        return  "hello方法访问成功";
//    }
//
//    /**
//     * 需要登陆的校验,此时该方法需要加注解，但不需要传角色
//     * @param
//     * @return String
//     */
//    @GetMapping("user")
//    @AuthToken
//    @ControllerWebLog(name = "getUser", isSaved = true)
//    public String user(String id) throws SQLException {
//        String name = userMapper.selectAdminById(id).getUsername();
//        log.info("user()方法无需鉴权，需要认证,当前用户名："+name);
//        return "user()方法访问成功";
//    }
//
//    /**
//     * 需要登陆的校验,此时该方法需要加注解，且需要传角色
//     * 角色可以传多个
//     * 如果需要更复杂的逻辑操作，建议使用框架：Spring Security,Apache Spring等框架
//     * @param id
//     * @return String
//     */
//    @GetMapping("admin")
//    @AuthToken(role_name = {"0","1"})
//    @ControllerWebLog(name = "getAdmin", isSaved = true)
//    public String admin(String id) throws SQLException {
//        String name = userMapper.selectAdminById(id).getUsername();
//        log.info("admin()方法需要鉴权,当前用户名："+name);
//        return "admin()方法响应成功";
//    }

}
