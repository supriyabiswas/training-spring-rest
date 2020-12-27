package com.supriyabiswas.tsr.persistance.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supriyabiswas.tsr.persistance.model.User;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

}
