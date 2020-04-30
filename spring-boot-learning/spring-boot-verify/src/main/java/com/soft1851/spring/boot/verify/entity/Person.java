package com.soft1851.spring.boot.verify.entity;

import com.soft1851.spring.boot.verify.annotation.PhoneNumber;
import com.soft1851.spring.boot.verify.annotation.Region;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

/**
 * @author CRQ
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @NotNull(message = "Id不能为空")
   // @Size(min = 6,max = 10)
    private String id;

   // @Size(max = 30)
    @NotNull(message = "name不能为空")
    private String name;

    @Min(18)
    private Integer age;

    //@Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$",message = "手机号码格式错误")
    @PhoneNumber(message = "phoneNumber格式不正确")
    //@NotBlank(message = "手机号码不能为空")
    private String phone;

    @NotNull(message = "email不能为空")
    @Email(message = "邮箱格式错误")
    private String email;

    /**
     * ^string匹配以string开头的字符串
     * string$匹配以string结尾的字符串
     * ^string$精确匹配字符串
     * ((^Man$|^Woman$|^UGM$))的值只能在这三者中选择
     */
    @Pattern(regexp = "((^Man$|^Woman$|^UGM$))",message = "sex值不在可选范围")
    private String sex;

    @Region
    private String region;
}
