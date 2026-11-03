"""UDP client: send temperature readings to the monitoring server."""

import socket

HOST = "127.0.0.1"
PORT = 5001


def main():
    with socket.socket(socket.AF_INET, socket.SOCK_DGRAM) as client:
        print("Enter a temperature or q to quit.")
        while True:
            reading = input("Temperature (°C): ").strip()
            if reading.lower() == "q":
                break

            try:
                temperature = float(reading)
            except ValueError:
                print("Please enter a valid number.")
                continue

            message = f"{temperature:.2f} °C"
            client.sendto(message.encode(), (HOST, PORT))
            print("Sent:", message)


if __name__ == "__main__":
    main()
