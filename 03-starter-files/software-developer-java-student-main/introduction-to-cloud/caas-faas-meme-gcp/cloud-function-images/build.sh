#!/bin/bash

# make sure imagemagic is installed
CONVERT=$(convert --version | grep "Command 'convert' not found'")
if [ "$CONVERT" != "" ]; then
    echo "You need to install Imagemagic to proceed with this script"
    echo "sudo apt install -y imagemagick"
    exit -1
fi

# Create the output directories for our base64 and thumbnals
cd code
mkdir -p list
mkdir -p base64
mkdir -p thumb64

# Process all the images
for FILE in $(cd images; ls *.jpg)
do
    echo "Convert file ${FILE}...."
    # Make an empty file with just the image name
    touch list/${FILE}
    # Convert the file to base64
    base64 images/${FILE} >base64/${FILE}.base64
    # Create a thumbnail, then convert it to base64 and remove the original thumbnail
    convert -thumbnail x64 images/${FILE} thumb64/${FILE}
    base64 thumb64/${FILE} >thumb64/${FILE}.thumb64
    rm thumb64/${FILE}
done

# Create the zip file
zip -r ../imagesFunction.zip *.js package.json list/ base64/ thumb64/

# Done
cd ..
