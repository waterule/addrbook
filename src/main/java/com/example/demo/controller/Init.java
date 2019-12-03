package com.example.demo.controller;

import com.example.demo.entity.AddrBook;
import com.example.demo.entity.Goods;
import com.example.demo.repo.GoodsRepo;
import com.example.demo.service.UserService;
import com.example.demo.vo.RespCom;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Api("登陆入口")
@RestController

public class Init {
    @Autowired
    UserService userser;
    @Autowired
    GoodsRepo grepo;

    @ApiOperation(value="首页", notes = "首页信息")
   @RequestMapping(value = "/" ,method = RequestMethod.GET)
   public ModelAndView init()
    {
       return new ModelAndView("html/index");
   }









    @GetMapping(value = "/getaddrs")
    public List<AddrBook> getaddrs(){
        return userser.getbookslist();
    }

    @PostMapping(value = "/saveaddrbook")
    public  RespCom saveAddr(@RequestBody AddrBook addrs){
        RespCom resp = new RespCom();
        userser.saveAddr(addrs);
        resp.setRescode("00");
        return resp;
    }


    @PostMapping(value = "/delids")
    public  RespCom delids(@RequestBody List<Long> addrs){
        RespCom resp = new RespCom();
        userser.deleteBook(addrs);
        resp.setRescode("00");
        return resp;
    }


    @GetMapping("/sec/{username}")

    public List<AddrBook> secuser(@PathVariable String username){
        List<AddrBook> list =   userser.getbooklist(username);
        return list;

    }


    @GetMapping("/edit/{id}")

    public List<AddrBook> editaddr(@PathVariable Long id){
        List<AddrBook> list =   userser.getbook(id);
        return list;

    }




}
