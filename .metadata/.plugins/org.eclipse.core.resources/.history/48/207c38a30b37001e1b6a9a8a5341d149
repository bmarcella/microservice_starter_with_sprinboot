kubeclt -> base cmd  represnt by K

K get [PODS, DEPLOYMENTS, SERVICES, NODES,ALL,CONFIGMAP,REPLICASET, HPA] / show all services
NB: REPLICASET IS instance of deployment thats mean number of replica of deployment . 
K apply -f [file_name.yml] / run yml file
# this cmd is to delete instances
K delete [instance: [configmap, pod, service, etc ...]] [ instance_name ]

K scale deployment {name of the dep} --replicas=  number of deployment
K describe [pod, sevice, etc..] name_of_the_instance
K set image deployment {name_dep} name_container=container_name:tag
K get events --sort-by=.metadata.creationTimestamp
K rollout history deployment {name dep}
K rollout undo deployment {name dep}  --to-revision=number of revision horizontl pod auto scaling

K autoscale deployment  name_dep --min =3 --max=10 --cpu-percent=70