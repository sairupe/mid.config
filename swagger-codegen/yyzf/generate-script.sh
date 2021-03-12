#!/bin/bash
single_project_name=${1}
app_key=${2}
api_version_number=${3}
package_path=${4}

cp /data/codegen/swagger-codegen-cli-2.4.9.jar ./
cp /data/codegen/generate-script.sh ./
cp -R /data/codegen/mustaches ./

rm -fr ./${single_project_name}.rpc

java -jar swagger-codegen-cli-2.4.9.jar generate -i ./api-docs/${single_project_name}/${single_project_name}_${api_version_number}.json \
-l java \
--additional-properties \
appKey=${app_key} \
-t ./mustaches \
--library feign \
--model-package  com.yyzf.${single_project_name}.rpc.model \
--api-package  com.yyzf.${single_project_name}.rpc.api \
--library feign \
--group-id com.yyzf \
--artifact-id ${single_project_name}.rpc \
--artifact-version ${api_version_number} \
-Dapis \
-Dmodels \
-DmodelTests=false  \
-DapiTests=false \
-DsupportingFiles \
-o ./${single_project_name}.rpc

rm -rf ./${package_path}/auth
rm -rf ./${package_path}/ApiClient.java
rm -rf ./${package_path}/CustomInstantDeserializer.java
rm -rf ./${package_path}/ParamExpander.java
rm -rf ./${package_path}/RFC3339DateFormat.java

cd ${single_project_name}.rpc

mvn clean deploy -Dmaven.test.skip=true -Dmaven.javadoc.skip=true