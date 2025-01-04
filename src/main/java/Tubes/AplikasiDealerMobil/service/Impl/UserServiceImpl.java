package Tubes.AplikasiDealerMobil.service.Impl;

import Tubes.AplikasiDealerMobil.dto.UserDto;
import Tubes.AplikasiDealerMobil.mapper.UserMapper;
import Tubes.AplikasiDealerMobil.model.User;
import Tubes.AplikasiDealerMobil.repository.UserRepository;
import Tubes.AplikasiDealerMobil.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);


        String username = user.getUsername().toLowerCase();


        if (username.contains("petugas")) {
            user.setRole(UserRole.DEALER_ADMIN);
        } else if (username.contains("sales")) {
            user.setRole(UserRole.SALES_DEALER);
        } else {
            user.setRole(UserRole.CUSTOMER);
        }

        System.out.println("Creating user with username: " + username + " and role: " + user.getRole());

        User savedUser = userRepository.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public String getCurrentUserRole(String username) {
        Optional<User> userOpt = userRepository.findByUsername(username);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            UserRole role = user.getRole();
            if (role == null) {
                role = UserRole.CUSTOMER;
                user.setRole(role);
                userRepository.save(user);
            }
            return role.toString();
        }
        return null;
    }

    @Override
    public boolean authenticateUser(String username, String password) {
        Optional<User> userOpt = userRepository.findByUsername(username);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            System.out.println("Found user: " + username + " with role: " + user.getRole());
            return user.getPassword().equals(password);
        }
        return false;
    }
}
