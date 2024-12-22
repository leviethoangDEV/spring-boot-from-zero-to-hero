package vn.hoangdev.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import vn.hoangdev.model.request.UserRequestDto;
import vn.hoangdev.model.response.ResponseSuccess;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/")
    public ResponseSuccess addUser(@Valid @RequestBody UserRequestDto userRequestDto) {
        return new ResponseSuccess(HttpStatus.CREATED, "User added successfully", 1);
    }

    @PutMapping("/{userId}")
    public ResponseSuccess updateUser(@PathVariable Long userId, @RequestBody UserRequestDto userRequestDto) {
        return new ResponseSuccess(HttpStatus.ACCEPTED, "User updated successfully");
    }

    @PatchMapping("/{userId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String patchUser(@PathVariable Long userId, @RequestParam(required = false) boolean status) {
        return "User status changed successfully";
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteUser(@PathVariable Long userId) {
        return "User deleted successfully";
    }

    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public UserRequestDto getUserId(@PathVariable Long userId) {
        return new UserRequestDto("Hoang", "Dev", "Email", "Phone");
    }

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
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
