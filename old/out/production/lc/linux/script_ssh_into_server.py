# file: script_ssh_into_server.py
# run: python script_ssh_into_server.py

import subprocess


print("starting script...")
print()

host = "imac.local"
# port = 22
user = "tcs"
# password = "meow"
command = "hostname"

subprocess.Popen(f"ssh {user}@{host} {command}", shell=True, stdout=subprocess.PIPE, stderr=subprocess.PIPE).communicate()



print()
print("script done")
