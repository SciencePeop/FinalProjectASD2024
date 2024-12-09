import java.util.*;

public class Journey {
    private Potter potter;
    private Monster monster;
    private List<Milestone> milestoneList;
    Scanner scanner = new Scanner(System.in);

    public Journey(Potter potter, Monster monster) {
        this.potter = potter;
        this.monster = monster;
        this.milestoneList = initialization();
    }


    public void startGame(String startId) {
        System.out.println("\nStarting the game...");

        Milestone currentMilestone = milestoneList.stream()
                .filter(milestone -> milestone.getId().equals(startId))
                .findFirst().orElse(null);
        Milestone nextMilestone = null;
        List<Milestone> optionMilestone;
        String[] mainQuestVisited = {"mQ1", "mQ2", "mQ3", "mQ4", "mQ5"};

        while (true) {
            System.out.println("\nYou choose " + currentMilestone.getName());
            potter.printStatus();

            //Kondisi jika tidak memiliki energi yang cukup untuk melanjutkan satupun quest yang ada
            if (potter.getEnergy() < getMinCostOfNextStep(currentMilestone)) {
                System.out.println("Your energy is not enough to continue the journey. You lose.");
                break;
            }

            //Ambil teman dari currentMilestone
            optionMilestone = getFriendsOfMilestone(currentMilestone);


            // Tampilkan opsi milestone
            System.out.println("Available paths:");
            for (int i = 0; i < optionMilestone.size(); i++) {
                System.out.println(i+1 +". "+ optionMilestone.get(i).getId() + " : " + optionMilestone.get(i).getName());
                System.out.println(optionMilestone.get(i).getDescription());
                System.out.println("Cost : " + optionMilestone.get(i).getEnergyCosts(currentMilestone)
                        + " \tCoins : "+optionMilestone.get(i).getCoinReward()
                        +" \tEnergy : "+ optionMilestone.get(i).getEnergyRestored());
            }
            System.out.println(optionMilestone.size() + 1 + ". Use Pusaka");
            System.out.println("Cost : " + potter.getEnergy() * 0.6);

            // Ambil pilihan pengguna
            boolean validChoice = false;
            int choice = 1;
            while (!validChoice) {
                System.out.print("Choose your next milestone: ");
                choice = scanner.nextInt();

                // Validasi pilihan
                if (choice < 0 || choice > optionMilestone.size() + 1) {
                    System.out.println("Invalid choice. Please try again.");
                    continue;
                }
                validChoice = true;
            }

            //Kondisi jika nextMilestone adalah finish

            //Kondisi jika menggunakan Pusaka
            if (choice == optionMilestone.size() + 1) {
                System.out.println("Using Pusaka");
                break;
            }
            // Perbarui milestone berikutnya
            nextMilestone = optionMilestone.get(choice - 1);

            // Update potter's energy dan milestone saat ini
            potter.decreaseEnergy(currentMilestone.getEnergyCosts(nextMilestone));
            potter.addCoins(currentMilestone.getCoinReward());
            potter.increaseEnergy(currentMilestone.getEnergyRestored());
            currentMilestone.setCompleted();

            //Hapus jika mainQuest
            for (int i = 0; i < mainQuestVisited.length; i++) {
                if (mainQuestVisited[i].equals(currentMilestone.getId())) {
                    mainQuestVisited[i] = null; // Ubah nilai menjadi null
                    break; // Keluar dari loop setelah menemukan
                }
                currentMilestone = nextMilestone;
            }
        }
    }

    public static List<Milestone> getFriendsOfMilestone(Milestone currentMilestone) {
        if (currentMilestone == null || currentMilestone.getConnectedMilestones() == null) {
            return new ArrayList<>(); // Mengembalikan list kosong jika milestone atau koneksinya null
        }
        return new ArrayList<>(currentMilestone.getConnectedMilestones().keySet());
    }

    public static int getMinCostOfNextStep(Milestone currentMilestone) {
        ArrayList<Integer> costs = new ArrayList<>(currentMilestone.getConnectedMilestones().values());
        int minimumCost = Collections.min(costs);
        return minimumCost;
    }

