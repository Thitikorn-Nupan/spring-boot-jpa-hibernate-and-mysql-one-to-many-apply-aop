package com.ttknp.logic_layer.repositories;

import com.ttknp.logic_layer.entities.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepo extends CrudRepository<Author,String> { }
