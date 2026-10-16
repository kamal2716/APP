% Question 5: Eligibility for the advanced programming course.
% Save as Course_Eligibility.pl and run in SWI-Prolog.

python_result(arun, pass).
data_structures_result(arun, pass).

python_result(bala, pass).
data_structures_result(bala, fail).

python_result(charan, pass).
data_structures_result(charan, pass).

python_result(divya, fail).
data_structures_result(divya, pass).

eligible(Student) :-
    python_result(Student, pass),
    data_structures_result(Student, pass).

% Query:
% ?- eligible(Student).
% Expected results: Student = arun ; Student = charan.
