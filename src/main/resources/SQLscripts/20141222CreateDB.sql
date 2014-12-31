/* Note this database will not secure users passwords if it is not running on a site using https. Someone could simply sniff the passwords  */
# TODO:
# [] Emails should be unique for each user
# [] Add Tables For Scholarship
# [] Add TimeStamp for fines... We need to protect against someone updating a fine amount and screwing up the fines that aren't paid off

CREATE DATABASE IF NOT EXISTS FRATERNITY;

USE FRATERNITY;

/* used so we can properly address parents */
CREATE TABLE IF NOT EXISTS Title (
  TitleID INT NOT NULL AUTO_INCREMENT,
  Title varchar(10),
  PRIMARY KEY (TitleID)
);

CREATE TABLE IF NOT EXISTS Parent
(
  ParentID INT NOT NULL AUTO_INCREMENT,
  TitleID INT REFERENCES Title (TitleID),
  ParentFname VARCHAR(35) CHARSET utf8 NOT NULL,
  ParentLname VARCHAR(35) CHARSET utf8 NOT NULL,
  ParentEmail VARCHAR(320),
  PRIMARY KEY (ParentID)
);

CREATE TABLE IF NOT EXISTS Major (
  MajorID INT NOT NULL AUTO_INCREMENT,
  Major varchar(100),
  PRIMARY KEY (MajorID)
);

CREATE TABLE IF NOT EXISTS Member (
  MemberID int NOT NULL AUTO_INCREMENT,
  FirstName VARCHAR(35) CHARSET utf8 NOT NULL,
  MiddleName VARCHAR(35) CHARSET utf8,
  LastName  VARCHAR(35) CHARSET utf8 NOT NULL,
  Email VARCHAR(320) NOT NULL,
  PC int NOT NULL,
  InitationNumber VARCHAR(9),
  CellNumber VARCHAR(11),
  HighSchool VARCHAR(50),
  HomeAddress VARCHAR(100), /* de-normalized */
  ParentID int REFERENCES Parent (ParentID),
  MajorID INT REFERENCES  Major (MajorID),
  EncodedPassword CHAR(60),
  PRIMARY KEY (MemberID)
);

CREATE TABLE IF NOT EXISTS Position (
  PositionID INT NOT NULL AUTO_INCREMENT,
  PositionName varchar(20) NOT NULL,
  HousePoints int,
  PRIMARY KEY (PositionID)
);

# TODO CREATE CONSTRAINT ON Grade <= 4.0
CREATE TABLE IF NOT EXISTS Grades (
  GradeID INT NOT NULL AUTO_INCREMENT,
  MemberID INT NOT NULL REFERENCES Member (MemberID),
  Quarter VARCHAR(6) NOT NULL,
  Year INT NOT NULL,
  Department VARCHAR(6) NOT NULL,
  CourseNumber CHAR(3) NOT NULL,
  Credits int NOT NULL,
  Grade FLOAT(4, 3) NOT NULL
);


# /* UNCOMMENT THIS SECTION WHEN RUNNING FOR FIRST TIME */
# INSERT INTO Position (PositionName) VALUES ("USER");
# INSERT INTO Position (PositionName) VALUES ("ADMIN");
# INSERT INTO Position (PositionName) VALUES ("GP");
# INSERT INTO Position (PositionName) VALUES ("VGP");
# INSERT INTO Position (PositionName) VALUES ("HM");
# INSERT INTO Position (PositionName) VALUES ("P");
# INSERT INTO Position (PositionName) VALUES ("SCHOLARSHIP");
# INSERT INTO Position (PositionName) VALUES ("AG");
# INSERT INTO Position (PositionName) VALUES ("GB");
# INSERT INTO Position (PositionName) VALUES ("HOD");
# INSERT INTO Position (PositionName) VALUES ("HI");
# INSERT INTO Position (PositionName) VALUES ("RISK");
# INSERT INTO Position (PositionName) VALUES ("SOCIAL");
# INSERT INTO Position (PositionName) VALUES ("RUSH");
# INSERT INTO Position (PositionName) VALUES ("PHILANTHROPY");
# INSERT INTO Position (PositionName) VALUES ("PHU");
# INSERT INTO Position (PositionName) VALUES ("SG");
# /* USE THIS SO WE CAN FIND BUGS WITHOUT ADDING EVERY POSITION (and their house points) TO OUR ACCOUNT */
# INSERT INTO Position (PositionName) VALUES ("DEVELOPER");

