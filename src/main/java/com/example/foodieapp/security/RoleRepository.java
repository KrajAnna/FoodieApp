package com.example.foodieapp.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository  extends JpaRepository<RoleEntity, Integer> {
    RoleEntity findByName(Role name);
    long countBy();
}
