try:
    file = open("serverLog.txt", "r")
    data = file.read()
    lines = data.split("\n")
    report = open("logReport.txt", "w")
    report.write("Total Lines: " + str(len(lines)) + "\n")
    report.write("Total Words: " + str(len(data.split())) + "\n")
    report.write("Total Characters: " + str(len(data)) + "\n")
    vowels = 0
    for ch in data.lower():
        if ch in "aeiou":
            vowels += 1
    report.write("Total Vowels: " + str(vowels) + "\n")
    error_count = data.count("[ERROR]")
    critical_count = data.count("[CRITICAL]")
    report.write("ERROR: " + str(error_count) + "\n")
    report.write("CRITICAL: " + str(critical_count) + "\n")
    report.close()
    file.close()
except FileNotFoundError:
    print("File not found")
finally:
    print("File was opened and read successfully")