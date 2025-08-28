const net = require('net');
const readline = require('readline');

const PORT = 5000;
const HOST = 'localhost';

const client = new net.Socket();

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

// Connect to the server
client.connect(PORT, HOST, () => {
  console.log(`Connected to server at ${HOST}:${PORT}`);
  promptCommand();  // Prompt once connected
});

client.on('data', (data) => {
  console.log(data.toString());
});

client.on('end', () => {
  console.log('Disconnected from server.');
  rl.close();
});

client.on('error', (err) => {
  console.error('Connection error:', err.message);
  rl.close();
});

// Function to prompt and handle user input
function promptCommand() {
  rl.question('Enter command: ', (input) => {
    client.write(input);

    if (input.trim().toUpperCase() === 'EXIT') {
      rl.close();      // Stop asking
      client.end();     // End socket connection
    } else {
      promptCommand();  // Keep asking
    }
  });
}
