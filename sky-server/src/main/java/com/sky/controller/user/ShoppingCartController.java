package com.sky.controller.user;

import com.sky.dto.ShoppingCartDTO;
import com.sky.entity.ShoppingCart;
import com.sky.result.Result;
import com.sky.service.ShoppingCartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/shoppingCart")
@Slf4j
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    /**
     * 添加购物车
     * 
     * @param shoppingCartDTO
     * @return
     */
    @PostMapping("/add")
    public Result<String> add(@RequestBody ShoppingCartDTO shoppingCartDTO) {
        log.info("添加购物车：{}", shoppingCartDTO);
        shoppingCartService.add(shoppingCartDTO);
        return Result.success();
    }

    /**
     * 查看购物车
     * 
     * @return
     */
    @GetMapping("/list")
    public Result<List<ShoppingCart>> list() {
        List<ShoppingCart> shopList = shoppingCartService.showShoppingCart();
        return Result.success(shopList);
    }

    /**
     * 清空购物车
     * 
     * @return
     */
    @DeleteMapping("/clean")
    public Result<String> clean() {
        shoppingCartService.cleanShoppingCart();
        return Result.success();
    }

    /**
     * 删除购物车中一个商品
     * 
     * @param shoppingCartDTO
     * @return
     */
    @PostMapping("/sub")
    public Result<String> sub(@RequestBody ShoppingCartDTO shoppingCartDTO) {
        log.info("减少购物车：{}", shoppingCartDTO);
        shoppingCartService.subShoppingCart(shoppingCartDTO);
        return Result.success();
    }

}
