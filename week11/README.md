# Week 11 – Python Applications

This folder contains six standalone programs for the Week 11 application programming exercises.

## Requirements

- Python 3
- For symbolic mathematics: `pip install sympy`
- For finite automata: `pip install automata-lib`

## Programs

| File | Description | Run |
|---|---|---|
| `1_tcp_student_results_server.py` | TCP server that looks up a register number and returns a result | `python 1_tcp_student_results_server.py` |
| `1_tcp_student_results_client.py` | TCP client that requests a student's result | `python 1_tcp_student_results_client.py` |
| `2_udp_temperature_server.py` | UDP server that receives and displays readings | `python 2_udp_temperature_server.py` |
| `2_udp_temperature_client.py` | UDP client that sends temperature readings | `python 2_udp_temperature_client.py` |
| `3_sympy_algebra.py` | Expand, factor, simplify and solve a quadratic equation | `python 3_sympy_algebra.py` |
| `4_sympy_vehicle_motion.py` | Differentiate displacement and integrate over an interval | `python 4_sympy_vehicle_motion.py` |
| `5_dfa_binary_ending_01.py` | DFA accepts binary strings ending in `01` | `python 5_dfa_binary_ending_01.py` |
| `6_nfa_contains_ab.py` | NFA accepts strings containing substring `ab` | `python 6_nfa_contains_ab.py` |

## How to run the network programs

1. Open two terminals on the same computer.
2. Start the relevant server first.
3. Run its client in the other terminal.
4. The clients connect to `127.0.0.1` on the port specified in the source.

For another computer on the network, change the client host to the server computer's LAN IP address and allow the selected port through its firewall.

The TCP example uses a small in-memory sample student result dictionary. Replace it with a database lookup for a real deployment. The UDP example sends one reading per datagram; UDP does not guarantee delivery or ordering.
