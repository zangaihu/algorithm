package tree;

/**
 * @author sunhu
 * @date 2020/11/26 16:48
 */
public class BinartTreeDemo {

    public static void main(String[] args) {

    }

    class BinartTree {

        private HeroNode root;

        public void setRoot(HeroNode node) {
            this.root = node;
        }

    }

    static class HeroNode {
        public int no;
        public String name;
        public String nikenmae;

        public HeroNode(int no, String name, String nikenmae) {
            this.no = no;
            this.name = name;
            this.nikenmae = nikenmae;

        }

        @Override
        public String toString() {
            return "HeroNode [no=" + no + ", name=" + name + ", nikenmae=" + nikenmae + "]";
        }

    }

}
