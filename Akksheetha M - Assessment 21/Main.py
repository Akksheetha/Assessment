from DataValidator import *
records = []
n = int(input("Enter number of records: "))
for i in range(n):
    try:
        usn = input("USN: ")
        name = input("Name: ")
        email = input("Email: ")
        phone = input("Phone: ")
        validate_usn(usn)
        validate_email(email)
        validate_phone(phone)
        records.append((usn, name, email, phone))
    except InvalidFieldError as e:
        print(e)
records = tuple(records)
print("\nValid Records:", len(records))
print()
for record in records:
    usn, name, email, phone = record
    print(usn, "|", name)