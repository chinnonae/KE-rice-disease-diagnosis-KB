:- module(rules, []).
:- use_module(colors, []).
:- use_module(inputs, []).
:- use_module(shapes, []).
:- use_module(places, []).
:- use_module(factors, []).

get_by_colors(X, Color):-
  ((Color == none) -> true; colors:color(Color,X)).

get_by_places(X, Place):-
  ((Place == none) -> true; places:place(Place, X)).

get_by_factors(X, Factor):-
  ((Factor == none) -> true; factors:factor(Factor, X)).

get_by_shapes(X, Shape):-
  ((Shape == none) -> true; shapes:shape(Shape, X)).
