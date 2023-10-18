    def scm_checkout() {
        echo 'get the file'
        git 'https://github.com/selvasathis/nexus.git'
    }
    def npm_package() {
        echo 'running npm package'
        sh 'npm install'
    }
