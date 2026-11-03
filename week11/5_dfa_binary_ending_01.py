"""DFA over {0,1} that accepts exactly the binary strings ending in 01."""

from automata.fa.dfa import DFA


def main():
    dfa = DFA(
        states={"q0", "q1", "q2"},
        input_symbols={"0", "1"},
        transitions={
            "q0": {"0": "q1", "1": "q0"},
            "q1": {"0": "q1", "1": "q2"},
            "q2": {"0": "q1", "1": "q0"},
        },
        initial_state="q0",
        final_states={"q2"},
    )

    test_strings = ["01", "101", "0001", "10", "011", "111", ""]
    for value in test_strings:
        answer = "Accepted" if dfa.accepts_input(value) else "Rejected"
        print(f"{value!r}: {answer}")


if __name__ == "__main__":
    main()
