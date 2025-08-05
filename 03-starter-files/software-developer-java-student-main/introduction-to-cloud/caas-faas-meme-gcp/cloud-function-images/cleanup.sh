#!/bin/bash

# Remove any output directories for the base64 and thumbnals
rm -rf code/list code/base64 code/thumb64

# Remove the zip file
rm -f imagesFunction.zip

# Remove and node packages that were installed
rm -rf node_modules
rm -f package-lock.json