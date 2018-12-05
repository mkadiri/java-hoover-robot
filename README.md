### Requirements
Docker installed and configured

### Build and start

This has only been tested on linux

- `git clone https://github.com/mkadiri/java-hoover-robot.git` - clone repo to a directory of your choice and cd in to it
- `bash build.sh` - creates the necessary docker images
- `docker-compose up -d` - starts the containers
- `docker logs -f mkadiri-java-microservice` - shows container logs (optional)


### API
To use the API consider using something like Postman.
The application only has one post endpoint

`POST` `https://localhost:8181/hoover/clean`

and requires a body such as the following

```
{
  "roomSize" : [5, 5],
  "coords" : [1, 2],
  "patches" : [
    [1, 0],
    [2, 2],
    [2, 3]
  ],
  "instructions" : "NNESEESWNWW"
}
```


### Folder structure

- `docker` - contains all the dockerfiles required for building a java maven application and another for hosting the 
    artifact
- `src` - under `main.java` you should find the java source files, under `main.resources` you should find the 
    application properties and liquibase migration files
- `build.sh` - This kicks off everything, it builds a java maven builder image which can be used to grab maven 
    dependencies (that is mapped to you local .m2 folder) and spits out a jar file in to a `target` folder
    

### Help
If you can't run the docker containers make sure there are no applications using port `8181` or `9191`.
Try `docker rm -f $(docker ps -qa) && docker-compose up -d`
