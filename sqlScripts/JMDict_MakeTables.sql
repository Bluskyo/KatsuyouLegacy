DROP DATABASE IF EXISTS JMDict;
CREATE DATABASE IF NOT EXISTS JMDict;

USE JMDict;

DROP TABLE IF EXISTS Kanji;
DROP TABLE IF EXISTS Translations;
DROP TABLE IF EXISTS Tags;

CREATE TABLE Metadata(
	Metadata_ID INT AUTO_INCREMENT,
    Pos TEXT,
    Similar_Meaning VARCHAR(100),
    Frequency VARCHAR(100),
    Field VARCHAR(100),
    Antonym VARCHAR(100),
    Similar_Kanji VARCHAR(200),
    
    PRIMARY KEY (Metadata_ID)
);

CREATE TABLE Translations(
	Translations_ID INT AUTO_INCREMENT,
    Gloss MEDIUMTEXT,
    
    PRIMARY KEY (Translations_ID)
);

CREATE TABLE Kanji(
	Kanji_ID INT AUTO_INCREMENT,
	Kanji_Seq INT,
    Kanji VARCHAR(60),
    Reading VARCHAR(60),
    Metadata_ID INT,
    Translations_ID INT,
    
    PRIMARY KEY (Kanji_ID),
    
    FOREIGN KEY (Metadata_ID) REFERENCES Metadata(Metadata_ID),
    FOREIGN KEY (Translations_ID) REFERENCES Translations(Translations_ID) 
    );