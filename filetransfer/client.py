import socket

# Create a UDP socket
client_socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

# Server address and port
server_host = '127.0.0.1'
server_port = 12345

# File to be sent
file_to_send = 'example.txt'

# Send the filename to the server
client_socket.sendto(file_to_send.encode(), (server_host, server_port))

# Open and send the file content to the server
with open(file_to_send, 'rb') as file:
    file_content = file.read()
    client_socket.sendto(file_content, (server_host, server_port))

print(f"File '{file_to_send}' sent to the server.")

# Close the socket
client_socket.close()
