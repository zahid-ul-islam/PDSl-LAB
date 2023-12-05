import socket

# Create a socket object
client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# Connect to the echo server
host = '127.0.0.1'  # Use the same host as the server
port = 12345         # Use the same port as the server
client_socket.connect((host, port))

# Send data to the server
data_to_send = "Hello, server! This is an echo test."
client_socket.send(data_to_send.encode())
print(f"Sent data to server: {data_to_send}")

# Receive echoed data from the server
echoed_data = client_socket.recv(1024).decode()
print(f"Received echoed data from server: {echoed_data}")

# Close the socket
client_socket.close()
