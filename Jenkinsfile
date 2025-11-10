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
        sh """
          # Build the Docker image
          docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} .
    
          # Stop and remove old container if it exists
          docker rm -f calc-app || true
    
          # Run the new container in background (detached)
          docker run -d --name calc-app ${DOCKER_IMAGE}:${DOCKER_TAG}
        """
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
    // stage('Deploy (Ansible)') {
    // environment { VENV = "${WORKSPACE}/.venv" }
    //   steps {
    //     withCredentials([string(credentialsId: 'sudo-pass', variable: 'SUDO_PASSWORD')]) {
    //       sh '''
    //         set -e
    //         python3 -m venv "$VENV"
    //         . "$VENV/bin/activate"
    //         pip install --upgrade pip ansible
    //         ansible --version
    
    //         # Run playbook with sudo (become) password from credentials
    //         ansible-playbook ansible/deploy.yml -i ansible/hosts \
    //           --extra-vars "ansible_become_pass=${SUDO_PASSWORD}"
    //       '''
    //     }
    //   }
    // }

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
