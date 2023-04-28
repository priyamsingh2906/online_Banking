package com.project.onlineProject.OnlineBanking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.onlineProject.OnlineBanking.Entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByAccountNumber(String accountNumber);
}
