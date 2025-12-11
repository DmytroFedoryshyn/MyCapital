#!/bin/bash

# Example: How this script would be used for the MyCapital project

# Option 1: Basic setup without auto-push (safer)
./git-setup.sh \
  -u DmytroFedoryshyn \
  -e dimonty2003@gmail.com \
  -r DmytroFedoryshyn/MyCapital \
  -k ~/.ssh/id_rsa_personal

# Option 2: Complete setup with auto-push
./git-setup.sh \
  -u DmytroFedoryshyn \
  -e dimonty2003@gmail.com \
  -r DmytroFedoryshyn/MyCapital \
  -k ~/.ssh/id_rsa_personal \
  -m "Initial commit" \
  -p

# Option 3: Initialize new repo and push
./git-setup.sh \
  -u DmytroFedoryshyn \
  -e dimonty2003@gmail.com \
  -r DmytroFedoryshyn/MyCapital \
  -k ~/.ssh/id_rsa_personal \
  -i \
  -p \
  -m "Initial project setup"

# Option 4: Using main branch instead of master
./git-setup.sh \
  -u DmytroFedoryshyn \
  -e dimonty2003@gmail.com \
  -r DmytroFedoryshyn/MyCapital \
  -k ~/.ssh/id_rsa_personal \
  -b main \
  -p

