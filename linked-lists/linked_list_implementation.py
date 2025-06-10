#singly linked list

class Node :
    def __init__(self , value ) :
        self.value = value
        self.nextNode = None
        
first_node = Node(10)
second_node = Node(20)
third_node = Node(30)

print(f"First Node Value : {first_node.value}")
print(f"Second Node Value : {second_node.value}")
print(f"Third Node Value : {third_node.value}")

first_node.nextNode = second_node
second_node.nextNode = third_node

print(f"first_node.nextNode.value : {first_node.nextNode.value}")
print(f"first_node.nextNode.nextNode.value : {first_node.nextNode.nextNode.value}")


# doubly linked lists

class DoublyNode :
    def __init__(self , value) :
        self.value = value 
        self.nextNode = None
        self.prevNode = None
        
x = DoublyNode(10)
y = DoublyNode(20)
z = DoublyNode(30)

print(f" x value : {x.value}")
print(f" y value : {y.value}")
print(f" z value : {z.value}")

x.nextNode = y
y.nextNode = z

z.prevNode = y
y.prevNode = x
print(x.nextNode.value)
print(z.prevNode.value)



