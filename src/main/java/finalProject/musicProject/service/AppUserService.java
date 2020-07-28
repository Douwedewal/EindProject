package finalProject.musicProject.service;

import finalProject.musicProject.domain.AppUser;
import finalProject.musicProject.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AppUserService implements IAppUserService {

    private final AppUserRepository appUserRepository;

    @Autowired
    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public AppUser getUserById(long id) {
        if(appUserRepository.existsById(id)) {
            return appUserRepository.getOne(id);
        }

        return null;
    }

    public AppUser addUser(AppUser newUser) {
        return appUserRepository.save(newUser);
    }

    @Override
    public String deleteUser(long id) {
        if(appUserRepository.existsById(id)) {
            appUserRepository.deleteById(id);
            return "User met " + id + " verwijderd.";
        }
        return "User komt niet voor in de database";
    }

    @Override
    public AppUser updateUserById(long id, AppUser updatedUser) {
        return null;
    }
}
