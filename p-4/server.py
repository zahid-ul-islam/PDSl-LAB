import socket
import threading

# Server configuration
HOST = '127.0.0.1'  # Loopback IP address
PORT = 8080  # Port number

# Create a socket object
server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# Bind the socket to a specific address and port
server_socket.bind((HOST, PORT))

# Listen for incoming connections
server_socket.listen()

print(f"Server is listening on {HOST}:{PORT}")

# List to store connected clients
clients = []


# Function to handle a client's connection
def handle_client(client_socket, client_address):
    print(f"New connection from {client_address}")

    try:
        # Receive and broadcast messages
        while True:
            message = client_socket.recv(1024).decode('utf-8')
            if not message:
                break
            print(f"Received message from {client_address}: {message}")

            # Broadcast the message to all connected clients
            for c in clients:
                c.send(f"{client_address}: {message}".encode('utf-8'))

    except Exception as e:
        print(f"Error handling connection from {client_address}: {e}")

    finally:
        # Remove the client from the list
        clients.remove(client_socket)
        client_socket.close()
        print(f"Connection from {client_address} closed")


# Accept and handle incoming connections
while True:
    client_socket, client_address = server_socket.accept()
    clients.append(client_socket)

    # Create a thread to handle the client
    client_handler = threading.Thread(target=handle_client, args=(client_socket, client_address))
    client_handler.start()
