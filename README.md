# Extracting Text from Images using Tesseract OCR Library in Java

This project demonstrates how to use Tesseract OCR library in Java to extract text from images. Tesseract is an open source OCR engine that can recognize text within images.
Prerequisites

    Java Development Kit (JDK) 8 or later
    Tesseract OCR library
    Tess4J library

Installation

    Download and install Tesseract OCR library from here.
    Add the path to Tesseract executable to your system's PATH environment variable.
    Add Tess4J library to your project's dependencies. You can download the latest version of Tess4J from here.
    Include the Tess4J library in your project's build path.

Usage

To use this project, follow these steps:

    Clone this repository to your local machine.
    Open the project in your favorite IDE.
    Run the Main.java file.
    The project will create two HTML files in the output directory - chinese.html and english.html
    The chinese.html file will contain Chinese content and the english.html file will contain English content.

Result for chinese text:
![](chinese.png?raw=true)

Result for english text:
![](english.png?raw=true)


## Additional Steps for Mac Users

If you're using a Mac and encountering an UnsatisfiedLinkError when running the project, you may need to perform some additional steps to set up the Tesseract OCR library correctly.
Source https://stackoverflow.com/questions/21394537/tess4j-unsatisfied-link-error-on-mac-os-x

If you need to update the version of the Tess4J library used in your project, you can follow these steps to make sure the library is correctly set up on your Mac:

Replace {VERSION} with the version of Tesseract OCR installed on your machine.
Open Terminal and navigate to the directory where the Tess4J library is installed on your machine. For example:

    cd /Users/username/.m2/repository/net/sourceforge/tess4j/tess4j/{VERSION}/

Create a new directory called darwin in the Tess4J library directory:

    mkdir darwin

Copy the Tess4J library JAR file to the darwin directory:

    jar uf tess4j-{VERSION}.jar darwin/

Replace tess4j-4.5.4.jar with the name of the Tess4J library JAR file for your version.

Run the following command to find the path to the libtesseract library on your machine:

    brew info tesseract

This will output information about the Tesseract OCR library installed on your machine, including the path to the libtesseract library.

Copy the libtesseract library to the darwin directory in the Tess4J library:

    cp /usr/local/Cellar/tesseract/{VERSION}/lib/libtesseract.{VERSION}.dylib darwin/libtesseract.dylib

Add the libtesseract library to the Tess4J library JAR file:

    jar uf tess4j-{VERSION}.jar darwin/libtesseract.dylib

Verify that the libtesseract library has been added to the Tess4J library JAR file:

    jar tf tess4j-{VERSION}.jar

This will output a list of all the files in the Tess4J library JAR file. Make sure that darwin/libtesseract.dylib is listed.

