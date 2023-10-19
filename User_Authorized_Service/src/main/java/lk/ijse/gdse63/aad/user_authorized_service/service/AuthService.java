package lk.ijse.gdse63.aad.user_authorized_service.service;


import feign.Response;
import lk.ijse.gdse63.aad.user_authorized_service.config.JWTService;
import lk.ijse.gdse63.aad.user_authorized_service.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    @Autowired
    private Response response;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JWTService jwtService;

    public Response register(UserDetails userDetails) {
        String password = passwordEncoder.encode(userDetails.getPassword());
        userDetails.setPw(password);
        userRepo.save(userDetails);
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("User successfully registered and JWT Successfully generated!");
        response.setData(jwtService.generateToken(userDetails));
        return response;
    }
}
