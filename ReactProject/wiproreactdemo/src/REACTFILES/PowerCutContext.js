import React, { createContext, useContext, useState } from 'react';

const PowerCutContext = createContext();

export const PowerCutProvider = ({ children }) => {
  const [announcements, setAnnouncements] = useState([]);

  const addAnnouncement = (street, message) => {
    const newAnnouncement = {
      id: Date.now(),
      street,
      message,
      time: new Date().toLocaleString(),
    };
    setAnnouncements(prev => [newAnnouncement, ...prev]);
  };

  return (
    <PowerCutContext.Provider value={{ announcements, addAnnouncement }}>
      {children}
    </PowerCutContext.Provider>
  );
};

export const usePowerCut = () => useContext(PowerCutContext);
