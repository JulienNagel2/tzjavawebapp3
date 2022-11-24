allow_k8s_contexts('jngtkc1')
SOURCE_IMAGE = os.getenv("SOURCE_IMAGE", default='jngharbor.allintanzu.com/tap1.3.2/vscodeapps/tanzu-java-web-app')
LOCAL_PATH = os.getenv("LOCAL_PATH", default='/Users/jnagel/jng/app/ztestsjng/tests_TAP/w3/tanzu-java-web-app')
NAMESPACE = os.getenv("NAMESPACE", default='jngnsdev2')
OUTPUT_TO_NULL_COMMAND = os.getenv("OUTPUT_TO_NULL_COMMAND", default=' > /dev/null ')
CERTFILE = "/Users/jnagel/jng/app/ztestsjng/tests_TAP/harbor/ca.crt"

k8s_custom_deploy(
    'tanzu-java-web-app',
    apply_cmd="tanzu apps workload apply -f config/workload.yaml --debug --live-update" +
               " --local-path " + LOCAL_PATH +
               " --source-image " + SOURCE_IMAGE +
               " --namespace " + NAMESPACE +
               " --yes " +
               " --registry-ca-cert " + CERTFILE +  
               OUTPUT_TO_NULL_COMMAND + 
               " && kubectl get workload tanzu-java-web-app --namespace " + NAMESPACE + " -o yaml",
    delete_cmd="tanzu apps workload delete -f config/workload.yaml --namespace " + NAMESPACE + " --yes",
    deps=['pom.xml', './target/classes'],
    container_selector='workload',
    live_update=[
      sync('./target/classes', '/workspace/BOOT-INF/classes')
    ]
)

k8s_resource('tanzu-java-web-app', port_forwards=["8080:8080"],
            extra_pod_selectors=[{'serving.knative.dev/service': 'tanzu-java-web-app'}])
