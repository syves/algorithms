class Tree
  def initialize(size, data)
    @size = size #array of size n
    @data = data #array of size n
  end
  def size
    @size
  end
  def printTree
    @data.map {|x| x.to_s}.join(',')
  end
end

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
