package lk.ijse.gdse63.aad.user_authorized_service.dto;

import lk.ijse.gdse63.aad.user_authorized_service.model.
import lombok.*;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class UserDetailsDTO  implements Serializable ,SuperDTO{
    private String userRole;
    private String userId;
    private String name;
    private String userName;
    private String userPassword;
    private String userNIC;
    private String userNICImageLocation;
    private int userAge;
    private GENDER gender;
    private String userEmail;
    private String userPhone;
    private String userAddress;
    private String remarks;
    private String userImageLocation;
    private boolean isAuthenticated;
}
