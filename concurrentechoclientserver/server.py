import socket
import threading

def handle_client(client_socket):
    while True:
        # Receive data from the client
        data = client_socket.recv(1024).decode()
        if not data:
            break  # Break the loop if no data is received

        print(f"Received data from client: {data}")

        # Echo the data back to the client
        client_socket.send(data.encode())
        print("Sent echoed data back to the client")

    # Close the client socket when the loop is exited
    client_socket.close()
    print("Closed connection with a client")

# Create a socket object
server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# Bind the socket to a specific address and port
host = '127.0.0.1'  # Use localhost
port = 12345         # Choose a port number
server_socket.bind((host, port))

# Listen for incoming connections
server_socket.listen()

print(f"Concurrent Echo Server is listening on {host}:{port}")

while True:
    # Accept a connection from a client
    client_socket, client_address = server_socket.accept()
    print(f"Accepted connection from {client_address}")

    # Create a new thread for each client
    client_thread = threading.Thread(target=handle_client, args=(client_socket,))
    client_thread.start()
