import java.util.LinkedHashMap;

/**
 * 哈希表
 * 
 * @author sunhu
 * @date 2020/11/27 11:22
 */
public class HashTableDemo {

    public static void main(String[] args) {
        HashTab hashTab = new HashTab(5);

        // 使用map作为模拟元素
        LinkedHashMap<Object, Object> linkedHashMap1 = new LinkedHashMap<>();
        linkedHashMap1.put("id", 4);
        linkedHashMap1.put("name", "4号");
        LinkedHashMap<Object, Object> linkedHashMap2 = new LinkedHashMap<>();
        linkedHashMap2.put("id", 5);
        linkedHashMap2.put("name", "7号");

        LinkedHashMap<Object, Object> linkedHashMap3 = new LinkedHashMap<>();
        linkedHashMap3.put("id", 8);
        linkedHashMap3.put("name", "8号");
        hashTab.add(linkedHashMap1);
        hashTab.add(linkedHashMap2);
        hashTab.add(linkedHashMap3);

        hashTab.list();

        LinkedHashMap byId = hashTab.findById(8);
        System.out.println(byId);

    }

    static class HashTab {
        private LinkedHashMap[] linkedHashMapArray;
        private int size;

        public HashTab(int size) {
            this.size = size;
            linkedHashMapArray = new LinkedHashMap[size];

            // 初始化
            for (int i = 0; i < linkedHashMapArray.length; i++) {
                linkedHashMapArray[i] = new LinkedHashMap<>();
            }
        }

        public void list() {
            for (int i = 0; i < linkedHashMapArray.length; i++) {
                LinkedHashMap linkedHashMap = linkedHashMapArray[i];
                System.out.printf("第%d个元素  ", i);
                if (linkedHashMap.isEmpty()) {
                    System.out.println("空");
                } else {
                    System.out.println(linkedHashMapArray[i]);
                }
            }
        }

        public void add(LinkedHashMap linkedHashMap) {
            int id = Integer.parseInt(linkedHashMap.get("id").toString());
            int index = hashFunction(id);
            linkedHashMapArray[index] = linkedHashMap;
        }

        public LinkedHashMap findById(int id) {
            int index = hashFunction(id);
            return linkedHashMapArray[index];
        }

        public int hashFunction(int id) {
            return id % size;
        }

    }

}
