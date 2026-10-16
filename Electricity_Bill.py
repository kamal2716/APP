# Question 4: Electricity consumption and bill
from functools import reduce

consumption = [8, 12, 9, 15, 11]  # units consumed each day
RATE_PER_UNIT = 6

# a) Days with consumption exceeding 10 units
high_consumption_days = list(filter(lambda units: units > 10, consumption))
print("Consumption above 10 units:", high_consumption_days)

# b) Cost for each day at ₹6 per unit
daily_costs = list(map(lambda units: units * RATE_PER_UNIT, consumption))
print("Daily electricity costs (₹):", daily_costs)

# c) Total electricity consumption
total_units = reduce(lambda total, units: total + units, consumption, 0)
print("Total electricity consumption:", total_units, "units")

# d) Pure function: calculates bill without modifying the original data
def calculate_bill(units_list):
    return sum(units_list) * RATE_PER_UNIT

print("Total electricity bill: ₹", calculate_bill(consumption))
print("Original consumption data:", consumption)
