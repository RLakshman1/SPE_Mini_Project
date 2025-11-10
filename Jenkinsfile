pipeline {
  agent any
  environment {
    DOCKERHUB_CREDENTIALS = credentials('docker_hub')
    DOCKER_IMAGE = "rlakshmandocker/miniproj_image1"
    DOCKER_TAG = "1.0"
  }
  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }
    stage('Test') {
      steps {
        sh 'mvn test'
      }
      post {
        always {
          junit '**/target/surefire-reports/*.xml'
        }
      }
    }
    stage('Package') {
      steps {
        sh 'mvn -B -DskipTests package'
      }
    }
    stage('Build Docker') {
      steps {
        sh 'docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} .'
      }
    }
    // stage('Push Docker') {
    //   steps {
    //     withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', usernameVariable: 'DOCKERHUB_USER', passwordVariable: 'DOCKERHUB_PASS')]) {
    //       sh 'echo $DOCKERHUB_PASS | docker login -u $DOCKERHUB_USER --password-stdin'
    //       sh 'docker push ${DOCKER_IMAGE}:${DOCKER_TAG}'
    //       sh 'docker logout'
    //     }
    //   }
    // } dummy
     stage('Push Docker') {
      steps {
          sh """
            echo "$DOCKERHUB_CREDENTIALS_PSW" | docker login -u "$DOCKERHUB_CREDENTIALS_USR" --password-stdin
            docker push $DOCKER_IMAGE:$DOCKER_TAG
            docker logout
          """
      }
    }
    stage('Deploy (Ansible)') {
      steps {
        sh 'ansible-playbook -i ansible/hosts ansible/deploy.yml '
      }
    }
  }
  post {
    success {
      echo 'Pipeline succeeded'
    }
    failure {
      echo 'Pipeline failed'
    }
  }
}
