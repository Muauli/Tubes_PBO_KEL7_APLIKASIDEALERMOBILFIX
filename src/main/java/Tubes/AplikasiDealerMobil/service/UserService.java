package Tubes.AplikasiDealerMobil.service;

import Tubes.AplikasiDealerMobil.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);

    String getCurrentUserRole(String username);

    boolean authenticateUser(String username, String password);
}
