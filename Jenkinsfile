def notifySlack(String buildStatus = 'STARTED') {
    // Build status of null means success.
    buildStatus = buildStatus ?: 'SUCCESS'

    def color

    if (buildStatus == 'STARTED') {
        color = '#D4DADF'
    } else if (buildStatus == 'SUCCESS') {
        color = '#BDFFC3'
    } else if (buildStatus == 'UNSTABLE') {
        color = '#FFFE89'
    } else {
        color = '#FF9FA1'
    }

    def msg = "${buildStatus}: Deploying `${env.JOB_NAME}` to staging rev #${env.BUILD_NUMBER}:\n${env.BUILD_URL}"

    slackSend(color: color, message: msg)
}

node {
    try {
        //notifySlack()
        // build steps.
        stage('Checkout'){
            git branch: 'master', changelog: true, credentialsId: '956422af-24d3-499d-9f1e-7b2337978ccb', url: 'https://github.com/vijayvangapandu/springboot-kubernetes-example.git'
        }

        stage('Build'){
            sh 'mvn clean package'
        }

        stage('Test'){
          // This is where your unit testing execution goes
        }

        stage('Coverage Report'){
            // This is where your code coverage / quality executions go if this has been applied to the project
        }

        stage('Docker Build'){
             sh 'docker build . --tag inventory'
           
        }

        stage('Push Docker Image to GCR'){
            //sh 'docker login -u _json_key --password-stdin https://gcr.io < /opt/docker-admin.json'
            //sh 'docker tag notifications-service gcr.io/eharmony-admin-ea022977/notifications-service:$BUILD_NUMBER'
            //sh 'docker push gcr.io/eharmony-admin-ea022977/notifications-service:$BUILD_NUMBER'
            sh 'docker tag inventory localhost:5000/inventory:1.0-SNAPSHOT'
        }

       stage('Deploy container') {
            sh 'kubectl create -f inventory-deployment.yaml'
            sh 'kubectl create -f inventory-service.yaml'
       }

    } catch (e) {
        currentBuild.result = 'FAILURE'
        throw e
    } finally {
        //notifySlack(currentBuild.result)
    }
}
