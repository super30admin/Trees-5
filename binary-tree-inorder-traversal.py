# Morris traversal, takes n + n time. tc O(n), sc O(1).
curr = root
inorder = []

while curr:
    if not curr.left:
        inorder.append(curr.val)
        curr = curr.right
    else:
        rightmost = curr.left
        while (rightmost.right and rightmost.right != curr):
            rightmost = rightmost.right
        
        if not rightmost.right:
            rightmost.right = curr
            curr = curr.left
        else:
            rightmost.right = None
            inorder.append(curr.val)
            curr = curr.right

return inorder