import paramiko
ssh = paramiko.SSHClient()
ssh.set_missing_host_key_policy(paramiko.AutoAddPolicy())
ssh.connect(hostname="192.168.1.123", port="2222", username="alumno", password="salesianos")
sftp_client = ssh.open_sftp()
sftp_client.get("encrypted_data.bin", "encrypted_data.bin")
sftp_client.get("private.pem", "private.pem")


sftp_client.close()
ssh.close()


