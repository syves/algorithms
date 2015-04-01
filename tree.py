class Tree():
    def __init__(self):
        self.root = None

    def __str__(self):
        if self.root:
            return self.root
        else:
            return 'this tree has no values'

    #add val for tree should check it root has node or not, simplefied  add function, if not add one
    #if it does calls root.add_value(value)

    #most of this belongs in nodes add val fucntion
    #printing tree rcursively
    def add_value(self, value):
        if value < self.root:
            if self.left.value == None:
                self.left = Node(value)
                return
            else:
                self.left.add_value(value)
        elif value > self.root:
            if self.right.value == None:
                self.right = Node(value)
                return
            else:
                self.right.add_value(value)

class Node():
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

    def __str__(self):
        if self.value:
            return str(self.value)
        else:
            return 'this node has no values'

my_tree = Tree()
my_tree.add_value(34)
my_tree.add_value(2)
my_tree.add_value(10)
my_tree.add_value(58)


