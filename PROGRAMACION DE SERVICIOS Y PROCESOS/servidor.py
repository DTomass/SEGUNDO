#!/usr/bin/python3
from http.server import BaseHTTPRequestHandler,HTTPServer
from urllib.parse import urlparse
params='192.168.10.72',8080
class HelloHandler(BaseHTTPRequestHandler):
    def do_GET(self):
        infos=[]
        infos.append('client_adress:%s'%str(self.client_address))
        infos.append('address_string:%s'%self.address_string())
        infos.append('command:%s'%self.command)
        infos.append('unparsedpath:%s'%self.path)
        parsed=urlparse(self.path)
        infos.append('parsedpath%s'%parsed.path)
        infos.append('query:%s'%parsed.query)
        infos.append('request_version:%s'% self.request_version)
        infos.append('server_version:%s'%self.server_version)
        infos.append('sys_version:%s'%self.sys_version)
        infos.append('protocol_version:%s'%self.protocol_version)
        for k,v in self.headers.items():
            infos.append('HEADER%s:%s'%(k,v.strip()))
        infos=b'<ul><li>'+b'</li><li>'.join([bytes(i,'utf-8')for i in infos])+b'</li></ul>'
        self.wfile.write(b"""<html><head><title>Hello World</title></head><body><p>HelloWorld</p>"""+infos+b"""</body></html>""")
        self.send_response(200)
        self.send_header(b'Content-type',b'text.html')
        self.end_headers()
        return

server=HTTPServer(params,HelloHandler)
server.serve_forever()