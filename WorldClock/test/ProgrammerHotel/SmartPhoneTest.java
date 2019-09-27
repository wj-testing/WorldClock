package ProgrammerHotel;

import org.junit.jupiter.api.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

class SmartPhoneTest {

    private SmartPhone phone;
    private static Clock[] clocks = new Clock[5];

    @BeforeAll
    public static void initClock(){
        clocks[0] = new Clock("PRC");
        clocks[1] = new Clock("Europe/London");
        clocks[2] = new Clock("Europe/Moscow");
        clocks[3] = new Clock("Australia/Sydney");
        clocks[4] = new Clock("America/New_York");
    }

    @BeforeEach
    void init(){
        phone = new SmartPhone();
    }

    @Test
    @DisplayName("手机时区为UTC+8")
    void phoneZoneidTest() {
        assertNotNull(phone);
        assertEquals(ZoneId.of("UTC+8"), phone.getId());
    }

    @Test
    @DisplayName("手机时间不准确，测试失败，输出错误信息")
    @Disabled
    void phoneWrongTimeTest(){
        phone.setCurrentTime();
        assertNotNull(phone);
        assertEquals(ZonedDateTime.now(), phone.getTime(), "时钟时间不准确");
    }

    @Test
    @DisplayName("校准手机时间")
    void phoneRightTimeTest(){
        ZonedDateTime now = ZonedDateTime.now();
        phone.setTime(now);
        assertNotNull(phone);
        assertEquals(now, phone.getTime());
    }

    @Test
    @DisplayName("手机调整北京时钟时间")
    void adjustTimeBeijing() {
        phone.setCurrentTime();
        phone.adjustTime(clocks);
        assertNotNull(clocks[0]);
        assertEquals("PRC", clocks[0].getName(), "北京时钟时区出错");
        assertEquals(phone.getTime().withZoneSameInstant(ZoneId.of(clocks[0].getName())), clocks[0].getTime(), "北京时钟时间调整失败");
    }

    @Test
    @DisplayName("手机调整伦敦时钟时间")
    void adjustTimeLondon() {
        phone.setCurrentTime();
        phone.adjustTime(clocks);
        assertNotNull(clocks[1]);
        assertEquals("Europe/London", clocks[1].getName(), "伦敦时钟时区出错");
        assertEquals(phone.getTime().withZoneSameInstant(ZoneId.of(clocks[1].getName())), clocks[1].getTime(), "伦敦时钟时间调整失败");
    }

    @Test
    @DisplayName("手机调整莫斯科时钟时间")
    void adjustTimeMoscow() {
        phone.setCurrentTime();
        phone.adjustTime(clocks);
        assertNotNull(clocks[2]);
        assertEquals("Europe/Moscow", clocks[2].getName(), "莫斯科时钟时区出错");
        assertEquals(phone.getTime().withZoneSameInstant(ZoneId.of(clocks[2].getName())), clocks[2].getTime(), "莫斯科时钟时间调整失败");
    }

    @Test
    @DisplayName("手机调整悉尼时钟时间")
    void adjustTimeSydney() {
        phone.setCurrentTime();
        phone.adjustTime(clocks);
        assertNotNull(clocks[3]);
        assertEquals("Australia/Sydney", clocks[3].getName(), "悉尼时钟时区出错");
        assertEquals(phone.getTime().withZoneSameInstant(ZoneId.of(clocks[3].getName())), clocks[3].getTime(), "悉尼时钟时间调整失败");
    }

    @Test
    @DisplayName("手机调整纽约时钟时间")
    void adjustTimeNewYork() {
        phone.setCurrentTime();
        phone.adjustTime(clocks);
        assertNotNull(clocks[4]);
        assertEquals("America/New_York", clocks[4].getName(), "纽约时钟时区出错");
        assertEquals(phone.getTime().withZoneSameInstant(ZoneId.of(clocks[4].getName())), clocks[4].getTime(), "纽约时钟时间调整失败");
    }
}