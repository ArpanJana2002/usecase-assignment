# OrangeHRM Selenium Docker

Automated testing of OrangeHRM using Selenium Grid on Docker.

## Tech Stack
- Java 17
- Selenium 4.18.1
- TestNG 7.9.0
- Docker + Selenium Grid

## Project Structure
## Setup & Run

**Prerequisites:** Docker Desktop, Java 17, Maven

```powershell
# Clone
git clone https://github.com/ArpanJana2002/Selenium-docker.git
cd Selenium-docker

# Run
docker-compose up --build
```

## URLs
| Service | URL |
|---|---|
| OrangeHRM | http://localhost:8080 |
| Selenium Grid | http://localhost:4444 |

## Credentials
Username : Admin
Password : admin123

## View Results
```powershell
docker logs test-runner
```
