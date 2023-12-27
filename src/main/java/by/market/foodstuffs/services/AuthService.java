package by.market.foodstuffs.services;

import by.market.foodstuffs.models.RoleEnum;
import by.market.foodstuffs.models.dtos.LoginDto;
import by.market.foodstuffs.models.dtos.RegisterDto;

public interface AuthService {

    String login(LoginDto loginDto);

    String register(RegisterDto registerDto, RoleEnum role);

}
