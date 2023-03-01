from Crypto.PublicKey import RSA
from Crypto.Cipher import AES, PKCS1_OAEP

archivo_encriptado = open("encriptado.bin", "rb")

private_key = RSA.import_key(open("private.pem").read())

enc_session_key = archivo_encriptado.read(private_key.size_in_bytes())
archivo_encriptado.close()

cipher_rsa = PKCS1_OAEP.new(private_key)
session_key = cipher_rsa.decrypt(enc_session_key)
print(session_key)
#print(session_key.decode("utf-8"))
