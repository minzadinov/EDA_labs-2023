package com.example.demo.repos;

import com.example.demo.models.Command;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandRepo extends CrudRepository<Command, Long> {
}
