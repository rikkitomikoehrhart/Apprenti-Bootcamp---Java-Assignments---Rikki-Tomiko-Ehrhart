// Javascript code to go along with our meme-generator website

// Change these constants to match your GCP deployment
const GCP_Project = "caas-faas-meme-project"
const GCP_Region = "us-central1"

// Fetch the thumbnail images from the API
const fetchThumbnailImages = async () => {
    const response = await fetch(
        `https://${GCP_Region}-${GCP_Project}.cloudfunctions.net/function-memeImages?operation=getThumbnails`,
        {
            method: 'GET',
            headers: {
                accept: 'application/json',
            },
        });
    const thumbListJson = await response.json(); //extract JSON from the http response
    buildThumbnails(thumbListJson);
}

// Go get them now as we load the rest
fetchThumbnailImages();

// Fetch the image from the API
const fetchImageJson = async (fileName) => {
    const response = await fetch(
        `https://${GCP_Region}-${GCP_Project}.cloudfunctions.net/function-memeImages?operation=getImage&imageName=${fileName}`,
        {
            method: 'GET',
            headers: {
                accept: 'application/json',
            },
        });
    const imageJson = await response.json(); //extract JSON from the http response
    return(imageJson);
}

// Generate the meme by drawing the image, then the top and bopttom text on top
function generateMeme(img, topText, bottomText) {
    const topTextSize = 0.12;
    const bottomTextSize = 0.15;
    const canvas = document.getElementById('meme-canvas');
    const ctx = canvas.getContext('2d');

    // Size canvas to image
    canvas.width = img.width;
    canvas.height = img.height;

    // Clear canvas and draw the image
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    ctx.drawImage(img, 0, 0);

    // Text style: white with black borders
    ctx.fillStyle = 'white';
    ctx.strokeStyle = 'black';
    ctx.textAlign = 'center';

    // Draw top text
    let fontSize = canvas.width * topTextSize;
    ctx.font = `${fontSize}px Impact`;
    ctx.lineWidth = fontSize / 20;
    ctx.textBaseline = 'top';
    topText.split('\n').forEach((t, i) => {
        ctx.fillText(t, canvas.width / 2, i * fontSize, canvas.width);
        ctx.strokeText(t, canvas.width / 2, i * fontSize, canvas.width);
    });

    // Draw bottom text
    fontSize = canvas.width * bottomTextSize;
    ctx.font = `${fontSize}px Impact`;
    ctx.lineWidth = fontSize / 20;
    ctx.textBaseline = 'bottom';
    bottomText.split('\n').reverse().forEach((t, i) => { // .reverse() because it's drawing the bottom text from the bottom up
        ctx.fillText(t, canvas.width / 2, canvas.height - i * fontSize, canvas.width);
        ctx.strokeText(t, canvas.width / 2, canvas.height - i * fontSize, canvas.width);
    });
}

// Add all listeners when the document first loads
window.addEventListener('DOMContentLoaded', (event) => {
    // Initialize variables
    const imageInput = document.getElementById('image-input');
    const topTextInput = document.getElementById('top-text');
    const bottomTextInput = document.getElementById('bottom-text');
    const generateBtn = document.getElementById('generate-btn');
    topTextInput.value = 'Top line text';
    bottomTextInput.value = 'Bottom line text';

    // Generate button click listener
    generateBtn.addEventListener('click', () => {
        const radioChecked = document.querySelector('input[type=radio][name=imageSelected]:checked');

        // The file was presented as an upload fle
        if (typeof imageInput.files[0] != "undefined") {
            console.log("Perform file upload:", imageInput.files[0].name);
            // Read image as DataURL using the FileReader API
            const reader = new FileReader();
            reader.onload = () => {
                const img = new Image;
                img.src = reader.result;
                img.onload = () => {
                    generateMeme(img, topTextInput.value, bottomTextInput.value);
                };
            };
            reader.readAsDataURL(imageInput.files[0]);
        } else if (radioChecked) { // A thumbnail radio button was used to select a file
            const imageName = radioChecked.value;
            console.log("Get file from API:", imageName);
            var img = new Image();
            fetchImageJson(imageName)
            .then(imgJson => {
                const img64 = imgJson.base64;
                img.src = `data:image/png;base64,${img64}`;
                img.onload = () => {
                    generateMeme(img, topTextInput.value, bottomTextInput.value);
                }
            });
        } else {
            console.error("No file upload or thumbnail selected - not sure what to draw");
        }
    });
});

// Function to define innerHTML for HTML table
function buildThumbnails(thumbListJson) {
    let radio = "";
    
    // Loop to access all rows 
    for (let thumb of thumbListJson.thumbNails) {
        radio += `
        <label>
            <input type="radio" name="imageSelected" value="${thumb.imageName}">
            <img src="data:image/png;base64,${thumb.base64}"/>
        </label>
        `;
    }
    // Setting innerHTML as radio variable
    document.getElementById("radio").innerHTML = radio;

    setRadioToClearFileInput();
}

// Clear the file upload if any radio button is selected
function setRadioToClearFileInput() {
    const upload = document.getElementById('image-input');        
    const generateBtn = document.getElementById('generate-btn');
    const radioButtons = document.querySelectorAll('input[name=imageSelected]');
    for (const radioButton of radioButtons) {
        radioButton.onclick = function() {
            upload.value = "";
            generateBtn.disabled = false;
        }
    }
}

// Deselect any radio buttons if the file upload is selected
document.getElementById('image-input').onchange = function() {
    var radio = document.querySelector('input[type=radio][name=imageSelected]:checked');
    if (radio) radio.checked = false;
    const generateBtn = document.getElementById('generate-btn');
    generateBtn.disabled = false;
}
