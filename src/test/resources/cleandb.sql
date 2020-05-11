DELETE FROM Role;
DELETE FROM Parent;
DELETE FROM Report;
DELETE FROM user;
DELETE FROM Student;
DELETE FROM Reminder;


INSERT INTO user VALUES (1, 'Nina', 'Jones', 'njones', '123456789', 'anne@somemail.com','2525252525'),
                        (2,'Anna', 'Adam', 'fflintston', '11111111', 'anne@somemail.com','2525252525'),
                        (3,'Taylor', 'Red', 'tred', '44444444', 'taylor@somemail.com','8888888888'),
                        (4,'Alisa', 'Ian', 'alan', '11111111', 'alisa@somemail.com','2525252525'),
                        (5,'Peter', 'Oliver', 'poliver', '3333333333', 'oliver@somemail.com','25252ddddd');
INSERT INTO reminder VALUES (1, 'FirstReminder', 'Somethings in the first reminder', 3, 0),
                        (2, 'SecondReminder', 'Somethings in the Second reminder', 1, 0),
                        (3, 'ThirdReminder', 'Somethings in the Third reminder', 2, 0),
                        (4, 'FourthReminder', 'Somethings in the Fourth reminder', 3, 0);

INSERT INTO `student` VALUES (1,'Thomas','James','Leader','123 Safe Rd, white street, Madison, WI, 53794','2016-03-25','A','Junior','1111111111','3333333333','Thomas.png','Marrige','male'),
                        (2,'Anastasia','Lyn','Creater','11 one rd, Madison, WI 53704','2016-03-02','A','Junior','2222222222','4141414141','anastasia.png','Marrige','male'),
                        (3,'Supari','Kunagorn','Fhlug','1111 ffff','2018-05-04','A','Senior','1111111111','1111111111','test','Married','female'),
                        (4,'Alexander','R','Fhlug','aaaaaaaaa','2013-05-04','B','senior','8888888888','8888888888','test','Married','male'),
                        (5,'Alexander11','R11','Fhlug','aaaaaaaaa','2013-05-04','B','senior','8888888888','8888888888','test','Married','male'),
                        (6,'UnitTest','test','test','asdff','2001-01-05','A','junior','123456789','987654321','test','Married','female');
INSERT INTO `role` VALUES (1, 'admin', 'njones'),
                          (2,'teacher', 'fflintston'),
                          (3,'parent','tred'),
                          (4,'parent','alan'),
                          (5,'parent','poliver');
INSERT INTO `parent` VALUES (1,3,2),(2,4,1),(3,5,3);
INSERT INTO `report` VALUES (1,'2020-05-10',4,4,5,1,2),(2,'2020-05-10',5,5,2,1,3),(3,'2020-05-09',3,5,4,1,4);


