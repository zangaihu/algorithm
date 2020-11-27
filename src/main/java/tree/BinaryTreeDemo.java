package tree;

/**
 * 简单二叉树的前、中、后序遍历
 * 
 * @author sunhu
 * @date 2020/11/26 16:48
 */
public class BinaryTreeDemo {

    public static void main(String[] args) {

        // 需要创建一科二叉树
        BinaryTree binaryTree = new BinaryTree();
        // 创建需要的结点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        // 我们先手动创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);

        /*     System.out.println("前序遍历");
        binaryTree.preOrder();
        
        System.out.println("中序遍历");
        binaryTree.infixOrder();
        
        System.out.println("后序遍历");
        binaryTree.postOrder();
        
        // 后序遍历查找
        System.out.println("后序遍历方式查找");
        HeroNode resNode = binaryTree.postOrderSearch(5);
        if (resNode != null) {
            System.out.printf("找到，信息为 no = %d name = %s", resNode.getNo(), resNode.getName());
        } else {
            System.out.printf("没有找到编号no = %d的英雄", 5);
        }*/
        System.out.println("前序遍历");
        binaryTree.preOrder();
        binaryTree.delNode(3);
        System.out.println("前序遍历");
        binaryTree.preOrder();

    }

    // 定义一个二叉树
    static class BinaryTree {
        private HeroNode root;

        public void setRoot(HeroNode root) {
            this.root = root;
        }

        // 前序遍历
        public void preOrder() {
            if (this.root != null) {
                this.root.preOrder();
            } else {
                System.out.println("二叉树为空，无法遍历");
            }
        }

        // 中序遍历
        public void infixOrder() {
            if (this.root != null) {
                this.root.infixOrder();
            } else {
                System.out.println("二叉树为空，无法遍历");
            }
        }

        // 后序遍历
        public void postOrder() {
            if (this.root != null) {
                this.root.postOrder();
            } else {
                System.out.println("二叉树为空，无法遍历");
            }
        }

        // 前序遍历查找
        public HeroNode perOrderSearch(int no) {
            if (this.root != null) {
                return root.preOrderSearch(no);
            } else {
                return null;
            }
        }

        // 中序遍历查找
        public HeroNode inFixOrderSearch(int no) {
            if (this.root != null) {
                return root.infixOrderSearch(no);
            } else {
                return null;
            }
        }

        // 后序遍历查找
        public HeroNode postOrderSearch(int no) {
            if (this.root != null) {
                return root.postOrderSearch(no);
            } else {
                return null;
            }
        }

        // 删除结点
        public void delNode(int no) {
            if (this.root.getNo() == no) {
                this.root = null;
            } else {
                this.root.delNode(no);
            }
        }

    }

    static class HeroNode {
        private int no;
        private String name;
        private HeroNode left;// 默认null
        private HeroNode right;// 默认null

        public HeroNode(int no, String name) {
            this.no = no;
            this.name = name;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public HeroNode getLeft() {
            return left;
        }

        public void setLeft(HeroNode left) {
            this.left = left;
        }

        public HeroNode getRight() {
            return right;
        }

        public void setRight(HeroNode right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return "HeroNode{" + "no=" + no + ", name='" + name + '\'' + '}';
        }

        // 前序遍历
        public void preOrder() {
            System.out.println(this);
            // 递归遍历左叶子节点
            if (this.left != null) {
                this.left.preOrder();
            }
            // 递归遍历右叶子节点
            if (this.right != null) {
                this.right.preOrder();
            }
        }

        // 中序遍历
        public void infixOrder() {
            // 先对左子节点中序遍历
            if (this.left != null) {
                this.left.infixOrder();
            }
            // 输出父节点
            System.out.println(this);
            // 对右子节点中序遍历
            if (this.right != null) {
                this.right.infixOrder();
            }
        }

        // 后序遍历
        public void postOrder() {
            // 先对左子节点后序遍历
            if (this.left != null) {
                this.left.postOrder();
            }
            // 对右子节点后续遍历
            if (this.right != null) {
                this.right.postOrder();
            }
            // 输出父节点
            System.out.println(this);
        }

        // 前序遍历查找节点
        public HeroNode preOrderSearch(int no) {
            // 当前节点是，返回
            if (this.no == no) {
                return this;
            }
            // 向左递归 前序遍历
            HeroNode resNode = null;
            if (this.left != null) {
                resNode = this.left.preOrderSearch(no);
            }
            // 找到，即返回
            if (resNode != null) {
                return resNode;
            }
            // 未找到，右子节点前序遍历
            if (this.right != null) {
                resNode = this.right.preOrderSearch(no);
            }
            return resNode;
        }

        // 中序遍历查找节点
        public HeroNode infixOrderSearch(int no) {
            HeroNode resNode = null;
            if (this.left != null) {
                resNode = this.left.infixOrderSearch(no);
            }
            if (resNode != null) {
                return resNode;
            }
            if (this.no == no) {
                return this;
            }
            if (this.right != null) {
                resNode = this.right.infixOrderSearch(no);
            }
            return resNode;
        }

        public HeroNode postOrderSearch(int no) {
            HeroNode resNode = null;
            if (this.left != null) {
                resNode = this.left.postOrderSearch(no);
            }
            if (resNode != null) {
                return resNode;
            }
            if (this.right != null) {
                resNode = this.right.postOrderSearch(no);
            }
            if (resNode != null) {
                return resNode;
            }
            if (this.no == no) {
                return this;
            }
            return resNode;
        }

        public void delNode(int no) {

            if (this.left != null && this.left.no == no) {
                this.left = null;
                return;
            }
            if (this.right != null && this.right.no == no) {
                this.right = null;
                return;
            }
            if (this.left != null) {
                this.left.delNode(no);
            }
            if (this.right != null) {
                this.right.delNode(no);
            }
        }
    }
}