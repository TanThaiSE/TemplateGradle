#!/bin/bash

function upload_files () {
  gsutil -m cp -r $1 $2/
  gsutil -m acl -r set public-read $2/*
}
