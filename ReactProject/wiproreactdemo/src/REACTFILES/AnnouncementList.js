import React from 'react';
import { usePowerCut } from '../REACTFILES/PowerCutContext';

const AnnouncementList = () => {
  const { announcements } = usePowerCut();

  return (
    <div style={{ maxHeight: '300px', overflowY: 'auto' }} className="mt-3">
       {/* Map through the announcements array to render each announcement */}
      {announcements.map(({ id, street, message, time }) => (
        <div
          key={id}// Unique key for React to track each item
          className={`border p-2 rounded mb-2 ${message.toLowerCase().includes('urgent') ? 'bg-warning' : 'bg-info'}`}
        >
           {/* Show the street name */}
          <strong>Street:</strong> {street} <br />
          {/* Show the message content */}
          <strong>Message:</strong> {message} <br />
          {/* Show the timestamp in smaller font */}
          <small><strong>Time:</strong> {time}</small>        </div>
      ))}
    </div>
  );
};

export default AnnouncementList;
