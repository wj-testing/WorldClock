package ProgrammerHotel;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class SmartPhone {
    private ZonedDateTime time;
    private ZoneId id;

    SmartPhone(){
        /** 智能手机时间设置为北京时间 */
        id = ZoneId.of("UTC+8");
    }

    public void setCurrentTime(){
        time = ZonedDateTime.now();
    }

    public void setTime(ZonedDateTime time) {
        this.time = time;
    }

    public ZonedDateTime getTime() {
        return time;
    }

    /** 自动调整5个城市的时钟时间 */
    public void adjustTime(Clock[] clocks){
        for(int i = 0; i < 5; i++){
            String name = clocks[i].getName();
            ZoneId id = ZoneId.of(name);
            ZonedDateTime ClockTime = time.withZoneSameInstant(id);
            clocks[i].setTime(ClockTime);
        }
    }

    public ZoneId getId() {
        return id;
    }

    /** 显示手机时间 */
    public void print(){
        setCurrentTime();
        System.out.println("Time of smartphone is:");
        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss |Z").format(time));
    }

}
