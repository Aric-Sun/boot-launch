package com.aricsun.boot.launch.service;

import com.aricsun.boot.launch.exception.CustomException;
import com.aricsun.boot.launch.exception.CustomExceptionType;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * 模拟异常（P65）
 * @author AricSun
 * @date 2020.12.26 0:02
 */
@Service
public class ExceptionService {

    // 服务层，模拟系统异常
    public void systemBizError() {
        try {
            Class.forName("com.mysql.jdbc.xxx.Driver");
        } catch (ClassNotFoundException e) {
            throw new CustomException(
                    CustomExceptionType.SYSTEM_ERROR,
                    "在ExceptionService业务，systemBizError方法内，" +
                    "出现ClassNotFoundException，请将该信息告知管理员");
        }
    }

    public void userBizError(int input) {
//        if (input < 0) {
//            throw new CustomException(
//                    CustomExceptionType.USER_INPUT_ERROR,
//                    "您输入的数据不符合业务逻辑，请确认后重新输入！");
//        }

        // 可以用断言去简写上面的代码，抛出的IllegalArgumentException用全局异常捕获类WebExceptionHandler去捕获
        // 注意是org.springframework.util.Assert;
        Assert.isTrue(input >= 0, "您输入的数据不符合业务逻辑，请确认后重新输入！");
    }

    // 其他的业务
}
