import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';

import Home from './Home';
import TrainersList from './TrainersList';
import TrainersMock from './TrainersMock';
import TrainerDetail from './TrainerDetails';

function App() {
  return (
    <Router>
      <div>
        <h1>My Academy Trainers App</h1>
        {/* Navigation Menu */}
        <nav style={{ marginBottom: '20px' }}>
          <Link to="/" style={{ marginRight: '15px' }}>Home</Link>
          <Link to="/trainer">Show Trainers</Link>
        </nav>

        {/* Route Configuration */}
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/trainer" element={<TrainersList trainers={TrainersMock} />} />
          <Route path="/trainer/:id" element={<TrainerDetail />}/>
        </Routes>
      </div>
    </Router>
  );
}

export default App;
