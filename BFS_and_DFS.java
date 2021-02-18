import java.util.LinkedList;

public class BFS_and_DFS {
    public static void main(String[] args) {
        anotherRepresentation();
        TreeNode root = buildTree();
        System.out.println("Traversing Treee with Recursive Approach - DFS1");
        traverseRecursive(root);
        System.out.println(" ");
        System.out.println("Traversing Treee with Stacks Approach - DFS1");
        DFS(root);
        System.out.println(" ");
        System.out.println("Traversing Treee with Queues Approach - BFS");
        BFS(root);

    }

    private static void anotherRepresentation() {
        int[][] graph = new int [11][2];
        graph[1][0] = 2; // left
        graph[1][1] = 3; // right

        graph[2][0] = 4;
        graph[2][1] = 5;

        graph[3][1] = 6;

        graph[4][0] = 7;

        graph[6][1] = 8;

        graph[7][1] = 9;
    }

    private static void BFS(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode first = queue.removeFirst();
            if (first.getRight() != null) queue.add(first.getRight());
            if (first.getLeft() != null) queue.add(first.getLeft());
            System.out.print(first.getValue());
        }
    }

    private static void DFS(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode last = stack.removeLast();
            if (last.getRight() != null) stack.add(last.getRight());
            if (last.getLeft() != null) stack.add(last.getLeft());
            System.out.print(last.getValue());
        }
    }

    private static void traverseRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.getValue());
        traverseRecursive(root.getLeft());
        traverseRecursive(root.getRight());
    }

    private static TreeNode buildTree() {
        TreeNode nine = new TreeNode(null,null, 9);
        TreeNode eight = new TreeNode(null,null, 8);
        TreeNode seven = new TreeNode(nine,null, 7);
        TreeNode four = new TreeNode(null,seven, 4);
        TreeNode five = new TreeNode(null,null, 5);
        TreeNode six= new TreeNode(eight,null, 6);
        TreeNode two= new TreeNode(five,four, 2);
        TreeNode three= new TreeNode(six, null, 3);
        TreeNode root = new TreeNode(three, two, 1);
        return root;
    }
}

class TreeNode {
    private TreeNode right;
    private TreeNode left;
    private Integer value;

    public TreeNode(TreeNode right, TreeNode left, Integer value) {
        this.right = right;
        this.left = left;
        this.value = value;
    }

    public TreeNode getRight() {
        return right;
    }

    public TreeNode getLeft() {
        return left;
    }

    public Integer getValue() {
        return value;
    }
}
