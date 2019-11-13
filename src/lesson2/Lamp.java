package lesson2;

public class Lamp {
    private int power;
    private boolean state;


    Lamp() {
        power = 0;
        state = false;
    }

    void turnOn() {
        power = 100;
        state = true;
    }

    void turnOff() {
        power = 0;
        state = false;
    }

    @Override
    public String toString() {
        String status = state ? "on" : "off";
        return "Lamp is turn  " + status + " Power is " + power;
    }
}
