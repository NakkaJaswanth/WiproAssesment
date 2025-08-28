const net = require('net');

const PORT = 5000;
const jewelleryItems = [
  { id: 1, name: 'Gold Ring', quantity: 5, price: 15000 },
  { id: 2, name: 'Silver Necklace', quantity: 3, price: 5000 }
];

// Create the TCP server
const server = net.createServer((socket) => {
  console.log('Client connected');

  socket.write('Welcome to the Jewellery Stock Server!\n');

  socket.on('data', (data) => {
    const input = data.toString().trim();
    const parts = input.split(' ');

    const command = parts[0].toUpperCase();

    switch (command) {
      case 'LIST':
        if (jewelleryItems.length === 0) {
          socket.write('No jewellery items found.\n');
        } else {
          jewelleryItems.forEach(item => {
            socket.write(`ID: ${item.id}, Name: ${item.name}, Quantity: ${item.quantity}, Price: ${item.price}\n`);
          });
        }
        break;

      case 'ADD':
        if (parts.length < 5) {
          socket.write('Invalid ADD command. Usage: ADD <id> <name> <quantity> <price>\n');
        } else {
          const [_, idStr, ...rest] = parts;
          const id = parseInt(idStr);
          const quantity = parseInt(rest[rest.length - 2]);
          const price = parseFloat(rest[rest.length - 1]);
          const name = rest.slice(0, rest.length - 2).join(' ');

          if (isNaN(id) || isNaN(quantity) || isNaN(price)) {
            socket.write('Invalid number input for ID, Quantity, or Price.\n');
            return;
          }

          jewelleryItems.push({ id, name, quantity, price });
          socket.write('Jewellery item added successfully!\n');

          console.log(`Added: ID=${id}, Name=${name}, Quantity=${quantity}, Price=${price}`);
        }
        break;

      case 'EXIT':
        socket.write('Client disconnected\n');
        socket.end();
        break;

      default:
        socket.write('Unknown command. Available commands: LIST, ADD, EXIT\n');
    }
  });

  socket.on('end', () => {
    console.log('Client disconnected');
  });

  socket.on('error', (err) => {
    console.error('Socket error:', err.message);
  });

});

// Start the server
server.listen(PORT, () => {
  console.log(`Server listening on port ${PORT}`);
});

server.on('error', (err) => {
  console.error('Server error:', err.message);
});
