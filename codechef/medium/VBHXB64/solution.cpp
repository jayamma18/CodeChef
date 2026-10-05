const http = require('http');
const url = require('url');

const server = http.createServer((req, res) => {
  const parsedUrl = url.parse(req.url, true);
    const pathname = parsedUrl.pathname;
      const query = parsedUrl.query;

        if (pathname === '/product') {
            const id = query.id;

                if (id === undefined || id === '') {
                      res.writeHead(400, { 'Content-Type': 'text/plain' });
                            res.end('Error: Product ID is required');
                                } else if (id === '123') {
                                      res.writeHead(200, { 'Content-Type': 'text/plain' });
                                            res.end('Product ID: 123, Name: Example Product, Price: $25');
                                                } else if (id === '456') {
                                                      res.writeHead(200, { 'Content-Type': 'text/plain' });
                                                            res.end('Product ID: 456, Name: Another Product, Price: $50');
                                                                } else {
                                                                      res.writeHead(404, { 'Content-Type': 'text/plain' });
                                                                            res.end('Not Found');
                                                                                }
                                                                                  } else {
                                                                                      res.writeHead(404, { 'Content-Type': 'text/plain' });
                                                                                          res.end('Not Found');
                                                                                            }
                                                                                            });

                                                                                            server.listen(3000);