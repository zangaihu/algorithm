/**
 * 单链表
 * 
 * @author sunhu
 * @date 2020/11/11 9:18
 */
public class SingleLinkedList {

    public static void main(String[] args) {
        HeroNode heronode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heronode2 = new HeroNode(2, "李逵", "黑旋风");
        HeroNode heronode3 = new HeroNode(3, "孙二娘", "母夜叉");
        HeroNode heronode4 = new HeroNode(4, "张顺", "浪里白条");
        HeroNode heronode5 = new HeroNode(5, "林冲", "豹子头");

        // 创建一个链表
        MySingleLinkedList singleLInkedlist = new MySingleLinkedList();
        // 加入
        // singleLInkedlist.add(heronode1);
        // singleLInkedlist.add(heronode2);
        // singleLInkedlist.add(heronode3);
        // singleLInkedlist.add(heronode4);
        // singleLInkedlist.add(heronode5);

        singleLInkedlist.addByOrder(heronode1);
        singleLInkedlist.addByOrder(heronode4);
        singleLInkedlist.addByOrder(heronode5);
        singleLInkedlist.addByOrder(heronode3);
        singleLInkedlist.addByOrder(heronode2);

        singleLInkedlist.update(new HeroNode(1, "诸葛", "孔明"));
        singleLInkedlist.update(new HeroNode(3, "诸葛", "孔明"));
        singleLInkedlist.update(new HeroNode(5, "诸葛", "孔明"));

        // singleLInkedlist.delete(5);

        // 显示
        singleLInkedlist.list();

        Integer length = singleLInkedlist.getLength();
        System.out.println(length);
    }

    static class MySingleLinkedList {

        private HeroNode head = new HeroNode(0, "", "");

        public Integer getLength() {
            int len = 0;
            HeroNode tmp = head;
            while (tmp.next != null) {
                len = len + 1;
                tmp = tmp.next;
            }
            return len;
        }

        public void add(HeroNode heroNode) {
            // 临时节点，头结点不能动
            HeroNode tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = heroNode;
        }

        /**
         * 顺序添加
         */
        public void addByOrder(HeroNode heroNode) {
            HeroNode tmp = head;
            Boolean flag = false;

            while (true) {
                if (tmp.next == null) {
                    break;
                }
                if (tmp.next.no > heroNode.no) {
                    break;
                } else if (tmp.next.no == tmp.no) {
                    flag = true;// 说明编号存在
                    break;
                }
                tmp = tmp.next;

            }
            // 判断flag值
            if (flag) {// 不能添加，说明编号存在
                System.out.printf("准备插入的英雄的编号%d存在！,不能加入", heroNode.no);
                System.out.println();
            } else {
                // 插入到链表，temp后面
                heroNode.next = tmp.next;
                tmp.next = heroNode;
            }

        }

        public void update(HeroNode heroNode) {
            if (head.next == null) {
                System.out.println("链表为空");
                return;
            }
            HeroNode tmp = head.next;
            Boolean flag = false;
            while (true) {
                if (tmp == null) {
                    break;
                }
                if (tmp.no == heroNode.no) {
                    flag = true;
                    break;
                }
                tmp = tmp.next;
            }
            if (flag) {
                tmp.name = heroNode.name;
                tmp.nikenmae = heroNode.nikenmae;
            } else {
                // 没有找到
                System.out.printf("没有找到编号为%d的结点，不能修改\n", heroNode.no);
            }
        }

        public void delete(int no) {

            if (head.next == null) {
                System.out.println("链表为空");
                return;
            }
            Boolean flag = false;
            HeroNode tmp = head;
            while (true) {
                if (tmp.next == null) {
                    break;
                }
                if (tmp.next.no == no) {
                    flag = true;
                    break;
                }
                tmp = tmp.next;
            }
            if (flag) {
                tmp.next = tmp.next.next;
            } else {
                System.out.printf("要删除的结点%d不存在\n", no);
            }

        }

        public void list() {
            if (head.next == null) {
                System.out.println("链表空");
                return;
            }
            HeroNode tmp = head.next;
            while (true) {
                if (tmp == null) {
                    break;
                }
                System.out.println(tmp);
                tmp = tmp.next;

            }

        }
    }

    // 首先定义一个HeroNode，每个HeroNode对象是一个结点
    static class HeroNode {
        public int no;
        public String name;
        public String nikenmae;
        public HeroNode next;// 指向 下一个结点
        // 构造器

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
