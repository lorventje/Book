pipeline {
  agent {
    docker {
      image 'jenkinsci/blueocean '
    }

  }
  stages {
    stage('Build assets') {
      steps {
        sh 'npm install'
      }
    }
  }
}