// SMART HOME
//
// 📝 Prompt:
//      You’re coding a smart home system. Devices like Lights,
//      Fans, and DoorLocks must:
//              👉 Be turned on
//              👉 Be turned off
//	            👉 Have a status
//
//      🎯 Goal:
//             Create a SmartDevice interface and write a
//             simple control system for it.


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SmartDevice[] smartDevices = new SmartDevice[] {
                new DoorLocks(),
                new RingCamera(),
                new FloodLights()
        };

        while (true) {
            System.out.println("SmartHome App Menu");
            System.out.println("------------------");
            System.out.println("1. Turn On All Devices");
            System.out.println("2. Turn Off All Devices");
            System.out.println("3. Turn On Specific Item");
            System.out.println("4. Turn Off Specific Item");
            System.out.println("5. Get Status of Devices");
            System.out.println("Or anything other number to exit.");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    // Turn On All Devices
                    for (SmartDevice device : smartDevices) {
                        device.turnOn();
                    }
                    System.out.println("All items are turned on\n\n");
                    continue;
                case 2:
                    // Turn Off All Devices
                    for (SmartDevice device : smartDevices) {
                        device.turnOff();
                    }
                    System.out.println("All items are turned off\n\n");
                    continue;
                case 3:
                    // Turn On Specific Item
                    System.out.println("Choose an item to turn on: ");
                    for (int i = 0; i < smartDevices.length; i++) {
                        System.out.printf("%d. %s", (i + 1), smartDevices[i].getClass().getName());
                    }
                    choice = Integer.parseInt(scanner.nextLine());
                    smartDevices[choice - 1].turnOn();
                    System.out.printf("%s has been turned on.\n\n", smartDevices[choice - 1].getClass().getName());
                    continue;
                case 4:
                    // Turn Off Specific Item
                    System.out.println("Choose an item to turn off: ");
                    for (int i = 0; i < smartDevices.length; i++) {
                        System.out.printf("%d. %s", (i + 1), smartDevices[i].getClass().getName());
                    }
                    choice = Integer.parseInt(scanner.nextLine());
                    smartDevices[choice - 1].turnOff();
                    System.out.printf("%s has been turned off.\n\n", smartDevices[choice - 1].getClass().getName());
                    continue;
                case 5:
                    // Get Status of Devices
                    for (SmartDevice device : smartDevices) {
                        System.out.println(device.getStatus());
                    }
                    System.out.println("\n\n");
                    continue;
                default:
                    // Exit
                    System.out.println("Thank you, have a great day!");
                    break;
            }
        }
    }
}