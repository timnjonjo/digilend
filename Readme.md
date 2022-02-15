# Digilend Platform MVP:1

### About DigiLend
DigiLend is a lending platform providing loans to 500+million youths and SME businesses in
Africa. It serves a daily active base of 30+ million providing features to power lending and
recovery of micro-loans. 

For further reference, please consider the following sections:

## Microservices
![Alt text](Digilend.png?raw=true "Title")
LendTech has built this application on microservices architecture
with distributed database for each of the services
* Authentication Provider
* Account & Loan Management
* Notification Service
* Payment Gateway
* Scoring Service
* Orchestrator(Business Process Service)
### Authentication Provider
Core Service Used to prove the identity of users and individual Microservice process. Providing management of  Users and Groups their permissions
- Manage Users, Roles and Permissions
- Manage Applications and their Tokens

### Account & Loan Management
Core Service to Manage Customer Accounts, Lending Accounts and Business Accounts
- Tracks Loan LifeCycle
- Manage Customer Account Details and Rules
- Manage Loan Product and Rules

### Notification Service
Service to send notifications or schedule Communication to individuals or groups
- Send Notifications(sms or email)
- Schedule notifications
- Manage communication templates(sms and emial templates)

### Payment Gateway

Service to Handle Money Disbursement and Receive money. Integrates to Money Channels, Banks and Mobile Money Services to provide a seamless way of send and receiving money.
- send and receive money

### Scoring Service
Service to score accounts, track leads and determine credit eligibility of individuals(Accounts)
- Integrates to Account & Loan Management to provide credit score of an account.


### Orchestrator(Business Process Service)
Coordinates process to produce a desired effect business rules.
- improve operational efficiency
- one point of change for any business need