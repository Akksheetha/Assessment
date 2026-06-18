import csv
import os

def read_login_data():
    file_path = os.path.join(os.path.dirname(__file__), "..", "data", "login_data.csv")
    data = []
    with open(file_path, newline="", encoding="utf-8") as csvfile:
        reader = csv.DictReader(csvfile)
        for row in reader:
            data.append((row["email"], row["password"], row["expected"]))
    return data
