from Crypto.PublicKey import RSA
from Crypto.Cipher import PKCS1_OAEP

# Generar un par de claves RSA para el remitente
key = RSA.generate(2048)
private_key = key.export_key()
public_key = key.publickey().export_key()

public_key_tocha = RSA.import_key(public_key)
cipher_rsa = PKCS1_OAEP.new(public_key_tocha)
message = b"Este es mi mensaje secreto"
encrypted_message = cipher_rsa.encrypt(message)

print("Mensaje encriptado:", encrypted_message)

private_key_tocha = RSA.import_key(private_key)
cipher_rsa = PKCS1_OAEP.new(private_key_tocha)
decrypted_message = cipher_rsa.decrypt(encrypted_message)

print("Mensaje desencriptado:", decrypted_message)