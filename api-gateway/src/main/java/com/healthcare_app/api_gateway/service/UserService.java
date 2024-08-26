package com.healthcare_app.api_gateway.service;

import com.healthcare_app.api_gateway.dto.CredentialsDto;
import com.healthcare_app.api_gateway.dto.SignUpDto;
import com.healthcare_app.api_gateway.dto.UserDto;
import com.healthcare_app.api_gateway.entities.Patient;
import com.healthcare_app.api_gateway.entities.User;
import com.healthcare_app.api_gateway.enums.Role;
import com.healthcare_app.api_gateway.exceptions.AppException;
import com.healthcare_app.api_gateway.mappers.UserMapper;
import com.healthcare_app.api_gateway.repository.PatientRepository;
import com.healthcare_app.api_gateway.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.nio.CharBuffer;
import java.util.Optional;

/**
 * Service class for handling user-related operations.
 * Provides methods for user authentication and registration.
 *
 * Author: B.T.M.A.S.D.B Rathnayaka
 * Date: 2024/07/29
 */
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PatientRepository patientRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Value("${patient-service.base.url}")
    private String patientServiceBaseUrl;

    /**
     * Finds a user by their login.
     *
     * @param login The login identifier of the user.
     * @return A UserDto object containing user details.
     * @throws AppException if the user is not found.
     */
    public UserDto findByLogin(String login) {
        User user = userRepository.findByLogin(login)
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        return userMapper.toUserDto(user);
    }

    /**
     * Authenticates a user based on provided credentials.
     *
     * @param credentialsDto The credentials provided by the user.
     * @return A UserDto object containing user details.
     * @throws AppException if the login or password is invalid.
     */
    public UserDto login(CredentialsDto credentialsDto) {
        User user = userRepository.findByLogin(credentialsDto.getLogin())
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.getPassword()), user.getPassword())) {
            return userMapper.toUserDto(user);
        }
        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }

    /**
     * Registers a new user.
     *
     * @param userDto The data transfer object containing user registration details.
     * @return A UserDto object containing registered user details.
     * @throws AppException if the login already exists.
     */
    public UserDto register(SignUpDto userDto) {
        Optional<User> optionalUser = userRepository.findByLogin(userDto.getLogin());

        if (optionalUser.isPresent()) {
            throw new AppException("Login already exists", HttpStatus.BAD_REQUEST);
        }

        User user = userMapper.signUpToUser(userDto);
        user.setRole(Role.PATIENT);
        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(userDto.getPassword())));

        User savedUser = userRepository.save(user);

        // Create patient directly in the database
        Patient patient = new Patient();
        patient.setName(userDto.getFirstName() + " " + userDto.getLastName());
        patient.setAddress("example-address"); // Set appropriate address if available
        patient.setPhoneNumber("0763366802"); // Set appropriate phone number if available
        patient.setEmail("example@gmail.com"); // Use the email from userDto

        patientRepository.save(patient);

        return userMapper.toUserDto(savedUser);
    }

}
