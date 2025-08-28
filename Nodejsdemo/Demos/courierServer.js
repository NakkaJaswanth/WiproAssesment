
const express = require('express');
const bodyParser = require('body-parser');
const path = require('path');
const mysql = require('mysql2');

const app = express();
const PORT = 3000;

// Middleware
app.use(bodyParser.urlencoded({ extended: true }));

// MySQL connection
const db = mysql.createConnection({
  host: 'localhost',
  user: 'root',         
  password: 'J@sh8367',         
  database: 'courier_db'
});

// Connect to database
db.connect((err) => {
  if (err) {
    console.error('MySQL connection error:', err.message);
    process.exit(1);
  }
  console.log('Connected to MySQL database');
});

// Serve HTML form
app.get('/', (req, res) => {
  res.sendFile(path.join(__dirname, 'index.html'));
});

// Handle form submission
app.post('/submit', (req, res) => {
  const {
    trackingId,
    senderName,
    receiverName,
    pickupAddress,
    deliveryAddress,
    weight
  } = req.body;

  // Validate fields
  if (!trackingId || !senderName || !receiverName || !pickupAddress || !deliveryAddress || !weight) {
    return res.send('All fields are required.');
  }

  const parsedWeight = parseFloat(weight);
  const cost = 50 + (parsedWeight * 20);

  const sql = `
    INSERT INTO bookings (trackingId, senderName, receiverName, pickupAddress, deliveryAddress, weight, cost)
    VALUES (?, ?, ?, ?, ?, ?, ?)
  `;

  const values = [trackingId, senderName, receiverName, pickupAddress, deliveryAddress, parsedWeight, cost];

  db.query(sql, values, (err, result) => {
    if (err) {
      console.error('MySQL insert error:', err.message);
      return res.send('Error storing courier data.');
    }

    res.send(`
      <h2>Courier Booking Confirmation</h2>
      <p>Courier Tracking ID: ${trackingId}</p>
      <p>Sender: ${senderName}</p>
      <p>Receiver: ${receiverName}</p>
      <p>Pickup: ${pickupAddress}</p>
      <p>Delivery: ${deliveryAddress}</p>
      <p>Weight: ${parsedWeight} kg</p>
      <p>Delivery Cost: ₹${cost}</p>
    `);
  });
});

// Start server
app.listen(PORT, () => {
  console.log(`Server running at http://localhost:${PORT}`);
});
