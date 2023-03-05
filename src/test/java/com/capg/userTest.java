package com.capg; import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when; import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner; import com.capg.entity.User;
import com.capg.exception.UserNotFoundException;
import com.capg.repository.UserRepository;
import com.capg.service.UserServiceImpl; 
@RunWith(MockitoJUnitRunner.class)        
public class UserMockitoTest {
    @Mock
    private UserRepository userRepository;     @InjectMocks
    private UserServiceImpl userService;     @Test
    public void testAddUserSuccess() {
        User user = new User();
        user.setEmailId("test@test.com");
        user.setPassword("password");
        when(userRepository.saveAndFlush(user)).thenReturn(user);
        assertEquals("User added successfully", userService.addUser(user));
        verify(userRepository, times(1)).saveAndFlush(user);
            }
    @Test
    public void testLoginUserSuccess() throws UserNotFoundException {
        User user = new User();
        user.setEmailId("test@test.com");
        user.setPassword("password");
        List<User> userList = new ArrayList<User>();
        userList.add(user);
        when(userRepository.findAll()).thenReturn(userList);
        assertEquals("Logged in successfully", userService.loginUser("test@test.com", "password"));
    }
    @Test
    public void testFindByUserEmailId() throws UserNotFoundException {
        String emailId = "test@example.com";
        User user = new User();
        user.setEmailId("test@example.com");
        user.setPassword("password123");
        user.setSecurityAnswer("test answer");
        when(userRepository.findAll()).thenReturn(Collections.singletonList(user));
        User result = userService.findByUserEmailId(emailId);
        assertEquals(user, result);
        verify(userRepository, times(1)).findAll();
    }     
    @Test
    public void testIsUser() {
        String emailId = "test@example.com";
        User user = new User();
        user.setEmailId("test@example.com");
        user.setPassword("password123");
        user.setSecurityAnswer("test answer");
        user.setRole("Admin"); 
        when(userRepository.findAll()).thenReturn(Collections.singletonList(user));
        String result = userService.isUser(emailId);
        assertEquals(result, "It is a user emailId");
        verify(userRepository, times(1)).findAll();
    }
    @Test
    public void testValidateSecurityAnswer() {
        String emailId = "test@example.com";
        String securityAnswer = "test answer";
        User user = new User();
        user.setEmailId("test@example.com");
        user.setPassword("password123");
        user.setSecurityAnswer("test answer");
        user.setRole("user");
        when(userRepository.findAll()).thenReturn(Collections.singletonList(user));
        boolean result = userService.validateSecurityAnswer(emailId, securityAnswer);
        assertTrue(result);
        verify(userRepository, times(1)).findAll();
    }
    @Test
    public void testValidateSecurityAnswerIncorrect() {
        String emailId = "test@example.com";
        String securityAnswer = "wrong answer";
        User user = new User();
        user.setEmailId("test@example.com");
        user.setPassword("password123");
        user.setSecurityAnswer("test answer");
        user.setRole("user");
        when(userRepository.findAll()).thenReturn(Collections.singletonList(user));
        boolean result = userService.validateSecurityAnswer(emailId, securityAnswer);
        assertFalse(result);
        verify(userRepository, times(1)).findAll();
    }
    @Test
    public void testResetPassword() throws UserNotFoundException {
        String emailId = "test@example.com";
        String password = "newPassword123";
        User user = new User();
        user.setEmailId(emailId);
        user.setPassword("oldPassword123");
        when(userRepository.findAll()).thenReturn(Collections.singletonList(user));
        String result = userService.resetPassword(emailId, password);
        assertEquals("updated password", result);
        assertEquals(password, user.getPassword());
        verify(userRepository, times(1)).saveAndFlush(user);
    }     @Test
    public void testDeleteUserByEmailId() throws UserNotFoundException {
        String emailId = "test@example.com";
        String password = "password123";
        User user = new User();
        user.setuId(1);
        user.setEmailId(emailId);
        user.setPassword(password);
        when(userRepository.findAll()).thenReturn(Collections.singletonList(user));
        String result = userService.deleteUserByEmailId(emailId, password);
        assertEquals("User deleted successfully", result);
        verify(userRepository, times(1)).deleteById(user.getuId());
    }     
}
