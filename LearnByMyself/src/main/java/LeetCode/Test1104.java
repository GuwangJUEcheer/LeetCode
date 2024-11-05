package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Test1104 {

    class RandomizedSet {

        List<Integer> list = new ArrayList<Integer>();
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        public RandomizedSet() {


        }

        public boolean insert(int val) {

            if(map.containsKey(val)){
                return false;
            }
            map.put(val,list.size() - 1);
            list.add(val);
            return true;
        }

        public boolean remove(int val) {

            if(!map.containsKey(val)){
                return false;
            }

            int index = map.get(val);
            list.set(index, list.get(list.size() - 1));
            map.put(list.get(index), index);
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        }

        public int getRandom() {
         return 0;
        }
    }
}
