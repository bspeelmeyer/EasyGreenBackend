package com.pp1.easygreen.security.jwt;

import com.pp1.easygreen.entity.BaseUser;
import com.pp1.easygreen.entity.User;
import com.pp1.easygreen.security.SecurityUserDetails;
import com.pp1.easygreen.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Resource
    private UserService userService;
    //    get user data from database
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("JwtUserDetailsService: username is {}", username);
        List<GrantedAuthority> authorityList = new ArrayList<>();
//        from database to get role
        BaseUser user = userService.getByEmail(username);
        return new SecurityUserDetails(user.getEmail(), user.getPassword(), authorityList);
    }

}