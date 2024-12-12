package HashMap;
import java.util.HashMap;
/*
    设计一种结构，在该结构中有如下三个功能：
    insert(key)：将某个key加入到该结构，做到不重复加入。
    delete(key)：将原本在结构中的某个key移除。 getRandom()：
    等概率随机返回结构中的任何一个key。
   【要求】 Insert、delete和getRandom方法的时间复杂度都是O(1)
 */
public class RandomPool {
    public class pool<K>{
        public HashMap<K,Integer> keyIndex;
        public HashMap<Integer,K> indexkey;
        public int size;
        public pool() {
             this.keyIndex = new HashMap<K,Integer>();
             this.indexkey = new HashMap<Integer,K>();
             this.size = 0;
        }
        public void Insert(K key){
            if (!this.keyIndex.containsKey(key)) {
                this.keyIndex.put(key,size);
                this.indexkey.put(size++,key);
            }
        }
        //把最后一个哈希元素放入被删除的位置上
        public void delete(K key) {
            if (this.keyIndex.containsKey(key)) {
                int deleteIndex = this.keyIndex.get(key);
                int lastIndex = --this.size;
                K lastKey = this.indexkey.get(lastIndex);
                this.keyIndex.put(lastKey,deleteIndex);
                this.indexkey.put(deleteIndex,lastKey);
                this.keyIndex.remove(key);
                this.indexkey.remove(lastIndex);
            }
        }
        public K getRandom(){
            if (size==0)
                return null;
            else{
                int random = (int) (Math.random()*this.size);
                return this.indexkey.get(random);
            }
        }
    }


}
