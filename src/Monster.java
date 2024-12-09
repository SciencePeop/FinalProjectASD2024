public class Monster {
    private String name;
    private int requiredEnergy; // Energy yang dibutuhkan untuk mengalahkan monster
    private BinarySearchTree bst;
    private int value = 60; // Nilai monster
    private String descripton;

    public Monster() {
        this.requiredEnergy = 60;
        this.bst = new BinarySearchTree();  // Inisialisasi Binary Search Tree
    }

    // Getter untuk nama monster
    public String getName() {
        return name;
    }

    public String getDescripton() {return descripton;}

    // Getter untuk nilai monster
    public int getValue() {
        return value;
    }

    public int getRequiredEnergy() {return requiredEnergy;}

    // Menambahkan nilai ke dalam BST
    public void addVitalObject(int value) {
        bst.insert(value);
    }

    //Mengisi nama monster
    public void setName(String name) {this.name = name;}

    //Mengisi deskripsi monster
    public void setDescripton(String descripton) {this.descripton = descripton;}

    public int attack(int target){
        int totalLevel = bst.maxDepth();
        int targetLevel = bst.findDepth(target);
        int pointPerLevel = this.value/totalLevel;
        int pointAccepted = (totalLevel-targetLevel)*pointPerLevel;
        return pointAccepted;
    }
}
