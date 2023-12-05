import socket

# Create a UDP socket
server_socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

# Bind the socket to a specific address and port
host = '127.0.0.1'  # Use localhost
port = 12345         # Choose a port number
server_socket.bind((host, port))

print(f"UDP File Server is listening on {host}:{port}")

# Set the maximum size for the received datagram
buffer_size = 4096

while True:
    # Receive file data and client address
    file_data, client_address = server_socket.recvfrom(buffer_size)

    # Extract filename from the received data
    filename = file_data.decode()

    # Receive file content
    file_content, _ = server_socket.recvfrom(buffer_size)

    # Save the received file
    with open(filename, 'wb') as file:
        file.write(file_content)

    print(f"File '{filename}' received and saved.")
