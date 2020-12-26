package com.aricsun.boot.launch.exception;

/**
 * @author AricSun
 * @date 2020.12.26 17:16
 */
public class ModelViewException extends RuntimeException {

    /*
     * function: 将 Exception 转换为ModelViewException
     * @Param [cause]
     * @Return com.aricsun.boot.launch.exception.ModelViewException
     */
    public static ModelViewException transfer(Throwable cause) {
        return new ModelViewException(cause);
    }

    private ModelViewException(Throwable cause) {
        super(cause);
    }
}
