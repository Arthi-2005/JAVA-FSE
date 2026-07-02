import React from 'react';
import styles from './Ex05CohortDashboard.module.css';

function Ex05CohortDashboard() {
  return (
    <div className="exercise-wrap">
      <h1 className={styles.heading}>Cohort Dashboard</h1>
      <div className={styles.card}>
        <h3>Cohort 2024</h3>
        <p>Total Students: 25</p>
        <p>Active: 22</p>
        <p className={styles.badge}>Ongoing</p>
      </div>
      <div className={styles.card}>
        <h3>Cohort 2025</h3>
        <p>Total Students: 30</p>
        <p>Active: 28</p>
        <p className={styles.badge}>Upcoming</p>
      </div>
    </div>
  );
}

export default Ex05CohortDashboard;
