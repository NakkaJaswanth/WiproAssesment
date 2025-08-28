const db = require('./mysqldbconnection');
/*A callback is a function that is passed as an argument to another function, and is executed after that function finishes its task.*/
//Without callbacks, Node.js would try to run all these at once, and results might be wrong.
// CREATE
function addStock(symbol, companyName, price, volume, callback) {
  db.query(
    'INSERT INTO stocks (symbol, companyName, price, volume) VALUES (?, ?, ?, ?)',
    [symbol, companyName, price, volume],
    (err, result) => {
      if (err) throw err;
      console.log(`Added stock with ID: ${result.insertId}`);
      if (callback) callback(result.insertId); // proceed to next step
    }
  );
}

// READ
function listStocks(callback) {
  db.query('SELECT * FROM stocks', (err, results) => {
    if (err) throw err;
    console.log('All Stocks:', results);
    if (callback) callback(); // proceed to next step
  });
}

// UPDATE
function updateStock(id, newPrice, newVolume, callback) {
  db.query(
    'UPDATE stocks SET price = ?, volume = ? WHERE id = ?',
    [newPrice, newVolume, id],
    (err, result) => {
      if (err) throw err;
      console.log(`Updated records: ${result.affectedRows}`);
      if (callback) callback(); // proceed to next step
    }
  );
}

// DELETE
function deleteStock(id, callback) {
  db.query('DELETE FROM stocks WHERE id = ?', [id], (err, result) => {
    if (err) throw err;
    console.log(`Deleted records: ${result.affectedRows}`);
    if (callback) callback(); // proceed to next step
  });
}

// SEQUENTIAL EXECUTION (Callback Chain)
addStock('AAPL', 'Apple Inc.', 175.50, 1000, (insertId) => {
  listStocks(() => {
    updateStock(insertId, 180.00, 1200, () => {
      deleteStock(insertId, () => {
        db.end((err) => {
          if (err) throw err;
          console.log('MySQL connection closed');
        });
      });
    });
  });
});
