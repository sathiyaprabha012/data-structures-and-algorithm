class Node :
    def __init__(self , value) :
        self.value = value
        self.left = None
        self.right = None
        
class BST :
    
    def __init__(self) :
        self.root = None
        
    def insert(self , root ,value) :
        if root is None :
            return Node(value)
        if(value < root.value) :
            root.left = self.insert(root.left , value)
        else :
            root.right = self.insert(root.right , value)
        return root
    
    def inorder(self , root) :
        if root :
            self.inorder(root.left)
            print(root.value , end = " ")
            self.inorder(root.right)
            
    def contains(self , root , search_value) :
        if root is None :
            return False 
        if root.value == search_value :
            return True
        elif search_value < root.value :
            return self.contains(root.left , search_value)
        else :
            return self.contains(root.right , search_value)
        
            
            
        
        
bst = BST()
bst.root = bst.insert(bst.root , 10)
bst.root = bst.insert(bst.root , 20 )
bst.root = bst.insert(bst.root , 5 )

bst.inorder(bst.root)
print(bst.contains(bst.root , 90))
print(bst.contains(bst.root , 20))


'''
# Without using recursion :
class BinarySearchTree:
    
    def __init__(self):
        self.root = None

    def insert(self, value):
        
        newNode = Node(value)
        
        if self.root is None:
            
            self.root = newNode
            return True
        
        tempNode = self.root
        
        while True:
            
            if newNode.value == tempNode.value:
                return False
            
            if newNode.value < tempNode.value:
                if tempNode.left is None:
                    tempNode.left = newNode
                    return True
                tempNode = tempNode.left
            
            else: 
                if tempNode.right is None:
                    tempNode.right = newNode
                    return True
                tempNode = tempNode.right

    def contains(self, value):
        tempNode = self.root
        
        while tempNode:
            if value < tempNode.value:
                tempNode = tempNode.left
            elif value > tempNode.value:
                tempNode = tempNode.right
            else:
                return True
        return False
        
    def minOfNode(self,currentNode):
        while currentNode.left:
            currentNode = currentNode.left
        return currentNode
    
    def maxOfNode(self,currentNode):
        while currentNode.right:
            currentNode = currentNode.right
        return currentNode

myTree = BinarySearchTree()

print(myTree.insert(10))    # True
print(myTree.insert(10))    # False (duplicate)
print(myTree.insert(8))     # True
print(myTree.insert(20))    # True
print(myTree.insert(25))    # True
print(myTree.insert(16))    # True

print(myTree.contains(16))  # True
print(myTree.contains(10))  # True
print(myTree.contains(19))  # False

print(myTree.root.value)                    # 10
print(myTree.root.right.value)              # 20
print(myTree.root.right.right.value)        # 25
print(myTree.root.left.value)               # 8

print(myTree.minOfNode(myTree.root).value)  # 8
print(myTree.maxOfNode(myTree.root).value)  # 25
'''