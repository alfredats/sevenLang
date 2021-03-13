class Tree
  # this tells ruby that we want .children and .node_name as instance variables, with accessor and setter methods with the same name
  attr_accessor :children, :node_name
  # if we used the 'attr' keyword instead, we only get the instance variable & an accessor (instance variable will not have setter method)

  def initialize(name, children=[])
    @children  = children       # instance variables are denoted by preceding '@', class variables '@@''
    @node_name = name
  end

  def visit_all(&block)
    visit &block
    children.each { |e| e.visit_all &block }
  end

  def visit(&block)
    block.call self
  end
end

ruby_tree = Tree.new( "ruby",
                      [ Tree.new("Reia"),
                        Tree.new("MacRuby")
                      ])

puts "Visiting a node"
ruby_tree.visit { |node| puts node.node_name }
puts

puts "visiting entire tree"
ruby_tree.visit_all { |node| puts node.node_name }
