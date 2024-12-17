package vn.hoangdev.controller;

import org.springframework.web.bind.annotation.*;
import vn.hoangdev.model.request.UserRequestDto;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping(value = "/", headers = "apiKey=v1.0")
    public String addUser(@RequestBody UserRequestDto userRequestDto) {
        return "User added successfully";
    }

    @PutMapping("/{userId}")
    public String updateUser(@PathVariable Long userId, @RequestBody UserRequestDto userRequestDto) {
        return "User updated successfully";
    }

    @PatchMapping("/{userId}")
    public String patchUser(@PathVariable Long userId, @RequestParam(required = false) boolean status) {
        return "User status changed successfully";
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable Long userId) {
        return "User deleted successfully";
    }

    @GetMapping("/{userId}")
    public UserRequestDto getUserId(@PathVariable Long userId) {
        return new UserRequestDto("Hoang", "Dev", "Email", "Phone");
    }

    @GetMapping("/list")
    public List<UserRequestDto> getUserList(
            @RequestParam(required = false) String email,
            @RequestParam(defaultValue = "0") Long page,
            @RequestParam(defaultValue = "10") Long limit
    ) {
        return List.of(
                new UserRequestDto("Hoang", "Dev", "Email", "Phone"),
                new UserRequestDto("Hoang", "Dev", "Email", "Phone")
                );
    }
}
