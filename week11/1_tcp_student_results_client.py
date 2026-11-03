"""TCP client: request a student's examination result."""

import socket

HOST = "127.0.0.1"
PORT = 5000


def main():
    register_number = input("Enter register number: ").strip()
    if not register_number:
        print("Register number cannot be empty.")
        return

    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as client:
        try:
            client.connect((HOST, PORT))
            client.sendall(register_number.encode())
            result = client.recv(1024).decode()
            print("Examination result:", result)
        except ConnectionRefusedError:
            print("Cannot connect. Start the TCP result server first.")
        except OSError as error:
            print("Network error:", error)


if __name__ == "__main__":
    main()
