:- use_module(rules, []).

diagnosis(X, Color, Shape, Place, Factor, Stage):-
  rules:get_by_colors(X, Color),
  rules:get_by_places(X, Place),
  rules:get_by_factors(X, Factor),
  rules:get_by_shapes(X, Shape),
  rules.get_by_stages(X, Stage)