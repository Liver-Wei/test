import java.util.*;

/**
 * @author Liver
 * @Description
 * @date 2021/5/6 23:21
 */
public class BinaryTree {

    //二叉树先序遍历
    public void preorderTraversalRecursive(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.val);
        preorderTraversalRecursive(root.left);
        preorderTraversalRecursive(root.right);
    }

    public void preorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                System.out.println(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
    }

    public void preOrder(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> stack = new LinkedList<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            System.out.println(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
    }


    //二叉树中序遍历
    public void inorderTraversalRecursive(TreeNode root) {
        if (root == null) {
            return;
        }

        inorderTraversalRecursive(root.left);
        System.out.println(root.val);
        inorderTraversalRecursive(root.right);
    }

    public void inorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            System.out.println(root.val);
            root = root.right;
        }
    }

    //二叉树后序遍历

    public void postTraversalRecursive(TreeNode root) {
        if (root == null) {
            return;
        }

        postTraversalRecursive(root.left);
        postTraversalRecursive(root.right);
        System.out.println(root.val);
    }

    public void postTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode visited = null;

        while (root != null || !stack.isEmpty()) {
            //往左节点一直走
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            //右节点为空或者已经访问过了则访问当前节点
            if (root.right == null || root.right == visited) {
                System.out.println(root.val);
                visited = root;
                //回溯置null
                root = null;
            } else {//右节点不为空,往右一直走
                stack.push(root);
                root = root.right;
            }

        }
    }

    //二叉树层序遍历
    public void levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public List<List<Integer>> levelOrderList(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }
        return ret;
    }

    public void levelDFS(int index, TreeNode root, List<List<Integer>> res) {//传给index的值为1
        //假设res是[ [1],[2,3] ]， index是3，就再插入一个空list放到res中
        if (res.size() < index) {
            res.add(new ArrayList<>());
        }
        //将当前节点的值加入到res中，index代表当前层，假设index是3，节点值是99
        //res是[ [1],[2,3] [4] ]，加入后res就变为 [ [1],[2,3] [4,99] ]
        res.get(index - 1).add(root.val);
        //递归的处理左子树，右子树，同时将层数index+1
        if (root.left != null) {
            levelDFS(index + 1, root.left, res);
        }
        if (root.right != null) {
            levelDFS(index + 1, root.right, res);
        }
    }

    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
