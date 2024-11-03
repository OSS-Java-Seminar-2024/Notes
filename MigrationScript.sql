-- Create the Kazaliste database
CREATE DATABASE Kazaliste;
USE Kazaliste;

-- Create the Izvedba table
CREATE TABLE Izvedba (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Projekt_ID INT NOT NULL,
    Vrsta_Izvedbe VARCHAR(50),
    Status_Izvedbe VARCHAR(50),
    Datum DATE,
    Pocetak TIME,
    Trajanje CHAR(10),
    Lokacija INT NOT NULL
);

-- Create the Lokacija table
CREATE TABLE Lokacija (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Lokacija VARCHAR(50),
    Status VARCHAR(50)
);

-- Create the Odjeli table
CREATE TABLE Odjeli (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Ime_Odjela VARCHAR(50),
    Kategorija VARCHAR(50)
);

-- Create the Projekt table
CREATE TABLE Projekt (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Odjel_ID INT NOT NULL,
    Ime_Projekta VARCHAR(50),
    Vrsta_Projekta VARCHAR(50),
    Status_Projekta INT NOT NULL,
    Datum_Pocetka DATE,
    Opis TEXT
);

-- Create the Radnici table
CREATE TABLE Radnici (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Odjel_ID INT NOT NULL,
    Ime VARCHAR(50),
    Prezime VARCHAR(50),
    Status VARCHAR(50),
    Specijalizacija VARCHAR(50)
);

-- Create the Radnik_na_projektu table
CREATE TABLE Radnik_na_projektu (
    Radnik_ID INT NOT NULL,
    Projekt_ID INT NOT NULL,
    PRIMARY KEY (Radnik_ID, Projekt_ID)
);

-- Create the Status table
CREATE TABLE Status (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Status CHAR(10),
    Opis TEXT
);

-- Add foreign keys
ALTER TABLE Izvedba 
    ADD CONSTRAINT FK_Izvedba_Lokacija FOREIGN KEY (Lokacija) REFERENCES Lokacija(ID);

ALTER TABLE Izvedba 
    ADD CONSTRAINT FK_Izvedba_Projekt FOREIGN KEY (Projekt_ID) REFERENCES Projekt(ID);

ALTER TABLE Projekt 
    ADD CONSTRAINT FK_Projekt_Odjeli FOREIGN KEY (Odjel_ID) REFERENCES Odjeli(ID);

ALTER TABLE Projekt 
    ADD CONSTRAINT FK_Projekt_Status FOREIGN KEY (Status_Projekta) REFERENCES Status(ID);

ALTER TABLE Radnici 
    ADD CONSTRAINT FK_Radnici_Odjeli FOREIGN KEY (Odjel_ID) REFERENCES Odjeli(ID);

ALTER TABLE Radnik_na_projektu 
    ADD CONSTRAINT FK_Radnik_na_projektu_Projekt FOREIGN KEY (Projekt_ID) REFERENCES Projekt(ID);

ALTER TABLE Radnik_na_projektu 
    ADD CONSTRAINT FK_Radnik_na_projektu_Radnici FOREIGN KEY (Radnik_ID) REFERENCES Radnici(ID);
