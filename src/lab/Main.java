package lab;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Musician> musicians = new ArrayList<>();
        Menu.display();

        int choice;
        do {
            Menu.display();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Введіть ім'я нового музиканта: ");
                    String musicianName = scanner.nextLine();
                    musicians.add(new Musician(musicianName));
                    break;
                case 2:
                    if (musicians.isEmpty()) {
                        System.out.println("Немає створених музикантів. Спочатку створіть музиканта.");
                        break;
                    }
                    System.out.print("Оберіть музиканта (введіть номер): ");
                    for (int i = 0; i < musicians.size(); i++) {
                        System.out.println((i + 1) + ". " + musicians.get(i).name);
                    }
                    int musicianIndex = scanner.nextInt();
                    if (musicianIndex < 1 || musicianIndex > musicians.size()) {
                        System.out.println("Неправильний номер музиканта.");
                        break;
                    }
                    scanner.nextLine(); // Очистка буфера
                    System.out.print("Оберіть номер інструменту (1.піаніно або 2.скрипка): ");
                    String instrumentChoice = scanner.nextLine().toLowerCase();
                    Instrument instrumentToAdd;
                    switch (instrumentChoice) {
                        case "1":
                            instrumentToAdd = new Piano();
                            break;
                        case "2":
                            instrumentToAdd = new Violin();
                            break;
                        default:
                            System.out.println("Неправильний вибір інструменту.");
                            continue;
                    }
                    musicians.get(musicianIndex - 1).addInstrument(instrumentToAdd);
                    break;
                case 3:
                    if (musicians.isEmpty()) {
                        System.out.println("Немає створених музикантів.");
                        break;
                    }
                    System.out.println("Виконання усіх музикантів:");
                    for (Musician musician : musicians) {
                        musician.playInstruments();
                        System.out.println(); // Додатковий рядок для читабельності
                    }
                    break;
                case 4:
                    if (musicians.isEmpty()) {
                        System.out.println("Немає створених музикантів.");
                        break;
                    }
                    System.out.println("Налаштування інструментів музикантів:");
                    for (Musician musician : musicians) {
                        musician.tuneInstruments();
                        System.out.println(); // Додатковий рядок для читабельності
                    }
                    break;
                case 5:
                    System.out.println("вихід");
                    break;
                default:
                    System.out.println("Неправильний вибір.");
            }
        } while (choice != 5);

        scanner.close();
    }
}