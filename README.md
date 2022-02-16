1- Once the project is ready to run , just right click on project and choose 'run as' then 'Spring Boot App'

2- I am using h2 as an in-memory database and I'm using liquibase for DDL and to insert some data for startup.

3- After starting 'on port 8080' , go to 'http://localhost:8080/api/h2-console' and press connect to activate h2 database. make sure that the JDBC field has this value : 'jdbc:h2:mem:testdb' ,After connecting , you can see tables 'CUSTOMER, WALLET, AND TOPUP_DATA' and some records in it.

4- To perform the app, you can use first unit testing for Service that exist in test package.

5- For testing the rest api , I'm using tool for http request 'postman'. it is a POST method and 
the url in postman is http://localhost:8080/api/topup
example for JSON Request : {

    {
    "amount" : "50",
    "currency" : "USD",
	"chargeId" : "0a17027e-d015-44f1-b9b1-a6ee7b88d659",
	"customer" : {
	"id" : "478a76bb-d10e-4f4c-bc13-8ec471f33cfa",
	"walletId" : "b8ba3f65-6793-4ad2-b425-54173cf267ba"
	}
}

successful response for this request is : {

    {
    "id": "83c6ed21-68f9-4ae6-a1e6-ff377cd023c9",
    "createdAt": "2022-02-16T15:32:00.9570238",
    "status": "SUCCESS",
    "amount": 50.0,
    "currency": "USD",
    "chargeId": "0a17027e-d015-44f1-b9b1-a6ee7b88d659",
    "customer": {
        "id": "478a76bb-d10e-4f4c-bc13-8ec471f33cfa",
        "walletId": "b8ba3f65-6793-4ad2-b425-54173cf267ba"
    },
    "fees": {
        "amount": 10.0,
        "currency": "EGP"
    },
    "balance": {
        "totalAmount": 240.0
    }
}

That's all for now , if you faced any unexpected error , contact me on howayda.gamal@gmail.com