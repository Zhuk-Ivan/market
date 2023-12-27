package by.market.foodstuffs.controllers;

import by.market.foodstuffs.models.RoleEnum;
import by.market.foodstuffs.models.dtos.AuthDto;
import by.market.foodstuffs.models.dtos.LoginDto;
import by.market.foodstuffs.models.dtos.RegisterDto;
import by.market.foodstuffs.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthDto> login(@RequestBody LoginDto loginDto) {
        String token = authService.login(loginDto);

        AuthDto authDto = new AuthDto();
        authDto.setAccessToken(token);

        return ResponseEntity.ok(authDto);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        String response = authService.register(registerDto, RoleEnum.USER);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/register/pro-user")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> registerProUser(@RequestBody RegisterDto registerDto) {
        String response = authService.register(registerDto, RoleEnum.PRO_USER);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/register/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> registerAdmin(@RequestBody RegisterDto registerDto) {
        String response = authService.register(registerDto, RoleEnum.ADMIN);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
