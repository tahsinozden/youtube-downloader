#!/bin/bash

sudo docker build . --rm -t youtube-downloader
sudo docker run -it -p 8080:8080 youtube-downloader:latest