package edu.miu.cs489.project.webshop.dto;

import edu.miu.cs489.project.webshop.enums.RoleEnum;

public record UserAuthResponse(
        String jwtToken,
        RoleEnum role
) {
}