    private List<Milestone> initialization() {
        List<Milestone> milestoneList = new ArrayList<>();
        Milestone start = new Milestone("s", "Naradhista Castle", "Start");

        Milestone start1 = new Milestone("s1", "Field of Light", "Start Path");
        Milestone start2 = new Milestone("s2", "Fortress of Faith", "Start Path");
        Milestone start3 = new Milestone("s3", "Tower of Fate’s Dawn", "Start Path");

        Milestone mQ1 = new Milestone("mQ1", "Hurricane Shoes", "Main Quest");
        Milestone mQ2 = new Milestone("mQ2", "Taranis Shield", "Main Quest");
        Milestone mQ3 = new Milestone("mQ3", "Phoenix Mantle", "Main Quest");
        Milestone mQ4 = new Milestone("mQ4", "Gandiva Arrow", "Main Quest");
        Milestone mQ5 = new Milestone("mQ5", "Helm of Kuuga", "Main Quest");

        Milestone sQ1 = new Milestone("sQ1", "Gather Food Supplies", 0, 17);
        Milestone sQ2 = new Milestone("sQ2", "Repair the Broken Cart", 0, 5);
        Milestone sQ3 = new Milestone("sQ3", "Assist the Villagers", 13, 5);
        Milestone sQ4 = new Milestone("sQ4", "Upgrade Village Walls", 0, 8);
        Milestone sQ5 = new Milestone("sQ5", "Scout the Nearby Forest", 0, 5);
        Milestone sQ6 = new Milestone("sQ6", "Find the Lost Tools", 12, 5);
        Milestone sQ7 = new Milestone("sQ7", "Build the Watchtower", 15, 0);
        Milestone sQ8 = new Milestone("sQ8", "Defend Against Bandits", 0, 5);
        Milestone sQ9 = new Milestone("sQ9", "Rescue the Stranded Traveler", 14, 11);
        Milestone sQ10 = new Milestone("sQ10", "Trade Goods with the Caravan", 0, 7);
        Milestone sQ11 = new Milestone("sQ11", "Locate the Hidden Spring", 15, 10);
        Milestone sQ12 = new Milestone("sQ12", "Train the Village Guard", 22, 0);
        Milestone sQ13 = new Milestone("sQ13", "Collect Medicinal Herbs", 0, 7);
        Milestone sQ14 = new Milestone("sQ14", "Repel the Night Raid", 0, 5);
        Milestone sQ15 = new Milestone("sQ15", "Retrieve the Ancient Relic", 17, 15);

        Milestone f1 = new Milestone("f1", "Infernal Dragon", "Final");
        Milestone f2 = new Milestone("f2", "Dark Leviathan", "Final");
        Milestone f3 = new Milestone("f3", "Blood Wraith", "Final");

        start.addConnection(start1, 0);
        start.addConnection(start2, 0);
        start.addConnection(start3, 0);

        start1.addConnection(sQ8, 15);
        start1.addConnection(mQ1, 10);
        start1.addConnection(sQ2, 17);

        start2.addConnection(sQ2, 8);
        start2.addConnection(sQ3, 14);
        start2.addConnection(mQ5, 20);

        start3.addConnection(mQ5, 13);
        start3.addConnection(sQ9, 8);

        mQ1.addConnection(start1, 10);
        mQ1.addConnection(sQ1, 8);
        mQ1.addConnection(mQ2, 17);

        mQ2.addConnection(mQ1, 17);
        mQ2.addConnection(sQ1, 10);
        mQ2.addConnection(sQ2, 12);
        mQ2.addConnection(sQ3, 8);
        mQ2.addConnection(mQ3, 13);

        mQ3.addConnection(mQ2, 13);
        mQ3.addConnection(sQ5, 9);
        mQ3.addConnection(sQ6, 7);
        mQ3.addConnection(sQ11, 9);
        mQ3.addConnection(sQ14, 10);

        mQ4.addConnection(sQ4, 14);
        mQ4.addConnection(sQ7, 10);
        mQ4.addConnection(sQ10, 8);
        mQ4.addConnection(sQ12, 10);
        mQ4.addConnection(f3, 17);

        mQ5.addConnection(start2, 20);
        mQ5.addConnection(start3, 13);
        mQ5.addConnection(sQ3, 4);
        mQ5.addConnection(sQ4, 14);
        mQ5.addConnection(sQ9, 10);
        mQ5.addConnection(sQ13, 13);

        sQ1.addConnection(mQ1, 8);
        sQ1.addConnection(mQ2, 10);
        sQ1.addConnection(sQ8, 20);
        sQ1.addConnection(sQ11, 10);
        sQ1.addConnection(sQ15, 14);

        sQ2.addConnection(start1, 17);
        sQ2.addConnection(start2, 8);
        sQ2.addConnection(mQ2, 12);

        sQ3.addConnection(start2, 14);
        sQ3.addConnection(mQ2, 8);
        sQ3.addConnection(mQ5, 4);
        sQ3.addConnection(sQ5, 20);

        sQ4.addConnection(mQ4, 14);
        sQ4.addConnection(mQ5, 14);
        sQ4.addConnection(sQ5, 8);
        sQ4.addConnection(sQ13, 15);

        sQ5.addConnection(mQ3, 9);
        sQ5.addConnection(sQ3, 20);
        sQ5.addConnection(sQ4, 8);
        sQ5.addConnection(sQ7, 10);

        sQ6.addConnection(mQ3, 7);
        sQ6.addConnection(f1, 8);
        sQ6.addConnection(f2, 12);

        sQ7.addConnection(mQ4, 10);
        sQ7.addConnection(sQ5, 10);
        sQ7.addConnection(sQ14, 9);
        sQ7.addConnection(f2, 13);
        sQ7.addConnection(f3, 15);

        sQ8.addConnection(start1, 15);
        sQ8.addConnection(sQ1, 20);
        sQ8.addConnection(sQ15, 8);

        sQ9.addConnection(start3, 8);
        sQ9.addConnection(mQ5, 10);
        sQ9.addConnection(sQ13, 12);

        sQ10.addConnection(mQ4, 8);
        sQ10.addConnection(sQ12, 15);
        sQ10.addConnection(sQ13, 16);

        sQ11.addConnection(mQ3, 9);
        sQ11.addConnection(sQ1, 10);
        sQ11.addConnection(sQ15, 10);
        sQ11.addConnection(f1, 15);

        sQ12.addConnection(mQ4, 10);
        sQ12.addConnection(sQ10, 15);
        sQ12.addConnection(f3, 9);

        sQ13.addConnection(mQ5, 13);
        sQ13.addConnection(sQ4, 15);
        sQ13.addConnection(sQ9, 12);
        sQ13.addConnection(sQ10, 16);

        sQ14.addConnection(mQ3, 10);
        sQ14.addConnection(sQ7, 9);
        sQ14.addConnection(f2, 16);

        sQ15.addConnection(sQ1, 14);
        sQ15.addConnection(sQ8, 8);
        sQ15.addConnection(sQ11, 10);

        milestoneList.add(start);
        milestoneList.add(start1);
        milestoneList.add(start2);
        milestoneList.add(start3);

        milestoneList.add(mQ1);
        milestoneList.add(mQ2);
        milestoneList.add(mQ3);
        milestoneList.add(mQ4);
        milestoneList.add(mQ5);

        milestoneList.add(sQ1);
        milestoneList.add(sQ2);
        milestoneList.add(sQ3);
        milestoneList.add(sQ4);
        milestoneList.add(sQ5);
        milestoneList.add(sQ6);
        milestoneList.add(sQ7);
        milestoneList.add(sQ8);
        milestoneList.add(sQ9);
        milestoneList.add(sQ10);
        milestoneList.add(sQ11);
        milestoneList.add(sQ12);
        milestoneList.add(sQ13);
        milestoneList.add(sQ14);
        milestoneList.add(sQ15);

        milestoneList.add(f1);
        milestoneList.add(f2);
        milestoneList.add(f3);

        return milestoneList;
    }
}