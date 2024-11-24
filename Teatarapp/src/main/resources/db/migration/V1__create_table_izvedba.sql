-- Create table Izvedba
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