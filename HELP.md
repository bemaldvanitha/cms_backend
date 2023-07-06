# Customer management system backend

backend side of customer management system

* The JVM level was changed from '1.8' to '17', review the [JDK Version Range](https://github.com/spring-projects/spring-framework/wiki/Spring-Framework-Versions#jdk-version-range) on the wiki for more details.

# Getting Started

follow these instructions before running this program

### Database setting
1) first goto application.properties
2) check whether maria db is running and create database called cms in maria db
3) then change datasource.url port name as maria db port
4) change datasource.username and datasource.password as db setting

### Backend endpoints
these are the endpoints provided by backend

Customer :-

@POST
* http://localhost:8080/api/customers - create new customer

@GET
* http://localhost:8080/api/customers - get all customers

@GET
* http://localhost:8080/api/customers/{customerId} - get one customer by id

@PATCH
* http://localhost:8080/api/customers/{customerId} - update existing customer

Bulk handle :-

@POST
* http://localhost:8080/upload - handle bulk creation

upload file should be excel file this will extract data from first sheet of that excel file

file should contain like this - 

name | birthdate | nic_number

name should be string
birthdate should be string and it should in MM/DD/YYYY format
nic_number should be string

Also this file can not contain headers otherwise those will also write into db