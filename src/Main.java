import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Potter potter = new Potter();
        Monster monster = new Monster();
        Journey journey = new Journey(potter, monster);

        // Step 1: Konfirmasi kesiapan bermain dan memasukan nama pemain
        System.out.println("We are in the kingdom of Naradhista. " +
                "\nA beautiful and peaceful kingdom. The king rules justly and wisely. " +
                "\nBut now our kingdom is threatened by the rise of the demon king. " +
                "\nThe rise of the demon king can be thwarted by defeating one of his three gatekeepers." +
                "\nAll the ksatriyas are being deployed in the battle against the kingdom of Argyadhaksa.");
        System.out.println("You who are currently a potter have the blood and soul of a ksatriya. " +
                "\nYou used to be an honorable ksatriya, but your memory was lost due to an accident. " +
                "\nCurrently, only you as a potter can be relied on to defeat the demon gatekeeper.");
        System.out.println("What's your name?");
        String namePotter = scanner.nextLine();
        potter.setName(namePotter);

        System.out.println("Are you ready to play the Quest Navigation game? (Yes/No): ");
        String ready = scanner.nextLine();

        if (!ready.equalsIgnoreCase("Yes")) {
            System.out.println("See you next time!");
            return;
        }

        //Pemilihan Monster
        int randomIntMonster = (int) (Math.random() * 10 % 3);
        switch (randomIntMonster){
            case 0:
                monster.setName("Infernal Dragon");
                int[] vitalObjectF1 = {1, 2, 3, 4, 6, 8, 9, 10, 11, 12, 15, 16, 17, 19, 20, 22, 23, 24, 26, 27, 28, 30, 32, 33, 35, 39, 41, 42, 43, 44, 46, 50, 51, 52, 54, 55, 56, 58, 59, 60, 61, 64, 65, 67, 68, 69, 72, 73, 75, 76, 77, 79, 83, 84, 87, 89, 90, 91, 92, 94, 95, 97, 98};
                for (int i = 0; i< vitalObjectF1.length; i++){monster.addVitalObject(i);}
                monster.setDescripton("");
                break;
            case 1:
                monster.setName("Dark Leviathan");
                int[] vitalObjectF2 = {6, 8, 10, 12, 15, 19, 22, 24, 28, 30, 35, 38, 43, 45, 47, 50, 52, 54, 57, 60, 65, 68, 72, 76, 80, 83, 85, 88, 90, 95, 98};
                for (int i = 0; i< vitalObjectF2.length; i++){monster.addVitalObject(i);}
                monster.setDescripton("");
                break;
            case 2:
                monster.setName("Blood Wraith");
                int[] vitalObjectF3 = {1, 2, 3, 7, 8, 9, 10, 11, 12, 14, 15, 16, 18, 19, 20, 21, 22, 23, 24, 26, 27, 28, 31, 32, 33, 34, 35, 36, 37, 39, 42, 44, 45, 48, 49, 51, 52, 55, 57, 58, 59, 61, 63, 65, 66, 67, 71, 72, 73, 74, 76, 77, 78, 81, 83, 87, 90, 91, 93, 95, 96, 97, 98};
                for (int i = 0; i< vitalObjectF3.length; i++){monster.addVitalObject(i);}
                monster.setDescripton("");
                break;
        }

        System.out.println("You meet the King to offer help and the King feels very helpful." +
                "\nThe King told you that you must defeat " + monster.getName()+
                "\n"+monster.getDescripton()+
                "The King tells you that before fighting the gatekeeper you must equip yourself with the weapons of the Gods."+
                "\nThe King tells you that there are 3 castles that hold a relic to get to the Demon's Gatekeeper place quickly."+
                "\nEach castle gives a different effect."+
                "\n1. Field of Light"+
                "\n2. Fortress of Faith"+
                "\n3. Tower of Fate’s Dawn"+
                "\nChoose which castle to take the relic:");
        String castleNum = scanner.nextLine();
        String startId = "";
        switch (castleNum){
            case "1" -> startId = "s1";
            case "2" -> startId = "s2";
            case "3" -> startId = "s3";
            default -> throw new IllegalStateException("Unexpected value: " + castleNum);
        }

        //Mulai permainan
        journey.startGame(startId);
        journey.finalStage();
    }
}