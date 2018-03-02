# PARSE-ANDROID BOILERPLATE [JAVA]

This is a simple, and hopefully growing, boilerplate for the Parse Android.

## SIMPLE SETUP

First, open the file:

    strings.xml

And replace the strings "**" in:

    <string name="parse_app_id">**</string>
    <string name="parse_client_key">**</string>
    
*in this sample i used back4app.com like service provider but you cant change it too.

If you are using another server change "https://parseapi.back4app.com" in:

    <string name="parse_server_url">https://parseapi.back4app.com/</string>
    
## TEST

Create a Class called: "Test" in your Parse-Server and add a column called "text".

After, add a row and put the "Hello World" text in the column & run the application.

You will see a message on the center of the device screen or Emulator
