const http = require('http');

const server = http.createServer((req, res) => {
    res.writeHead(200, { 'Content-Type': 'application/json' });
    res.end(JSON.stringify({
        service: 'API Service',
        status: 'running',
        timestamp: new Date().toISOString()
    }));
});

server.listen(3000, () => {
    console.log('API service started on port 3000');
});
