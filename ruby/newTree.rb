class Tree
  include Enumerable
  attr_accessor :children, :node_name

  def initialize(init={})
    init.each do |key, value|
      @node_name = key
      @children = Tree.new(value)
    end
  end

  def visit(&block)
   block.call self
  end
end

ruby_tree = Tree.new( {"grandpa" => {"dad"   => {"child 1" => {}, "child 2" => {} },
                                     "uncle" => {"child 3" => {}, "child 4" => {} } } } )

# how to replicate previous behavior?
ruby_tree.visit do |node|
  puts node.node_name
  puts node.children
end
