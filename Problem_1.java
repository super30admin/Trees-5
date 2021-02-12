// Time Complexity :O(n)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    TreeMap<Integer,List<Node>> map;
    public Node connect(Node root) {
        map=new TreeMap<Integer,List<Node>>();
        dfs(root,1);
		//I have commented these lines as I can save this extra iteration by directly connecting the values by getting it from map in my dfs function.
		
        //System.out.println(map);
        // for(List<Node> list:map.values()){
        //     if(list.size()==1){
        //         continue;
        //     }else{
        //         for(int i=0;i<list.size();i++){
        //             if(i==list.size()-1){
        //                 list.get(i).next=null;
        //             }else{
        //                 list.get(i).next=list.get(i+1);
        //             }
        //         }
        //     }
        // }
        return root;
    }
    
    public void dfs(Node node,int level){
        if(node==null){
            return;
        }
        if(map.containsKey(level)){
            node.next=map.get(level).get(0);
            map.get(level).set(0,node);
        }else{
            List<Node> list=new ArrayList<>();
            node.next=null;
            list.add(node);
            map.put(level,list);
        }
        dfs(node.right,level+1);
        dfs(node.left,level+1);
        
    }
}

//The below code is even more space effiecient.In this I have remove the dependecy of using extra arraylist in the hashmap.
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    TreeMap<Integer,Node> map;
    public Node connect(Node root) {
        map=new TreeMap<Integer,Node>();
        dfs(root,1);
        return root;
    }
    
    public void dfs(Node node,int level){
        if(node==null){
            return;
        }
        if(map.containsKey(level)){
            node.next=map.get(level);
            map.put(level,node);
        }else{
            map.put(level,node);
        }
        dfs(node.right,level+1);
        dfs(node.left,level+1);
        
    }
}