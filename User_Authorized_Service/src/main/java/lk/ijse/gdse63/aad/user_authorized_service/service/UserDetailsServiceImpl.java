package lk.ijse.gdse63.aad.user_authorized_service.service;


import feign.Response;
import jakarta.transaction.Transactional;
import lk.ijse.gdse63.aad.user_authorized_service.dto.UserDetailsDTO;
import lk.ijse.gdse63.aad.user_authorized_service.interfaces.PackageDetailControllerInterface;
import lk.ijse.gdse63.aad.user_authorized_service.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService,UserDetailsServicee{
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private Response response;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PackageDetailControllerInterface packageDetailControllerInterface;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<lk.ijse.gdse63.aad.user_authorized_service.model.UserDetails> user = userRepo.findByUserName(username);
        return user.isPresent() ? user.get() : user.orElseThrow(() -> new UsernameNotFoundException("User not found!"));
    }


    @Override
    public Response save(UserDetailsDTO userDetailsDTO) {
        if (search(userDetailsDTO.getUserId()).getData() == null) {
            userRepo.save(modelMapper.map(userDetailsDTO, UserDetails.class));
            return createAndSendResponse(HttpStatus.OK.value(), "User Successfully saved!", null);
        }
        throw new RuntimeException("User already exists!");
    }

    @Override
    public Response update(UserDetailsDTO userDetailsDTO) {
        if (search(userDetailsDTO.getUserId()).getData() != null) {
            userRepo.save(modelMapper.map(userDetailsDTO, UserDetails.class));
            return createAndSendResponse(HttpStatus.OK.value(), "User Successfully updated!", null);
        }
        throw new RuntimeException("User does not exists!");
    }

    @Override
    public Response delete(String s) {
        if (search(s).getData() != null) {
            userRepo.deleteById(s);
            return createAndSendResponse(HttpStatus.OK.value(), "User Successfully deleted!", null);
        }
        throw new RuntimeException("User does not exists!");
    }

    @Override
    public Response search(String s) {
        Optional<UserDetails> userDetails = userRepo.findById(s);
        if (userDetails.isPresent()) {
            return createAndSendResponse(HttpStatus.FOUND.value(), "User Successfully retrieved!", modelMapper.map(userDetails.get(), UserDetails.class));
        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "User does not exists!", null);
    }

    @Override
    public UserDetailsDTO getUserDetails(String s) {
        Optional<UserDetails> userDetails = userRepo.findById(s);

        if (userDetails.isPresent()) {
            System.out.println(userDetails.get());
            return modelMapper.map(userDetails.get(), UserDetailsDTO.class);
        }
        throw new RuntimeException("userdetail cannot found!!!");
    }

    @Override
    public Response getAll() {
        List<UserDetails> users = userRepo.findAll();
        if (!users.isEmpty()) {
            ArrayList<UserDetailsDTO> userDetails_dtos = new ArrayList<>();
            users.forEach((userDetails) -> {
                userDetails_dtos.add(modelMapper.map(userDetails, UserDetailsDTO.class));
            });
            return createAndSendResponse(HttpStatus.FOUND.value(), "Users Successfully retrieved!", userDetails_dtos);
        }
        throw new RuntimeException("No Users found in the database!");
    }

    @Override
    public Response createAndSendResponse(int statusCode, String message, Object data) {
        response.setStatusCode(statusCode);
        response.setMessage(message);
        response.setData(data);
        return response;
    }
}
