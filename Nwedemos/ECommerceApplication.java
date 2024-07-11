// UserAccountRepository.java
package com.example.ecommerce.repository;

import com.example.ecommerce.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
}