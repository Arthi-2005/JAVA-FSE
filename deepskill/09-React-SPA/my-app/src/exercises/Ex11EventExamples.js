import React, { useState } from 'react';

function Counter() {
  const [count, setCount] = useState(0);

  return (
    <div style={{ marginBottom: 20 }}>
      <h2>Counter</h2>
      <p>Count: {count}</p>
      <button onClick={() => setCount(count + 1)}>Increment</button>
      <button onClick={() => setCount(count - 1)} style={{ marginLeft: 10 }}>Decrement</button>
    </div>
  );
}

function CurrencyConverter() {
  const [inr, setInr] = useState(0);
  const euro = inr * 0.011;

  return (
    <div>
      <h2>Currency Converter</h2>
      <p>Enter amount in INR:</p>
      <input type="number" value={inr} onChange={e => setInr(e.target.value)} />
      <p>Euro: &euro;{euro.toFixed(2)}</p>
    </div>
  );
}

function Ex11EventExamples() {
  return (
    <div className="exercise-wrap">
      <h1>Event Examples</h1>
      <Counter />
      <CurrencyConverter />
    </div>
  );
}

export default Ex11EventExamples;
