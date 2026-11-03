"""TCP server: receive a register number and return the student's result."""

import socket

HOST = "127.0.0.1"
PORT = 5000

# Sample data. Replace this dictionary with a database query when needed.
RESULTS = {
    "101": "Pass - 8.4 CGPA",
    "102": "Pass - 9.1 CGPA",
    "103": "Fail - Reappear required",
}


def main():
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as server:
        server.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
        server.bind((HOST, PORT))
        server.listen()
        print(f"Result server listening on {HOST}:{PORT}")

        while True:
            connection, address = server.accept()
            with connection:
                print("Connected:", address)
                register_number = connection.recv(1024).decode().strip()
                result = RESULTS.get(register_number, "Register number not found")
                connection.sendall(result.encode())
                print(f"{register_number}: {result}")


if __name__ == "__main__":
    main()
