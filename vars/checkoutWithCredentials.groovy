def call(Map config) {
    def credentialsId = config.credentialsId
    def scmUrl = config.scmUrl
    def destination = config.destination

    node {
        checkout([
            $class: 'GitSCM',
            branches: [[name: '*/master']],
            userRemoteConfigs: [[url: scmUrl, credentialsId: credentialsId]],
            doGenerateSubmoduleConfigurations: false,
            extensions: [[$class: 'CleanBeforeCheckout']],
            submoduleCfg: [],
            relativeTargetDir: destination,
        ])
    }
}
