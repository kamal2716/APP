# Question 1: Student marks using functional programming
from functools import reduce

students = [("Arun", 45), ("Bala", 72), ("Charan", 38), ("Divya", 90)]

# a) Students who scored 50 or above
qualified = list(filter(lambda student: student[1] >= 50, students))
print("Students scoring 50 or above:", qualified)

# b) Add 5 grace marks, without exceeding 100
updated_students = list(map(lambda student: (student[0], min(student[1] + 5, 100)), students))
print("Marks after grace marks:", updated_students)

# c) Total marks after grace marks
total_marks = reduce(lambda total, student: total + student[1], updated_students, 0)
print("Total marks after grace marks:", total_marks)

# d) Lambda functions make short operations easy to pass to filter(), map(), and reduce().
