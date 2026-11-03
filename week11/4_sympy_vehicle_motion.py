"""Differentiate displacement to find velocity/acceleration and integrate it."""

import sympy as sp


def main():
    t = sp.symbols("t")
    s = t**3 - 6*t**2 + 9*t + 5

    velocity = sp.diff(s, t)
    acceleration = sp.diff(velocity, t)

    print("Displacement s(t):", s)
    print("Velocity v(t):", velocity)
    print("Acceleration a(t):", acceleration)
    print("Times when vehicle is at rest:", sp.solve(velocity, t))

    start = float(input("Integration start time: "))
    end = float(input("Integration end time: "))
    displacement_change = sp.integrate(velocity, (t, start, end))
    print(f"Displacement change from {start} to {end}:", displacement_change)


if __name__ == "__main__":
    main()
