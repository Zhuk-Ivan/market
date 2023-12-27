package by.market.foodstuffs.services.impl;

import by.market.foodstuffs.exception.MarketException;
import by.market.foodstuffs.mappers.UserMapper;
import by.market.foodstuffs.models.RoleEnum;
import by.market.foodstuffs.models.dtos.LoginDto;
import by.market.foodstuffs.models.dtos.RegisterDto;
import by.market.foodstuffs.models.entity.Role;
import by.market.foodstuffs.models.entity.User;
import by.market.foodstuffs.repositories.RoleRepository;
import by.market.foodstuffs.repositories.UserRepository;
import by.market.foodstuffs.security.JwtTokenProvider;
import by.market.foodstuffs.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {

    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private JwtTokenProvider jwtTokenProvider;
    private UserMapper userMapper;

    public AuthServiceImpl(AuthenticationManager authenticationManager,
                           UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder,
                           JwtTokenProvider jwtTokenProvider,
                           UserMapper userMapper) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userMapper = userMapper;
    }

    @Override
    public String login(LoginDto loginDto) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getLogin(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);

        return token;
    }

    @Override
    public String register(RegisterDto registerDto, RoleEnum role) {
        if(userRepository.existsByUserName(registerDto.getUserName())){
            throw new MarketException(HttpStatus.BAD_REQUEST, "Пользователь с таким именем уже существует.");
        }

        if(userRepository.existsByEmail(registerDto.getEmail())){
            throw new MarketException(HttpStatus.BAD_REQUEST, "Пользователь с таким email-ом уже существует");
        }

        User user = userMapper.registerDtoToUser(registerDto);

        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByRoleName(role).get();
        roles.add(userRole);
        user.setRoles(roles);

        userRepository.save(user);
        return "Пользователь зарегистрирован.";
    }
}
