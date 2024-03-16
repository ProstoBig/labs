package lab;

import java.util.Scanner;

class Bicycle {
    // Внутрішній клас для колеса
    class Wheel {
        void rotate() {
            System.out.println("Колеса обертаються");
        }
    }

    // Статичний вкладений клас для ліхтарика
    static class Light {
        void flash() {
            System.out.println("Ліхтарик блимає");
        }
    }

    // Локальний (в методі) клас для гальм
    void brake() {
        class Brake {
            void stop() {
                System.out.println("Машина тормозить");
            }
        }
        Brake brake = new Brake();
        brake.stop();
    }

    // Безіменний внутрішній клас для педалей
    void pedal() {
        // Визначення класу
        Runnable pedalAction = new Runnable() {
            @Override
            public void run() {
                System.out.println("Машина поїхала");
            }
        };

        // Виклик методу класу
        pedalAction.run();
    }

    // Метод для взаємодії складових частин
    void interact() {
        Wheel wheel = new Wheel();
        Light light = new Light();

        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            menu.display();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    wheel.rotate();
                    break;
                case 2:
                    light.flash();
                    break;
                case 3:
                    pedal();
                    break;
                case 4:
                    brake();
                    break;
                case 5:
                    System.out.println("Вихід");
                    break;
                default:
                    System.out.println("Неправильний вибір опції.");
            }
        } while (choice != 0);
    }
}

public class Main {
    public static void main(String[] args) {
        Bicycle bicycle = new Bicycle();
        bicycle.interact();
    }
}
