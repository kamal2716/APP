"""Use SymPy to expand, factor, simplify and solve a quadratic."""

import sympy as sp


def main():
    x = sp.symbols("x")

    expression = (x + 2) ** 2
    print("Original expression:", expression)
    print("Expanded:", sp.expand(expression))
    print("Factorized:", sp.factor(x**2 + 5*x + 6))
    print("Simplified:", sp.simplify((x**2 - 1) / (x - 1)))

    equation = sp.Eq(x**2 - 5*x + 6, 0)
    print("Quadratic equation:", equation)
    print("Solutions:", sp.solve(equation, x))


if __name__ == "__main__":
    main()
