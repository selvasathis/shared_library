def call () {
    def npm_package = {
        echo 'running npm package'
        sh 'npm install'
    }
    def docker_build = {
        echo 'docker building in progress'
        sh 'docker build -t nodejsnew .'
    }
    def container_deploy = {
        echo 'container deploy in progress'
        sh ' docker run -itd --name cont1nodejs -p 9090:8080 nodejsnew'
    }
    def push_image = {
        withCredentials([usernamePassword(credentialsId: 'nexus_pass', usernameVariable: 'NEXUS_USERNAME' , passwordVariable: 'NEXUS_PASSWORD')]) {
            sh "docker login -u ${NEXUS_USERNAME} -p ${NEXUS_PASSWORD} 3.112.178.107:8085"
            sh "docker tag nodejsnew ${NEXUS_REPO}:${NEXUS_PORT}/Sathis"
            sh "docker push ${NEXUS_REPO}:${NEXUS_PORT}/sathis"
            echo "image pushed successfully "
        }
    }
}


// stage('Nexus Image Push'){
//    withCredentials([usernamePassword(credentialsId: 'docker-credentials', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
//        sh "docker login -u ${DOCKER_USERNAME} -p ${DOCKER_PASSWORD} 3.110.193.37:8083"
//        sh "docker tag saidamo/myweb:0.0.2 3.110.193.37:8083/damo:1.0.0"
//        sh 'docker push 3.110.193.37:8083/damo:1.0.0'
//    }
// }
