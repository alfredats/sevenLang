dependents(X) :-
  dependants(Y),
  X is Y.

dependants(X) :-
  dependents(Y),
  X is Y.

min_savings(MS) :-
  dependants(Y),
  MS is 5000 * Y.

savings_account(adequate) :-
  amount_saved(X),
  min_savings(MS),
  X >= MS.

savings_account(inadequate) :-
  amount_saved(X),
  min_savings(MS),
  X < MS.

minimum_income(MI) :-
  dependants(Y),
  MI is 15000 + 4000 * Y.


income(adequate) :-
  earnings(Z,steady),
  minimum_income(MI),
  Z >= MI.

income(inadequate) :-
  earnings(Z,steady),
  minimum_income(MI),
  Z < MI.

income(inadequate) :-
  earnings(Z,unsteady).


invest(savings) :-
  savings_account(inadequate).

invest(combination) :-
  savings_account(adequate),
  income(inadequate).

invest(stocks) :-
  savings_account(adequate),
  income(adequate).



% Test Cases

% Test case 0a : dependents-dependants alias
% MODEL:
% { dependents(5),  dependants(5) }
%
% BINDINGS:
% X = 5

% Uncomment to run
% dependants(5).
% ?- dependents(X).

% Test case 0b : dependents-dependants alias
% MODEL:
% { dependants(5),  dependents(5) }
%
% BINDINGS:
% X = 5

% Uncomment to run
% dependents(5).
% ?- dependants(X).

% Test case 1 : inadequate savings for dependants
% Expected output:
% MODEL:
% { savings_account(inadequate),  amount_saved(1000),  min_savings(25000),  dependants(5) }
%
% BINDINGS:
% SA = inadequate

% Uncomment to run
% amount_saved(1000).
% dependants(5).
% ?- savings_account(SA).



% % Test case 2 : adequate savings for dependants
% MODEL:
% { savings_account(adequate),  amount_saved(100000000000000000000),  min_savings(25000),  dependants(5) }
%
% BINDINGS:
% SA = adequate

% Uncomment to run
% amount_saved(100000000000000000000).
% dependants(5).
% ?- savings_account(SA).



% % Test case 3 : income adequate
% MODEL:
% { income(adequate),  earnings(100000000000000000,steady),  minimum_income(35000),  dependants(5) }
%
% BINDINGS:
% I = adequate

% Uncomment to run
% dependants(5).
% earnings(100000000000000000,steady).
% ?- income(I).



% % Test case 4 : income inadequate (not enough earnings for no. of dependants)
% MODEL:
% { income(inadequate),  earnings(10,steady),  minimum_income(35000),  dependants(5) }
%
% BINDINGS:
% I = inadequate

% Uncomment to run
% dependants(5).
% earnings(10,steady).
% ?- income(I).



% % Test case 5 : income inadequate (earnings unsteady)
% MODEL:
% { income(inadequate),  earnings(10000000000000000000000,unsteady) }
%
% BINDINGS:
% I = inadequate

% Uncomment to run
% dependants(5).
% earnings(10000000000000000000000,unsteady).
% ?- income(I).



% Test case 6: savings recommended
% MODEL:
% { invest(savings),  savings_account(inadequate),  amount_saved(1),  min_savings(495000),  dependants(99) }
%
% BINDINGS:
% Strategy = savings

% Uncomment to run
% dependants(99).
% amount_saved(1).
% earnings(1,steady).
% ?- invest(Strategy).



% Test case 7: combination recommended
% MODEL:
% { invest(combination),  savings_account(adequate),  amount_saved(20000),  min_savings(5000),  dependants(1),  income(inadequate),  earnings(1,steady),  minimum_income(19000) }
%
% BINDINGS:
% Strategy = combination

% Uncomment to run
% dependants(1).
% amount_saved(20000).
% earnings(1,steady).
% ?- invest(Strategy).



% Test case 7: stocks recommended
% MODEL:
% { invest(stocks),  savings_account(adequate),  amount_saved(100000000000),  min_savings(0),  dependants(0),  income(adequate),  earnings(10000000,steady),  minimum_income(15000) }
%
% BINDINGS:
% Strategy = stocks


% Uncomment to run
% dependants(0).
% amount_saved(100000000000).
% earnings(10000000,steady).
% ?- invest(Strategy).


