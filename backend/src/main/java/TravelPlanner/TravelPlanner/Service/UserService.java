package TravelPlanner.TravelPlanner.Service;

import TravelPlanner.TravelPlanner.Entity.User;
import TravelPlanner.TravelPlanner.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    UsersRepository usersRepository;

    @Autowired
    public UserService(UsersRepository usersRepository) {
        super();
        this.usersRepository = usersRepository;
    }

    //constructor
    public UserService() {

    }

    //easier for controller to create user
    public User createUser(User user) {
        user = usersRepository.save(user);
        return user;
    }

    //for the login
    public User loginUser(User user) {
        return usersRepository.findByUserEmailAndUserPassword(user.getUserEmail(), user.getUserPassword());
    }

    //find a user
    public Optional<User> findOneUser(Integer userId) {
        Optional<User> user = usersRepository.findById(userId);
        return user;
    }

    public List<User>  findAll() {
        return usersRepository.findAll();
    }
}
