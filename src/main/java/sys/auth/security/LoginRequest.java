package sys.auth.security;

import javax.validation.constraints.NotBlank;

public class LoginRequest {

    @NotBlank(message = "UserName can not be blank !")
    private String username;

    @NotBlank(message = "Password can not be blank !")
    private String password;

    public String getUserName() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}