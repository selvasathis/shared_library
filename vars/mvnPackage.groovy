def call() {
    def mvnHome =  tool name: 'maven3', type: 'maven'   
    sh "${mvnHome}/bin/mvn clean package"
}