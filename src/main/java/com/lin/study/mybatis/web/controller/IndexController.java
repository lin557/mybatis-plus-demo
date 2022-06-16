package com.lin.study.mybatis.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private BuildProperties buildProperties;
    
    /**
     * 这里只为引导用户调用html，其他所有业务都使用api接口完成
     * @return
     */
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("version", "v" + buildProperties.getVersion());
        return "index";
    }
}
