const express = require('express');
const fs = require('fs');

let app = express();
let port = process.env.PORT || 5000;

app.get('/server/getTime', (req, res) => {
	let time = new Date();
	res.send(`The local time is ${time.toLocaleTimeString()}`);
});

app.get('/server/getFile', (req, res) => {
	let file = req.query.filename;
	fs.readFile(file, 'utf8', (err, content) => {
		if (err) {
			res.send("Cant open file");
			return console.log(err);
		}
		res.send(content);
	});
});

app.listen(port, () => {
		console.log(`listening on port ${port}`);
});
