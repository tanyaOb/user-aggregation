package com.example.useraggregation.controller;

import com.example.useraggregation.dto.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.useraggregation.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "Get all users from different databases", description = "Fetching users from the configured databases.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully fetched users"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

}
