:- use_module(rules, []).

diagnosis(X):-
  rules:get_by_colors(X),
  rules:get_by_places(X),
  rules:get_by_factors(X),
  rules:get_by_shapes(X).
