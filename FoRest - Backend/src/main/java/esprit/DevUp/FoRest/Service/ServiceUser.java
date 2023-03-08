package esprit.DevUp.FoRest.Service;

import esprit.DevUp.FoRest.Entity.Event.Event;
import esprit.DevUp.FoRest.Entity.User;
import esprit.DevUp.FoRest.Repository.GestionEvenement.EventRepository;
import esprit.DevUp.FoRest.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ServiceUser implements ISeviceUser {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(User u) {
        return userRepository.save(u);
    }

    @Override
    public User updateUser(User u) {
        return userRepository.save(u);
    }

    @Override
    public User retrieveUser(Integer idUser) {
        return userRepository.findById(idUser).get();
    }

    @Override
    public void removeUser(Integer idUser) {
        userRepository.deleteById(idUser);
    }


}
