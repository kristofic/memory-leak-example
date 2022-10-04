@echo off
for /l %%x in (1, 1, 100000) do curl http://localhost:8080/user/softec/1 >NUL 2>&1
