# Assessment

# ### Prerequisite for setting up Banking service ###
* Maven 3.3.9
* MySQL 5.6.37 MySQL Community Server

* ### Setup MySQL Database for Dev Profile (bankingservice for database, root for usernamd and root for password)

* login as root to mysql and run the below command
```sql
	create database bankingservice
```
* exit mysql and run the below command from the command line
```sql
	mysql -u root -e "GRANT ALL ON bankingservice.* TO root IDENTIFIED BY 'bankingservice'";
```
-----

### Build the Platform ###
By default, this will build the dev profile

```maven
    mvn clean install
	cd server-component/cardservice
	mvn package
```

-----

### Deploy the REST Service ###

```cmd
    cd server-components/creditcardservice
	mvn spring-boot:run (or) java -jar target/creditcardservice.jar
