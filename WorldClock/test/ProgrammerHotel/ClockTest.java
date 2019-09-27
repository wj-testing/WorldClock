package ProgrammerHotel;

import org.junit.jupiter.api.*;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ClockTest {

    private ZonedDateTime time;

    @BeforeAll
    public static void beforeClockTest(){
        System.out.println("Enter the tests for World Clocks.");
    }

    @BeforeEach
    void init(){
        ZonedDateTime time = ZonedDateTime.now();
    }

    @Test
    @DisplayName("设置时钟为北京时间")
    void setTimeBeijing() {
        Clock clock = new Clock("PRC");
        clock.setTime(time);
        assertNotNull(clock);
        assertEquals("PRC", clock.getName());
        assertEquals(time, clock.getTime());
    }

    @Test
    @DisplayName("设置时钟为伦敦时间")
    void setTimeLondon() {
        Clock clock = new Clock("Europe/London");
        clock.setTime(time);
        assertNotNull(clock);
        assertEquals("Europe/London", clock.getName());
        assertEquals(time, clock.getTime());
    }

    @Test
    @DisplayName("设置时钟为莫斯科时间")
    void setTimeMoscow() {
        Clock clock = new Clock("Europe/Moscow");
        clock.setTime(time);
        assertNotNull(clock);
        assertEquals("Europe/Moscow", clock.getName());
        assertEquals(time, clock.getTime());
    }

    @Test
    @DisplayName("设置时钟为悉尼时间")
    void setTimeSydney() {
        Clock clock = new Clock("Australia/Sydney");
        clock.setTime(time);
        assertNotNull(clock);
        assertEquals("Australia/Sydney", clock.getName());
        assertEquals(time, clock.getTime());
    }

    @Test
    @DisplayName("设置时钟为纽约时间")
    void setTimeNewYork() {
        Clock clock = new Clock("America/New_York");
        clock.setTime(time);
        assertNotNull(clock);
        assertEquals("America/New_York", clock.getName());
        assertEquals(time, clock.getTime());
    }

    @AfterAll
    public static void afterClockTest(){
        System.out.println("Leaving the tests for World Clocks.");
    }
}