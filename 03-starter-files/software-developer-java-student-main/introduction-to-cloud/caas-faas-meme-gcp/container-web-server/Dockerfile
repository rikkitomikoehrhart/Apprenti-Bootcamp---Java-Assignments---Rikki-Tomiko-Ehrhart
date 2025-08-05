# Start with the Apache2 HTTPD public image from Dockerhub
# The Aplipne version is smaller
FROM httpd:alpine

# Copy our website files
COPY htdocs/* /usr/local/apache2/htdocs/

# Expose port 80 so we can use it from a browser
EXPOSE 80
