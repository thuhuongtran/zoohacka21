const express = require('express');
const path = require('path');
const app = express();

app.use(express.static(__dirname + '/'));

app.get('/*', (req,res) => {

res.sendFile('index.html', {root: path.join(__dirname+"/src")});
});
app.listen(process.env.PORT || 8082);
