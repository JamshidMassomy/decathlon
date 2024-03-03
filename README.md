# Read Me First

# What is Decathlon Events ?

Decathlon events are set of event which athletes competes
with each other in series of rounds and has special scoring formulas
for track-events, jump-events, throw-events.

This service is designed to calculable those scores according to give parameter
e.g sport and result archived by athlete during contest event.

# Specifications

The project requirement is JDK-17 and gradle 8.5 and embedded h2 in memory database

API BASE URL: https://localhost:8080/api/v1
DB: http://localhost:8080/h2-console/
SWAGGER: http://localhost:8080/swagger-ui.html

# Setup

Project can be setup by docker compose or with IntelliJ idea
by importing and introducing proper JDK version and gradle no special configurations
are needed for IDE setup.

# Docker setup

for docker compose : docker-compose up -d (In the devOps folder)
it takes few second to complete containers boot
