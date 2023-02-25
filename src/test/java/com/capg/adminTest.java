//package com.capg;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import com.capg.entity.Admin;
//import com.capg.repository.AdminRepository;
//import com.capg.service.AdminServiceImpl;
//
//import static org.junit.Assert.assertSame;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
////@ExtendWith(MockitoExtension.class)
//@RunWith(MockitoJUnitRunner.class)
//public class adminTest {
//
//    @Mock
//    private AdminRepository adminRepository;
//
//    @InjectMocks
//    private AdminServiceImpl adminService;
//
//    @Test
//    public void addAdminTest() {
//        // Create a mock admin object
//        String admin = new Admin();
//        admin.setUsername("admin1");
//        admin.setPassword("password123");
//
//        // Stub the adminRepository.saveAndFlush() method to return the admin object
//        when(adminRepository.saveAndFlush(admin)).thenReturn(admin);
//
//        // Call the addAdmin method in the adminService class
//        Admin addedAdmin = adminServiceImpl.addAdmin(admin);
//
//        // Verify that the adminRepository.saveAndFlush() method was called with the admin object
//        verify(adminRepository).saveAndFlush(admin);
//
//        // Verify that the returned admin object is the same as the mock admin object
//        assertSame(admin, addedAdmin);
//    }
//}
//
