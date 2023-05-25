# Crab Eats (Online Food Ordering System)

This repository contains the **backend** codebase for a robust Online Food Ordering system. (Frontend is [here]([https://github.com/crabsatellite/crabEats_backend](https://github.com/crabsatellite/crabEats_frontend))) 

The backend is built using Spring and Hibernate, and the frontend utilizes ReactJS and Ant Design.

---

## Backend

The backend of the system is built with Java, utilizing the Spring and Hibernate frameworks.

### Features:

- **REST API**: The system is built around a REST API implemented via Spring MVC. The API provides various endpoints including user registration, menu searching, food ordering, and checkout functionalities.

- **Data Storage and Access**: Hibernate is used for data storage and operations. It allows us to perform complex operations on stored data such as retrieving the menu and various restaurant details with ease.

- **Security**: Spring Security is utilized to ensure authentication and authorization of users. This secures the application from potential malicious attacks by making sure only authenticated users have access to their respective accounts.

- **Loose Coupling**: The Spring Framework's core technologies have been used to loosely couple all the components in the application. This results in a modular design, enhancing maintainability and scalability of the system.

---

## Frontend

The frontend of the application is built with ReactJS and uses the Ant Design UI library for an interactive and user-friendly interface.

### Features:

- **Interactive UI**: The UI is built using ReactJS which allows for a dynamic and responsive user interface.

- **Shopping Cart**: The system provides an intuitive shopping cart feature, allowing users to add menu items to their cart and place orders.

- **User-Friendly Design**: The application uses Ant Design to provide a clean, minimalist and easy-to-navigate interface.

---

## Backend Setup (Java)

1. **Clone the Repository**
   - On GitHub, navigate to the main page of the repository.
   - Click on 'Code' button in green.
   - In the 'Clone >> HTTPS' section, copy the clone URL for the repository.
   - Open your command line or Terminal application and navigate to the directory where you wish to clone the repository.
   - Type `git clone`, and then paste the URL you copied earlier. It will look like this: `https://github.com/crabsatellite/crabEats_backend.git`
   - Press Enter to clone the repository to your local machine.

2. **Setup Environment Variables**
   - Navigate to the directory where the project resides.
   - You should have a `.env` file or a `application.properties` file where you will need to add your database credentials such as the database name, username, and password. For Spring Boot applications, this is typically found in `src/main/resources/application.properties`.
   - Also, add other necessary configurations such as your server port.

3. **Run the Backend Server**
   - Open a terminal in the project's root directory.
   - You can usually start the application using `./mvnw spring-boot:run`..

Please ensure you have the Java Development Kit (JDK) installed to run the server.

## Frontend Setup (React.js)

1. **Clone the Repository**
   - Repeat the cloning steps from the Backend setup.

2. **Setup Environment Variables**
   - Navigate to the directory where the project resides.
   - You should have a `.env` file where you will need to add the API endpoints that your application will use to communicate with the backend server.
   - Other typical environment variables include the port number that the React app will run on.

3. **Run the Frontend Server**
   - Open a terminal in the project's root directory.
   - Install the necessary dependencies by running `npm install`.
   - After installation, you can start the application using `npm start`.

Please ensure you have Node.js and npm installed to set up and run the project.

After you've set up both the backend and frontend servers, your application should now be running both locally on your machine.

---

This project is still under development. Contributions are very welcome!

---

## License

This project is licensed under the MIT License. See `LICENSE` for more information.

---

## Contact

Feel free to get in touch if you have any questions. 

---

**Enjoy ordering your meals with Crab Eats!**
