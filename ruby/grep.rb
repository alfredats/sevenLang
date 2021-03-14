#!/nix/store/nbf3gwfs1cp1lks5lgn0rambhn6czb0r-ruby-2.6.6/bin/ruby
# Implement a simple grep
# - Grep takes 2 arguments, a regexp and a filename.

if ARGV.length != 2
  puts "Usage: ./grep.rb <pattern> <filename>"
  puts "Note: Ruby's regexp requires the expression sandwiched between two forward-slashes (/) "
end

pattern = Regexp.new(ARGV[0])
content = IO.readlines(ARGV[1])

puts pattern
puts content[0]
i = 0
begin
  if pattern.match(content[i])
    puts "#{i}: #{content[i]}"
  end
  i = i + 1
end while i < content.length
