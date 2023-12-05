import socket

# Create a UDP socket
client_socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

# Server address and port
server_host = '127.0.0.1'
server_port = 12345

# Send data to the server
data_to_send = "Hello, server! This is a UDP test."
client_socket.sendto(data_to_send.encode(), (server_host, server_port))
print(f"Sent data to server: {data_to_send}")

# Receive echoed data from the server
data, server_address = client_socket.recvfrom(1024)
print(f"Received echoed data from server at {server_address}: {data.decode()}")

# Close the socket
client_socket.close()
