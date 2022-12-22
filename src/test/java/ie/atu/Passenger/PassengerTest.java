package ie.atu.Passenger;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassengerTest {

    private Passenger myPassenger;
    @BeforeEach
    void setUp() {
        myPassenger = new Passenger("Mr", "John Doe", "1234334567891L", 1233456789, 42);
    }

    @Test
    void testTitlePass(){
        assertEquals("Mr", myPassenger.getTitle());
        myPassenger.setTitle("Ms");
        assertEquals("Ms", myPassenger.getTitle());
        myPassenger.setTitle("Mrs");
        assertEquals("Mrs", myPassenger.getTitle());

    }

    @Test
    void testNamePass(){
        assertEquals("John Doe", myPassenger.getName());
    }

    @Test
    void testIdPass(){
        assertEquals("1234334567891L", myPassenger.getId());
    }

    @Test
    void testPhonePass(){
        assertEquals(1233456789, myPassenger.getPhone());
    }

    @Test
    void testAgePass(){
        assertEquals(42, myPassenger.getAge());
    }

    @Test
    void testTitleFail(){
        Exception exMessage = assertThrows(IllegalArgumentException.class, () -> {myPassenger.setTitle("Mister");});
        assertEquals("This is not a valid name. Use Mr, Ms or Mrs.", exMessage.getMessage());
    }

    @Test
    void testNameFail(){
        Exception exMessage = assertThrows(IllegalArgumentException.class, () -> {myPassenger.setName("ks");});
        assertEquals("This is not a valid name.", exMessage.getMessage());
    }

    @Test
    void testIdFail(){
        Exception exMessage = assertThrows(IllegalArgumentException.class, () -> {myPassenger.setId("123");});
        assertEquals("This is not a valid ID.", exMessage.getMessage());
    }

    @Test
    void testPhoneFail(){
        Exception exMessage = assertThrows(IllegalArgumentException.class, () -> {myPassenger.setPhone(123);});
        assertEquals("This is not a valid phone number.", exMessage.getMessage());
    }

    @Test
    void testAgeFail(){
        Exception exMessage = assertThrows(IllegalArgumentException.class, () -> {myPassenger.setAge(5);});
        assertEquals("You must be over 16.", exMessage.getMessage());
    }

}
