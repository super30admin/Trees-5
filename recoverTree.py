class Solution:
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """-.*3.63...0
        Do not return anything, modify root in-place instead.
        """
        '''
        Inorder of a BST is in increasing order. 
        so we declare 2 var first and second
        the first time we encounter prev.val > root.val --> we Try to catch the prev 
        the 2nd time we we encounter prev.val > root.val --> we Try to catch the curr root
        
        Eg : 
        Test case : [10, 5, 8, 2, 20, null, null]
        In Order : 2 5 20 10 8  --> The nodes to be swapped are 20 and 8 
                       P   R     --> 1st encounter
                           P  R  --> 2nd encounter
                           
        '''
        def inorder(root):
            nonlocal first, second, prev 
            if not root:
                return 
            inorder(root.left)
            if prev and root.val < prev.val:
                second = root
                if first is None:
                    first = prev
            prev = root
            inorder(root.right)
            
        first = second = prev = None 
        inorder(root)
        first.val , second.val = second.val , first.val
 
    def bruteForcerecoverTree(self, root: Optional[TreeNode]) -> None:
        """-.*3.63...0
        Do not return anything, modify root in-place instead.
        """
        '''
        Inorder of a BST is in increasing order. 
        Time Complexity = O(N)
        Space Complexity = O(N)
        '''
        def inorder(root):
            nonlocal r
            if not root:
                return 
            inorder(root.left)
            r.append(root)
            inorder(root.right)
            
        r =[] 
        inorder(root)
        srt = []
        for i in r:
            srt.append(i.val)
        srt = sorted(srt)
        for i in range(len(r)):
            r[i].val = srt[i]
        return root
