#nodes belong to a tree
class Node
  def initialize(parent, lNode, rNode)
    @parent = self.parent
    @lNode = self.left #?
    @rNode = self.right#?
  end
end

myTree = Tree.new(5, [2, 7, 3, 2, 8])
p myTree.size
p myTree.printTree
2node = Node.new(nil, nil, nil)


#transform input into a tree, then mutate tree?
#string -> [ints]?
def createTree
  #size = depth of tree? 
  #self.parent = data[0]
  #get pairs from rest? [-1,-1] or [1,2]
  #self.right = 
end

# ::Main //string-> string
def main
  #will these vars need to be global? to be available to methods?
  #raw input = size
  #
end

