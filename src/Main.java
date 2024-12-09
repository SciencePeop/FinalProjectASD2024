import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Potter potter = new Potter();
        Monster monster = new Monster("Infernal Dragon", 60);
        Journey journey = new Journey(potter, monster);

        // Step 1: Konfirmasi kesiapan bermain
        System.out.println("Are you ready to play the Quest Navigation game? (Yes/No): ");
        String ready = scanner.next();

        if (!ready.equalsIgnoreCase("Yes")) {
            System.out.println("See you next time!");
            return;
        }
        Milestone start1 = new Milestone("Field of Light", "Start Path");
        journey.startGame(start1);
    }
}