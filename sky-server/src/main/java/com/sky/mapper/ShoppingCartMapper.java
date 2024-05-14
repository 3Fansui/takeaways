package com.sky.mapper;

import com.sky.entity.ShoppingCart;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ShoppingCartMapper {

    /**
     * 查询购物车
     * 
     * @param shoppingCart
     * @return List<ShoppingCart>
     */
    List<ShoppingCart> list(ShoppingCart shoppingCart);

    /**
     * 根据id更新购物车数量
     * 
     * @param shoppingCart
     */
    @Update("update sky_take_out.shopping_cart set number = #{number} where id = #{id}")
    void updateNumberById(ShoppingCart shoppingCart);

    /**
     * 添加购物车
     * 
     * @param shoppingCart
     */
    @Insert("insert into sky_take_out.shopping_cart (user_id, dish_id, setmeal_id, name, image, amount, number, dish_flavor, create_time) "
            +
            "values " +
            "(#{userId}, #{dishId}, #{setmealId}, #{name}, #{image}, #{amount}, #{number}, #{dishFlavor}, #{createTime})")
    void insert(ShoppingCart shoppingCart);

    /**
     * 清空购物车
     * 
     * @param userId
     */
    @Delete("delete from sky_take_out.shopping_cart where user_id = #{userId}")
    void deleteByUserId(Long userId);

    /**
     * 根据id删除购物车
     * 
     * @param id
     */
    @Delete("delete from sky_take_out.shopping_cart where id = #{id}")
    void deleteById(Long id);

    /**
     * 批量插入购物车数据
     *
     * @param shoppingCartList
     */
    void insertBatch(List<ShoppingCart> shoppingCartList);
}
