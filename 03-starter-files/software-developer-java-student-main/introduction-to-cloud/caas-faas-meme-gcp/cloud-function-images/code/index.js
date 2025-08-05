const imagedb = require('./imagedb');

/**
** Responds to any HTTP request.
**
** @param {!express:Request} req HTTP request context.
** @param {!express:Response} res HTTP response context.
**/

exports.memeImages = (req, res) => {
    console.log("(*) imagesManager invoked ->");
    console.log(req);

    // Default response includes the event and is an illegal operation
    let responseBody = {};
    let responseCode = 501;
    console.log("(*) Received query: ->");
    console.log(req.query);
    responseCode = 502;
    console.log("(*) Request method:", req.method);

    // See if they specified an operation
    if (req.query.operation) {
        const operation = req.query.operation;
        responseCode = 503;

        // Fetch a list of the images we have
        const imageList = imagedb.getImageList();
        responseCode = 504;

        switch (operation) {
            // See if they asked for a list of images
            case "listImages":
                responseBody['imageList'] = imageList;
                responseCode = 200;
                break;

            // See if they asked for a list of thumbnails
            case "getThumbnails":
                responseBody = imagedb.getImageThumbnailObjects();
                if (responseBody.count > 0) {
                    responseCode = 200;
                } else {
                    responseCode = 406
                }
                break;

            // See if they asked for a specific image
            case "getImage":
                const imageName = req.query.imageName;
                if (imageList.indexOf(imageName) > -1) {
                    responseBody = imagedb.getImageDataObject(imageName);
                    responseCode = 200;
                } else {
                    responseBody['statusMessage'] = "I do not have that image in my database: " + imageName;
                    responseCode = 404;
                }
                break;

            // They asked for an operation that is unknown to me
            default:
                responseBody['error'] = "I do not understand that operation: " + operation;
                responseCode = 404;
                break;
        }
    } else {
        responseBody['statusMessage'] = "You need to feed me an operation to perform in the query parameters";
        responseCode = 204;
    }

    // Return the response
    console.log("(*) Response code:", responseCode, "body: ->");
    console.log(responseBody);

    res.set('Access-Control-Allow-Origin', '*');  // Cloud Run and Cloud Functions are different domains
    res.status(responseCode).send(JSON.stringify(responseBody));
};
