package com.example.demo.service.impl;

import com.example.demo.entity.AddrBook;
import com.example.demo.repo.AddrBookRepo;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    EntityManager em;


    @Autowired
    AddrBookRepo bookRepo;

    @Override
    public List<AddrBook> getbookslist() {

        StringBuilder sb = new StringBuilder();
        sb.append("  from ");
        sb.append(AddrBook.class.getName());
        List<AddrBook> list = em.createQuery(sb.toString()).getResultList();
        if(list!=null &&list.size()>0){
            return list;
        }
        return null;
    }

    @Override
    public Long saveAddr(AddrBook book) {
        if(book.getName()==null || "".equals(book.getName())){
            book.setName("未命名");
        }
        return bookRepo.save(book).getId();
    }

    @Override
    public List<AddrBook> getbooklist(String telOrName) {
        telOrName = "%"+telOrName+"%";
        StringBuilder sb = new StringBuilder();
        sb.append("  from ");
        sb.append(AddrBook.class.getName());
        sb.append("  t where  t.tel like :telOrName or t.name like :telOrName ");
        List<AddrBook> list = em.createQuery(sb.toString()).setParameter("telOrName",telOrName).getResultList();
        if(list!=null &&list.size()>0){
            return list;
        }
        return null;
    }

    @Override
    public void deleteBook(List<Long> ids) {

        for(Long id :  ids)
        bookRepo.deleteById(id);
    }

    @Override
    public List<AddrBook> getbook(Long id) {

        StringBuilder sb = new StringBuilder();
        sb.append("  from ");
        sb.append(AddrBook.class.getName());
        sb.append("  t where  t.id=:id ");
        List<AddrBook> list = em.createQuery(sb.toString()).setParameter("id",id).getResultList();
        if(list!=null &&list.size()>0){
            return list;
        }
        return  null;
    }


}
