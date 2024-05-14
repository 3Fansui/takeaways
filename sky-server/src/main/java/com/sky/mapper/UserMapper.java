package com.sky.mapper;

import com.sky.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface UserMapper {

    /**
     * 根据openid查询用户
     * @param openid
     * @return
     */
    @Select("select * from sky_take_out.user where openid = #{openid}")
    User getByOpenid(String openid);

    /**
     * 插入数据
     * @param user
     */
    void insert(User user);

    @Select("select * from sky_take_out.user where id=#{userId}")
    User getById(Long userId);

    Integer queryAll();

    Integer queryNewCustomers(Map map);

    /**
     * 根据动态条件统计用户数量
     *
     * @param map
     * @return
     */
    Integer countByMap(Map<String, Object> map);
}