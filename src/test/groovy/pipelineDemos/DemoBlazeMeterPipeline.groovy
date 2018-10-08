def execute() {
    node() {
        stage('Checkout source code') {
            checkout(
                    [
                            $class                           : 'GitSCM',
                            branches                         : [[name: '*/master']],
                            doGenerateSubmoduleConfigurations: false,
                            extensions                       : [],
                            submoduleCfg                     : [],
                            userRemoteConfigs                : [
                                    [url: 'some_test_repo']]
                    ]
            )
        }

        stage("Execute test") {
            sh "./gradlew test"
        }
    }
}

return this