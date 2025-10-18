package service;

import java.util.UUID;

public class AuthService {
    public String generateToken(String username) {
        return "mrp_" + UUID.randomUUID();
    }
}
