mvn clean package && \
aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin 624676054102.dkr.ecr.us-east-1.amazonaws.com && \
docker build -t inventory-app . && \
docker tag inventory-app:latest 624676054102.dkr.ecr.us-east-1.amazonaws.com/inventory-app:latest && \
docker push 624676054102.dkr.ecr.us-east-1.amazonaws.com/inventory-app:latest