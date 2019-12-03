package com.example.demo.service;

import com.example.demo.entity.AddrBook;

import java.util.List;

public interface UserService {

    List<AddrBook> getbookslist();
    Long saveAddr(AddrBook book);
    List<AddrBook> getbooklist(String telOrName);
    void deleteBook(List<Long> ids);

    List<AddrBook> getbook(Long id);
}
