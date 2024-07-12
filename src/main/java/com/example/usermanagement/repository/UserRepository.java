package com.example.usermanagement.repository;

import com.example.usermanagement.model.UserTbl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserTbl, Integer> {
    boolean existsByUserName(String userName);

    boolean existsByUserNameAndPassword(String userName, String password);

    void deleteByUserName(String userName);
}
