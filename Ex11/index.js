"use strict";

const express = require('express');
const MongoClient = require('mongodb').MongoClient;
const ObjectId = require('mongodb').ObjectId;
const MONGO_URL = "mongodb://<dbuser>:<dbpassword>@ds247058.mlab.com:47058/milabsongs";

let app = express();
let port = process.env.PORT || 5000;
let db = ""

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({
    extended: true
}));

MongoClient.connect(MONGO_URL, (err, database) => {
    if (err) {
        console.error(err);
        return;
    }

    db = database.db('milabsongs');
    app.listen(port, () => {
        console.log(`listening on port ${port}`);
    });
});

app.post('/', (req, res) => {
    createNewSong(req.body.songname, req.body.artist, req.body.genre, res)
});

app.put('/', (req, res) => {
    updateSong(req.body.id, req.body.songname, req.body.artist, req.body.genre, res);
});

app.delete('/:id', (req, res) => {
    deleteSong(req.param.id, res);
});



function createNewSong(name, artist, genre, res) {
    if (!name || !artist || !genre){
        res.status(400).send({error: "missing song parameters"})
    }
    else {
        db.collection('songs').insert({songname: name, artist: artist, genre: genre} , function(err, res) {
            if (err) {
                res.send("insert song failed")
            }
            else {
                res.send("song added successfully")
            }
        })
    }
}

function readSongByField(fieldvalue, field, res) {
    db.collection('songs').find({${field}: fieldvalue}).toArray((err, results) => {
        if(err || !results[0]) {
            res.send("Error finding songs");
        }
        else {
            res.write(`Songs found:\n`);
            results.forEach(song => printOneSong(song, res));
            res.end();
        }
    });
}

function printOneSong(song, res) {
    res.write(`Song name: ${song.name}\n`);
    res.write(`Song artist: ${song.artist}\n`);
    res.write(`Song genre: ${song.genre}\n`);
    res.write(`Song id: ${song._id}\n\n`);
}

function updateSong(id, name, artist, genre, res) {
    db.collection('songs').updateOne({_id: ObjectId(id)}, {$set: {songname: name, artist: artist, genre: genre} }, function (err, numUpdated) {
            if (err) {
                res.send("update song " + id + "failed");
            } 
            else if (numUpdated) {
                res.send("song update successfully");
            }
            else {
                res.send("song not found");
            }
        })
}

function deleteSong(songId, res) {
    db.collection('songs').deleteOne({ _id: ObjectId(songId) }, function(err, res) {
        if (err) {
                res.send("delete song " + id + "failed");
            } 
            else {
                res.send("song deleted successfully");
            }
    });
}

