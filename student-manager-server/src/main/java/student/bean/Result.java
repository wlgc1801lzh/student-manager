package student.bean;

import lombok.Data;

/**
 * 统一返回值类型
 *
 * @author hui
 * @date 2021-11-12 11:33:38
 */
@Data
public class Result {
    /**
     * 返回码
     */
    private Integer code;
    /**
     * 返回消息
     */
    private String msg;
    /**
     * 返回数据
     */
    private Object data;

    public Result(RetCode retCode) {
        this.code = retCode.getCode();
        this.msg = retCode.getMsg();
    }

    public Result(RetCode retCode, Object data) {
        this.code = retCode.getCode();
        this.msg = retCode.getMsg();
        this.data = data;
    }
}