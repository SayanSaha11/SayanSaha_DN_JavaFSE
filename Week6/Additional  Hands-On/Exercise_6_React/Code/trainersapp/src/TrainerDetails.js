import React from 'react';
import { useParams } from 'react-router-dom';
import TrainersMock from './TrainersMock';

const TrainerDetail = () => {
  const { id } = useParams();

  const trainer = TrainersMock.find(t => t.trainerId === id);

  if (!trainer) {
    return <p>Trainer not found.</p>;
  }

  return (
    <div>
      <h2>Trainers Details</h2>
      <p><strong>{trainer.name} ({trainer.technology})</strong></p>
      <p>{trainer.email}</p>
      <p>{trainer.phone}</p>
      <ul>
        {trainer.skills.map((skill, idx) => (
          <li key={idx}>{skill}</li>
        ))}
      </ul>
    </div>
  );
};

export default TrainerDetail;
