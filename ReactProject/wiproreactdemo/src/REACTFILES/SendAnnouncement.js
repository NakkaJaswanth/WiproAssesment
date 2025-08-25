import React, { useState } from 'react';
import { usePowerCut } from '../REACTFILES/PowerCutContext';

const SendAnnouncement = () => {
  const { addAnnouncement } = usePowerCut();
  const [street, setStreet] = useState('');
  const [message, setMessage] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    if (street.trim() === '' || message.trim() === '') {
      alert('Please fill in all fields.');
      return;
    }
    addAnnouncement(street, message);
    setStreet('');
    setMessage('');
  };

  return (
    <form onSubmit={handleSubmit} className="mb-4">
      <input
        type="text"
        className="form-control mb-2"
        placeholder="Street Name"
        value={street}
        onChange={(e) => setStreet(e.target.value)}
      />
      <textarea
        className="form-control mb-2"
        placeholder="Announcement Message"
        value={message}
        onChange={(e) => setMessage(e.target.value)}
      />
      <button type="submit" className="btn btn-primary">Send Announcement</button>
    </form>
  );
};

export default SendAnnouncement;
