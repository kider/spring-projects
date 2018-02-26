package com.spring.boot.example.springbootdemo.service;

import com.spring.boot.example.springbootdemo.entity.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * The interface User service.
 *
 * @author :<a href="mailto:chenhao@ebnew.com">kid</a>
 * @date :2018-01-29 14:06:18
 */
@CacheConfig(cacheNames = "users")
public interface UserService {
    /**
     * 新增一个用户
     *
     * @param name the name
     * @param age  the age
     * @author :<a href="mailto:chenhao@ebnew.com">kid</a>
     * @date :2018-01-29 14:06:18
     */
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @CachePut(key = "#p0")
    void create(String name, Integer age);

    /**
     * 根据name删除一个用户高
     *
     * @param name the name
     * @author :<a href="mailto:chenhao@ebnew.com">kid</a>
     * @date :2018-01-29 14:06:18
     */
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    void deleteByName(String name);

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
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @CacheEvict(value = "users",allEntries = true)
    void deleteAllUsers();

    /**
     * 批量添加用户
     *
     * @param v 用户数
     * @author :<a href="mailto:chenhao@ebnew.com">kid</a>
     * @date :2018-01-29 16:03:59
     */
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    void createBath(int v);

    /**
     * Find by name user.
     *
     * @param name the name
     * @return the user
     * @author :<a href="mailto:chenhao@ebnew.com">kid</a>
     * @date :2018-02-02 14:00:19
     */
    @Cacheable(key = "#p0")
    User findByName(String name);

    /**
     * Update user.
     *
     * @param user the user
     * @author :<a href="mailto:chenhao@ebnew.com">kid</a>
     * @date :2018-02-02 14:01:22
     */
    @CachePut(key = "#p0.name")
    void updateUser(User user);

}
