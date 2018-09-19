package com.socialfeed.repository;

import com.socialfeed.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AccountRepository extends JpaRepository<UserAccount,Long>{
}