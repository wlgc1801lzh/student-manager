package student.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import student.bean.Result;
import student.bean.RetCode;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author hui
 * @date 2022-01-09 09:14:04
 */
public class JsonUtil {

    /**
     * Servlet返回JSON
     *
     * @param response HttpServletResponse对象
     * @param retCode  统一返回值枚举
     * @throws IOException IO异常
     */
    public static void response(HttpServletResponse response, RetCode retCode) throws IOException {
        response.setCharacterEncoding("utf8");
        response.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter writer = response.getWriter();
        writer.write(mapper.writeValueAsString(new Result(retCode)));
        writer.flush();
        writer.close();
    }
}