CREATE TABLE IF NOT EXISTS Member_Position (
  MemberPosID int not null AUTO_INCREMENT,
  PositionID int not null REFERENCES Position (PositionID),
  StartQtr VARCHAR(6) NOT NULL,
  StartYear CHAR(4) NOT NULL,
  EndQtr VARCHAR(6) NOT NULL,
  EndYear CHAR(4) NOT NULL,
  MemberID int not null REFERENCES Member(MemberID),
  PRIMARY KEY (MemberPosID)
);

CREATE TABLE IF NOT EXISTS FineType (
  FineTypeID int not null AUTO_INCREMENT,
  FineName varchar(20),
  FineDesc VARCHAR(250),
  Amount int not null,
  PRIMARY KEY (FineTypeID)
);

CREATE TABLE IF NOT EXISTS Member_Fine (
  MemberFineID int not null AUTO_INCREMENT,
  FineTypeID int not null REFERENCES FineType(FineTypeID),
  MemberID int not null REFERENCES  Member(MemberID),
  PRIMARY KEY (MemberFineID)
);

/* Will allow us to disallow comments */
CREATE TABLE IF NOT EXISTS FeedbackType (
  FeedbackTypeID int not null AUTO_INCREMENT,
  FeedbackType varchar(20),
  PRIMARY KEY (FeedbackTypeID)
);

# /* UNCOMMENT THIS SECTION WHEN RUNNING FOR FIRST TIME */
# INSERT INTO FeedbackType VALUES ("None");
# INSERT INTO FeedbackType VALUES ("Comment");
# INSERT INTO FeedbackType VALUES ("Vote");
# INSERT INTO FeedbackType VALUES ("Claim");

CREATE TABLE IF NOT EXISTS Announcement (
  AnnouncementID int not null AUTO_INCREMENT,
  MemberID int not null REFERENCES Member (MemberID),
  EventTitle VARCHAR(20) CHARSET utf8 NOT NULL,
  Message  VARCHAR(250) CHARSET utf8 NOT NULL,
  StartTime DATETIME,
  EndTime DATETIME,
  Expiration DATETIME,
  FeedbackTypeID int not null REFERENCES FeedbackType (FeedbackTypeID),
  PRIMARY KEY (AnnouncementID)
);

CREATE TABLE IF NOT EXISTS Feedback (
  FeedbackID int not null AUTO_INCREMENT,
  AnnouncementID int not null REFERENCES Announcement(AnnouncementID),
  MemberID int not null REFERENCES  Member(MemberID),
  Feedback VARCHAR(250),
  PRIMARY KEY (FeedbackID)
);

CREATE TABLE IF NOT EXISTS Duty (
  DutyID int not null AUTO_INCREMENT,
  DutyName varchar(25) NOT NULL,
  DutyDesc varchar(50),
  PRIMARY KEY (DutyID)
);

CREATE TABLE IF NOT EXISTS DutyStatus(
  DutyStatusID int not null AUTO_INCREMENT,
  DutyStatus varchar(15) not null,
  StatusDesc varchar(25),
  PRIMARY KEY (DutyStatusID)
);


CREATE TABLE IF NOT EXISTS DutyHistory(
  DutyHistoryID int not null AUTO_INCREMENT,
  MemberID int not null REFERENCES Member (MemberID),
  DutyID int not null REFERENCES Duty (DutyID),
  TimeStamp datetime not null DEFAULT CURRENT_TIMESTAMP,
  DutyStatusID int not null references DutyStatus (DutyStatusID),
  CheckedBy int not null references Member (MemberID),
  PRIMARY KEY (DutyHistoryID)
);


