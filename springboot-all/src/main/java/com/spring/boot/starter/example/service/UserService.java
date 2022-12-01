package com.spring.boot.starter.example.service;

import com.spring.boot.starter.example.entity.User;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;


/**
 * The interface User service.
 *
 * @author :<a href="mailto:chenhao@ebnew.com">kid</a>
 * @date :2018-01-29 14:06:18
 */
public interface UserService {


    /**
     * 新增一个用户
     *
     * @param name the name
     * @param age  the age
     * @author :<a href="mailto:chenhao@ebnew.com">kid</a>
     * @date :2018-01-29 14:06:18
     */
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    void create(String name, Integer age);

    /**
     * 根据name删除一个用户
     *
     * @param name the name
     * @author :<a href="mailto:chenhao@ebnew.com">kid</a>
     * @date :2018-01-29 14:06:18
     */
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    void deleteByName(String name) throws IOException;

    /**
     * 获取用户总量
     *
     * @return the all users
     * @author :<a href="mailto:chenhao@ebnew.com">kid</a>
     * @date :2018-01-29 14:06:18
     */
    Integer getAllUsers();

    /**
     * 删除所有用户
     *
     * @author :<a href="mailto:chenhao@ebnew.com">kid</a>
     * @date :2018-01-29 14:06:18
     */
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    void deleteAllUsers();

    /**
     * 批量添加用户
     *
     * @param v 用户数
     * @author :<a href="mailto:chenhao@ebnew.com">kid</a>
     * @date :2018-01-29 16:03:59
     */
    @Transactional(rollbackFor = Exception.class, isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
    void createBath(int v);

    /**
     * Find by name user.
     *
     * @param name the name
     * @return the user
     * @author :<a href="mailto:chenhao@ebnew.com">kid</a>
     * @date :2018-02-02 14:00:19
     */
    User findByName(String name);

    /**
     * Update user.
     *
     * @param user the user
     * @author :<a href="mailto:chenhao@ebnew.com">kid</a>
     * @date :2018-02-02 14:01:22
     */
    void updateUser(User user);

}
