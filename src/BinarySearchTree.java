public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    private class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
            this.left = this.right = null;
        }
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }

        return root;
    }

    // Menambahkan metode untuk mencari kedalaman sebuah nilai
    public int findDepth(int value) {
        return findDepthRec(root, value, 0);
    }

    private int findDepthRec(Node root, int value, int depth) {
        // Jika node null, kembalikan -1 (tidak ditemukan)
        if (root == null) {
            return -1;
        }

        // Jika nilai ditemukan, kembalikan kedalamannya
        if (root.value == value) {
            return depth;
        }

        // Cari di kiri atau kanan, tambah kedalaman pada setiap langkah
        if (value < root.value) {
            return findDepthRec(root.left, value, depth + 1);
        } else {
            return findDepthRec(root.right, value, depth + 1);
        }
    }

    // Metode untuk mencari nilai dalam pohon biner
    public boolean search(int value) {
        return searchRec(root, value);
    }

    private boolean searchRec(Node root, int value) {
        if (root == null) {
            return false;
        }

        if (root.value == value) {
            return true;
        }

        if (value < root.value) {
            return searchRec(root.left, value);
        }

        return searchRec(root.right, value);
    }

    // Metode untuk mencari kedalaman maksimal
    int maxDepth() {
        return maxDepthRec(root);
    }

    private int maxDepthRec(Node node) {
        if (node == null) {
            return 0; // Base case: empty tree has depth 0
        }

        // Recursively find the depth of left and right subtrees
        int leftDepth = maxDepthRec(node.left);
        int rightDepth = maxDepthRec(node.right);

        // Return the larger depth plus 1 for the current node
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
