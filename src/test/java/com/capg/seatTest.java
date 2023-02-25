//package com.capg;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import com.capg.entity.Seat;
//import com.capg.exception.SeatNotFoundException;
//import com.capg.repository.SeatRepository;
//import com.capg.service.SeatServiceImpl;
//
//import static org.mockito.Mockito.*;
//
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//import static org.junit.Assert.*;
//
//@RunWith(MockitoJUnitRunner.class)
//public class seatTest {
//
//  @Mock
//  private SeatRepository seatRepository;
//
//  @InjectMocks
//  private SeatServiceImpl seatServiceImpl;
//
//  @Test
//  public void testAddSeats() {
//    Seat seat = new Seat();
//   
//    String result = seatServiceImpl.addSeats(seat);
//    assertEquals("Seat added successfully", result);
//
//    verify(seatRepository, times(1)).save(seat);
//  }
//  
//  @Test
//  public void testListAllSeats() throws SeatNotFoundException {
//    Seat seat1 = new Seat();
//
//    List<Seat> seats = Arrays.asList(seat1, seat1);
//
//    when(seatRepository.findAll()).thenReturn(seats);
//
//    List<Seat> result = seatServiceImpl.listAllSeats();
//    assertEquals(2, result.size());
//
//    verify(seatRepository, times(1)).findAll();
//  }
//  
//  @Test
//  public void testGetSeatsBySeatNumber() throws SeatNotFoundException {
//      // Mock data
//      Seat mockSeat = new Seat();
//      mockSeat.setSeatNumber("A1");
//     
//      when(seatRepository.findAll()).thenReturn(Collections.singletonList(mockSeat));
//
//      // Call the method
//      Seat result = seatServiceImpl.getSeatsBySeatNumber("A1");
//
//      // Verify the result
//      assertEquals(mockSeat, result);
//  }
//
// 
//  @Test
//  public void testFindBySeatFloor() throws SeatNotFoundException {
//      seatServiceImpl = new SeatServiceImpl();
//
//      // Create mock data
//      Seat expectedSeat = new Seat();
//      expectedSeat.setSeatFloor(3);
//
//   
//  }
//  
// 
//
//}
//
//
//
//
//
//
//
//
//
//
////  @Test
////  public void testDeleteSeats() throws SeatNotFoundException {
////      // Arrange
////      Seat seat = new Seat();
////      seat.setSeatNumber("A1");
////      when(seatRepository.findAll()).thenReturn(Arrays.asList(seat));
////
////      // Act
////      //SeatService.deleteSeats("A1");
////
////      // Assert
////      verify(seatRepository).delete(seat);
//  //}
//
//
//
//
//
