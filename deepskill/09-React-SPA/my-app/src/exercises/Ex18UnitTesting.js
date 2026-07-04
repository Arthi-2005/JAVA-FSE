import React from 'react';

function CohortDetails({ name, count }) {
  return (
    <div>
      <h3>{name}</h3>
      <p>Total Students: {count}</p>
    </div>
  );
}

function Ex18UnitTesting() {
  return (
    <div className="exercise-wrap">
      <h1>Unit Testing Demo</h1>
      <p>This component can be tested with Jest and Enzyme.</p>
      <CohortDetails name="Cohort 2024" count={25} />
      <CohortDetails name="Cohort 2025" count={30} />
      <div style={{ marginTop: 20, padding: 15, background: '#f0f2f5', borderRadius: 8 }}>
        <p>Example test (Jest + Enzyme):</p>
        <pre style={{ fontSize: 12 }}>
{`import { shallow } from 'enzyme';
import CohortDetails from './CohortDetails';

it('renders cohort name', () => {
  const wrapper = shallow(&lt;CohortDetails name="Test" count={10} /&gt;);
  expect(wrapper.find('h3').text()).toEqual('Test');
});`}
        </pre>
      </div>
    </div>
  );
}

export default Ex18UnitTesting;
