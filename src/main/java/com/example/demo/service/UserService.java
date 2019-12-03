package com.example.demo.service;

import com.example.demo.entity.AddrBook;
import com.example.demo.entity.Goods;

import java.util.List;

public interface UserService {
    public Long getuser(String username,String password);
    public Long saveUser(String username,String password);
    public Long saveGoods(Goods gods);
    public boolean ishasU(String username);
    public List<Goods> getGoodslist();
    List<AddrBook> getbookslist();
    Long saveAddr(AddrBook book);
    List<AddrBook> getbooklist(String telOrName);
    void deleteBook(List<Long> ids);

    List<AddrBook> getbook(Long id);
}
