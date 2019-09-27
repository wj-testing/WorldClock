package ProgrammerHotel;

public class Lobby {

    static Clock[] clocks = new Clock[5];
    public static void main(String[] args){
        clocks[0] = new Clock("PRC");
        clocks[1] = new Clock("Europe/London");
        clocks[2] = new Clock("Europe/Moscow");
        clocks[3] = new Clock("Australia/Sydney");
        clocks[4] = new Clock("America/New_York");
        SmartPhone phone = new SmartPhone();

        for(int i = 0; i < 5; i++){
            clocks[i].print();;
        }

        phone.setCurrentTime();
        phone.print();
        phone.adjustTime(clocks);

        System.out.println("\nAfter adjustment, the world clocks' time are:");
        for(int i = 0; i < 5; i++){
            clocks[i].print();;
        }
    }
}
