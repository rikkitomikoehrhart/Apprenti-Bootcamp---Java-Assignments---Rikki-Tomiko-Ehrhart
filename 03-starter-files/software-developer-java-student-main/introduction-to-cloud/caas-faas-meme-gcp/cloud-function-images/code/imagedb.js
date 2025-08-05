const fs = require('fs-extra');
const path = require('path');

function getImageList() {
    let imageList = [];
    const srcPath = path.join(".", "list");
    const dir = fs.readdirSync(srcPath);
    for (const item of dir) {
        imageList.push(item);
    }
    return imageList;
}

function getImageThumbnailObjects() {
    let thumbList = [];
    let count = 0;
    let overallStatus = "Success";
    const srcPath = path.join(".", "list");
    const dir = fs.readdirSync(srcPath);
    for (const item of dir) {
        let status = "Unset";
        const filename = path.join(".","thumb64", item + ".thumb64");
        if (fs.existsSync(filename)) {
            data = fs.readFileSync(filename, "utf8");
            status = "Success";
            count++;
        } else {
            data = "Thumb not found";
            status = "Failed";
            overallStatus = "Failed";
        }
        const thumb = {
            imageName: item,
            statusMessage: status,
            base64: data
        };
        thumbList.push(thumb);
    }
    return {
        thumbNails: thumbList,
        statusMessage: overallStatus,
        count: count
    };
}

function getImageDataObject(imageName) {
    let data = "Unset";
    let status = "Unset";

    const filename = path.join(".","base64", imageName + ".base64");
    if (fs.existsSync(filename)) {
        data = fs.readFileSync(filename, "utf8");
        status = "Success";
    } else {
        data = "File not found";
        status = "Failed";
    }

    return {
        imageName: imageName,
        statusMessage: status,
        base64: data
    };
}

module.exports = { getImageList, getImageThumbnailObjects, getImageDataObject };
