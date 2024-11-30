package com.example.foodieapp.security;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    @PostConstruct
    public void initRoles(){

        if(roleRepository.countBy()==0){
            roleRepository.save(new RoleEntity(Role.ADMIN));
            roleRepository.save(new RoleEntity(Role.USER));
        }
    }


}
