package ru.prepare2travel.prepare2travelserver.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.prepare2travel.prepare2travelserver.mapper.UserMapper;
import ru.prepare2travel.prepare2travelserver.model.User;
import ru.prepare2travel.prepare2travelserver.model.dto.UserDTO;
import ru.prepare2travel.prepare2travelserver.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserMapper userMapper;

    public UserDTO save(UserDTO dto){
        if(userRepository.findByUsername(dto.getUsername()).isEmpty()){
            User user = userMapper.fromDto(dto);
            user.setPassword(passwordEncoder.encode(dto.getPassword()));
            user.setRegisteredAt(LocalDateTime.now());
            user.setSex(User.UserSex.male);
            user.setRoles(List.of(User.Role.USER));
            return userMapper.toDto(userRepository.save(user));
        }
        else{
            User user = userMapper.fromDto(dto);
            return userMapper.toDto(userRepository.save(user));
        }
    }

    public UserDTO getUserById(Long id){
        User user = userRepository.findById(id).orElseThrow(()->
                new EntityNotFoundException("Cannot find user with id: "+id));

        return userMapper.toDto(user);
    }

    public UserDTO getUserByUsername(String username){
        User user = userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("User with username "+username+" not found"));
        return userMapper.toDto(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("User with username "+username+" not found"));
    }
}
