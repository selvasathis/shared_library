def call() {
    sh 'mvn clean package'
    echo 'mvn clean package done'
}