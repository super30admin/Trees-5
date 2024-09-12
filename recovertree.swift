// Time Complexity : 0(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

   var x :  TreeNode? = nil
    var y : TreeNode? = nil
    var previous : TreeNode? = nil
    func recoverTree(_ root: TreeNode?) {
        var current: TreeNode? = root
        var stack: [TreeNode] = []
        while current != nil || !stack.isEmpty {
            if let node = current {
                stack.append(node)
                current = node.left
            } else {
                 let node = stack.popLast()
                if let prev = previous, let node = node {
                    if node.val < prev.val  {
                       y = node
                        if x != nil {
                           break 
                        }
                        x = prev
                    } 
                    
                }
                previous = node  
                current = node?.right
                
            }
        }
        swap(x,y)

    }
    func swap(_ n1: TreeNode?,_ n2: TreeNode?) {
        guard let n1 = n1, let n2 = n2 else {return}
       var temp = n1.val
       n1.val = n2.val
       n2.val = temp
    }   
   
