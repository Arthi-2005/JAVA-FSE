import React, { Component } from 'react';

class OnlineShopping extends Component {
  constructor(props) {
    super(props);
    this.state = {
      cart: [
        { id: 1, name: 'Laptop', price: 45000 },
        { id: 2, name: 'Mouse', price: 500 },
        { id: 3, name: 'Keyboard', price: 1200 },
        { id: 4, name: 'Monitor', price: 8000 },
        { id: 5, name: 'Headphones', price: 1500 }
      ]
    };
  }

  render() {
    let total = this.state.cart.reduce((sum, item) => sum + item.price, 0);
    return (
      <div>
        <h2>Online Shopping</h2>
        <h3>Cart Items</h3>
        <ul>
          {this.state.cart.map(item => (
            <li key={item.id}>{item.name} - Rs.{item.price}</li>
          ))}
        </ul>
        <p><strong>Total: Rs.{total}</strong></p>
      </div>
    );
  }
}

function Ex07ShoppingApp() {
  return (
    <div className="exercise-wrap">
      <h1>Shopping App</h1>
      <OnlineShopping />
    </div>
  );
}

export default Ex07ShoppingApp;
