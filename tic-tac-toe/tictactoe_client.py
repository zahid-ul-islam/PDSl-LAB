# tictactoe_client.py
import socket
from threading import Thread
from tkinter import Tk, Button, messagebox
from queue import Queue

class TicTacToeClient:
    def __init__(self, host, port):
        self.host = host
        self.port = port
        self.client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        self.root = Tk()
        self.buttons = [[None, None, None] for _ in range(3)]
        self.data_queue = Queue()

    def connect_to_server(self):
        try:
            self.client_socket.connect((self.host, self.port))
            Thread(target=self.receive_data).start()
            Thread(target=self.process_data).start()
            self.create_gui()
        except Exception as e:
            print(f"Error connecting to the server: {e}")

    def receive_data(self):
        try:
            with self.client_socket:
                while True:
                    data = self.client_socket.recv(1024).decode()
                    if not data:
                        break
                    print(f"Received data: {data}")
                    self.data_queue.put(data)
        except Exception as e:
            print(f"Error receiving data: {e}")

    def process_data(self):
        while True:
            data = self.data_queue.get()
            self.root.after(0, self.update_gui, data)

    def update_gui(self, data):
        _, row, col, player = data.split(",")
        row, col, player = int(row), int(col), int(player)
        mark = "X" if player == 1 else "O"
        self.buttons[row][col].config(text=mark)

    def make_move(self, row, col):
        move_data = f"MOVE,{row},{col},{self.player}"  # Include the player information
        try:
            self.client_socket.sendall(move_data.encode())
        except Exception as e:
            print(f"Error sending move data: {e}")

    def create_gui(self):
        for i in range(3):
            for j in range(3):
                self.buttons[i][j] = Button(
                    self.root, text="", font=("Helvetica", 24), width=5, height=2,
                    command=lambda row=i, col=j: self.make_move(row, col)
                )
                self.buttons[i][j].grid(row=i, column=j)

        self.root.mainloop()

if __name__ == "__main__":
    client = TicTacToeClient("127.0.0.1", 5555)  # Use the same IP and port as the server
    client.connect_to_server()
