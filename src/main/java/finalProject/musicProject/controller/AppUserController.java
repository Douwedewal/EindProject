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
    public AppUser getUserById(@PathVariable Long id) {
        return appUserService.getUserById(id);
    }

    @PostMapping(value = "/api/user")
    public AppUser addUser(@RequestBody AppUser newUser) {
        return appUserService.addUser(newUser);
    }

    @DeleteMapping(value = "/api/user/{id}")
    public String deleteUser(@PathVariable long id) {

        String antwoord = appUserService.deleteUser(id);

        return antwoord;
    }

    @PutMapping(value = "/api/user/{id}")
    public AppUser updateUserById(@PathVariable long id, @RequestBody AppUser updatedUser) {
        /*return appUserService.getUserById(id).map(
                user -> {
                    user.setName(updatedUser.getName());
                    return appUserRepository.save(user);
                })
                // Kan de user niet vinden in database
                .orElseGet(() -> {
                    updatedUser.setUser_id(id);
                    return appUserRepository.save(updatedUser);
                });

         */
        return null;
    }
}
