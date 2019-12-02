package com.example.demo.repo;

import com.example.demo.entity.AddrBook;
import org.springframework.data.repository.CrudRepository;

public interface AddrBookRepo extends CrudRepository<AddrBook,Long> {
}
