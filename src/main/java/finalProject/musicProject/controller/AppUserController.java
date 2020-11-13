package finalProject.musicProject.controller;

import finalProject.musicProject.domain.AppUser;
import finalProject.musicProject.service.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class AppUserController {

    @Autowired
    private IAppUserService appUserService;

    @GetMapping(value = "/api/user/{id}")
    public AppUser getUserById(@PathVariable long id) {
        return appUserService.getUserById(id);
    }

    @PostMapping(value = "/api/user")
    public AppUser addUser(@RequestBody AppUser newUser) {
        return appUserService.addUser(newUser);
    }

    @DeleteMapping(value = "/api/user/{id}")
    public String deleteUser(@PathVariable long id) {

        return appUserService.deleteUser(id);
    }
}
