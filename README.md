# SPE Mini Project - Scientific Calculator (Java + Maven + Docker + Jenkins + Ansible)

This scaffold contains a Java implementation of a menu-driven scientific calculator and example DevOps pipeline artifacts:
- Java source in `src/main/java/com/example`
- Unit tests in `src/test/java/com/example` (JUnit 5)
- `pom.xml` configured to build an executable jar
- `Dockerfile` to containerize the app
- `Jenkinsfile` example for CI/CD
- `ansible/deploy.yml` and `ansible/hosts` to deploy locally (localhost)

## Quick local run (Linux)
1. Install OpenJDK 17 and Maven.
2. Build and test:
   ```
   mvn test
   mvn -DskipTests package
   ```
3. Run locally:
   ```
   java -jar target/SPE_Mini_Project-1.0-SNAPSHOT.jar < input.txt
   ```

## Build docker image locally
```
docker build -t rlakshmandocker/miniproj_image1:1.0 .
docker login
docker push rlakshmandocker/miniproj_image1:1.0
```

## Notes
- The Jenkinsfile and ansible playbook already contain the Docker Hub image rlakshmandocker/miniproj_image1.
- Replace Jenkins credentials ID `dockerhub-creds` with your Jenkins credential name if you use Jenkins.
- The `ansible` playbook uses `community.docker` modules; you may need to install `ansible` collections:
  `ansible-galaxy collection install community.docker`
