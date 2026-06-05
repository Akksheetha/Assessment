students = {}
n = int(input("Enter the number of students : "))
for i in range(0,n):
    usn = str(input("Enter the USN number : "))
    marks = int(input("Enter the marks : "))
    students[usn] = marks
maximum = 0
minimum = 101
usn_store_max = ""
usn_store_min = ""
for i in students:
    if students.get(i)>maximum:
        maximum = students.get(i)
        usn_store_max = i
    if students.get(i)<minimum:
        minimum = students.get(i)
        usn_store_min = i
print("Maximum :",maximum,"-",usn_store_max)
print("Minimum :",minimum,"-",usn_store_min)
distinction = {}
merit = {}
passcategory = {}
fail = {}
total = 0
for i in students:
    if students.get(i)>=86 and students.get(i)<=100:
        distinction[i] = students.get(i)
        total += students.get(i)
    elif students.get(i)>=76 and students.get(i)<=86:
        merit[i] = students.get(i)
        total += students.get(i)
    elif students.get(i)>=60 and students.get(i)<=75:
        passcategory[i] = students.get(i)
        total += students.get(i)
    else:
        fail[i] = students.get(i)
        total += students.get(i)
print("Distinction count :",len(distinction))
print("Distinction : ",distinction)
print("Merit count :",len(merit))
print("Merit : ",merit)
print("Pass count :",len(passcategory))
print("Pass : ",passcategory)
print("Fail count :",len(fail))
print("Fail : ",fail)
print("class average is ",total/(len(students)))
print("Below Average : ",fail)
sort = sorted(students)
print("LeaderBoard")
for i in sort[::-1]:
    print(i,":",students[i])

