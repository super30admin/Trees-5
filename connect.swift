// Time Complexity : 0(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

       func connect(_ root: Node?) -> Node? {
        if root == nil {
            return root
        }
        var level = root
        var current = root
        var previous : Node? = nil
        while level != nil {
            while current != nil {
                current?.left?.next = current?.right
                previous?.right?.next = current?.left
                previous = current
                current = current?.next
            }
            level = level?.left
            current = level
            previous = nil
        }
        return root
    }
  
   
