import java.util.LinkedList;

public class LowestAncestor {

    public static void main(String[] args) {

    }

    public static Node lca(Node root, int v1, int v2) {
        LinkedList<Node> ancestorV1 = new LinkedList<>();
        LinkedList<Node> ancestorV2 = new LinkedList<>();
        if (root.data == v1 || root.data == v2) return root;
        searchInNode(root, v1, ancestorV1);
        searchInNode(root, v2, ancestorV2);
        ancestorV1.forEach(x -> System.out.println(x.data));
        for (int i = ancestorV1.size() -1; i > 0; i--) {
            Node curentAncestor = ancestorV1.get(i);
            if (containsTheSameAncestor(curentAncestor, ancestorV2)) return curentAncestor;
        }
        return root;
    }

    private static boolean containsTheSameAncestor(Node node, LinkedList<Node> ancestorV2) {
        return ancestorV2.stream()
                .map(x-> x.data)
                .anyMatch(data -> data == node.data);
    }

    private static void searchInNode(Node root, int value, LinkedList<Node> ancestor) {
        if (root == null) return;
        if (root.data == value) {
            ancestor.addLast(root);
            return;
        }
        ancestor.addLast(root);

        if (root.data > value) {
            searchInNode(root.left, value, ancestor);
        } else if (root.data < value) {
            searchInNode(root.right, value, ancestor);
        }
    }
}

class Node {
    int data;
    Node left;
    Node right;

}

