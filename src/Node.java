public class Node {

    public Node(long value) {
        this.value = value;
        this.left = null;
        this.rigth = null;
    }

    public long value;
    public Node left;
    public Node rigth;

    public static Node insert(Node node, long value) {
        if (node == null) return new Node(value);
        if (value > node.value) node.rigth = insert(node.rigth, value);
        else node.left = insert(node.left, value);
        return node;
    }

    public void add(long value) {
        insert(this, value);
    }

    public int size() {
        return count(this);
    }

    public boolean isBalance() {
        Node node = this;
        int heigthL = this.left != null ? this.left.getHeigth() : 0;
        int heigthR = this.rigth != null ? this.rigth.getHeigth() : 0;
        return heigthR - heigthL == 1 ||
                heigthR - heigthL == 0 ||
                heigthR - heigthL == -1;
    }

    public int getHeigth() {
        return calculateHeigth(this);
    }

    public int getLeftHeigth() {
        return calculateHeigth(this.left);
    }

    public int getRigthHeigth() {
        return calculateHeigth(this.rigth);
    }

    private int calculateHeigth(Node node) {
        if (node == null) return 0;
        int profundidadeL = 1 + calculateHeigth(node.left);
        int profundidadeR = 1 + calculateHeigth(node.rigth);
        return profundidadeL > profundidadeR ? profundidadeL : profundidadeR;
    }

    private int count(Node node) {
        if (node == null) return 0;
        return 1 + count(node.left) + count(node.rigth);
    }

    public void inOrder() {
        order(this);
    }

    static void order(Node node) {
        if (node == null) return;
        order(node.left);
        System.out.println(node.value);
        order(node.rigth);
    }

    public Node balancedTree() {
        Node node = this;
        while (!node.isBalance())
            node = balance(node);
        return node;
    }

    public static Node balance(Node node) {
        if (node == null) return null;
        node.left = balance(node.left);
        node.rigth = balance(node.rigth);
        int heigthL = node.left != null ? node.left.getHeigth() : 0;
        int heigthR = node.rigth != null ? node.rigth.getHeigth() : 0;
        if (heigthR - heigthL > 1) {
            Node root = node.rigth;
            node.rigth = root.left;
            root.left = node;
            node = root;
        } else if (heigthL - heigthR > 1) {
            Node root = node.left;
            node.left = root.rigth;
            root.rigth = node;
            node = root;
        }
        return node;
    }
}
