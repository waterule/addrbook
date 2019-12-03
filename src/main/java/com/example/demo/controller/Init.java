package com.example.demo.controller;

import com.example.demo.entity.AddrBook;
import com.example.demo.service.UserService;
import com.example.demo.vo.RespCom;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class Init {
    @Autowired
    UserService userser;

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
