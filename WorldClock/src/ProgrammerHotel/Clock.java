package ProgrammerHotel;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Clock {
    private ZonedDateTime time;
    private String name;

    Clock(String name){
        //暂停1秒以让时钟走时不准
        try{
            Thread.sleep(1000);
        }catch(Exception e){
            System.exit(0);
        }
        ZoneId id = ZoneId.of(name);
        time = ZonedDateTime.now().withZoneSameInstant(id);
        this.name = name;
    }

    public void print(){
        System.out.println("Time of " + name + " is:");
        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss |Z").format(time));
    }

    public String getName() {
        return name;
    }

    public ZonedDateTime getTime() {
        return time;
    }

    public void setTime(ZonedDateTime time) {
        this.time = time;
    }
}
