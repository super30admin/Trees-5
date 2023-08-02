//Time Complexity: O(h)
//Space Complexity: O(h)

class Solution {

    class Next {
        Node node;
        int lvl;
        public Next(Node node, int lvl) {
            this.node = node;
            this.lvl = lvl;
        }
    }
    public Node connect(Node root) {
        
      
        Queue<Next> q = new LinkedList<>();
        HashMap<Integer, List<Node>> map = new HashMap<>();
        q.add(new Next(root, 0));

        map.put(0, new ArrayList());
        map.get(0).add(root);

        while(!q.isEmpty()) {
            Next pointer = q.poll();
            int lvl = pointer.lvl;
            lvl++;
            Node curr = pointer.node;

            if(curr != null && curr.left != null) {
                if(!map.containsKey(lvl)) {
                     map.put(lvl, new ArrayList());
                }
                
                map.get(lvl).add(curr.left);
                q.add(new Next(curr.left, lvl));
            }

            if(curr != null && curr.right != null) {
                if(!map.containsKey(lvl)) {
                    map.put(lvl, new ArrayList());
                }
                map.get(lvl).add(curr.right);
                q.add(new Next(curr.right, lvl));
            }
        }

        Node currParent = root;
        for(int lvl : map.keySet()) {
            Node root1 = currParent;
            int idx = 0;
            for(Node curr: map.get(lvl)) {
                if(idx > 0) {
                    if(root1 != null) {
                        root1.next = curr;
                        root1 = root1.next;
                    }
                }
                idx++;
            }
            if(currParent!= null && currParent.left != null) {
                currParent = currParent.left;
            }
        }

        return root;
    }

}