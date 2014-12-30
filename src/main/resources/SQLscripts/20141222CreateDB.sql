/* Note this database will not secure users passwords if it is not running on a site using https. Someone could simply sniff the passwords  */
# TODO ADD CONSTRAINTS:
# [] Emails should be unique for each user
# [] Add Tables For Scholarship
# []
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
  PasswordHash Binary(32), /* USE SHA-256 */
  PasswordSalt BINARY(32), /* Assumes that the salt will be 32 bytes... see http://docs.spring.io/spring-security/site/docs/3.2.x/reference/htmlsingle/#spring-security-crypto-keygenerators */
  PRIMARY KEY (MemberID)
);

CREATE TABLE IF NOT EXISTS Position (
  PositionID INT NOT NULL AUTO_INCREMENT,
  PositionName varchar(20) NOT NULL,
  HousePoints int,
  PRIMARY KEY (PositionID)
);

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


