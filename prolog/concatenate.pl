% this is our base case; appending an empty list to anything returns itself.
concatenate([],List,List).

concatenate([H|[]], List, [H|List]) % concatenating a single-element list to another list.
concatenate([H1|[H2|[]]],List, [H1,H2|List]).
concatenate([H1|[H2|[H3|[]]]],List, [H1,H2,H3|List])

% ... so on and so forth...


% we can generalize the inductive rules as follows:
concatenate([H|T1],List,[H|T2]) :- concatenate(T1,List,T2).
% recall that Y :- X is read as: if X then Y (X implies Y)
% the above statement then reads as
%       if the concatenation of the first list's tail & the second list is the third lists tail,
%           and the heads of the first and third lists are the same,
%               then the concatenation of the first list and the second list is the third.
%
% concretely,
%   this means that the tail of the first list is traversed until we reach an empty list,
%       then the base case is proven true, after which the recursed implications are inductively true as well.
