def call('mvn clean') {
    sh 'mvn clean package'
    echo 'mvn clean package done'
}
def call('mvn test') {
    sh 'mvn test'
    echo 'mvn test done'
}