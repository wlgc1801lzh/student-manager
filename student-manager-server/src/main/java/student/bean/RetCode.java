package student.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 统一返回值枚举
 *
 * @author hui
 * @date 2022-01-08 09:44:26
 */
@Getter
@AllArgsConstructor
public enum RetCode {

    //通用接口
    OK(200, "接口调用成功"),
    //登录接口
    LOGIN_SUCCESS(1000, "登陆成功"),
    PERMISSION_DENIED(1010, "无权限"),
    NO_LOGGED(1011, "未登录"),
    ;

    /**
     * 返回码
     */
    private final Integer code;
    /**
     * 返回消息
     */
    private final String msg;
}