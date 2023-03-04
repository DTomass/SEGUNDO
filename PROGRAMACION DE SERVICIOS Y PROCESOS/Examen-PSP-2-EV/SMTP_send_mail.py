import smtplib

client_mail = smtplib.SMTP('192.168.1.123:1081')
client_mail.ehlo()
client_mail.set_debuglevel(1)

message_template='From:%s\r\nTo:%s\r\nSubject:%s\r\n\r\nMessage:%s'

subject='Correo examen Daniel Tomas :)'
sender = 'tomas.madan21@zaragoza.salesianos.edu'
dest ='gorka.sanz@zaragoza.salesianos.edu'
message ='Hola :)'

client_mail.sendmail(sender,dest,message_template%(sender,dest,subject,message))
client_mail.close()