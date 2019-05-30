package com.itheima.service;

import java.util.List;

/**
 * 详情
 *
 * @author wz
 * @date 2019-04-02-17:04
 */
public interface UserService {
    public boolean isRegister(String username);

    List<String> findkeyWords(String keyWords);
}
