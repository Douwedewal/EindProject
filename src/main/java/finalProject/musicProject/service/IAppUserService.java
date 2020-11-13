package finalProject.musicProject.service;

import finalProject.musicProject.domain.AppUser;

public interface IAppUserService {

    AppUser getUserById(long id);
    AppUser addUser(AppUser newUser);
    String deleteUser(long id);
}
