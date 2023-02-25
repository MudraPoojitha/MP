//package com.capg;
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.*;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import com.capg.controller.UserController;
//import com.capg.entity.User;
//import com.capg.service.UserService;
//
//@RunWith(MockitoJUnitRunner.class)
//public class userTest {
//
//    @Mock
//    private UserService userService;
//
//    @InjectMocks
//    private UserController userController;
//
//    @Test
//    public void testAddUser() {
//        // Create a mock User object
//        User user = new User();
//        //user.setName("John Doe");
//
//        // Set up the mock UserService to return "User added successfully"
//        when(userService.addUser(user)).thenReturn("User added successfully");
//
//        // Call the userService() method and verify that it returns the expected result
//        String result = userController.userService(user);
//        assertEquals("User added successfully", result);
//
//        // Verify that the UserService's addUser() method was called with the expected User object
//        verify(userService).addUser(user);
//    }
//}
