# eecs4413-project

## Instructions on running the project on a localhost machine:
1. Copy the project URI from the GitHub Page
2. Open Eclipse IDE for Enterprise Java and Web Developers
3. Right-click to import "Project from Git"
4. Select "Clone URI" and paste the copied URI into a URI section
5. After successfully importing the project into your local machine, click "Run" tab on Eclipse and choose "Run Configurations"
6. Under "Arguments" tab, there is a section, "Working directory". Change the Default to Other, and set it to the current working directory
7. Run on the Tomcat server, and the first page will appear on your browser

## Instructions on running the project on a localhost machine using Docker:
1. Install the Docker Desktop here https://docs.docker.com/get-docker/
2. Open [GroceryDAOImpl.java](https://github.com/misato100/eecs4413-project/blob/main/src/main/java/dao/GroceryDAOImpl.java) and [UserDAOImpl.java](https://github.com/misato100/eecs4413-project/blob/main/src/main/java/dao/UserDAOImpl.java), 
and change the paths for databases by following the instructions within the comments (within a getConnection method).
3. Open [UserManager.java](https://github.com/misato100/eecs4413-project/blob/main/src/main/java/controller/UserManager.java)
and change the paths for databases by following the instructions within the comments (within a doPost method).
4. Export a war file of the project into your local machine and name it as "eecs4413-project" (This is the same as the project name).
5. In your command line, direct to the same folder as where the war file resides
6. ```type nul > Dockerfile ```
7. Open your favorite editor and add
```FROM tomcat:9.0-jdk21-openjdk COPY ./eecs4413-project.war /usr/local/tomcat/webapps``` to your Dockerfile.
8. In your command line,
```docker pull tomcat:9.0-jdk21-openjdk```
```docker build -t web-service .```
```docker run -d -p 8080:8080 web-service```
9. Visit http://localhost:8080/eecs4413-project/

## Instructions on running the project online using Docker:
1. In your command line,
```docker pull mtsz33/web-service:1```
```docker build -t web-service .```
```docker run -d -p 8080:8080 web-service```
9. Visit http://localhost:8080/eecs4413-project/
