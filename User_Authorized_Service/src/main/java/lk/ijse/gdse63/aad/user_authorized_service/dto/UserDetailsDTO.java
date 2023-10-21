package lk.ijse.gdse63.aad.user_authorized_service.dto;

import jakarta.persistence.Enumerated;
import lk.ijse.gdse63.aad.user_authorized_service.model.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDetailsDTO  implements SuperDTO{
    private String userId;
    private String userName;
    private String pw;
    @Enumerated
    private Roles role;
    private String userNIC;
    private String userAddress;
    private String userDOB;
    private String userPhone;
    private String userEmail;
    private String gender;
    private String userNICimageLocation;
    private String userImageLocation;
    private boolean isAuthenticated;
}
