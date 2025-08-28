const mysql = require('mysql2');
const readline = require('readline');

//  Create MySQL Connection
const db = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  password: 'J@sh8367',
  database: 'stock_market'
});

//  Setup readline interface
//user input from the console and output prompts or messages.
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

//  Main Menu
function mainMenu() {
  console.log(`
Stock Market Management System
-------------------------------
1. Add Stock
2. View All Stocks
3. View Stock by ID
4. Update Stock Price & Volume
5. Delete Stock
6. Exit
`);
  rl.question('Enter your choice: ', (choice) => {
    switch (choice.trim()) {
      case '1': return addStock();
      case '2': return viewAllStocks();
      case '3': return viewStockById();
      case '4': return updateStock();
      case '5': return deleteStock();
      case '6': return exitApp();
      default:
        console.log('Invalid choice. Try again.');
        mainMenu();
    }
  });
}

//  CRUD Operations

function addStock() {
  rl.question('Enter Stock Symbol: ', (symbol) => {
    if (!symbol) return invalid('Symbol');

    rl.question('Enter Company Name: ', (companyName) => {
      if (!companyName) return invalid('Company Name');

      rl.question('Enter Price: ', (price) => {
        if (isNaN(price)) return invalid('Price');

        rl.question('Enter Volume: ', (volume) => {
          if (isNaN(volume)) return invalid('Volume');

          db.query(
            'INSERT INTO stocks (symbol, companyName, price, volume) VALUES (?, ?, ?, ?)',
            [symbol, companyName, parseFloat(price), parseInt(volume)],
            (err, result) => {
              if (err) throw err;
              console.log('Stock added successfully!');
              mainMenu();
            }
          );
        });
      });
    });
  });
}

function viewAllStocks() {
  db.query('SELECT * FROM stocks', (err, results) => {
    if (err) throw err;
    console.log('\nAll Stocks:');
    results.forEach(stock => {
      console.log(`ID: ${stock.id}, Symbol: ${stock.symbol}, Company: ${stock.companyName}, Price: ${stock.price}, Volume: ${stock.volume}`);
    });
    mainMenu();
  });
}

function viewStockById() {
  rl.question('Enter Stock ID: ', (id) => {
    if (isNaN(id)) return invalid('Stock ID');
    db.query('SELECT * FROM stocks WHERE id = ?', [id], (err, results) => {
      if (err) throw err;
      if (results.length === 0) {
        console.log('Stock not found.');
      } else {
        const stock = results[0];
        console.log(`ID: ${stock.id}, Symbol: ${stock.symbol}, Company: ${stock.companyName}, Price: ${stock.price}, Volume: ${stock.volume}`);
      }
      mainMenu();
    });
  });
}

function updateStock() {
  rl.question('Enter Stock ID: ', (id) => {
    if (isNaN(id)) return invalid('Stock ID');

    rl.question('Enter New Price: ', (price) => {
      if (isNaN(price)) return invalid('Price');

      rl.question('Enter New Volume: ', (volume) => {
        if (isNaN(volume)) return invalid('Volume');

        db.query(
          'UPDATE stocks SET price = ?, volume = ? WHERE id = ?',
          [parseFloat(price), parseInt(volume), id],
          (err, result) => {
            if (err) throw err;
            if (result.affectedRows === 0) {
              console.log('Stock not found.');
            } else {
              console.log('Stock updated successfully!');
            }
            mainMenu();
          }
        );
      });
    });
  });
}

function deleteStock() {
  rl.question('Enter Stock ID to delete: ', (id) => {
    if (isNaN(id)) return invalid('Stock ID');

    db.query('DELETE FROM stocks WHERE id = ?', [id], (err, result) => {
      if (err) throw err;
      if (result.affectedRows === 0) {
        console.log('Stock not found.');
      } else {
        console.log('Stock deleted successfully!');
      }
      mainMenu();
    });
  });
}

// Input Validation Helper
function invalid(field) {
  console.log(`Invalid ${field}. Try again.`);
  mainMenu();
}

//  Exit App
function exitApp() {
  db.end((err) => {
    if (err) throw err;
    console.log('MySQL connection closed.');
    rl.close();
  });
}

// Start App
db.connect((err) => {
  if (err) {
    console.error('Error connecting to MySQL:', err.message);
    process.exit(1);
  }
  console.log('Connected to MySQL');
  mainMenu();
});
