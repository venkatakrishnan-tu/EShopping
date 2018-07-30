# EShopping
To persist the data, used H2 in memory database with Spring Boot framework.
Used Facade design pattern to orchestrate the different components of the ecommerce system - InventoryService, PaymentService, ShipmentService,OrderService

The credit card number is validated to have between 13-16 numbers.

REST urls: 
1. To get the order record,
GET: localhost:8080/orders/{id}
eg:localhost:8080/orders/3

OUTPUT:
{
    "name": "philip",
    "address": "1 autumn walk dr ",
    "city": "Rockville",
    "zip": "22345",
    "status": "FAILURE",
    "comment": "Not enough quantities in the inventory.",
    "totalPrice": 32.57,
    "userId": 3,
    "productId": 3,
    "creditCardNo": "1212-1212",
    "quantity": 6,
    "orderId": 3
}




2. To place the order,
POST: localhost:8080/orders
INPUT:
Post request body
{
    "name": "philip",
    "address": "1 autumn walk dr ",
    "city": "Rockville",
    "zip": "22345",
    "status": "FAILED",
    "comment": "Invalid credit card number",
    "totalPrice": 32.57,
    "userId": 3,
    "productId": 3,
    "creditCardNo": "1212-1212-1212-1212",
    "quantity": 1,
    "id": 3
}

OUTPUT:
{
    "response": "SUCCESS"
}
