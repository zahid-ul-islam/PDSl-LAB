import socket

# Create a socket object
server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# Bind the socket to a specific address and port
host = '127.0.0.1'  # Use localhost
port = 12345         # Choose a port number
server_socket.bind((host, port))

# Listen for incoming connections
server_socket.listen()

print(f"Echo Server is listening on {host}:{port}")

while True:
    # Accept a connection from a client
    client_socket, client_address = server_socket.accept()
    print(f"Accepted connection from {client_address}")

    # Receive and echo data back to the client
    data = client_socket.recv(1024).decode()
    print(f"Received data from client: {data}")

    # Echo the data back to the client
    client_socket.send(data.encode())
    print("Sent echoed data back to the client")

    # Close the client socket
    client_socket.close()
