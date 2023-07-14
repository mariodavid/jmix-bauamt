
### Deploy to Heroku

1. Create a production mode jar 
```shell
./gradlew stage
```

2. Configure Heroku CLI
```shell
heroku plugins:install java 
```

3. deploy jar directly to heroku
```shell
heroku deploy:jar build/libs/bauamt-0.0.1-SNAPSHOT.jar --app jmix-bauamt
```
