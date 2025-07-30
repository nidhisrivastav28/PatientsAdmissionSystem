# Patient Admission System

## Schemas

1. **Patient**

    ```sql
    CREATE TABLE IF NOT EXISTS PATIENT (
        ID INT PRIMARY KEY AUTO_INCREMENT,
        NAME VARCHAR(100) NOT NULL,
        AGE INT,
        GENDER VARCHAR(10)
    );
    ```

2. **Doctor**

    ```sql
    CREATE TABLE IF NOT EXISTS DOCTOR (
        ID INT PRIMARY KEY AUTO_INCREMENT,
        NAME VARCHAR(100) NOT NULL,
        SPECIALISATION VARCHAR(30)
    );
    ```

3. **Admission**

    ```sql
    CREATE TABLE IF NOT EXISTS ADMISSION (
        PATIENT_ID INT,
        DOCTOR_ID INT,
        WARD VARCHAR(50),
        PRIMARY KEY (PATIENT_ID, DOCTOR_ID),
        FOREIGN KEY (PATIENT_ID) REFERENCES PATIENT(ID) ON DELETE CASCADE,
        FOREIGN KEY (DOCTOR_ID) REFERENCES DOCTOR(ID) ON DELETE CASCADE
    );
    ```
## Functionalities

1. Insert Patient Details
2. Show Patient Details
3. Search Patient Details By Name
4. Update Patient Details
5. Delete Patient Details
6. Insert Doctor Details
7. Show Doctor Details
8. Search Doctor Details By Specialisation
9. Update Doctor Details
10. Delete Doctor Details
11. Insert Patient Admission Details
12. Show Patient Admission Details