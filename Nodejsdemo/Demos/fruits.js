const fs = require('fs');              // File System module for reading/writing files
const path = require('path');          // Path module to handle file paths

//  Define an array of fruit objects
const fruits = [
  { id: 1, name: "Apple", color: "Red", price: 120 },
  { id: 2, name: "Banana", color: "Yellow", price: 40 },
  { id: 3, name: "Mango", color: "Orange", price: 150 }
];

//  Define the paths for the files
const fruitsFile = path.join(__dirname, 'fruits.txt');        // Main file to write data
const copyFile = path.join(__dirname, 'fruits_copy.txt');     // Copy file using pipe

/**
  Write fruit data to a file using a Writable Stream
 */
function writeFruitsToFile() {
  // Create a writable stream to 'fruits.txt'
  const writeStream = fs.createWriteStream(fruitsFile);

  // Handle successful write completion
  writeStream.on('finish', () => {
    console.log('Data written to fruits.txt successfully.');
    readFruitsFromFile(); // Start reading after writing is finished
  });

  // Handle any errors during writing
  writeStream.on('error', (err) => {
    console.error('Error writing file:', err);
  });

  // Write each fruit object as a JSON string followed by newline
  fruits.forEach(fruit => {
    writeStream.write(JSON.stringify(fruit) + '\n');
  });

  // Signal that we're done writing
  writeStream.end();
}

/**
  Read from the file using a Readable Stream and handle events
 */
function readFruitsFromFile() {
  console.log('Reading fruits.txt using stream...');

  // Create a readable stream with UTF-8 encoding
  //Reads the file as a stream, in UTF-8 (text) format.
  const readStream = fs.createReadStream(fruitsFile, { encoding: 'utf8' });

  let buffer = ''; // Buffer to accumulate incoming data

  //  When a chunk of data is received
  /*When you read a file using a stream (createReadStream()), you don’t get the whole file at once.
  Instead, you get it piece by piece — and each piece is called a chunk.*/
  readStream.on('data', (chunk) => {
    buffer += chunk; // Append new chunk to the buffer

    // Split buffer by new lines to process each JSON string
    let lines = buffer.split('\n');

    // Save incomplete last line to buffer for next chunk
    buffer = lines.pop();

    // Parse and display each fruit record
    for (const line of lines) {
      if (line.trim()) {
        const fruit = JSON.parse(line);
        console.log(`Fruit ID: ${fruit.id}, Name: ${fruit.name}, Color: ${fruit.color}, Price: ${fruit.price}`);
      }
    }
  });

  // Event: When the stream ends (no more data)
  readStream.on('end', () => {
    // Process remaining data in buffer (if any)
    if (buffer.trim()) {
      const fruit = JSON.parse(buffer);
      console.log(`Fruit ID: ${fruit.id}, Name: ${fruit.name}, Color: ${fruit.color}, Price: ${fruit.price}`);
    }

    // Proceed to copy the file
    copyFruitsFile();
  });

  // Event: Handle errors during reading
  readStream.on('error', (err) => {
    console.error('Error reading file:', err);
  });
}

/**
 * Task 3: Copy content from fruits.txt to fruits_copy.txt using pipe
 */
function copyFruitsFile() {
  // Create readable and writable streams
  const readStream = fs.createReadStream(fruitsFile);
  const writeStream = fs.createWriteStream(copyFile);

  // Pipe data from read stream directly to write stream
  /*pipe() is a method provided by stream objects in Node.js. It is used to connect a readable stream to a writable stream, allowing the data to flow automatically from the source to the destination.*/
  readStream.pipe(writeStream);

  // Event: When writing is finished
  writeStream.on('finish', () => {
    console.log('Content copied to fruits_copy.txt using pipe');
  });

  // Event: Handle errors during writing
  writeStream.on('error', (err) => {
    console.error('Error writing to copy file:', err);
  });
}

// Start the entire process by writing the data first
writeFruitsToFile();
