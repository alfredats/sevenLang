    secret_number = rand(10)
    guessed_number = nil
    until guessed_number == secret_number
        puts "Pick a number from 0 to 10" if guessed_number.nil?
        guessed_number = gets.chomp.to_i
        puts "Too higher, try lower" if guessed_number > secret_number
        puts "Too low, try higher"   if guessed_number < secret_number
    end
    puts "You guessed it!"
