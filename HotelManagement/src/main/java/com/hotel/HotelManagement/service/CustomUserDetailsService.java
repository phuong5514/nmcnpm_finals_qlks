    package com.hotel.HotelManagement.service;

    import com.hotel.HotelManagement.entity.CustomUserDetails;
    import com.hotel.HotelManagement.entity.Role;
    import com.hotel.HotelManagement.entity.User;
    import com.hotel.HotelManagement.repository.UserRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.security.core.GrantedAuthority;
    import org.springframework.security.core.authority.SimpleGrantedAuthority;
    import org.springframework.security.core.userdetails.UserDetails;
    import org.springframework.security.core.userdetails.UserDetailsService;
    import org.springframework.security.core.userdetails.UsernameNotFoundException;
    import org.springframework.stereotype.Service;

    import java.util.*;

    @Service
    public class CustomUserDetailsService implements UserDetailsService {
        @Autowired
        private UserServiceInterface userServiceInterface;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


            User user = userServiceInterface.findByUsername(username);

            // Bước 2: Kiểm tra xem người dùng có tồn tại hay không
            if (user == null) {
                System.out.println("User " + username + " not found in database.");
                throw new UsernameNotFoundException("User with username: " + username + " was not found.");
            }



            System.out.println("User found: " + user.getUsername());

            Collection<GrantedAuthority> authorities = new HashSet<>();
            for (Role role : user.getRoles()) {
                // Mỗi vai trò được ánh xạ thành một đối tượng SimpleGrantedAuthority
                String roleName = role.getRoleName();
                GrantedAuthority authority = new SimpleGrantedAuthority(roleName);
                authorities.add(authority);
            }

            CustomUserDetails userDetails = new CustomUserDetails(user,authorities);

            return userDetails;
        }
    }
