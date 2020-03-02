package TravelPlanner.TravelPlanner.Service;

import TravelPlanner.TravelPlanner.Entity.User;
import TravelPlanner.TravelPlanner.Entity.Role;
import TravelPlanner.TravelPlanner.Repository.RoleRepository;
import TravelPlanner.TravelPlanner.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;


@Service
public class UserService {

    private UsersRepository usersRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(UsersRepository userRepository,
                       RoleRepository roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usersRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User findUserByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

    public User findUserByUserName(String userName) {
        return usersRepository.findByUserName(userName);
    }

    public User saveUser(User user) {
        user.setUserPassword(bCryptPasswordEncoder.encode(user.getUserPassword()));
        user.setActive(true);
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return usersRepository.save(user);
    }

}
//
//@Service
//public class UserService {
//    UsersRepository usersRepository;
//
//    @Autowired
//    public UserService(UsersRepository usersRepository) {
//        super();
//        this.usersRepository = usersRepository;
//    }
//
//    //constructor
//    public UserService() {
//
//    }
//
//    //easier for controller to create user
//    public User createUser(User user) {
//        user = usersRepository.save(user);
//        return user;
//    }
//
//    //for the login
//    public User loginUser(User user) {
//        return usersRepository.findByUserEmailAndUserPassword(user.getUserEmail(), user.getUserPassword());
//    }
//
//    //find a user
//    public Optional<User> findOneUser(Integer userId) {
//        Optional<User> user = usersRepository.findById(userId);
//        return user;
//    }
//
//    public List<User>  findAll() {
//        return usersRepository.findAll();
//    }
//}
