const express = require('express');
const fs = require('fs');

let app = express();
let port = process.env.PORT || 5000;



app.get('/server/files', (req, res) => {
	let file = req.query.filename;
	const readStream = fs.createReadStream(file);
	readStream.pipe(res);
});

app.listen(port, () => {
		console.log(`listening on port ${port}`);
});
