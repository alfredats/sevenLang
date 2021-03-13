module ToFile
  def filename
    "object_#{self.object_id}.txt"
    # recall that ruby functions must return a value
    # in this case, it returns the value of the last line within the function,
    # which is the string.
    #
    # The string itself also is formatted with #{}
  end

  def to_f
    File.open(filename,'w') { |f| f.write(to_s) }
  end
end

class Person
  include ToFile
  attr_accessor :name

  def initialize(name)
    @name = name
  end

  def to_s
    name
  end
end

Person.new('matz').to_f
