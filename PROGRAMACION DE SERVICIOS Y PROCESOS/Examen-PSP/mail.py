import smtplib

client_mail = smtplib.SMTP('192.168.1.45:1025')
client_mail.ehlo()
client_mail.set_debuglevel(1)

message_template='From:%s\r\nTo:%s\r\n\r\n%s'

sender = 'tomas.madan21@zaragoza.salesianos.edu'
dest ='gorka.sanz@zaragoza.salesianos.edu'
message ='Hola :)'

client_mail.sendmail(sender,dest,message_template%(sender,dest,message))
client_mail.close()