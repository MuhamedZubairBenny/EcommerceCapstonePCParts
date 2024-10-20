package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.User;
import za.ac.cput.dto.UserDto;
import za.ac.cput.factory.UserFactory;
import za.ac.cput.repository.UserRepository;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void saveUser(UserDto userDto){
        User existingUser = userRepository.findByEmail(userDto.getEmail());
        if (existingUser != null) {
            throw new IllegalArgumentException("Email is already registered.");
        }

        // Proceed with password encryption and user creation
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User user = UserFactory.buildUser(
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.getPassword()
        );

        if (user == null){
            throw new IllegalArgumentException("Invalid user data");
        }
        userRepository.save(user);
    }

    public User updateUser(UserDto userDto) {
        User existingUser = findByEmail(userDto.getEmail());
        if (existingUser != null) {
            // Use the builder pattern to create a new user object with updated details
            User updatedUser = UserFactory.buildUser(existingUser.getId()
                    , userDto.getFirstName()
                    , userDto.getLastName()
                    , userDto.getEmail()
                    , userDto.getPassword()
                    , userDto.getMobileNumber()
                    , userDto.getDateOfBirth()
                    , existingUser.getShipping()
                    , existingUser.getCart());

            return userRepository.save(updatedUser);
        }
        return null;
    }

    public User create(User user) {return userRepository.save(user);}

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null){
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(), Collections.emptyList());
    }

}
