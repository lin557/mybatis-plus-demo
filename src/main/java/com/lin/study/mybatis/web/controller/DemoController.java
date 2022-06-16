package com.lin.study.mybatis.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lin.study.mybatis.sql.entity.BaseDemo;
import com.lin.study.mybatis.sql.mapper.BaseDemoMapper;

@RestController
public class DemoController {

    @Autowired
    private BaseDemoMapper baseDemoMapper;
    
    @RequestMapping("/demo")
    public @ResponseBody Object demo(HttpServletRequest request) throws Exception {
        List<BaseDemo> list = baseDemoMapper.selectList(null);
        return list;
    }
    
    /**
     * 只有指定列有值
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/demo/column")
    public @ResponseBody Object demoColumn(HttpServletRequest request) throws Exception {
        QueryWrapper<BaseDemo> queryWrapper = new QueryWrapper<BaseDemo>();
        List<BaseDemo> list = baseDemoMapper.selectList(queryWrapper.select("id", "car_id").like("car_name", "aa"));
        return list;
    }
    
    /**
     * 条件查询
     * @param request
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/demo/{id}")
    public @ResponseBody Object demoParam(HttpServletRequest request, @PathVariable Long id) throws Exception {
        QueryWrapper<BaseDemo> queryWrapper = new QueryWrapper<BaseDemo>();
        List<BaseDemo> list = baseDemoMapper.selectList(queryWrapper.eq("id", id));
        return list;
    }
    
    /**
     * 条件查询 like
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/demo/like")
    public @ResponseBody Object demoLike(HttpServletRequest request) throws Exception {
        QueryWrapper<BaseDemo> queryWrapper = new QueryWrapper<BaseDemo>();
        List<BaseDemo> list = baseDemoMapper.selectList(queryWrapper.like("car_name", "aa"));
        return list;
    }
    
    /**
     * 排序
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/demo/sort")
    public @ResponseBody Object demoSort(HttpServletRequest request) throws Exception {
        QueryWrapper<BaseDemo> queryWrapper = new QueryWrapper<BaseDemo>();
        List<BaseDemo> list = baseDemoMapper.selectList(queryWrapper.orderByDesc("id"));
        return list;
    }
    
    @RequestMapping("/demo/insert")
    public @ResponseBody Object demoInsert(HttpServletRequest request) throws Exception {
        BaseDemo baseDemo = new BaseDemo();
        String id = String.format("id%d", System.currentTimeMillis());
        baseDemo.setCarId(id);
        baseDemo.setCarName(id + "-aa");
        baseDemoMapper.insert(baseDemo);
        List<BaseDemo> list = baseDemoMapper.selectList(null);
        return list;
    }
}
