# These curl commands can be run from cloudshell to provide authentication

# Change these constants to match the GCP resources
GCP_Project="caas-faas-meme-project"
GCP_Region="us-central1"

# Successfully get image list
curl -m 70 -X POST "https://${GCP_Region}-${GCP_Project}.cloudfunctions.net/function-memeImages?operation=listImages"

# Successfully get thumbnail list
curl -m 70 -X POST "https://${GCP_Region}-${GCP_Project}.cloudfunctions.net/function-memeImages?operation=getThumbnails"

# Successfully get the doge.jpg image
curl -m 70 -X POST "https://${GCP_Region}-${GCP_Project}.cloudfunctions.net/function-memeImages?operation=getImage&imageName=doge.jpg"

# Fail to get an invalid image
curl -m 70 -X POST "https://${GCP_Region}-${GCP_Project}.cloudfunctions.net/function-memeImages?operation=getImage&imageName=nothing.jpg"

# Fail with a bad operation
curl -m 70 -X POST "https://${GCP_Region}-${GCP_Project}.cloudfunctions.net/function-memeImages?operation=unknown"
