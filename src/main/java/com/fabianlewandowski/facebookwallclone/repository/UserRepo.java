package com.fabianlewandowski.facebookwallclone.repository;

import com.fabianlewandowski.facebookwallclone.mode.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
    User findUserByUsername(String username);
}
