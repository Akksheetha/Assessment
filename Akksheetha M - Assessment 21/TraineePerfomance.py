class Person:
    def __init__(self, name, age, email):
        self.name = name
        self.age = age
        self.email = email
    def display_info(self):
        print("Name:", self.name)
        print("Age:", self.age)
        print("Email:", self.email)
class Trainee(Person):
    def __init__(self, name, age, email, batch_id, marks, projects, publications):
        super().__init__(name, age, email)
        self.batch_id = batch_id
        self.marks = marks
        self.projects = projects
        self.publications = publications
    def display_info(self):
        super().display_info()
        print("Batch:", self.batch_id)
        print("Marks:", self.marks)
        print("Projects:", self.projects)
        print("Publications:", self.publications)
class SDETTrainee(Trainee):
    def __init__(self, name, age, email, batch_id, marks, projects, publications, tool):
        super().__init__(name, age, email, batch_id, marks, projects, publications)
        self.tool = tool
    def compute_aggregate(self):
        avg = sum(self.marks) / len(self.marks)
        return (avg * 0.6) + (self.projects * 5) + (self.publications * 3)
trainees = []
n = int(input("Enter number of trainees: "))
for i in range(n):
    name = input("Enter Name: ")
    age = int(input("Enter Age: "))
    email = input("Enter Email: ")
    batch_id = input("Enter Batch ID: ")
    marks = []
    for j in range(5):
        mark = int(input("Enter Mark: "))
        marks.append(mark)
    projects = int(input("Enter Projects: "))
    publications = int(input("Enter Publications: "))
    tool = input("Enter Tool: ")
    obj = SDETTrainee(name,age,email,batch_id,marks,projects,publications,tool)
    trainees.append(obj)
highest = trainees[0]
for t in trainees:
    t.display_info()
    print("Aggregate:", t.compute_aggregate())
    if t.compute_aggregate() > highest.compute_aggregate():
        highest = t
print("Highest Aggregate Trainee:", highest.name)