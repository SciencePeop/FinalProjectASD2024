public class Potter {
    private String name;
    private int energy;
    private int coins;

    // Constructor default
    public Potter() {
        this.name = "Potter";
        this.energy = 250; // Nilai default energi
        this.coins = 0; // Nilai default koin
    }

    // Constructor dengan parameter
    public Potter(String name, int energy, int coins) {
        this.name = name;
        this.energy = energy;
        this.coins = coins;
    }

    public void printStatus() {
        System.out.println("Potter: " + name + " | Energy: " + energy + " | Coins: " + coins);
    }

    // Mengurangi energi dengan pengamanan agar tidak negatif
    public void decreaseEnergy(int amount) {
        this.energy = Math.max(this.energy - amount, 0);
    }

    // Menambahkan energi
    public void increaseEnergy(int amount) {
        this.energy += amount;
    }

    // Menambahkan koin
    public void addCoins(int amount) {
        this.coins += amount;
    }

    // Melihat energy
    public int getEnergy() {return energy;}
}
