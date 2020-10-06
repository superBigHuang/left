package com.huang.left.controller;

import com.huang.left.entity.Type;
import com.huang.left.service.TypeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("type")
public class TypeController {

    @Autowired
    private TypeService typeService;

    @ApiOperation("通过id查找话题")
    @GetMapping("/getTypeById/{id}")
    public Type getTypeById(@PathVariable long id) {
        return typeService.findById(id);
    }

    @ApiOperation("查询所有话题")
    @GetMapping("/findAll")
    public List<Type> findAll() {
        return typeService.findAllType();
    }

    @ApiOperation("新增或修改话题")
    @PostMapping("/save")
    public Type save(@RequestBody Type type) {
        return typeService.saveType(type);
    }
    @ApiOperation("通过名称查找话题")
    @GetMapping("/findByName/{name}")
    public Type findByName(@PathVariable String name) {
        return typeService.findByName(name);
    }



}
