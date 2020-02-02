package com.baomidou.mybatisplus.samples.quickstart;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.samples.quickstart.entity.User;
import com.baomidou.mybatisplus.samples.quickstart.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {

    @Resource
    private UserMapper userMapper;

    //@Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }
    @Test
    public void testSelect1() {
        System.out.println(("----- selectAll method test ------"));
        Page<User> pageUser = userMapper.selectPage(new Page<User>(1, 10),new QueryWrapper<User>().orderByAsc("name").like("name","Tom"));
        pageUser.getRecords().forEach(System.out::println);
    }
    @Test
    public void test() {
        System.out.println(("----- selectAll method test ------"));
        User user = userMapper.selectByUsername("Jone");
        System.out.println(user);
    }
}
