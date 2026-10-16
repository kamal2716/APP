# Question 3: Product discounts using a pure function
prices = [500, 1200, 2500, 999, 1800]

# a) Pure function: returns a discounted price and does not change its input
def discounted_price(price):
    if price > 1000:
        return price * 0.80
    return price

# b) Apply the function to every price using map()
discounted_prices = list(map(discounted_price, prices))
print("Original prices:", prices)
print("Prices after discount:", discounted_prices)

# c) Identify products costing more than ₹1,000
eligible_prices = list(filter(lambda price: price > 1000, prices))
print("Products costing more than ₹1,000:", eligible_prices)

# d) The function returns a new value and never modifies the original list or its elements.
