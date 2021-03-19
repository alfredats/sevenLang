reverse([H|T],List) :-
    reverse(T,Hprime),
    append(Hprime,[H],List).
