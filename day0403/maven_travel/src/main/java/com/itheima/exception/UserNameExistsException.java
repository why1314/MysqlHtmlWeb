package com.itheima.exception;


/**
 * 详情
 *
 * @author wz
 * @date 2019-04-03-18:04
 */
public class UserNameExistsException extends Exception {
    public UserNameExistsException() {
    }

    public UserNameExistsException(String message) {
        super(message);
    }

}
