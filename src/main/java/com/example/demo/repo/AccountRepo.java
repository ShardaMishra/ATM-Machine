package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Account;

@Repository
@EnableJpaRepositories
public interface AccountRepo extends JpaRepository<Account, Long>  {	

}
