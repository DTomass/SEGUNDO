import http.client
conn=http.client.HTTPConnection('192.168.10.70',8080)
conn.request('GET','/url/de/test?a=42&b=si')
response = conn.getresponse()
response.status,response.reason
(200,'OK')
response.read()