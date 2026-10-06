interface SmartDevice {
    void turnOn();
    void turnOff();
}

class SmartFan implements SmartDevice {
    public void turnOn() {
        System.out.println("Smart Fan is turned ON.");
    }

    public void turnOff() {
        System.out.println("Smart Fan is turned OFF.");
    }
}

class SmartLight implements SmartDevice {
    public void turnOn() {
        System.out.println("Smart Light is turned ON.");
    }

    public void turnOff() {
        System.out.println("Smart Light is turned OFF.");
    }
}

class SmartAC implements SmartDevice {
    public void turnOn() {
        System.out.println("Smart AC is turned ON.");
    }

    public void turnOff() {
        System.out.println("Smart AC is turned OFF.");
    }
}

public class pro5 {
    public static void main(String[] args) {
        SmartDevice device;

        device = new SmartFan();
        device.turnOn();
        device.turnOff();

        device = new SmartLight();
        device.turnOn();
        device.turnOff();

        device = new SmartAC();
        device.turnOn();
        device.turnOff();
    }
}