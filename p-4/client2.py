import socket
import threading

# Client configuration
HOST = '127.0.0.1'  # Loopback IP address
PORT = 8080  # Port number

# Create a socket object
client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# Connect to the server
client_socket.connect((HOST, PORT))

# Function to send messages to the server
def send_message():
    while True:
        message = input("Client 2 - Enter message: ")
        client_socket.send(message.encode('utf-8'))

# Function to receive messages from the server
def receive_message():
    while True:
        incoming_message = client_socket.recv(1024).decode('utf-8')
        print("Received message:", incoming_message)

# Create threads for sending and receiving messages
send_thread = threading.Thread(target=send_message)
receive_thread = threading.Thread(target=receive_message)

# Start the threads
send_thread.start()
receive_thread.start()
