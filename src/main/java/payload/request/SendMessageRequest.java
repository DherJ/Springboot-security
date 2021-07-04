package payload.request;

import javax.validation.constraints.NotBlank;

public class SendMessageRequest {
    
    @NotBlank
    private String username;

    @NotBlank
    private String email;

    @NotBlank
    private String message;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
