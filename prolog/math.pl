count(0,[]). % the base case; an empty list has count 0
count(Count,[_|T]) :- count(TCount, T), Count is TCount + 1. % note the "is" operator

sum(0,[]).
sum(Total,[H|T]) :- sum(Sum,T), Total is H + Sum.

% I'm guessing prolog handles the type checking for average?
average(Avg, List) :- sum(Sum,List), count(Count,List), Avg is Sum/Count.
