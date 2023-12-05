import socket

# Create a UDP socket
server_socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

# Bind the socket to a specific address and port
host = '127.0.0.1'  # Use localhost
port = 12345         # Choose a port number
server_socket.bind((host, port))

print(f"UDP Server is listening on {host}:{port}")

while True:
    # Receive data from the client
    data, client_address = server_socket.recvfrom(1024)
    print(f"Received data from client at {client_address}: {data.decode()}")

    # Echo the data back to the client
    server_socket.sendto(data, client_address)
    print("Sent echoed data back to the client")
