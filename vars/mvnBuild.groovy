// def mvnClean() {
//     sh 'mvn clean package',
//     echo 'mvn clean package done'
// }
// def mvnTest() {
//     sh 'mvn test',
//     echo 'mvn test done'
// }
def call() {
    sh 'sudo apt install maven -y'
    echo 'mvn package installation done'
}
// def call('mvn clean') {
//     sh 'mvn clean package'
//     echo 'mvn clean package done'
// }
// def call('mvn test') {
//     sh 'mvn test'
//     echo 'mvn test done'
// }