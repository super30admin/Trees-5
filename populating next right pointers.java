//Time complexity:-0(n*no of leaves).
//Space complexity:- O(n);
//Did it run on leetcode:- Yes.
//What problems did you face?:- initially after levelorder traversing found difficulty in linking.
//Your code with approach:- first llevel order traversal is done and stored in list of list. next iteratiing in that list and linking next nodes.


class Solution {
    List<List<Node>> cache=new ArrayList<>();
    public Node connect(Node root) {
        bfs(root,0);
        Node root1=null;
        for(int i=0;i<cache.size();i++){
            for(int j=0;j<cache.get(i).size();j++){
                root1=cache.get(i).get(j);
                if(root1!=cache.get(i).get(cache.get(i).size()-1))
                    root1.next=cache.get(i).get(j+1);
            }
        }
       return root; 
    }
    private void bfs(Node root,int h){
        if(root==null){
            return;
        }
        if(h>=cache.size()){
            cache.add(new ArrayList<>());
        }
        cache.get(h).add(root);
        bfs(root.left,h+1);
        bfs(root.right,h+1);
    }
}