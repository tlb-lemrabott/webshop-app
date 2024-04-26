package edu.miu.cs489.project.webshop.dto;

public record UserAuthRequest(
        String username,
        String password
) {
}
