% Question 6: Employee promotion eligibility.
% Save as Promotion_Eligibility.pl and run in SWI-Prolog.

employee(ravi, 6, completed, 5).
employee(priya, 3, completed, 4).
employee(kumar, 8, not_completed, 5).
employee(meena, 7, completed, 4).

eligible_for_promotion(Name) :-
    employee(Name, Years, Training, Rating),
    Years >= 5,
    Training = completed,
    Rating >= 4.

% Query:
% ?- eligible_for_promotion(Name).
% Expected results: Name = ravi ; Name = meena.
