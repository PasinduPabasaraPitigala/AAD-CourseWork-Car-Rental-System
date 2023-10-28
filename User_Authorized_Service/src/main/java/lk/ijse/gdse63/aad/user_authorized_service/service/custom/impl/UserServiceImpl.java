package lk.ijse.gdse63.aad.user_authorized_service.service.custom.impl;

import lk.ijse.gdse63.aad.user_authorized_service.config.JWTService;
import lk.ijse.gdse63.aad.user_authorized_service.dto.UserDetailsDTO;
import lk.ijse.gdse63.aad.user_authorized_service.repo.UserRepo;
import lk.ijse.gdse63.aad.user_authorized_service.response.Response;
import lk.ijse.gdse63.aad.user_authorized_service.service.custom.UserDetailsServicee;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserDetailsService, UserDetailsServicee {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private Response response;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JWTService jwtService;
    @Override
    public ResponseEntity<Response> add(UserDetailsDTO userDetailsDTO) {
        if (search(userDetailsDTO.getUserId()).getBody().getData() == null) {
            userDetailsDTO.setPw(passwordEncoder.encode(userDetailsDTO.getPw()));

            userRepo.save(mapper.map(userDetailsDTO, UserDetails.class));
            return createAndSendResponse(HttpStatus.CREATED.value(), "User Successfully saved and JWT successfully generated!", jwtService.generateToken(mapper.map(userDetailsDTO, UserDetails.class)));

        }

        return createAndSendResponse(HttpStatus.CONFLICT.value(), "User already exists!", null);
    }

    @Override
    public ResponseEntity<Response> update(UserDetailsDTO userDetailsDTO) {
        if (search(userDetailsDTO.getUserId()).getBody().getData() == null) {
            return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "User not found!", null);

        }
        userRepo.save(mapper.map(userDetailsDTO, UserDetails.class));
        return createAndSendResponse(HttpStatus.OK.value(), "User successfully updated!", null);

    }

    @Override
    public ResponseEntity<Response> delete(String s) {
        if (search(s).getBody().getData() == null) {
            return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "User not found!", null);

        }
        userRepo.deleteById(s);
        return createAndSendResponse(HttpStatus.OK.value(), "User successfully deleted!", null);
    }

    @Override
    public ResponseEntity<Response> search(String s) {
        Optional<UserDetails> user = userRepo.findById(s);
        if (user.isPresent()) {
            return createAndSendResponse(HttpStatus.OK.value(), "User successfully retrieved!", mapper.map(user.get(), UserDetailsDTO.class));

        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "User not found!", null);
    }

    @Override
    public ResponseEntity<Response> getAll(UserDetailsDTO userDetailsDTO) {
        List<UserDetails> users = userRepo.findAll();
        if (users.isEmpty()) {
            return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "Users not found!", null);

        }
        List<UserDetailsDTO> usersList = new ArrayList<>();
        users.forEach((user) -> {
            usersList.add(mapper.map(user, UserDetailsDTO.class));

        });
        return createAndSendResponse(HttpStatus.OK.value(), "Users successfully retrieved!", usersList);
    }

    @Override
    public ResponseEntity<Response> createAndSendResponse(int statusCode, String message, Object data) {
        response.setMessage(message);
        response.setData(data);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(statusCode));
    }

    @Override
    public String handleUploads(MultipartFile imageFile) {
        // Getting the file name.
        String fileName = imageFile.getOriginalFilename();

        // Specify the destination directory.In this case it is downloads.
        String destinationDirectory = System.getProperty("user.home") + "/Downloads";
        // Create the directory if it doesn't exist.
        File directory = new File(destinationDirectory);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Create the file path.
        String filePath = destinationDirectory + "/" + fileName;

        // Save the image file.
        try {
            imageFile.transferTo(Paths.get(filePath));
            return filePath;
        } catch (IOException e) {
            throw new RuntimeException("An error occurred while saving the image :" + e.getLocalizedMessage());
        }
    }

    @Override
    public ResponseEntity<Response> getUserByUserName(String username, String password) {
        Optional<UserDetails> user = userRepo.findByUserName(username);
        if(user.isPresent()){
            UserDetailsDTO userDTO = mapper.map(user.get(), UserDetailsDTO.class);
            userDTO.setAuthenticated(passwordValidator(password,user.get().getPw()));
            return createAndSendResponse(HttpStatus.OK.value(),"User successfully retrieved!",userDTO);

        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(),"User not found!",null);
    }

    @Override
    public Boolean passwordValidator(String password, String hashedPassword) {
        return passwordEncoder.matches(password, hashedPassword);
    }

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserDetails> user = userRepo.findByUserName(username);
        return user.isPresent() ? user.get() : user.orElseThrow(() -> new UsernameNotFoundException("User not found!"));
    }
}
