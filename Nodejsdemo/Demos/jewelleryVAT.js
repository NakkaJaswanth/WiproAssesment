// Function to calculate VAT and total price
function calculateVAT(price, vatRate = 3) {
  const vat = +(price * vatRate / 100).toFixed(2);     // VAT amount
  const totalPrice = +(price + vat).toFixed(2);        // Total price including VAT
  return {
    vat,
    totalPrice
  };
}

// Jewellery items
const jewelleryItems = [
  { id: 1, name: "Gold Necklace", price: 50000 },
  { id: 2, name: "Diamond Ring", price: 75000 },
  { id: 3, name: "Silver Bracelet", price: 12000 }
];

// Set VAT rate (can be customized)
const vatRate = 3;

// Display results for each item
jewelleryItems.forEach(item => {
  const { vat, totalPrice } = calculateVAT(item.price, vatRate);

  console.log(`Jewellery ID: ${item.id}`);
  console.log(`Name: ${item.name}`);
  console.log(`Price: ${item.price}`);
  console.log(`VAT (${vatRate}%): ${vat}`);
  console.log(`Total Price: ${totalPrice}`);
  console.log('-----------------------------');
});
