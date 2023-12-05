# tictactoe_server.py
import socket
from threading import Thread

class TicTacToeServer:
    def __init__(self, host, port):
        self.host = host
        self.port = port
        self.server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        self.server_socket.bind((self.host, self.port))
        self.connections = []
        self.current_player = 1  # Variable to track the current player (1 or 2)

    def start(self):
        print(f"Server listening on {self.host}:{self.port}")
        self.server_socket.listen()

        while True:
            client_socket, client_address = self.server_socket.accept()
            print(f"Accepted connection from {client_address}")
            self.connections.append((client_socket, client_address))
            thread = Thread(target=self.handle_client, args=(client_socket, client_address))
            thread.start()

    def handle_client(self, client_socket, client_address):
        try:
            with client_socket:
                while True:
                    data = client_socket.recv(1024).decode()
                    if not data:
                        break
                    print(f"Received data from {client_address}: {data}")
                    # Broadcasting data to all clients
                    self.broadcast(data, client_socket)
        except Exception as e:
            print(f"Error handling client {client_address}: {e}")
        finally:
            print(f"Connection closed by {client_address}")
            self.connections.remove((client_socket, client_address))

    def broadcast(self, data, sender_socket):
        for client_socket, _ in self.connections:
            if client_socket != sender_socket:
                try:
                    client_socket.sendall(data.encode())
                except Exception as e:
                    print(f"Error broadcasting to a client: {e}")

if __name__ == "__main__":
    server = TicTacToeServer("127.0.0.1", 5555)  # Use your desired IP and port
    server.start()
