#!/usr/bin/env groovy 

node {
    deleteDir()
    library "s4sdk-pipeline-library@feature/k8s-stage"
    sh "git clone --depth 1 https://github.com/SAP/cloud-s4-sdk-pipeline.git pipelines"
    load './pipelines/s4sdk-pipeline.groovy'
}
