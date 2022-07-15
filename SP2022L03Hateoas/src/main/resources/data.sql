INSERT into students(id, age, deleted, name) values(1,21,0,"Pesho");
INSERT into students(id, age, deleted, name) values(2,22,0,"Gosho");
INSERT into students(id, age, deleted, name) values(3,23,1,"Anna");

INSERT into courses(id,  name, price) values(1,"Spring", 100);
INSERT into courses(id,  name, price) values(2,"JavaScript", 5);


INSERT into orders(id,  course_id, student_id) values(1,1,1);
INSERT into orders(id,  course_id, student_id) values(2,2,1);
INSERT into orders(id,  course_id, student_id) values(3,2,2);