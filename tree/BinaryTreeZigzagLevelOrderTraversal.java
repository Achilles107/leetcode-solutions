package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

public class BinaryTreeZigzagLevelOrderTraversal {

    private List<List<Integer>> leftToRight(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> leftToRight = new ArrayList<>();
        if (root == null)
            return leftToRight;

        queue.add(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> inner = new ArrayList<>();

            for (int i =0; i<size; i++){
                TreeNode currNode = queue.poll();
                inner.add(currNode.val);
                if (currNode.left != null)
                    queue.add(currNode.left);
                if (currNode.right != null)
                    queue.add(currNode.right);
            }
            leftToRight.add(inner);
        }
        return leftToRight;
    }

    private List<List<Integer>> rightToLeft(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> rightToLeft = new ArrayList<>();
        if (root == null)
            return rightToLeft;

        queue.add(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> inner = new ArrayList<>();

            for (int i =0; i<size; i++){
                TreeNode currNode = queue.poll();
                inner.add(currNode.val);
                if (currNode.right != null)
                    queue.add(currNode.right);
                if (currNode.left != null)
                    queue.add(currNode.left);
            }
            rightToLeft.add(inner);
        }
        return rightToLeft;
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        TreeNode temp = root;
        List<List<Integer>> leftToRight = leftToRight(temp);
        List<List<Integer>> rightToLeft = rightToLeft(root);
        List<List<Integer>> result = new ArrayList<>();

        for (int i =0; i<leftToRight.size(); i++){
            if (i % 2 == 0){
                result.add(leftToRight.get(i));
            }
            else {
                result.add(rightToLeft.get(i));
            }
        }
        return result;
    }
    public static void main(String[] args) {

    }
}
