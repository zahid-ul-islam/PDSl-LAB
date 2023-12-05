import socket

# Create a socket object
client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# Connect to the server
host = '127.0.0.1'  # Use the same host as the server
port = 12345         # Use the same port as the server
client_socket.connect((host, port))

# Receive the welcome message from the server
welcome_message = client_socket.recv(1024).decode()
print(welcome_message)

# Send data to the server
data_to_send = "Hello, server!"
client_socket.send(data_to_send.encode())

# Close the socket
client_socket.close()
