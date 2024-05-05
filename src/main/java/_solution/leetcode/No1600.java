package _solution.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class No1600 {

    class ThroneInheritance {

        MultiTreeNode king;

        Map<String, MultiTreeNode> name2Node = new HashMap<>();

        public ThroneInheritance(String kingName) {
            this.king = new MultiTreeNode(kingName);
            name2Node.put(kingName, king);
        }

        public void birth(String parentName, String childName) {
            MultiTreeNode parent = name2Node.get(parentName);

            MultiTreeNode child = new MultiTreeNode(childName);
            name2Node.put(childName, child);
            child.parent = parent;
            parent.children.add(child);
        }

        public void death(String name) {
            name2Node.get(name).alive = false;
        }

        public List<String> getInheritanceOrder() {
            List<String> order = new ArrayList<>();
            successor(king, order);
            return order;
        }

        private void successor(MultiTreeNode parent, List<String> order) {
            if (parent.alive) order.add(parent.name);
            for (MultiTreeNode child : parent.children) {
                successor(child, order);
            }
        }

        class MultiTreeNode {
            String name;
            MultiTreeNode parent;
            List<MultiTreeNode> children = new ArrayList<>();
            boolean alive = true;

            public MultiTreeNode(String name) {
                this.name = name;
            }
        }
    }

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */

}
