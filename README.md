# Springboot and React

CRUD Operations on UserData using Java-Springboot
This task implements CRUD operations for managing user details stored in the database.
The tech stack used: 
Backend- Java, Springboot | Frontend- ReactJs

•	The designing of this application involves layers such as Controller, Service, Repository (DAO), Entity ,DTO((Data Transfer Object)). 
•	The reason to choose this design is to ensure that each layer handles a specific responsibility and avoid connecting the DB directly to the UI.
Flow
When a client sends a request , the data flow will be as follows:
Frontend(Client) -> Controller layer -> Service Layer -> Repository Layer - > Database
The response from the database follows the reverse path back to the client.
Layer Responsibilities
Entity layer:
The Entity layer represents the database structure using Java classes. This layer allows Spring Data JPA to automatically map Java objects to database records.
private Integer id; private String name; private String username; private String email are the fields used in this application
DTO Layer
Userdto is used when creating or returning user data, which helps maintain clean APIs and controlled data exposure. It helps to prevent the exposing of sensitive info like passwords to end users.
Repository / DAO Layer
The Repository layer handles database operations. Here UserDao extends JpaRepository, which provides built-in methods like save(),findAll()
Service Layer
This layer contains the business logic. UserService acts as an intermediary between the Controller and the Repository.
Here it handles
•	Converting DTO objects to Entity objects
•	Performing CRUD operations
•	Handling conditions like checking if a user exists before deletion

Controller Layer
This layer exposes REST APIs that allow clients to interact with the application. It handles HTTPS requests such as : GET /details/allDetails  , POST /details/add  , PUT /details/name/{id} , DELETE /details/name/{id}

<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/637b4b36-f1e1-4612-a107-ac20475331d6" />
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/a5f5ad42-c715-4b40-8073-75fe808c5fff" />
<img width="940" height="410" alt="image" src="https://github.com/user-attachments/assets/c5624562-a9cd-4bbf-9304-45ddcfe12cde" />
