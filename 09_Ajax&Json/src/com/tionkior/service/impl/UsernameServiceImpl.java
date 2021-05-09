package com.tionkior.service.impl;

import com.tionkior.dao.UsernameDao;
import com.tionkior.dao.impl.UsernameImpl;
import com.tionkior.domain.Person;
import com.tionkior.service.UsernameService;

/**
 * @ClassName : UsernameServiceImpl
 * @Author : TionKior
 * @Date : 2021/5/9 14:57
 * @Version : V1.0
 * @Description : Find Username Service
 */

public class UsernameServiceImpl implements UsernameService {

    UsernameDao dao = new UsernameImpl();

    @Override
    public boolean finUsername(String username) {

        int i = dao.findUsername(username);

        return i == 0;
    }
}
