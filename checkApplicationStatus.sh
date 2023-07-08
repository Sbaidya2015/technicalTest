$ WEBPAGE="https://www.google.com/" # web page to be loaded
$ STDOUTFILE=".tempCurlStdOut" # temp file to store stdout
$ > $STDOUTFILE # cleans the file content

$ HTTPCODE=$(curl --max-time 5 --silent --write-out %{response_code} --output "$STDOUTFILE" "$WEBPAGE")
$ CONTENT=$(<$STDOUTFILE) # if there are no errors, this is the HTML code of the web page

$ echo "HTTP CODE: "$HTTPCODE
$ echo "CONTENT LENGTH: "${#CONTENT}" chars" # HTML length