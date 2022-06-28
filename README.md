# The lottery
lottery spring boot app

### Prerequisites

* installed java 11

### Run

```
> ./gradlew bootRun
```

### Try out
```
GET http://localhost:8080/lottery/participants
Accept: */*
Content-Type: application/json
```
```
POST http://localhost:8080/lottery/participants
Accept: */*
Content-Type: application/json

{
  "name": "Joe Doe",
  "age": 100,
  "city": "Saint P"
}
```
```
GET http://localhost:8080/lottery/start
Accept: */*
```
```
GET http://localhost:8080/lottery/winners
Accept: */*
Content-Type: application/json
```