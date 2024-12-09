public class Monster {
    private String name;
    private int requiredEnergy; // Energy yang dibutuhkan untuk mengalahkan monster
    private BinarySearchTree bst;
    private int value; // Nilai monster

    public Monster(String name, int requiredEnergy) {
        this.name = name;
        this.requiredEnergy = requiredEnergy;
        this.bst = new BinarySearchTree();  // Inisialisasi Binary Search Tree
    }

    // Getter untuk nama monster
    public String getName() {
        return name;
    }

    // Getter untuk nilai monster
    public int getValue() {
        return value;
    }

    public int getRequiredEnergy() {return requiredEnergy;}

    // Menambahkan nilai ke dalam BST
    public void addVitalObject(int value) {
        bst.insert(value);
    }

}
