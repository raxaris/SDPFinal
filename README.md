# CarMarketPro

Welcome to Alisar CarMarket, a comprehensive automotive marketplace simulator, leveraging six design patterns, including Factory Method, Singleton, Decorator, Adapter, Observer, and Strategy. This application provides a rich and interactive experience, catering to both regular users and administrators.

## User Types

### Admin
Administrators enjoy the following privileges:
- CRUD operations on users and vehicles for efficient management.

### Regular User
Regular users have access to a wide array of features:
- Catalog browsing with dynamic filters for makes, models, and prices.
- Vehicle search by ID.
- Sorting options for vehicles based on various criteria.
- Purchasing available vehicles from the catalog.
- Placing orders for customized vehicles.
- Interacting with owned vehicles through methods like refueling and applying protective coatings.

## Features

### User Management
- Seamless user registration and login.
- Database interaction for user data storage.

### Vehicle Management
- An extensive vehicle catalog.
- Vehicle search by ID.
- Versatile sorting capabilities based on brand, model, price, and more.
- Convenient purchase options for cataloged vehicles.
- Order placement for custom vehicle requests.
- Vehicle interaction functionalities, including refueling and coating applications.

## Design Patterns

AliSar CarMarket employs various design patterns to ensure robust functionality:

1. **Factory Method**: Used for creating vehicle objects.
2. **Singleton**: Utilized for managing a singleton database instance, ensuring a single, centralized point for data storage and retrieval.
3. **Decorator**: Enables dynamic vehicle customization.
4. **Adapter**: Facilitates interactions between different components.
5. **Observer**: Used to notify users about changes in the vehicle catalog, enhancing their experience and keeping them informed about updates.
6. **Strategy**: Provides flexibility for vehicle actions and customization.

## Getting Started

To begin using CarMarketPro, follow these steps: 

1. Clone the repository to your local machine: git clone https://github.com/your-repo.git
2. Run the application to explore its rich features.

## Technologies Used:
### Back-End Development:
Java: The back-end code is written in Java, providing the core functionality of the application.

### Database:
PostgreSQL: A powerful open-source relational database management system used to store and manage user and vehicle data.

### Database Driver:
[PostgreSQL JDBC Driver]: The database driver  used to establish connections and interact with the PostgreSQL database.

## Contributiors:
- [HubertFisher](https://github.com/HubertFisher)
- [raxaris](https://github.com/raxaris)