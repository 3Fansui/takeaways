package com.sky.controller.user;

import com.sky.constant.StatusConstant;
import com.sky.entity.Dish;
import com.sky.result.Result;
import com.sky.service.DishService;
import com.sky.vo.DishVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController("userDishController")
@RequestMapping("/user/dish")
@Slf4j
@Api(tags = "C端-菜品浏览接口")
public class DishController {
    @Autowired
    private DishService dishService;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 根据分类id查询菜品
     *
     * @param categoryId
     * @return
     */
    @GetMapping("/list")
    @SuppressWarnings("unchecked")
    public Result<List<DishVO>> list(Long categoryId) {
        //构造redis中是否存在菜品数据
        String cacheKey = "dish_" + categoryId;
        List<DishVO> list = (List<DishVO>) redisTemplate.opsForValue().get(cacheKey);
        if (list != null && list.size() > 0) {
            //如果存在，直接返回，无须查询数据库
            return Result.success(list);
        }

        Dish dish = new Dish();
        dish.setCategoryId(categoryId);
        dish.setStatus(StatusConstant.ENABLE);// 查询起售中的菜品
        list = dishService.listWithFlavor(dish);
        // 如果不存在，查询数据库，将查询到的数据放入redis中
        redisTemplate.opsForValue().set(cacheKey, list);

        return Result.success(list);
    }

}
