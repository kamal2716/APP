# Question 2: Salary revision using map(), filter(), and lambda
from functools import reduce

salaries = [35000, 42000, 28000, 50000, 39000]

# b) Employees eligible for a 10% increment
eligible = list(filter(lambda salary: salary < 40000, salaries))
print("Eligible salaries:", eligible)

# a) Revise eligible salaries by 10%; other salaries remain unchanged
revised_salaries = list(map(lambda salary: salary * 1.10 if salary < 40000 else salary, salaries))
print("Revised salaries:", revised_salaries)

# c) Total salary expenditure after revision
total_expenditure = reduce(lambda total, salary: total + salary, revised_salaries, 0)
print("Total salary expenditure after revision: ₹", round(total_expenditure, 2))

# d) Functional tools process each salary consistently and make transformations concise.
