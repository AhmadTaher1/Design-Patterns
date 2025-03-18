package Visitor;


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

public class FindElements {

     TreeNode treeNode;
     boolean found=false;

    public void recover(TreeNode node){

        if(node==null){
            return;
        }

        if(node.left !=null){
            node.left.val= node.val*2+1;
            recover(node.left);
        }
        if(node.right !=null){
            node.right.val= node.val*2+2;
            recover(node.right);
        }

    }

    public FindElements(TreeNode root) {
        root.val+=1;
        recover(root);
        treeNode=root;
    }

    public void DFS(TreeNode node,int target){
        if(node==null){
            return ;
        }
        if(node.val==target){
            found=true;
            return;
        }
        if(node.left!=null){
            DFS(node.left,target);
        }
        if(node.right!=null){
           DFS(node.right,target);
        }
    }

    public boolean find(int target) {

        DFS(treeNode,target);
        boolean temp=found;
        found=false;
        return temp;
    }

    public static void main(String[] args) {
        TreeNode node1=new TreeNode();
        TreeNode node2=new TreeNode();
        TreeNode node3=new TreeNode();
        node1.val=0;
        node2.val=4;
        node3.val=8;
        node1.left=node2;
        node1.right=node3;
        FindElements findElements=new FindElements(node1);
        System.out.println(findElements.find(1));
        System.out.println(findElements.find(3));
        System.out.println(findElements.find(4));
        System.out.println(findElements.find(5));



    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */

