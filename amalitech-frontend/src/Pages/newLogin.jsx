import React, { useState, useEffect } from "react";
import './Login.css'
import user_icon from '../Assets/person.png';
import email_icon from '../Assets/email.png';
import password_icon from '../Assets/password.png';
import { Button, Spinner, Badge } from "react-bootstrap"; // Import Badge component for status styling
import UserService from "../UserService";
import { useParams } from "react-router-dom";
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

const NewLogin = () => {
  const { userId } = useParams();
  const [accessKeys, setAccessKeys] = useState([]);
  const [loading, setLoading] = useState(false); 

  useEffect(() => {
    const fetchData = async () => {
      try {
        setLoading(true); 
        const token = localStorage.getItem('token');
        const keysResponse = await UserService.getKeysGeneratedByUser(userId, token);
        setAccessKeys(keysResponse);
        await UserService.updateKeyDetails(userId, token);
        
      } catch (error) {
        console.error('Error fetching or updating keys:', error);
        toast.error("Failed to fetch or update keys");
      } finally {
        setLoading(false); 
      }
    };

    fetchData();

  }, [userId]);


  const handleClick = async () => {
    try {
      setLoading(true); 
      const token = localStorage.getItem('token');
      const response = await UserService.generateKeyByUser(userId, token);
      if (!response) {
        toast.success("Key generated successfully");
        const keysResponse = await UserService.getKeysGeneratedByUser(userId, token);
        setAccessKeys(keysResponse);
      } else {
        toast.error("Active key already exists");
      }
    } catch (error) {
      console.error('Error generating key:', error);
      toast.error("Active key already exists");
    } finally {
      setLoading(false); 
    }
  };
  
  return (
    <div className="container">
      <h1>Hello Joe</h1>
      <div className="d-flex justify-content-end mb-3">
        <Button variant="success" onClick={handleClick}>
          Generate New Access Key
        </Button>
      </div>
      <div className="cards">
        {accessKeys.map((card, index) => (
          <div className="card" key={index}>
            <h3>KeyID: {card.keys}</h3>
            <p>The Key number is 00{card.id}, procured on <strong style={{ color: 'darkgreen' }}>{card.dateOfProcurement}</strong>. 
              It has been actively used since its
               procurement and is set to expire on <strong style={{ color: 'darkred', fontWeight: 'bold', fontSize: 'larger' }}>{card.expiryDate}</strong>. This key plays a 
              crucial role in securing access to essential resources, ensuring smooth operations within the system.</p>
            <p><strong>Status:</strong>
              <Badge bg={card.status === 'ACTIVE' ? 'success' : 'danger'}>
                {card.status}
              </Badge>
            </p>
           
          </div>
        ))}
      </div>
      <ToastContainer /> {/* Toast container for displaying toast messages */}
    </div>
  );
}

export default NewLogin;
