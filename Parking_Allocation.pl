% Question 7: Rule-based parking slot allocation.
% Save as Parking_Allocation.pl and run in SWI-Prolog.

parking_slot(s1, car, available).
parking_slot(s2, bike, occupied).
parking_slot(s3, car, available).
parking_slot(s4, bike, available).
parking_slot(s5, car, occupied).

available_slot(VehicleType, Slot) :-
    parking_slot(Slot, VehicleType, available).

% Query for available car parking slots:
% ?- available_slot(car, Slot).
% Expected results: Slot = s1 ; Slot = s3.
