"""UDP server: receive and display temperature readings."""

import socket

HOST = "127.0.0.1"
PORT = 5001


def main():
    with socket.socket(socket.AF_INET, socket.SOCK_DGRAM) as server:
        server.bind((HOST, PORT))
        print(f"Temperature server listening on {HOST}:{PORT}")
        print("Press Ctrl+C to stop.")

        try:
            while True:
                data, address = server.recvfrom(1024)
                message = data.decode(errors="replace").strip()
                print(f"Temperature from {address}: {message}")
        except KeyboardInterrupt:
            print("\nServer stopped.")


if __name__ == "__main__":
    main()
