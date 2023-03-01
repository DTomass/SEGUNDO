import paramiko
ssh = paramiko.SSHClient()
ssh.set_missing_host_key_policy(paramiko.AutoAddPolicy())
ssh.connect(hostname="", port="", username="", password="")
sftp_client = ssh.open_sftp()
sftp_client.get("archivo_desencriptado.txt", "/home/carpeta/archivo_en_server.txt")

sftp_client.close()
ssh.close()
