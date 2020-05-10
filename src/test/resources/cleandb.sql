delete from user;
delete from reminder;
delete from student;

insert into user values (1, 'Nina', 'Jones', 'njones', '123456789', 'anne@somemail.com','2525252525'),
                        (2,'Anna', 'Adam', 'fflintston', '11111111', 'anne@somemail.com','2525252525'),
                        (3,'Taylor', 'Red', 'tred', '44444444', 'taylor@somemail.com','8888888888');
INSERT INTO reminder VALUES (1, 'FirstReminder', 'Somethings in the first reminder', 3, 0),
                        (2, 'SecondReminder', 'Somethings in the Second reminder', 1, 0),
                        (3, 'ThirdReminder', 'Somethings in the Third reminder', 2, 0),
                        (4, 'FourthReminder', 'Somethings in the Fourth reminder', 3, 0);

INSERT INTO `student` VALUES (1,'Thomas','James','Leader','123 Safe Rd, white street, Madison, WI, 53794','2016-03-25','A','Junior','1111111111','3333333333','Thomas.png','Marrige','male'),
                        (2,'Anastasia','Lyn','Creater','11 one rd, Madison, WI 53704','2016-03-02','A','Junior','2222222222','4141414141','anastasia.png','Marrige','male'),
                        (3,'Supari','Kunagorn','Fhlug','1111 ffff','2018-05-04','A','Senior','1111111111','1111111111','test','Married','female'),
                        (4,'Alexander','R','Fhlug','aaaaaaaaa','2013-05-04','B','senior','8888888888','8888888888','test','Married','male'),
                        (5,'Test','test','test','asdff','2001-01-05','A','junior','123456789','987654321','test','Married','female');
