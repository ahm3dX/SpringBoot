package TN.CompanyManagement.Entity;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {
    private String userName;
    private String Password;
}
