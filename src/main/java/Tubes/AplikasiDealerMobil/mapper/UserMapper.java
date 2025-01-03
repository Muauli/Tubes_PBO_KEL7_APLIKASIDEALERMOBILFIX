package Tubes.AplikasiDealerMobil.mapper;

import Tubes.AplikasiDealerMobil.model.User;
import Tubes.AplikasiDealerMobil.dto.UserDto;

public class UserMapper {
  public static UserDto mapToUserDto(User user) {
        return new UserDto(
            user.getId(),
            user.getUsername(),
            user.getPassword(),
            user.getRole()
        );
    }

    public static User mapToUser(UserDto userDto) {
        return new User (
                userDto.getId(),
                userDto.getUsername(),
                userDto.getPassword(),
                userDto.getRole()
        );

    }
}
