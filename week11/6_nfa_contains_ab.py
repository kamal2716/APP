"""NFA over {a,b} that accepts strings containing the substring 'ab'."""

from automata.fa.nfa import NFA


def main():
    nfa = NFA(
        states={"q0", "q1", "q2"},
        input_symbols={"a", "b"},
        transitions={
            "q0": {"a": {"q0", "q1"}, "b": {"q0"}},
            "q1": {"b": {"q2"}},
            "q2": {"a": {"q2"}, "b": {"q2"}},
        },
        initial_state="q0",
        final_states={"q2"},
    )

    test_strings = ["ab", "aab", "baba", "abb", "aa", "ba", ""]
    for value in test_strings:
        answer = "Accepted" if nfa.accepts_input(value) else "Rejected"
        print(f"{value!r}: {answer}")


if __name__ == "__main__":
    main()
