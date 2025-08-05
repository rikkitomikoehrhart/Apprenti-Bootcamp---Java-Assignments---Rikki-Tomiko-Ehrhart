#!/bin/sh

GCRREPONAME="caas-faas-meme-repo"
GCRPROJECT="caas-faas-meme-project"
GCRLOCATION="us-central1"
GCRREPO="${GCRLOCATION}-docker.pkg.dev"

LOCALTAG="meme-web-image"

echo "This script needs docker running locally to build docker images, and the gcloud utility and a valid login currently configured...."
echo " "

### Build the image locally as meme-web-image
echo "Build the docker image...."
dos2unix htdocs/*
docker build --no-cache -t $LOCALTAG .

### Look for the GCP artifact registry to push to
echo "Look for our artifact registry at GCP...."
GAR=$(gcloud artifacts repositories list --project=$GCRPROJECT --location=$GCRLOCATION | grep $GCRREPONAME | wc -l)
if [ "$GAR" != "1" ]; then
    ### Create an artifact registry at GCP to be our container registry
    echo "Create a new artifact registry to hold our Docker images...."
    gcloud artifacts repositories create $GCRREPONAME \
      --project=$GCRPROJECT \
      --location=$GCRLOCATION \
      --repository-format=docker \
      --description="Docker repository for CaaS FaaS demo"

    echo "Add a helper to your local auth to use gcloud to auth into artifact registry...."
    gcloud auth configure-docker $GCRREPO
else
    echo "We already have a valid artifact registry at GCP - skipping."
fi

### Tag the image to go to GCP
echo "Tag the image with our remote repository and push it...."
REMOTETAG="$GCRREPO/$GCRPROJECT/$GCRREPONAME/$LOCALTAG:latest"
docker tag $LOCALTAG $REMOTETAG
docker push $REMOTETAG

echo " "
echo "The image is now pushed to GCP - use the image $REMOTETAG in your application"
