# 📚 Data Structures in Python: Stack, Queue, and Deque

---

## 🔹 1. Stack (LIFO - Last In, First Out)
A stack is a linear data structure that follows the Last In First Out (LIFO) principle — the last element added is the first to be removed.

### Common Operations:
- push(item) – Add item to top
- pop() – Remove item from top
- peek() – View top item without removing

### 🧪 Example : Using List
stack = []
stack.append(10)    # push
stack.append(20)
print(stack.pop())  # pop -> 20
print(stack[-1])    # peek -> 10

---

## 🔸 2. Queue (FIFO - First In, First Out)
A queue is a linear data structure that follows the First In First Out (FIFO) principle — the first element added is the first to be removed.

### Common Operations:
- enqueue(item) – Add item to rear
- dequeue() – Remove item from front

### 🧪Example : Using queue.Queue
from queue import Queue
q = Queue()
q.put(1)             # enqueue
q.put(2)
q.get()              # dequeue -> 1

---

## 🔹 3. Deque (Double-Ended Queue)
A deque supports insertion and deletion from both ends — front and rear.

### Common Operations:
- append(item) – Add to right
- appendleft(item) – Add to left
- pop() – Remove from right
- popleft() – Remove from left

### 🧪Example : Using collections.deque
from collections import deque
dq = deque()
dq.append(10)         # right
dq.appendleft(5)      # left
print(dq)             # deque([5, 10])
dq.pop()              # -> 10
dq.popleft()          # -> 5

---