package com.sky.mapper;

import com.sky.entity.Dish;
import com.sky.entity.SetmealDish;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SetmealDishMapper {
    /**
     * 根据菜品id查寻对应的套餐id
     * @param dishIds
     * @return
     */
    List<Long> getSetmealIdsByDishIds(List<Long> dishIds);

    int queryConnect(Dish dish);
    void insertBatch(List<SetmealDish> setmealDishes);

    /**
     * 根据套餐id删除
     *
     * @param setmealId
     */
    @Delete("delete from sky_take_out.setmeal_dish where setmeal_id = #{setmealId}")
    void deleteBySetmealId(Long setmealId);

    /**
     * 根据套餐id查询菜品
     *
     * @param setmealId
     */
    @Select("select * from sky_take_out.setmeal_dish where setmeal_id = #{setmealId}")
    List<SetmealDish> getDishBySetmealId(Long setmealId);

}
